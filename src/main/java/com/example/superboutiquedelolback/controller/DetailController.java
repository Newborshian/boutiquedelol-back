package com.example.superboutiquedelolback.controller;


import com.example.superboutiquedelolback.dto.DetailDto;
import com.example.superboutiquedelolback.services.InterfaceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("details")
public class DetailController {

    @Autowired
    private InterfaceDetailService detailService;

    @GetMapping("all")
    public List<DetailDto> getAll(){
        return detailService.getAll();
    }

}
