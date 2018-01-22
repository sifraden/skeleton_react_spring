package com.demo.skeleton_rest.service;

import java.util.List;

import com.demo.skeleton_rest.persistance.model.User;


public interface UserService {
	
	User create(User user);
	 
	void delete(String id);
 
    List<User> findAll();
 
    User findById(String id);
    
    User findByLoginAndPassword(String login, String password);
    
    User findByLogin(String login);
 
    User update(User user);
    
    String generateToken(User user);
    
	boolean checkPassword(String password_plaintext, String stored_hash);


}
