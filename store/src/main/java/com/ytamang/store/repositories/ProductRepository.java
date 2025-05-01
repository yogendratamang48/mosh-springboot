package com.ytamang.store.repositories;

import com.ytamang.store.dtos.ProductSummary;
import com.ytamang.store.dtos.ProductSummaryDTO;
import com.ytamang.store.entities.Category;
import com.ytamang.store.entities.Product;
import jakarta.persistence.MapKeyEnumerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name);
    List<Product> findByNameNotLike(String name);

    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameEndingWithIgnoreCase(String name);

    @Query("select p from Product p where p.price between :min and :max order by p.name")
    List<Product> findProducts(BigDecimal min, BigDecimal max);

    @Modifying
    @Query("update Product p set p.price=:newPrice where p.category.id=:categoryId")
    void updatePriceByCategory(@Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId);

    @Query("select new com.ytamang.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category=:category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);
}
