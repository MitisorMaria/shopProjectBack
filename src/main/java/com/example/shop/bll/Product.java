package com.example.shop.bll;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type")
    private ProductType type;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Float price;
    @Column(name = "picPath", length = 1000)
    private String picPath;

    public Product() {
    }

    public Product(Long id, ProductType type, String name, Float price, String picPath) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.picPath = picPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

}
