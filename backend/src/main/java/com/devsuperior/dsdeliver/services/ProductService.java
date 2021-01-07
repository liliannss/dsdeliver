package com.devsuperior.dsdeliver.services;

import com.devsuperior.dsdeliver.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAll();

}