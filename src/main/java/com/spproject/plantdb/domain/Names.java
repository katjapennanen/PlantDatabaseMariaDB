package com.spproject.plantdb.domain;

public class Names {
	private String engName;
	private String latName;
	private String finName;
	
	public Names() {
	}

	public Names(String engName, String latName, String finName) {
		this.engName = engName;
		this.latName = latName;
		this.finName = finName;
	}

	public String getEngName() {
		return engName;
	}

	public String getLatName() {
		return latName;
	}

	public String getFinName() {
		return finName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public void setLatName(String latName) {
		this.latName = latName;
	}

	public void setFinName(String finName) {
		this.finName = finName;
	}
}

