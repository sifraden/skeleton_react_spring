package com.demo.skeleton_rest.persistance.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.skeleton_rest.persistance.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	void delete(User deleted);
	 
    List<User> findAll();
 
    User findOne(String id);
    
    User findByLoginAndPassword(String login, String password);
    
    User findByLogin(String login);
 
    User save(User saved);

}
