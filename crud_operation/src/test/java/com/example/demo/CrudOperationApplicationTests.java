package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepo;
import com.example.demo.service.CrudImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudOperationApplicationTests {
	@Autowired
	private CrudImpl crudImpl;
	@MockBean
	private CrudRepo crudRepo;
	@Test
	public void getCrudTest() {
		CrudEntity crudEntity = new CrudEntity(1, "Ram", 100, 40);
		crudRepo.save(crudEntity);
		boolean actual = crudRepo.findById(1).orElse(null) != null;
		//CrudEntity crud = crudRepo.findById(1).orElse(null);
		//when(crudRepo.findById(1).orElse(null)).thenReturn(crudEntity);
		//assertEquals(1, crudImpl.getProduct().size());
		//assertThat(crud).isEqualTo(crudEntity);
		assertThat(actual).isTrue();
	}

}
