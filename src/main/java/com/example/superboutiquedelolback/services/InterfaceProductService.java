package com.example.superboutiquedelolback.services;

import com.example.superboutiquedelolback.dto.ProductDto;
import com.example.superboutiquedelolback.entity.ProductEntity;

import java.util.List;

public interface InterfaceProductService {

    ProductDto toDto(ProductEntity productEntity);

    List<ProductDto> getAll();

    Integer addProduct(ProductDto productDto);

}

