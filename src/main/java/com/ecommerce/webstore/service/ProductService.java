package com.ecommerce.webstore.service;

import com.ecommerce.webstore.DTO.ProductDto;
import com.ecommerce.webstore.exceptions.ProductNotFoundException;
import com.ecommerce.webstore.model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(ProductDto productDto);
}
