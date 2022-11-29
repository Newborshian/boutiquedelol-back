package com.example.superboutiquedelolback.repository;

import com.example.superboutiquedelolback.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
