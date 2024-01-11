package com.example.Name.Spring.Security.studies.service;

import com.example.Name.Spring.Security.studies.entities.product.Product;
import com.example.Name.Spring.Security.studies.entities.product.ProductRequestDTO;
import com.example.Name.Spring.Security.studies.entities.product.ProductResponseDTO;
import com.example.Name.Spring.Security.studies.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(ProductRequestDTO data){
        var product = new Product(data);
        productRepository.save(product);
            return product;
    }

    public List<ProductResponseDTO> getAll(){
        List<ProductResponseDTO> listProducts = productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
            return listProducts;
    }
}









