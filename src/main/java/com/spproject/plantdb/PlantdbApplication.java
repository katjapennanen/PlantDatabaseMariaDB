package com.spproject.plantdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.spproject.plantdb.domain.User;
import com.spproject.plantdb.domain.UserRepository;
import com.spproject.plantdb.domain.WaterType;
import com.spproject.plantdb.domain.WaterTypeRepository;

@SpringBootApplication
public class PlantdbApplication {
	private static final Logger log = LoggerFactory.getLogger(PlantdbApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlantdbApplication.class, args);
	}

	@Bean
	public CommandLineRunner plantDemo(PlantRepository prepo, WaterTypeRepository wrepo, LightTypeRepository lrepo,
			FertilizerTypeRepository frepo, UserRepository urepo) {
		return (args) -> {
			log.info("Save some stuffsies");

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
					wrepo.findByName("Let soil dry almost completely").get(0), lrepo.findByName("Partial Shade").get(0),
					frepo.findByName("Couple times a month").get(0), "2018-12-12"));

			prepo.save(new Plant("Elephant Ear Plant", "Alocasia", "Juurakkovehka",
					wrepo.findByName("Let soil dry almost completely").get(0), lrepo.findByName("Filtered sun").get(0),
					frepo.findByName("Weekly").get(0), "2018-12-12"));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$04$19ycEAQTqV66Cg4bZt9oR.xTEzfEaEXLrr/dSsOBVIjNr/ep3wtEm", "USER");
			User user2 = new User("admin", "$2a$04$txKbHel.N18yPJDEufmO..KFpUHaCa9AY7Am.fQdTou8uE8qZgOU6", "ADMIN");
			urepo.save(user1);
			urepo.save(user2);

			log.info("fetch all books");
			for (Plant plant : prepo.findAll()) {
				log.info(plant.toString());
			}

		};
	}
}
