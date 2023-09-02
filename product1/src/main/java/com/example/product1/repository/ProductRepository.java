package com.example.product1.repository;

import com.example.product1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    String findByProductName(String name);
    Double findByProductCost(Double cost);
    String findByProductDescription(String description);
    String findByProductVendor(String vendor);

}
