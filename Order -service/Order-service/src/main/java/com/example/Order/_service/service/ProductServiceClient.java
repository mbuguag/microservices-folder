package com.example.Order._service.service;

import com.example.Order._service.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductServiceClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String productServiceUrl = "http://localhost:8081/products";

    public Product getProduct(String productId) {
        return restTemplate.getForObject(productServiceUrl + "/" + productId, Product.class);
    }
}
