package com.example.shop.services;

import com.example.shop.bll.Product;
import com.example.shop.bll.ProductType;
import com.example.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllByType(ProductType type) {
        Product product = new Product();
        product.setType(type);

        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAny()
                .withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Product> example = Example.of(product, customExampleMatcher);

        return productRepository.findAll(example);
    }

    public void addProduct (Product product){
        productRepository.save(product);
    }


    public void updateProduct (Product product){
        productRepository.updateProductById(product.getName(), product.getPrice(), product.getPicPath(), product.getId());
    }

    public void deleteProductById (Long id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByTypeAndIds (ProductType type, String idString) {
        List<String> stringIDs = new ArrayList<String>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(idString);
        while (m.find()) {
            stringIDs.add(m.group());
        }

        List<Product> toReturn = new ArrayList<Product>();
        for (String id: stringIDs) {
            if (productRepository.findById(Long.parseLong(id)).isPresent())
            toReturn.add(productRepository.findById(Long.parseLong(id)).get());
        }
        return toReturn;
    }
}
