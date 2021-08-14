package com.webapp.restmobile.model;

import javax.persistence.Entity;

@Entity
public class Laptop {

	private long id;
	private String brand;
	private String serialNumber;

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", serialNumber=" + serialNumber + "]";
	}

	public Laptop(long id, String brand, String serialNumber) {
		super();
		this.id = id;
		this.brand = brand;
		this.serialNumber = serialNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
