package com.hp.afterhours.mongo.model;

public class Car {
	String brand, model;
	Integer horsePower;
	
	public Car(String brand, String model, Integer horsePower) {
		this.brand = brand;
		this.model = model;
		this.horsePower = horsePower;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(Integer horsePower) {
		this.horsePower = horsePower;
	}
	
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model+ ", horsePower=" + horsePower+ "]";
	}
}
