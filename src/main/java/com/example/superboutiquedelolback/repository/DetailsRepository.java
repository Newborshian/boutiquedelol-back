package com.example.superboutiquedelolback.repository;


import com.example.superboutiquedelolback.dto.DetailDto;
import com.example.superboutiquedelolback.entity.DetailEntity;
import com.example.superboutiquedelolback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<DetailEntity, Integer> {

    List<DetailEntity> findAllByUserEntity(UserEntity userEntity);

    List<DetailEntity> findByUserEntity(UserEntity userEntity);
}
