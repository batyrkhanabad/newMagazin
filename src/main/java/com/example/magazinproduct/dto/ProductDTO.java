package com.example.magazinproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private Short summa;
    private Long categoryId;


}
