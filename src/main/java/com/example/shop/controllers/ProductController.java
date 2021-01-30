package com.example.shop.controllers;

import com.example.shop.bll.Product;
import com.example.shop.bll.ProductType;
import com.example.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{type}")
    public List<Product> getProductsByType(@PathVariable("type") ProductType type) {
        List<Product> products = productService.getAllByType(type);
        return products;
    }
}
