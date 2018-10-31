package com.spproject.plantdb.domain;

public class Needs {
	private String water;
	private String light;
	private String fertilizer;
	private String repotting;
	
	public Needs() {
		
	}

	public Needs(String water, String light, String fertilizer, String repotting) {
		this.water = water;
		this.light = light;
		this.fertilizer = fertilizer;
		this.repotting = repotting;
	}

	public String getWater() {
		return water;
	}

	public String getLight() {
		return light;
	}

	public String getFertilizer() {
		return fertilizer;
	}

	public String getRepotting() {
		return repotting;
	}

	public void setWater(String water) {
		this.water = water;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public void setFertilizer(String fertilizer) {
		this.fertilizer = fertilizer;
	}

	public void setRepotting(String repotting) {
		this.repotting = repotting;
	}
}

