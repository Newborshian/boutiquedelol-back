package com.example.superboutiquedelolback.controller;


import com.example.superboutiquedelolback.dto.DetailDto;
import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.services.InterfaceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getByName/{name}")
    public List<DetailDto> getByName(@PathVariable String name) { return detailService.getByName(name); }

    @PostMapping("detailChange")
    public ResponseEntity<Boolean> detailsChange(@RequestBody DetailDto detailDto) {
        try {
            Boolean response = detailService.detailsChange(detailDto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
}
}
