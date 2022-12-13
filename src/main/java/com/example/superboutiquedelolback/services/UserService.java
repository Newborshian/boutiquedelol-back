package com.example.superboutiquedelolback.services;

import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.entity.UserEntity;
import com.example.superboutiquedelolback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements InterfaceUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto toDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setMail(userEntity.getMail());
        userDto.setRole(userEntity.getRole());
        userDto.setStatus(userEntity.getStatus());

        return userDto;
    }
    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> list = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : list) {
            userDtoList.add(this.toDto(userEntity));
        }
        return userDtoList;
    }
    @Override
    public Integer addUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setMail(userDto.getMail());
        userEntity.setRole(userDto.getRole());
        userEntity.setStatus(userDto.getStatus());

        userRepository.saveAndFlush(userEntity);
        return userEntity.getId();
    }
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }
    @Override
    public UserDto getById(Integer id) {
        UserDto userDto = this.toDto(userRepository.findById(id).get());
        return userDto;
    }
    @Override
    public Boolean loginService(String name, String password) {
        if (userRepository.existsByNameAndPassword(name, password)){
            return true;
        } else {
            return false;
        }
    }

}
