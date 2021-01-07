package com.devsuperior.dsdeliver.repositories;

import com.devsuperior.dsdeliver.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}