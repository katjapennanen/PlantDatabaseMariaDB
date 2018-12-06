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
@Table(name= "light_type")
public class LightType  implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long lightid;
	@Column(length = 50)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lightid")
	private List<Plant> plants;
	
	public LightType() {}
	
	public LightType(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getLightid() {
		return lightid;
	}

	public String getName() {
		return name;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setLightid(Long lightid) {
		this.lightid = lightid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}
}
