package com.ytamang.store.services;

import com.ytamang.store.entities.Category;
import com.ytamang.store.entities.Product;
import com.ytamang.store.repositories.ProductRepository;
import com.ytamang.store.repositories.CategoryRepository;
import com.ytamang.store.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

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
                .name("Furniture")
                .build();
        categoryRepository.save(category);
        var product = Product.builder()
                .name("Armchair - ZYCV")
                .price(55.00)
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

    @Transactional
    public void addToWishlist() {
        var user = userRepository.findById(1L).orElseThrow();
        var product = productRepository.findById(1L).orElseThrow();
        user.getWishlist().add(product);
        userRepository.save(user);
    }

    @Transactional
    public void deleteProduct(){
        System.out.println("Deleting product");
        productRepository.deleteById(1L);
    }
    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)(3));
    }

}
