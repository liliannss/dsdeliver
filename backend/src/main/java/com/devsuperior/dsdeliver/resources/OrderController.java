package com.devsuperior.dsdeliver.resources;

import com.devsuperior.dsdeliver.dtos.OrderDTO;
import com.devsuperior.dsdeliver.enums.OrderStatus;
import com.devsuperior.dsdeliver.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderDTO> insert(UriComponentsBuilder uriComponentsBuilder, @RequestBody OrderDTO orderDTO) {
        OrderDTO dto = service.insert(orderDTO);

        UriComponents uriComponents = getUriComponents(uriComponentsBuilder, dto);

        return ResponseEntity.created(uriComponents.toUri()).body(dto);
    }

    private UriComponents getUriComponents(UriComponentsBuilder uriComponentsBuilder, OrderDTO dto) {
        UriComponents uriComponents =
                uriComponentsBuilder
                        .path("/{id}")
                        .buildAndExpand(dto.getId());
        return uriComponents;
    }

}