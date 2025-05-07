package com.example.ProductMicroservice.service;

import com.example.ProductMicroservice.model.Product;
import com.example.ProductMicroservice.model.ProductRequest;
import com.example.ProductMicroservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String addNewProduct(ProductRequest request, String userId) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setUserId(userId);
        product.setAvailableQuantity(request.getAvailableQuantity());

        return  productRepository.save(product).getId();
    }

    public List<Product> findAllProductByUser(String userId) {
        return productRepository.findByUserId(userId);
    }
}
