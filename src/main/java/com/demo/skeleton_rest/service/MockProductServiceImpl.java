package com.demo.skeleton_rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.demo.skeleton_rest.persistance.model.Product;

@Profile("mock")
@Service
public class MockProductServiceImpl implements ProductService {

	public Product create(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product ("123", "mock product1", "mock first product", 11));
		return products;
	}

	public Product findById(String id) {
		return new Product("11", "mock product 11", "mock product 11", 11);
	}

	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
