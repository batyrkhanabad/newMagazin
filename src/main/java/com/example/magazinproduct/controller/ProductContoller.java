package com.example.magazinproduct.controller;

import com.example.magazinproduct.dto.ProductDTO;
import com.example.magazinproduct.entity.Product;
import com.example.magazinproduct.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductContoller {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDTO dto){
        return new ResponseEntity<>(productService.create(dto), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Product>> readAll(){
        return new ResponseEntity<>(productService.readAll(),HttpStatus.OK);
    }

    @GetMapping("/caregory/{id}")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id){
        return mappingResponseListProduct(productService.readByCategoryId(id));
    }
    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product){
        return  mappingResponseProduct(productService.upDate(product));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        productService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product){
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> product){
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
