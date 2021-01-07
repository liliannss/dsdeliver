package com.devsuperior.dsdeliver.repositories;

import com.devsuperior.dsdeliver.entites.Order;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllOrdersWithProductsByStatusOrderByMomentAsc(OrderStatus status);

}