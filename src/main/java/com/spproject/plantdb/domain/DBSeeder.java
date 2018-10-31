package com.spproject.plantdb.domain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBSeeder implements CommandLineRunner {
	private PlantRepository prepo;
	
	public DBSeeder(PlantRepository prepo) {
		this.prepo = prepo;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		
		Plant pilea = new Plant(
				new Names("Pilea", "Pilea Peperomioides", "Kilpipiilea"), 
				new Needs("Medium", "Medium", "Moderate", "Spring"), 
				"12121290");
		
		Plant alocasia = new Plant(
				new Names("Elephant Ear Plant", "Alocasia", "Juurakkovehka"), 
				new Needs("Medium", "Medium", "Moderate", "Spring"), 
				"12121290");
		
		this.prepo.deleteAll();
		
		this.prepo.save(pilea);
		this.prepo.save(alocasia);
	}
}
