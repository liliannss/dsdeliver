package com.devsuperior.dsdeliver.services.impl;

import com.devsuperior.dsdeliver.dtos.OrderDTO;
import com.devsuperior.dsdeliver.dtos.ProductDTO;
import com.devsuperior.dsdeliver.entites.Order;
import com.devsuperior.dsdeliver.entites.Product;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import com.devsuperior.dsdeliver.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(OrderStatus status) {
        List<Order> orders = orderRepository.findAllOrdersWithProductsByStatusOrderByMomentAsc(status);

        List<OrderDTO> orderDTOList = orders.stream()
                .map(order -> new OrderDTO(order))
                .collect(Collectors.toList());

        return orderDTOList;
    }

    @Override
    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        Order order = new Order(
                null,
                orderDTO.getAddress(),
                orderDTO.getLatitude(),
                orderDTO.getLongitude(),
                Instant.now(),
                OrderStatus.PENDING);

        for (ProductDTO productDTO : orderDTO.getProducts()) {
            Product product = productRepository.getOne(productDTO.getId()); //instancia o produto sem ir ao Banco de Dados -> Cria uma entidade gerenciado pelo JPA -> Ao salvar o pedido, serão salvas as associações do produto
            order.getProducts().add(product);
        }

        order = orderRepository.save(order); //referência para objeto salvo

        return new OrderDTO(order);
    }

    @Override
    @Transactional
    public OrderDTO update(Long id) {
        Order order = orderRepository.getOne(id);

        order.setStatus(OrderStatus.DELIVERED);

        orderRepository.save(order);

        return new OrderDTO(order);
    }

}