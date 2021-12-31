package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    ProductEntity findProductEntityByName(String name);
    List<ProductEntity> findProductEntitiesByCategory_Id(Integer category);
    @Query("select productEntity.category.id from ProductEntity productEntity where productEntity.name = ?1")
    Integer findCategoryIdByProductName(String name);
}
