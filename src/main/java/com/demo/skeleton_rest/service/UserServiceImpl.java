package com.demo.skeleton_rest.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.demo.skeleton_rest.persistance.model.User;
import com.demo.skeleton_rest.persistance.repository.UserRepository;



@Profile("dev")
@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);		
	
	@Autowired
	private UserRepository userRepository;
	
	private static int workload = 10;


	public User create(User user) {
		User userHashed = new User();
		userHashed.setId(user.getId());
		userHashed.setEmail(user.getEmail());
		userHashed.setLogin(user.getLogin());
		userHashed.setPassword(hashPassword(user.getPassword()));
		userHashed.setAuthority(user.getAuthority());
		return userRepository.save(userHashed);
	}

	public void delete(String id) {
		userRepository.delete(id);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		return userRepository.findOne(id);
	}

	public User findByLoginAndPassword(String login, String password) {
		return userRepository.findByLoginAndPassword(login, password);
	}
	
	public User findByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public String generateToken(User user) {
		String token = "";
		
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secretKey");
		    token = JWT.create()
		        .withIssuer("auth0")
		        .sign(algorithm);
		} catch (UnsupportedEncodingException exception){
		    //UTF-8 encoding not supported
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
	 		
		return token;
	 

	}
	
	public String hashPassword(String password) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password, salt);
		return hashed_password;
	}
	
	public boolean checkPassword(String password, String stored_hash) {
		LOG.info("Check Crypt PWD for {} with {}", password, stored_hash);
		boolean password_verified = false;
		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password, stored_hash);

		return(password_verified);
	}



}
