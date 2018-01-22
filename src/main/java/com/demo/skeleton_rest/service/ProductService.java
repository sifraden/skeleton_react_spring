package com.demo.skeleton_rest.service;

import java.util.List;

import com.demo.skeleton_rest.persistance.model.Product;

public interface ProductService {

	Product create(Product product) throws Exception;
	 
	void delete(String id);
 
    List<Product> findAll();
 
    Product findById(String id);
    
    List<Product> findByName(String name);
 
    Product update(Product product);
}
