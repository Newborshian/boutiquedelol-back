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
    public List<ProductDto> createList(List<ProductEntity> list) {
        List<ProductDto> dtoList = new ArrayList<>();
        for (ProductEntity productEntity : list) {
            dtoList.add(this.toDto(productEntity));
        }
        return dtoList;
    }

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
        return this.createList(list);
    }

    @Override
    public Integer addProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDto.getName());
        productEntity.setImage(productDto.getImage());
        productEntity.setLore(productDto.getLore());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setAvailable(productDto.getAvailable());
        productEntity.setType(productDto.getType());

        productRepository.saveAndFlush(productEntity);
        return productEntity.getId();
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public ProductDto getById(Integer id) {
        ProductDto productDto = this.toDto(productRepository.findById(id).get());
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProductOrderByNameAsc() {
        List<ProductEntity> list = productRepository.findAllByOrderByNameAsc();
        return this.createList(list);
    }
    @Override
    public List<ProductDto> getAllProductOrderByNameDesc() {
        List<ProductEntity> list = productRepository.findAllByOrderByNameDesc();
        return this.createList(list);
    }
    @Override
    public List<ProductDto> getAllProductOrderByPriceAsc() {
        List<ProductEntity> list = productRepository.findAllByOrderByPriceAsc();
        return this.createList(list);
    }
    @Override
    public List<ProductDto> getAllProductOrderByPriceDesc() {
        List<ProductEntity> list = productRepository.findAllByOrderByPriceDesc();
        return this.createList(list);
    }

    @Override
    public List<ProductDto> getAllProductByType(String type) {
        List<ProductEntity> list = productRepository.findByTypeLike(type);
        return this.createList(list);
    }

    @Override
    public List<ProductDto> getAllProductByName(String name) {
        List<ProductEntity> list = productRepository.findByNameLike("%" + name.toUpperCase() + "%");
        return this.createList(list);
    }
    @Override
    public List<ProductDto> getAllProductByPriceBetween(Double price1, Double price2) {
        List<ProductEntity> list = productRepository.getAllProductByPrice(price1, price2);
        return this.createList(list);
    }
}
