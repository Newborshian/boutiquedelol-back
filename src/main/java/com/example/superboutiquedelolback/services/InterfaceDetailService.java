package com.example.superboutiquedelolback.services;

import com.example.superboutiquedelolback.dto.DetailDto;
import com.example.superboutiquedelolback.entity.DetailEntity;

import java.util.List;

public interface InterfaceDetailService {

    DetailDto toDto(DetailEntity detailEntity);

    List<DetailDto> getAll();

}
