package com.example.product1.service;

import com.example.product1.entity.Product;
import com.example.product1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

   @Override
    public Product updateProduct(Product product,int productId) {
       Product product1 = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product Not Found"));
       product1.setProductName(product.getProductName());
       product1.setProductCost(product.getProductCost());
       product1.setProductDescription(product.getProductDescription());
       product1.setProductVendor(product.getProductVendor());

       return productRepository.save(product1);


//    @Override
//    public Product updateProduct(Product product, int productId) {
//            Product updatedProduct = productRepository.findById(productId).orElse(null);
//            if (updatedProduct != null) {
//                updatedProduct.setProductName(productRepository.findByProductName(product.getProductName()));
//                updatedProduct.setProductCost(productRepository.findByProductCost(product.getProductCost()));
//                updatedProduct.setProductDescription(productRepository.findByProductDescription(product.getProductDescription()));
//                updatedProduct.setProductVendor(productRepository.findByProductVendor(product.getProductVendor()));
//                return productRepository.save(updatedProduct);
//            } else {
//                // Handle the case where the product with the given ID doesn't exist
//                throw new IllegalArgumentException("Product not found");
//            }
        }

    }


