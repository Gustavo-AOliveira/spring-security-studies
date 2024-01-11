package com.example.Name.Spring.Security.studies.controller;

import com.example.Name.Spring.Security.studies.entities.product.ProductRequestDTO;
import com.example.Name.Spring.Security.studies.entities.product.ProductResponseDTO;
import com.example.Name.Spring.Security.studies.exception.EmptyListException;
import com.example.Name.Spring.Security.studies.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody @Valid ProductRequestDTO data, UriComponentsBuilder uriBuilder){
        var product = productService.saveProduct(data);
        var uri = uriBuilder.path("api/products").buildAndExpand(product.getId()).toUri();
            return ResponseEntity.created(uri).body(new ProductResponseDTO(product));

    }
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        List<ProductResponseDTO> listProducts = productService.getAll();
            if(listProducts.isEmpty()){
                throw new EmptyListException();
            }
            return ResponseEntity.ok().body(listProducts);
    }
}












