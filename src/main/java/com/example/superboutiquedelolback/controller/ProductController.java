package com.example.superboutiquedelolback.controller;

import com.example.superboutiquedelolback.dto.ProductDto;
import com.example.superboutiquedelolback.services.InterfaceProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return service.getAllById();
    }

}
