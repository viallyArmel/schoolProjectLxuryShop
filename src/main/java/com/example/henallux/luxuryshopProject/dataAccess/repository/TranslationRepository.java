package com.example.henallux.luxuryshopProject.dataAccess.repository;

import com.example.henallux.luxuryshopProject.dataAccess.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface TranslationRepository extends JpaRepository<TranslationEntity, Integer> {
    @Query("SELECT translation from TranslationEntity translation WHERE translation.language.code = ?1")
    ArrayList<TranslationEntity> findCategoriesByCodeLanguage(String code);

    @Query("SELECT translation from TranslationEntity translation WHERE translation.category.id = ?1 AND translation.language.code = ?2")
    TranslationEntity findByCategoryIdAndCodeLanguage(int id, String lang);



}
