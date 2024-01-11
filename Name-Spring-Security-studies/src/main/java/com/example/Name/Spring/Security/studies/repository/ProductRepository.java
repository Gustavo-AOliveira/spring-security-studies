package com.example.Name.Spring.Security.studies.repository;

import com.example.Name.Spring.Security.studies.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
