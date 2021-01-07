package com.devsuperior.dsdeliver.services.impl;

import com.devsuperior.dsdeliver.dtos.ProductDTO;
import com.devsuperior.dsdeliver.entites.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;
import com.devsuperior.dsdeliver.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> products = repository.findAll();

        List<ProductDTO> productDTOList = products.stream()
                .map(product -> new ProductDTO(product))
                .sorted(Comparator.comparing(productDTO -> productDTO.getName()))
                .collect(Collectors.toList());

        return productDTOList;
    }

}
