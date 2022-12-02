package com.example.superboutiquedelolback.services;

import com.example.superboutiquedelolback.dto.ProductDto;
import com.example.superboutiquedelolback.entity.ProductEntity;

import java.util.List;

public interface InterfaceProductService {

    List<ProductDto> createList(List<ProductEntity> list);

    ProductDto toDto(ProductEntity productEntity);

    List<ProductDto> getAll();

    Integer addProduct(ProductDto productDto);

    void deleteProduct(Integer id);

    ProductDto getById(Integer id);

    List<ProductDto> getAllProductOrderByNameAsc();
    List<ProductDto> getAllProductOrderByNameDesc();
    List<ProductDto> getAllProductOrderByPriceAsc();
    List<ProductDto> getAllProductOrderByPriceDesc();
    List<ProductDto> getAllProductByType(String type);
    List<ProductDto> getAllProductByName(String name);
    List<ProductDto> getAllProductByPriceBetween(Double price1, Double price2);
}

