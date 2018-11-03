package com.spproject.plantdb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WaterType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long waterId;
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wtype")
	private List<Plant> plants;
	
	public WaterType() {}
	
	public WaterType(String name) {
		this.name = name;
	}

	public Long getWaterId() {
		return waterId;
	}

	public String getName() {
		return name;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setWaterId(Long waterId) {
		this.waterId = waterId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

}
