package com.example.demo.repoTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.CrudEntity;
import com.example.demo.repository.CrudRepo;
import com.example.demo.service.CrudImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepoTest {
	@Autowired
	private CrudImpl crudImpl;
	@Autowired
	private CrudRepo crudRepo;
	
	@Test
	public void findByName() {
		CrudEntity crudEntity = new CrudEntity(1, "Ram", 100, 40);
		crudRepo.save(crudEntity);
		CrudEntity crud = crudRepo.findByName("Ram");
		//CrudEntity crud = crudRepo.findById(1).orElse(null);
		//when(crudRepo.findById(1).orElse(null)).thenReturn(crudEntity);
		//assertEquals(1, crudImpl.getProduct().size());
		assertThat(crud).isEqualTo(crudEntity);
		//assertThat(actual).isTrue();
	}

}
