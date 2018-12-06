package com.spproject.plantdb;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spproject.plantdb.web.PlantController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlantdbApplicationTests {

	@Autowired
	private PlantController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
