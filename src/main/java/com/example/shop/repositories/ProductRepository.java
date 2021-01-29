package com.example.shop.repositories;

import com.example.shop.bll.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("update Product p set p.name = ?1, p.price = ?2, p.picByte = ?3 where p.id = ?4")
    void updateProductById(String name, Float price, byte[] picByte, Long id);
}
