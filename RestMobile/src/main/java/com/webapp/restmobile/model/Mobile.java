package com.webapp.restmobile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mobile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mobileId;
	private String mobileModel;
	private Double mobilePrice;
	private String mobileImageName;

	public Mobile() {
	}

	public Mobile(Integer mobileId, String mobileModel, Double mobilePrice, String mobileImageName) {
		super();
		this.mobileId = mobileId;
		this.mobileModel = mobileModel;
		this.mobilePrice = mobilePrice;
		this.mobileImageName = mobileImageName;
	}

	public Integer getMobileId() {
		return mobileId;
	}

	public void setMobileId(Integer mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileModel() {
		return mobileModel;
	}

	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}

	public Double getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(Double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getMobileImageName() {
		return mobileImageName;
	}

	public void setMobileImageName(String mobileImageName) {
		this.mobileImageName = mobileImageName;
	}

}
