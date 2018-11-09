package com.spproject.plantdb.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class LightType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long lightId;
	@Column(length = 50)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ltype")
	private List<Plant> plants;
	
	public LightType() {}
	
	public LightType(String name) {
		this.name = name;
	}

	public Long getLightId() {
		return lightId;
	}

	public String getName() {
		return name;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setLightId(Long lightId) {
		this.lightId = lightId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
	
}
