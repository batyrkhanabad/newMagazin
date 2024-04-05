package com.example.magazinproduct.service;

import com.example.magazinproduct.entity.Category;
import com.example.magazinproduct.entity.Product;
import com.example.magazinproduct.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Product> readAll(){
        return categoryRepository.findAll();
    }
    public Category readById(Long id){
        return categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category not found  " + id)).getCategory();
    }

}
