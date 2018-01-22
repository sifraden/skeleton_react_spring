package com.demo.skeleton_rest.persistance.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document(collection = "product")
public class Product implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
    @ApiModelProperty(notes = "The database generated product ID")
	@Id
	private String id;
    
    @ApiModelProperty(notes = "name of the product")
	@Field
	private String name;
    
    @ApiModelProperty(notes = "description of the product")
	@Field
	private String description;
    
    @ApiModelProperty(notes = "The price of the product")
	@Field
	private double price;
	
	
	
	
	public Product() {
		super();
	}
	public Product(String id, String name, String description, double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
	

}
