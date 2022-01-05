package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.dataAccess.entity.TranslationEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.TranslationRepository;
import com.example.henallux.luxuryshopProject.dataAccess.util.ProviderConverter;
import com.example.henallux.luxuryshopProject.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TranslationDAO implements TranslationDataAccess{

    private TranslationRepository translationRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public TranslationDAO(TranslationRepository translationRepository, ProviderConverter providerConverter){
        this.translationRepository = translationRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Translation> getCategoriesTranslatedIn(String code) {
        List<TranslationEntity> translationEntities = translationRepository.findCategoriesByCodeLanguage(code);
        ArrayList<Translation> translations = new ArrayList<>();

        for(TranslationEntity entity : translationEntities){
            translations.add(providerConverter.tanslationEntityToTranslation(entity));
        }
        return translations;
    }

    @Override
    public Translation getCategoryNameByIdAndLocale(int id, String locale) {
        TranslationEntity entity = translationRepository.findByCategoryIdAndCodeLanguage(id, locale);
        return providerConverter.tanslationEntityToTranslation(entity);
    }
}
