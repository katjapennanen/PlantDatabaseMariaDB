package com.spproject.plantdb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Plants")
public class Plant {
	
	@Id
	private String id;
	private Names names;
	private Needs needs;
	private String repotDate;
	
	public Plant() {
	}

	public Plant(Names names, Needs needs, String repotDate) {
		this.names = names;
		this.needs = needs;
		this.repotDate = repotDate;
	}

	public String getId() {
		return id;
	}

	public Names getNames() {
		return names;
	}

	public Needs getNeeds() {
		return needs;
	}

	public String getRepotDate() {
		return repotDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNames(Names names) {
		this.names = names;
	}

	public void setNeeds(Needs needs) {
		this.needs = needs;
	}

	public void setRepotDate(String repotDate) {
		this.repotDate = repotDate;
	}
}

