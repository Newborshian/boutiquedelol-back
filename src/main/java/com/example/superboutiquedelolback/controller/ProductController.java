package com.example.superboutiquedelolback.controller;

import com.example.superboutiquedelolback.dto.ProductDto;
import com.example.superboutiquedelolback.services.InterfaceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private InterfaceProductService service;

    @GetMapping("allProduct")
    public List<ProductDto> getAllProduct() {
        return service.getAll();
    }

    @PostMapping("addProduct")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductDto productDto) {
        try {
            Integer id = service.addProduct(productDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable("id") Integer id) {
        service.deleteProduct(id);
    }

    @GetMapping("getById")
    public ProductDto getById (@RequestParam Integer id) {
        return service.getById(id);
    }
}
