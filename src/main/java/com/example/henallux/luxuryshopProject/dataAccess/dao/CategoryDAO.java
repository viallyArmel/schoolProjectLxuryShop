package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.dataAccess.entity.CategoryEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.CategoryRepository;
import com.example.henallux.luxuryshopProject.dataAccess.util.ProviderConverter;
import com.example.henallux.luxuryshopProject.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess{

    private CategoryRepository categoryRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public CategoryDAO (CategoryRepository categoryRepository, ProviderConverter providerConverter){
        this.categoryRepository = categoryRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<String> getImageNameCategories(){
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ArrayList<String> categImageNames = new ArrayList<>();

        for (CategoryEntity entity : categoryEntities){
            categImageNames.add(entity.getImage());
        }
        return categImageNames;
    }

    @Override
    public Category findCategoryEntityById(int id) {
        CategoryEntity entity = categoryRepository.findCategoryEntityById(id);
        return providerConverter.categoryEntityToCategory(entity);
    }
}
