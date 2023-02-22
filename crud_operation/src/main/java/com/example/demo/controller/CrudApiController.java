package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepo;
import com.example.demo.service.CrudImpl;

@RestController
public class CrudApiController {

	@Autowired
	private CrudImpl crudImpl;

	@PostMapping(path = "/save")
	private CrudEntity save(@Valid @RequestBody CrudEntity crudEntity) {
		//CrudEntity save1 = crudImpl.saveproduct(crudEntity);

		return crudImpl.saveproduct(crudEntity);
	}

	@PostMapping(path = "/saveall")
	private List<CrudEntity> saveAll(@RequestBody List<CrudEntity> crudEntity) {
		return crudImpl.saveproducts(crudEntity);
	}

	@GetMapping(path = "/getall")
	private ResponseEntity<List<CrudEntity>> getAll() {
		return new ResponseEntity<>(crudImpl.getProduct(), HttpStatus.OK);
	}

	@GetMapping(path = "/productbyid/{Id}")
	private CrudEntity getById(@PathVariable int Id) {
		CrudEntity productById = crudImpl.getProductById(Id);
		if (productById == null) {
			throw new productNotFoundException("Id " + Id);
		}
//		EntityModel<CrudEntity> entityModel = EntityModel.of(productById);
//		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAll());
//		entityModel.add(link.withRel("all-products"));
		return productById;
	}

	@GetMapping(path = "/product/{name}")
	private CrudEntity getByName(@PathVariable String name) {
		return crudImpl.getProductByName(name);
	}

	@DeleteMapping(path = "/deletebyid/{Id}")
	private String deletebyid(@PathVariable int Id) {
		return crudImpl.deleteProductById(Id);
	}

	@DeleteMapping(path = "/delete/{name}")
	private String deletebyname(@PathVariable String name) {
		return crudImpl.deleteProductByName(name);
	}

	@DeleteMapping(path = "/deleteall")
	private void deleteAll() {
		crudImpl.deleteAllProduct();
	}

	@PutMapping(path = "/update")
	private CrudEntity update(@RequestBody CrudEntity crudEntity) {
//		CrudEntity saveProduct = crudImpl.updateProduct(crudEntity);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//		.path("{Id}").buildAndExpand(saveProduct.getId()).toUri();
		return crudImpl.updateProduct(crudEntity);
	}
}
