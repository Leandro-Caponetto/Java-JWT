package com.cursos.springsecuritycourse.controller;

import com.cursos.springsecuritycourse.entity.Product;
import com.cursos.springsecuritycourse.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productRepository.findAll();

        if(products != null && !products.isEmpty()){
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Product> createOne(@RequestBody @Valid Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(product));
    }

}
