package com.spproject.plantdb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class FertilizerType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long fertilizerId;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ftype")
	private List<Plant> plants;
	
	public FertilizerType() {}
	
	public FertilizerType(String name) {
		this.name = name;
	}

	public Long getFertilizerId() {
		return fertilizerId;
	}

	public String getName() {
		return name;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setFertilizerId(Long fertilizerId) {
		this.fertilizerId = fertilizerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

}
