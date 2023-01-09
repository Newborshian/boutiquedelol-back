package com.example.superboutiquedelolback.services;


import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.entity.UserEntity;

import java.util.List;

public interface InterfaceUserService {

    UserDto toDto(UserEntity userEntity);
    List<UserDto> createList(List<UserEntity> list);
    List<UserDto> getAllUser();
    List<UserDto> getAllUserValidate();
    List<UserDto> getAllUserNotValidate();
    Integer addUser(UserDto userDto);
    void deleteUser(Integer id);
    UserDto getById(Integer id);
    Integer loginService(String name, String password);
    UserDto getInfoForLogged(String name, String password);
    Boolean userValidateByAdmin(Integer id);
    Boolean userChange(UserDto userDto);
}
