package com.Logingrupp4.Logingrupp4.repositories;

import org.springframework.data.repository.CrudRepository;

import com.Logingrupp4.Logingrupp4.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}
