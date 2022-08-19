package com.example.Rimshop.DTO;

import com.example.Rimshop.DTO.ProductDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoryDto implements Serializable {
    private final Long id;
    private final String name;
    private final List<ProductDto> productList;
}
