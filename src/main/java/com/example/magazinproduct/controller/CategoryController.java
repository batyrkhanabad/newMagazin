package com.example.magazinproduct.controller;

import com.example.magazinproduct.entity.Category;
import com.example.magazinproduct.entity.Product;
import com.example.magazinproduct.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Product>> readAll(){
        return new ResponseEntity<>(categoryService.readAll(), HttpStatus.OK);
    }
}
