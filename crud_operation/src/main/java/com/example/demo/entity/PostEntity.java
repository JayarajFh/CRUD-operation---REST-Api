package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PostEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String discription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private CrudEntity crudEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public CrudEntity getCrudEntity() {
		return crudEntity;
	}

	public void setCrudEntity(CrudEntity crudEntity) {
		this.crudEntity = crudEntity;
	}

	@Override
	public String toString() {
		return "PostEntity [id=" + id + ", discription=" + discription + ", crudEntity=" + crudEntity + "]";
	}
	
}
