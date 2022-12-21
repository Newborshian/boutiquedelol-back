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
        return service.getAllUser();
    }

    @GetMapping("allUserValidate")
    public List<UserDto> getAllUserValidate() {
        return service.getAllUserValidate();
    }

    @GetMapping("allUserNotValidate")
    public List<UserDto> getAllUserNotValidate() {
        return service.getAllUserNotValidate();
    }

    @PostMapping("addUser")
    public ResponseEntity<Integer> addUser(@RequestBody UserDto userDto) {
        try {
            Integer id = service.addUser(userDto);
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
    @GetMapping("login")
    public ResponseEntity<Integer> login(@RequestParam("name")String name, @RequestParam("password")String password){
        if (name.length() < 1 || password.length() < 1){
            return new ResponseEntity("Un des Champs est vide", HttpStatus.BAD_REQUEST);
        }

        try {
            Integer res = service.loginService(name, password);
            return new ResponseEntity(res, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
