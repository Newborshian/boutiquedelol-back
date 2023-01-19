package com.example.superboutiquedelolback.services;


import com.example.superboutiquedelolback.dto.DetailDto;
import com.example.superboutiquedelolback.entity.DetailEntity;
import com.example.superboutiquedelolback.repository.DetailsRepository;
import com.example.superboutiquedelolback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService implements InterfaceDetailService {

    @Autowired
    DetailsRepository detailsRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public DetailDto toDto(DetailEntity detailEntity) {
        DetailDto detailDto = new DetailDto();
        detailDto.setDetailsId(detailEntity.getId());
        detailDto.setUserId(detailEntity.getUserEntity().getId());
        detailDto.setName(detailEntity.getUserEntity().getName());
        detailDto.setMail(detailEntity.getUserEntity().getMail());
        detailDto.setLastName(detailEntity.getLastName());
        detailDto.setFirstName(detailEntity.getFirstName());
        detailDto.setGender(detailEntity.getGender());
        detailDto.setBirthDate(detailEntity.getBirthdate());
        detailDto.setDescription(detailEntity.getDescription());
        detailDto.setAddress(detailEntity.getAddress());
        detailDto.setZipCode(detailEntity.getZipCode());
        detailDto.setCity(detailEntity.getCity());
        detailDto.setPhoneNumber(detailEntity.getPhoneNumber());
        detailDto.setImage(detailEntity.getImage());
        return detailDto;
    }

    @Override
    public List<DetailDto> getAll() {
        List<DetailEntity> list = detailsRepository.findAll();
        List<DetailDto> finalList = new ArrayList<>();
        for (DetailEntity detailEntity: list){
            finalList.add(this.toDto(detailEntity));
        }
        return finalList;
    }

    @Override
    public List<DetailDto> getByName(String name) {
        List<DetailEntity> list = detailsRepository.findByUserEntity(userRepository.findByName(name));
        List<DetailDto> finalList = new ArrayList<>();
        for (DetailEntity detailEntity: list){
            finalList.add(this.toDto(detailEntity));
        }
        return finalList;
    }
}
