package com.ecommerce.webstore.controller;


import com.ecommerce.webstore.DTO.ErrorDto;
import com.ecommerce.webstore.DTO.ProductDto;
import com.ecommerce.webstore.exceptions.ProductNotFoundException;
import com.ecommerce.webstore.model.Product;
import com.ecommerce.webstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws ProductNotFoundException
    {
        Product product = productServiceObj.getSingleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
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

    // if the above mapping methods throw the ProductNotFoundException then spring will
    // automatically invoke the below function.
    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ErrorDto> productNotFoundClassHandler(Exception e)
    {
        ErrorDto errorObj = new ErrorDto(e.getMessage());
        return new ResponseEntity<>(errorObj,HttpStatus.NOT_FOUND);
    }
}
