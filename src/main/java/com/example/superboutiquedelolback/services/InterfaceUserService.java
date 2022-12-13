package com.example.superboutiquedelolback.services;


import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.entity.UserEntity;

import java.util.List;

public interface InterfaceUserService {

    UserDto toDto(UserEntity userEntity);

    List<UserDto> getAllUser();

    Integer addUser(UserDto userDto);

    void deleteUser(Integer id);

    UserDto getById(Integer id);
    Integer loginService(String name, String password);
}
