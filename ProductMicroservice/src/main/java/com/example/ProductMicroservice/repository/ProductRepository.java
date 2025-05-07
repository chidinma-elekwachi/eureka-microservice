package com.example.ProductMicroservice.repository;

import com.example.ProductMicroservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
