package com.example.superboutiquedelolback.services;

import com.example.superboutiquedelolback.dto.ProductDto;
import com.example.superboutiquedelolback.entity.ProductEntity;
import com.example.superboutiquedelolback.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements InterfaceProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto toDto(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setImage(productEntity.getImage());
        productDto.setLore(productEntity.getLore());
        productDto.setPrice(productEntity.getPrice());
        productDto.setAvailable(productEntity.getAvailable());
        productDto.setType(productEntity.getType());
        return productDto;
    }

    @Override
    public List<ProductDto> getAll() {
        List<ProductEntity> list = productRepository.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (ProductEntity productEntity : list) {
            dtoList.add(this.toDto(productEntity));
        }
        return dtoList;
    }

    @Override
    public Integer addProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setImage(productDto.getImage());
        productEntity.setLore(productDto.getLore());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setAvailable(productEntity.getAvailable());
        productEntity.setType(productEntity.getType());

        productRepository.saveAndFlush(productEntity);
        return productEntity.getId();
    }

}
