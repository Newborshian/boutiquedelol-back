package com.example.superboutiquedelolback.controller;

import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.services.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")

public class UserController {

    @Autowired
    private InterfaceUserService service;

    @GetMapping("allUser")
    public List<UserDto> getAllUser() {
        return service.getAll();
    }

    @PostMapping("addUser")
    public ResponseEntity<Integer> addUser(@RequestBody UserDto userDto) {
        try {
            Integer id = service.addService(userDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        service.deleteUser(id);
    }

    @GetMapping("getById")
    public UserDto getById (@RequestParam Integer id) {
        return service.getById(id);
    }
}
