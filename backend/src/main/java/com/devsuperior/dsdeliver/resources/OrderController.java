package com.devsuperior.dsdeliver.resources;

import com.devsuperior.dsdeliver.dtos.OrderDTO;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import com.devsuperior.dsdeliver.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> findAll(@RequestParam OrderStatus status) {
        return service.findAll(status);
    }

}