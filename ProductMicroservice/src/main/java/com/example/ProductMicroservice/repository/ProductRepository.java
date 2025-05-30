package com.example.ProductMicroservice.repository;

import com.example.ProductMicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByUserId(String userId);
}
