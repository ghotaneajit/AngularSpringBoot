package com.example.product1.service;

import com.example.product1.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product saveProduct(Product product);
    void deleteProduct(int productId);
    Product updateProduct(Product product,int productId);
}
