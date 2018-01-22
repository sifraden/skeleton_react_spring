package com.demo.skeleton_rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.demo.skeleton_rest.persistance.model.Product;
import com.demo.skeleton_rest.persistance.model.User;
import com.demo.skeleton_rest.service.ProductService;
import com.demo.skeleton_rest.service.UserService;
import com.demo.skeleton_rest.service.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:9191", allowCredentials="false")
@Api(value="skeleton api", description="Operation for Skeleton Product Store")
@RestController
@RequestMapping("/api/skeleton")
public class skeletonController {
	
	private static final Logger LOG = LoggerFactory.getLogger(skeletonController.class);		
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
//	mongod --dbpath /Users/soufianeifraden/Desktop/Projets/mongodb/data/db/
	
    @CrossOrigin(origins = "*", allowCredentials="false", methods = (RequestMethod.POST))
	@ApiOperation(value = "Creation of product")
	@RequestMapping(value = "product/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	Product createProduct(@RequestBody Product product) throws Exception {
		System.out.println("WS Create " + product.toString());
		return productService.create(product);
		
	}
	
	@ApiOperation(value = "Get all the products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(value = "product/all", method = RequestMethod.GET)
	List<Product> getAllProducts() {
		System.out.println("WS get all products");
		return productService.findAll();
	}
	
	@ApiOperation(value = "Get a product")
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)	
	Product getProduct(@PathVariable String id) {
		return productService.findById(id);
	}
	
	@ApiOperation(value = "Get a products by name")
	@RequestMapping(value = "products/{name}", method = RequestMethod.GET)
	List<Product> getProductsByName(@PathVariable String name){
		return productService.findByName(name);
	}
	
	
	@ApiOperation(value = "Get all the users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	@RequestMapping(value = "user/all", method = RequestMethod.GET)
	List<User> getAllUsers(){
		return userService.findAll();
	}
	
	@ApiOperation(value = "Get a user by login & password")
	@RequestMapping(value = "user/{login}/{pwd}", method = RequestMethod.GET)
	String getUserByLoginAndPwd(@PathVariable String login, @PathVariable String pwd) {
		String token = null;
		User user = userService.findByLogin(login);
		if (user != null && userService.checkPassword(pwd, user.getPassword()))
			token = userService.generateToken(user);
		LOG.info("TOKEN {}", token);
		return token;
		
	}
	
	
	@RequestMapping(value = "user/add", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	User createUser(@RequestBody User user) {
		return userService.create(user);
	}
	
	@ApiOperation(value = "Delete product")
	@RequestMapping(value = "product/delete/{id}", method = RequestMethod.DELETE)
	void deleteProduct(@PathVariable String id) {
		productService.delete(id);
	}
	
	
	@RequestMapping(value = "user/isAdmin/{login}/", method = RequestMethod.GET)
	boolean isUserAdmin(@PathVariable String login) {
		System.out.println("Check Authority of user" + login);
		User user = userService.findByLogin(login);
		boolean isAdmin = false;
		if (user.getAuthority().equals("ADMIN"))
			isAdmin = true;
		
		return isAdmin;
	}
	

}
