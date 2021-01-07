package com.devsuperior.dsdeliver.dtos;

import com.devsuperior.dsdeliver.entites.Order;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = -4602126946733068967L;

    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private Instant moment;
    private OrderStatus status;
    private List<ProductDTO> products = new ArrayList<>();

    public OrderDTO(Order order) {
        id = order.getId();
        address = order.getAddress();
        latitude = order.getLatitude();
        longitude = order.getLongitude();
        moment = order.getMoment();
        status = order.getStatus();
        products = order
                .getProducts()
                .stream()
                .map(product -> new ProductDTO(product))
                .collect(Collectors.toList());
    }

}