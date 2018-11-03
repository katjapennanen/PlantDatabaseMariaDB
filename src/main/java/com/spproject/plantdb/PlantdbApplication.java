package com.spproject.plantdb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spproject.plantdb.domain.FertilizerType;
import com.spproject.plantdb.domain.FertilizerTypeRepository;
import com.spproject.plantdb.domain.LightType;
import com.spproject.plantdb.domain.LightTypeRepository;
import com.spproject.plantdb.domain.Plant;
import com.spproject.plantdb.domain.PlantRepository;
import com.spproject.plantdb.domain.WaterType;
import com.spproject.plantdb.domain.WaterTypeRepository;

@SpringBootApplication
public class PlantdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantdbApplication.class, args);
	}

	@Bean
	public CommandLineRunner plantDemo(PlantRepository prepo, WaterTypeRepository wrepo, LightTypeRepository lrepo,
			FertilizerTypeRepository frepo) {
		return (args) -> {

			// New watering types
			wrepo.save(new WaterType("Let soil dry almost completely"));
			wrepo.save(new WaterType("Let top of the soil dry"));
			wrepo.save(new WaterType("Let dry ony slightly"));
			wrepo.save(new WaterType("Do not let dry out"));

			// Creating lighting need types
			lrepo.save(new LightType("Full shade"));
			lrepo.save(new LightType("Partial Shade"));
			lrepo.save(new LightType("Filtered sun"));
			lrepo.save(new LightType("Partial sun"));
			lrepo.save(new LightType("Full sun"));

			// Creating fertilizing frequencies
			frepo.save(new FertilizerType("Max once a month"));
			frepo.save(new FertilizerType("Couple times a month"));
			frepo.save(new FertilizerType("Weekly"));

			// Save couple new plants
			prepo.save(new Plant("Pilea", "Pilea peperomioides", "Kilpipiilea",
					wrepo.findByName("Let soil dry almost completely").get(0), 
					lrepo.findByName("Partial Shade").get(0),
					frepo.findByName("Couple times a month").get(0), "2018-12-12"));

			prepo.save(new Plant("Elephant Ear Plant", "Alocasia", "Juurakkovehka",
					wrepo.findByName("Let soil dry almost completely").get(0), 
					lrepo.findByName("Filtered sun").get(0),
					frepo.findByName("Weekly").get(0), "2018-12-12"));

		};
	}
}
