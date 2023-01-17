package com.example.superboutiquedelolback.services;


import com.example.superboutiquedelolback.dto.DetailDto;
import com.example.superboutiquedelolback.entity.DetailEntity;
import com.example.superboutiquedelolback.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService implements InterfaceDetailService {

    @Autowired
    DetailsRepository detailsRepository;

    @Override
    public DetailDto toDto(DetailEntity detailEntity) {
        DetailDto detailDto = new DetailDto();
        detailDto.setName(detailEntity.getUserEntity().getName());
        detailDto.setMail(detailEntity.getUserEntity().getMail());
        detailDto.setLastName(detailEntity.getLastName());
        detailDto.setFirstName(detailEntity.getFirstName());
        detailDto.setGender(detailEntity.getGender());
        detailDto.setBirthDate(detailEntity.getBirthdate());
        detailDto.setDescription(detailEntity.getDescription());
        detailDto.setAddress(detailEntity.getAddress());
        detailDto.setZipCode(detailEntity.getZipCode());
        detailDto.setCity(detailDto.getCity());
        detailDto.setPhoneNumber(detailEntity.getPhoneNumber());
        detailDto.setImage(detailDto.getImage());
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
}
