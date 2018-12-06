package com.spproject.plantdb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "water_type")
public class WaterType implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long waterid;
	@Column(length = 50)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "waterid")
	private List<Plant> plants;
	
	public WaterType() {}
	
	public WaterType(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getWaterid() {
		return waterid;
	}

	public String getName() {
		return name;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setWaterid(Long waterid) {
		this.waterid = waterid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
}
