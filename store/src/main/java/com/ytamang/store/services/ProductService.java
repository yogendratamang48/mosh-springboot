package com.ytamang.store.services;

import com.ytamang.store.entities.Category;
import com.ytamang.store.entities.Product;
import com.ytamang.store.repositories.ProductRepository;
import com.ytamang.store.repositories.CategoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void createCategory(){
        var category = Category.builder()
                .name("Cookwares")
                .build();
        categoryRepository.save(category);
    }
    public void createProduct(){
        var product = Product.builder()
                .name("Frying pan - Stainless steel")
                .price(65.99)
                .build();
        productRepository.save(product);
    }

    @Transactional
    public void createProductAndCategory(){
        var category = Category.builder()
                .name("Electronics")
                .build();
        categoryRepository.save(category);
        var product = Product.builder()
                .name("Headphones - ZYCV")
                .price(100.00)
                .build();
        product.setCategory(category);
        productRepository.save(product);
    }

//    @Transactional
    public void createProductUnderCategory() {
        var category = categoryRepository.findById(3).orElseThrow();
        var product = Product.builder()
                .name("Kadhai-2")
                .price(78.90)
                .build();
        product.setCategory(category);
        productRepository.save(product);

    }

}
