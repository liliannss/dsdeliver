package com.devsuperior.dsdeliver.services.impl;

import com.devsuperior.dsdeliver.dtos.OrderDTO;
import com.devsuperior.dsdeliver.entites.Order;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(OrderStatus status) {
        List<Order> orders = repository.findAllOrdersWithProductsByStatusOrderByMomentAsc(status);

        List<OrderDTO> orderDTOList = orders.stream()
                .map(order -> new OrderDTO(order))
                .collect(Collectors.toList());

        return orderDTOList;
    }

}