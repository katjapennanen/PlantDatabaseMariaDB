package com.spproject.plantdb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Plant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long plantId;
	@Column(length = 50)
	private String engName;
	@Column(length = 50)
	private String latName;
	@Column(length = 50)
	private String finName;
	@Column(length = 12)
	private String repotDate;
	private String note;
	private String imgUrl;

	@ManyToOne
	@JoinColumn(name = "waterId")
	private WaterType wtype;

	@ManyToOne
	@JoinColumn(name = "lightId")
	private LightType ltype;

	@ManyToOne
	@JoinColumn(name = "fertilizerId")
	private FertilizerType ftype;

	public Plant() {
	}

	public Plant(String engName, String latName, String finName, WaterType wtype, LightType ltype, FertilizerType ftype,
			String repotDate, String note, String imgUrl) {
		super();
		this.engName = engName;
		this.latName = latName;
		this.finName = finName;
		this.wtype = wtype;
		this.ltype = ltype;
		this.ftype = ftype;
		this.repotDate = repotDate;
		this.note = note;
		this.imgUrl= imgUrl;
	}

	public Long getPlantId() {
		return plantId;
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

	public String getRepotDate() {
		return repotDate;
	}

	public String getNote() {
		return note;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public WaterType getWtype() {
		return wtype;
	}

	public LightType getLtype() {
		return ltype;
	}

	public FertilizerType getFtype() {
		return ftype;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
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

	public void setRepotDate(String repotDate) {
		this.repotDate = repotDate;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public void setWtype(WaterType wtype) {
		this.wtype = wtype;
	}

	public void setLtype(LightType ltype) {
		this.ltype = ltype;
	}

	public void setFtype(FertilizerType ftype) {
		this.ftype = ftype;
	}

}
