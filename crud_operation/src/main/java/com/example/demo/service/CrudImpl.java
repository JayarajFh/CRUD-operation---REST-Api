package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepo;

@Service
public class CrudImpl {
	
	@Autowired
	private CrudRepo crudRepository;
	
	public CrudEntity saveproduct (CrudEntity crudEntity) {
		return crudRepository.save(crudEntity);
	}
	public List<CrudEntity> saveproducts (List<CrudEntity> crudEntities) {
		return crudRepository.saveAll(crudEntities);
	}
	public List<CrudEntity> getProduct () {
		System.out.println(crudRepository.findAll());
		return crudRepository.findAll();
	}
	public CrudEntity getProductById (int Id) {
		System.out.println(Id);
		return crudRepository.findById(Id).orElse(null);
	}
	public CrudEntity getProductByName (String name) {
		return crudRepository.findByName(name);
	}
	public String deleteProductById (int Id) {
		crudRepository.deleteById(Id);
		return "product Removed" +Id;
	}
	public String deleteProductByName (String name) {
		crudRepository.deleteByName(name);
		return "product Removed" +name;
	}
	public void deleteAllProduct () {
		crudRepository.deleteAll();
		
	}
	public CrudEntity updateProduct (CrudEntity crudEntity) {
		CrudEntity existingProduct = crudRepository.findById(crudEntity.getId()).orElse(null);
		existingProduct.setName(crudEntity.getName());
		existingProduct.setQuantity(crudEntity.getQuantity());
		existingProduct.setPrice(crudEntity.getPrice());
		return crudRepository.save(existingProduct);
	}
}
