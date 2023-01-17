package com.example.superboutiquedelolback.services;

import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.entity.UserEntity;
import com.example.superboutiquedelolback.repository.DetailsRepository;
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
        userDto.setValidateByAdmin(userEntity.getValidateByAdmin());

        return userDto;
    }

    @Override
    public List<UserDto> createList(List<UserEntity> list) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserEntity userEntity : list) {
            userDtoList.add(this.toDto(userEntity));
        }
        return userDtoList;
    }


    @Override
    public List<UserDto> getAllUser() {
        List<UserEntity> list = userRepository.findAll();
        return this.createList(list);
    }

    @Override
    public List<UserDto> getAllUserValidate() {
        List<UserEntity> list = userRepository.findAllByValidateByAdminIsTrue();
        return this.createList(list);
    }

    @Override
    public List<UserDto> getAllUserNotValidate() {
        List<UserEntity> list = userRepository.findAllByValidateByAdminIsFalse();
        return this.createList(list);
    }

    @Override
    public Integer addUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setMail(userDto.getMail());
        userEntity.setRole("user");
        userEntity.setValidateByAdmin(false);

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
    public Integer loginService(String name, String password) {
        if (userRepository.existsByNameAndPassword(name, password)){
            if (userRepository.existsByNameAndPasswordAndValidateByAdminIsTrue(name, password)){
                return 1; //Login Good
            } else {
                return 2; //Not Validate By Admin
            }
        } else {
            return 0; //Login Bad
        }
    }

    @Override
    public UserDto getInfoForLogged(String name, String password) {
        UserEntity userEntity = userRepository.findByNameAndPassword(name, password);
        UserDto userDto = this.toDto(userEntity);
        return userDto;
    }

    @Override
    public Boolean userValidateByAdmin(Integer id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userEntity.setValidateByAdmin(true);
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public Boolean userChange(UserDto userDto) {
        UserEntity userEntity = userRepository.findById(userDto.getId()).get();
        userEntity.setName(userDto.getName());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setMail(userDto.getMail());
        userDto.setRole(userDto.getRole());
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public UserEntity userAndDetailsUser(Integer id) {
        UserEntity userEntity = userRepository.userAndDetailsUser(id);
        return userEntity;
    }
}
