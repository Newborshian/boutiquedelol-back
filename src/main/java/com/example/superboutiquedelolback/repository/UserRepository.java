package com.example.superboutiquedelolback.repository;

import com.example.superboutiquedelolback.dto.UserDto;
import com.example.superboutiquedelolback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Boolean existsByNameAndPasswordAndValidateByAdminIsTrue(@Param("name")String name, @Param("password")String password);
    Boolean existsByNameAndPassword(@Param("name")String name, @Param("password")String password);
    List<UserEntity> findAllByValidateByAdminIsTrue();
    List<UserEntity> findAllByValidateByAdminIsFalse();
    UserEntity findByNameAndPassword(@Param("name")String name, @Param("password")String password);
}
