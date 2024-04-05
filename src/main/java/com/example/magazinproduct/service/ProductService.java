package com.example.magazinproduct.service;

import com.example.magazinproduct.dto.ProductDTO;
import com.example.magazinproduct.entity.Product;
import com.example.magazinproduct.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create(ProductDTO dto){
        return productRepository.save(Product.builder()
                .name(dto.getName())
                .summa(dto.getSumma())
                .category(categoryService.readById(dto.getCategoryId()))
                .build());
    }
    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public List<Product> readByCategoryId(Long id){
        return  productRepository.findByCategoryId(id);
    }
    public Product upDate(Product product){
        return productRepository.save(product);
    }

    public Product delete(Long id){
       productRepository.deleteById(id);
        return null;
    }

}
