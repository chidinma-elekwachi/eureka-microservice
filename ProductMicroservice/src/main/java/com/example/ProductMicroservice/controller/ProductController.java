package com.example.ProductMicroservice.controller;

import com.example.ProductMicroservice.model.ProductRequest;
import com.example.ProductMicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public String createProduct(@RequestBody ProductRequest productRequest){

    }
}
