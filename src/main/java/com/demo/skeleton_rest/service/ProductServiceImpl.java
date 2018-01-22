package com.demo.skeleton_rest.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.demo.skeleton_rest.persistance.model.Product;
import com.demo.skeleton_rest.persistance.repository.ProductRepository;

@Profile("dev")
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product create(Product product) throws Exception {
		if (product.getId() == null || StringUtils.isBlank(product.getId()))
			throw new Exception("Product can't have ID null or empty");
		
		Product savedProduct = productRepository.save(product);	
		return savedProduct;
	}

	public void delete(String id) {
		productRepository.delete(id);
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(String id) {
		return productRepository.findOne(id);
	}

	public Product update(Product product) {
		return productRepository.save(product);
	}

	public List<Product> findByName(String name) {
		return productRepository.findByNameLike(name);
	}

}
