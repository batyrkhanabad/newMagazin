package com.example.magazinproduct.repository;

import com.example.magazinproduct.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Product,Long> {
    List<Product> findByCategoryId(Long id);

}
