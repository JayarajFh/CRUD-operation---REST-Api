package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.CrudEntity;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.CrudRepo;
import com.example.demo.repository.PostRepo;

@RestController
public class PostController {
	
	@Autowired
	PostRepo repo;
	
	@Autowired
	CrudRepo repoCrud;
	
	@PostMapping(path = "/post/{id}")
	public ResponseEntity<PostEntity>  postData(@PathVariable int id, @Valid @RequestBody PostEntity post) {
		//Optional<CrudEntity> post1 = repo.findById(id);
		Optional<CrudEntity> post1 = repoCrud.findById(id);
		if (post1 == null) {
			throw new productNotFoundException("Id " + id);
		}
		post.setCrudEntity(post1.get());
		PostEntity posted = repo.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(posted.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@GetMapping(path = "/getpost/{id}")
	public List<PostEntity> getPostData(@PathVariable int id) {
		Optional<CrudEntity> post1 = repoCrud.findById(id);
		if (post1 == null) {
			throw new productNotFoundException("Id " + id);
		}
		return post1.get().getPost();
		//return repo.findById(id).orElse(null);
	}

}
