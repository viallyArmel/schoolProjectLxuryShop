package com.example.henallux.luxuryshopProject.dataAccess.dao;

import com.example.henallux.luxuryshopProject.dataAccess.entity.ProductEntity;
import com.example.henallux.luxuryshopProject.dataAccess.repository.ProductRepository;
import com.example.henallux.luxuryshopProject.dataAccess.util.ProviderConverter;
import com.example.henallux.luxuryshopProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess{

    private ProductRepository productRepository;
    private ProviderConverter providerConverter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter providerConverter){
        this.productRepository = productRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public Integer findCategoryIdByProductName(String name) {
        return productRepository.findCategoryIdByProductName(name);
    }

    @Override
    public ArrayList<Product> getProducts() {
        List<ProductEntity> entities = productRepository.findAll();
        ArrayList<Product> products = new ArrayList<>();

        for (ProductEntity entity : entities){
            products.add(providerConverter.productEntityToProduct(entity));
        }
        return products;
    }

    @Override
    public Product findProductEntityByName(String name) {
        ProductEntity entity = productRepository.findProductEntityByName(name);
        return providerConverter.productEntityToProduct(entity);
    }

    @Override
    public ArrayList<Product> findProductEntitiesByCategory_Id(Integer category) {
        List<ProductEntity> entities = productRepository.findProductEntitiesByCategory_Id(category);
        ArrayList<Product> categories = new ArrayList<>();
        for(ProductEntity entity : entities){
            categories.add(providerConverter.productEntityToProduct(entity));
        }
        return categories;
    }
}
