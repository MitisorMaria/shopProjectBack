package com.example.shop.controllers;

import com.example.shop.bll.Product;
import com.example.shop.bll.ProductType;
import com.example.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) throws IOException {
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{type}")
    public List<Product> getProductsByType(@PathVariable("type") ProductType type) throws IOException {
        List<Product> products = productService.getAllByType(type);
        return products;
    }
}
