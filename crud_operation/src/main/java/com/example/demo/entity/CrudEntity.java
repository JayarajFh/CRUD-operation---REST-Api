package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_table")
public class CrudEntity {
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 2)
	private String name;
	private int quantity;
	private double price;
	
	@OneToMany(mappedBy = "crudEntity")
	@JsonIgnore
	private List<PostEntity> post;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public List<PostEntity> getPost() {
		return post;
	}
	public void setPost(List<PostEntity> post) {
		this.post = post;
	}
	public CrudEntity(){
		   super();
		}
	public CrudEntity(int id, String name, int quantity, double price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "CrudEntity [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
}
