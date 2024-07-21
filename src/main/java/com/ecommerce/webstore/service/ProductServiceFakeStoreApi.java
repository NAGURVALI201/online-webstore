package com.ecommerce.webstore.service;

import com.ecommerce.webstore.DTO.ProductDto;
import com.ecommerce.webstore.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceFakeStoreApi implements ProductService{

    RestTemplate restTemplate;

    public ProductServiceFakeStoreApi(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {

        ProductDto productDtoObj = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                ProductDto.class
        );

        if(productDtoObj==null)
        {
            return null;
        }
        return productDtoObj.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        ProductDto[] productDtoObjs = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                ProductDto[].class
        );

        if(productDtoObjs == null)
        {
            return new ArrayList<>();
        }
        List<Product> result = new ArrayList<>();

        for(ProductDto p : productDtoObjs)
        {
            result.add(p.toProduct());
        }
        return result;
    }

    @Override
    public Product createProduct(ProductDto productDto) {

        ProductDto receivedObj = restTemplate.postForObject(
           "https://fakestoreapi.com/products",productDto,ProductDto.class
        ) ;

        if(receivedObj==null)
        {
            return null;
        }
        return receivedObj.toProduct();
    }
}
