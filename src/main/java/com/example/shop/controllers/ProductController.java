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
        byte[] uncompressedImage = product.getPicByte();
        byte[] compressedImage = compressBytes(uncompressedImage);
        product.setPicByte(compressedImage);
        productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{type}")
    public List<Product> getProductsByType(@PathVariable("type") ProductType type) throws IOException {
        List<Product> products = productService.getAllByType(type);
        for (Product product : products) {
            byte[] compressedImage = product.getPicByte();
            byte[] uncompressedImage = decompressBytes(compressedImage);
            product.setPicByte(uncompressedImage);
        }
        return products;
    }


    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }


    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }
}
