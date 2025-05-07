package com.example.ProductMicroservice.controller;

import com.example.ProductMicroservice.model.Product;
import com.example.ProductMicroservice.model.ProductRequest;
import com.example.ProductMicroservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/{userId}")
    public String createProduct(
            @RequestBody ProductRequest request,
            @PathVariable("userId") String userId){
        String productId = productService.addNewProduct(request, userId);

        return productId;
    }

    @GetMapping(value = "/{userId}")
    public List<Product> findAllProductByUser(@PathVariable("userId") String userId){
        return productService.findAllProductByUser(userId);
    }

}
