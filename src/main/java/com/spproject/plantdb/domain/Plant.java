package com.spproject.plantdb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "plant")
public class Plant implements Serializable {

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long plantid;
	@Column(length = 50)
	private String engname;
	@Column(length = 50)
	private String latname;
	@Column(length = 50)
	private String finname;
	@Column(length = 12)
	private String repotdate;
	@Column
	private String note;
	@Column
	private String imgurl;

	@ManyToOne
	@JoinColumn(name = "waterid")
	private WaterType waterid;

	@ManyToOne
	@JoinColumn(name = "lightid")
	private LightType lightid;

	@ManyToOne
	@JoinColumn(name = "fertilizerid")
	private FertilizerType fertilizerid;

	public Plant() {
	}

	public Plant(String engName, String latName, String finName, WaterType wtype, LightType ltype, FertilizerType ftype,
			String repotDate, String note, String imgUrl) {
		this.engname = engName;
		this.latname = latName;
		this.finname = finName;
		this.waterid = wtype;
		this.lightid = ltype;
		this.fertilizerid = ftype;
		this.repotdate = repotDate;
		this.note = note;
		this.imgurl= imgUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getPlantid() {
		return plantid;
	}

	public String getEngname() {
		return engname;
	}

	public String getLatname() {
		return latname;
	}

	public String getFinname() {
		return finname;
	}

	public String getRepotdate() {
		return repotdate;
	}

	public String getNote() {
		return note;
	}

	public String getImgurl() {
		return imgurl;
	}

	public WaterType getWaterid() {
		return waterid;
	}

	public LightType getLightid() {
		return lightid;
	}

	public FertilizerType getFertilizerid() {
		return fertilizerid;
	}

	public void setPlantid(Long plantId) {
		this.plantid = plantId;
	}

	public void setEngname(String engname) {
		this.engname = engname;
	}

	public void setLatname(String latname) {
		this.latname = latname;
	}

	public void setFinname(String finname) {
		this.finname = finname;
	}

	public void setRepotdate(String repotdate) {
		this.repotdate = repotdate;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public void setWaterid(WaterType waterid) {
		this.waterid = waterid;
	}

	public void setLightid(LightType lightid) {
		this.lightid = lightid;
	}

	public void setFertilizerid(FertilizerType fertilizerid) {
		this.fertilizerid = fertilizerid;
	}

	

	
}
