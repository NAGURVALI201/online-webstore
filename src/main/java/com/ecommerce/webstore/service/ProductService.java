package com.ecommerce.webstore.service;

import com.ecommerce.webstore.DTO.ProductDto;
import com.ecommerce.webstore.model.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product createProduct(ProductDto productDto);
}
