package com.ytamang.store.repositories;

import com.ytamang.store.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
