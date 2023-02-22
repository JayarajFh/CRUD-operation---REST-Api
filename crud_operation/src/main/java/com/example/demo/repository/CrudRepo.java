package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.CrudEntity;

@Repository
public interface CrudRepo extends JpaRepository<CrudEntity, Integer>  {

	CrudEntity findByName(String name);
	void deleteByName (String name);

}
