package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dtos.OrderDTO;
import com.devsuperior.dsdeliver.enums.OrderStatus;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAll(OrderStatus status);
    OrderDTO insert(OrderDTO orderDTO);

}