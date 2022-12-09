package com.example.superboutiquedelolback.services;


import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.entity.UserEntity;

import java.util.List;

public interface InterfaceUserService {

    UserDto toService(UserEntity userEntity);

    List<UserDto> getAll();

    Integer addService(UserDto userDto);

    void deleteUser(Integer id);

    UserDto getById(Integer id);
    Boolean loginService(String name, String password);
}
