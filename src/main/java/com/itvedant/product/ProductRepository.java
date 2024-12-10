package com.itvedant.product;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itvedant.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
