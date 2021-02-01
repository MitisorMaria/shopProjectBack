package com.example.shop.services;

import com.example.shop.bll.Product;
import com.example.shop.bll.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getAllByType(ProductType type);
    void addProduct (Product product);
    void updateProduct (Product product);
    void deleteProductById (Long id);
    List<Product> getProductsByTypeAndIds (ProductType type, String idString);
}
