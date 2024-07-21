package com.ecommerce.webstore.controller;


import com.ecommerce.webstore.DTO.ProductDto;
import com.ecommerce.webstore.model.Product;
import com.ecommerce.webstore.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productServiceObj;

    // if there is a single constructor the annotation @AutoWired will be placed.
    // @AutoWired will be automatically placed.
    public ProductController(ProductService productServiceObj)
    {
        this.productServiceObj = productServiceObj;
    }

    @GetMapping("/{id}")
    private Product getProduct(@PathVariable("id") Long id)
    {
        return productServiceObj.getSingleProduct(id);
    }
    @GetMapping("")
    private List<Product> getAllProducts()
    {
        return productServiceObj.getAllProducts();
    }
    @PostMapping("")
    private Product createProduct(@RequestBody ProductDto productDto)
    {
        return productServiceObj.createProduct(productDto);
    }
}
