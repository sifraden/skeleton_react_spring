package com.demo.skeleton_rest.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;
import com.demo.skeleton_rest.persistance.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	void delete(Product deleted);
	 
    List<Product> findAll();
 
    Product findOne(String id);
    
    List<Product> findByNameLike(String name);
 
    Product save(Product saved);

}

