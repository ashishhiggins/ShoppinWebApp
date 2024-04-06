package com.ashishhiggins.shoppinwebapp.repository;

import com.ashishhiggins.shoppinwebapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
