package com.example.superboutiquedelolback.repository;

import com.example.superboutiquedelolback.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    List<ProductEntity> findAllByOrderByNameAsc();
    List<ProductEntity> findAllByOrderByNameDesc();


}
