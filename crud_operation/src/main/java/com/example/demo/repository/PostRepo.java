package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.PostEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
	

}
