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
			wrepo.save(new WaterType("Let soil dry completely"));
			wrepo.save(new WaterType("Let soil mostly dry"));
			wrepo.save(new WaterType("Let top (~2cm) of the soil dry"));
			wrepo.save(new WaterType("Let dry only slightly"));
			wrepo.save(new WaterType("Constant moisture"));

			// Creating lighting need types
			lrepo.save(new LightType("Full shade"));
			lrepo.save(new LightType("Partial shade to full shade"));
			lrepo.save(new LightType("Partial shade/Specling of sun"));
			lrepo.save(new LightType("Full sun to partial shade"));
			lrepo.save(new LightType("Full sun"));

			// Creating fertilizing frequencies
			frepo.save(new FertilizerType("(Max) once a month"));
			frepo.save(new FertilizerType("Bi-weekly"));
			frepo.save(new FertilizerType("Weekly"));

			// Save couple new plants
			
			prepo.save(new Plant("Hanging pepper plant", "Peperomia Prostrata", "-",
					wrepo.findByName("Let dry only slightly").get(0), 
					lrepo.findByName("Full sun to partial shade").get(0),
					frepo.findByName("(Max) once a month").get(0), "2018-12-12", "Likes to be slightly pot-bound"));
			
			prepo.save(new Plant("Polka dot Begonia", "Begonia Maculata", "Pilkkubegonia",
					wrepo.findByName("Let top (~2cm) of the soil dry").get(0), 
					lrepo.findByName("Partial shade/Specling of sun").get(0),
					frepo.findByName("Weekly").get(0), "2018-12-12", "Leaves burn easily in direct sun"));
			
			prepo.save(new Plant("Swiss cheese plant, Monstera 'Monkey mask'", "Monstera Adansonii", "Menninkäisenlehti",
					wrepo.findByName("Let top (~2cm) of the soil dry").get(0), 
					lrepo.findByName("Partial shade to full shade").get(0),
					frepo.findByName("(Max) once a month").get(0), "2018-12-12", ""));
			
			prepo.save(new Plant("Madagascar palm", "Pachypodium lamerei", "Aavikkopaksujalka",
					wrepo.findByName("Let top (~2cm) of the soil dry").get(0), 
					lrepo.findByName("Full sun to partial shade").get(0),
					frepo.findByName("(Max) once a month").get(0), "2018-12-12", ""));
			
			prepo.save(new Plant("Pilea", "Pilea peperomioides", "Kilpipiilea",
					wrepo.findByName("Let top (~2cm) of the soil dry").get(0), 
					lrepo.findByName("Partial shade/Specling of sun").get(0),
					frepo.findByName("Bi-weekly").get(0), "2018-12-12", ""));

			prepo.save(new Plant("Elephant Ear Plant", "Alocasia", "Juurakkovehka",
					wrepo.findByName("Let dry only slightly").get(0), 
					lrepo.findByName("Partial shade to full shade").get(0),
					frepo.findByName("(Max) once a month").get(0), "2018-12-12", ""));
			
			prepo.save(new Plant("Elephant Ear Plant", "Alocasia Lauterbachiana", "-",
					wrepo.findByName("Let dry only slightly").get(0), 
					lrepo.findByName("Partial shade to full shade").get(0),
					frepo.findByName("(Max) once a month").get(0), "2018-12-12", ""));

			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$10$yPNvrMidBDJfKcLSwE3pFe1psXbwz2B36L16iP3p5XqY.s4WQq5wK", "USER");
			User user2 = new User("admin", "$2a$10$oVsKG/JjIyuSejF23XyTEuF4mx90fGXGyOg.o7TTUY/IyXlNakdFS", "ADMIN");
			urepo.save(user1);
			urepo.save(user2);

			log.info("fetch all books");
			for (Plant plant : prepo.findAll()) {
				log.info(plant.toString());
			}
		};
	}
}
