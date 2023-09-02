package com.example.product1.controller;

import com.example.product1.entity.Product;
import com.example.product1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins="*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return new ResponseEntity<>(product,HttpStatus.CREATED);
    }


    @DeleteMapping("/removeProduct/{id}")
    public ResponseEntity<Map<Integer,String>> deleteProduct(@PathVariable int id){
        Map<Integer,String> map = new HashMap<>();
        map.put(id,"Deleted");
       productService.deleteProduct(id);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable(name="id") int productId){

        return new ResponseEntity<>(productService.updateProduct(product,productId),HttpStatus.OK);
    }
}
