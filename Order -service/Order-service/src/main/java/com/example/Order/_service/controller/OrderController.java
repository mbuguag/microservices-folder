package com.example.Order._service.controller;

import com.example.Order._service.model.Order;
import com.example.Order._service.service.ProductServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ProductServiceClient productServiceClient;

    public OrderController(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        // Fetch product details from Product Service
        var product = productServiceClient.getProduct(order.getProductId());
        if (product != null) {
            return "Order created for product: " + product.getName();
        }
        return "Product not found!";
    }
}


