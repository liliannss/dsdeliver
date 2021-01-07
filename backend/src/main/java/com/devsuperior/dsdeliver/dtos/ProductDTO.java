package com.devsuperior.dsdeliver.dtos;

import com.devsuperior.dsdeliver.entites.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -8128070838967050440L;

    private String name;
    private Double price;
    private String description;
    private String imageUri;

    public ProductDTO(Product product) {
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();
        imageUri = product.getImageUri();
    }

}