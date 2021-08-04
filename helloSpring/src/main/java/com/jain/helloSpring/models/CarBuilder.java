package com.jain.helloSpring.models;

public class CarBuilder {
	private String make;
	private String model;
	private String manufacturingYear;
	private String color;
	private String transmission;
	private String trim;
	private String engineCapacity;
	private String fuelType;
	
	public String getMake() {
		return make;
	}

	public CarBuilder setMake(String make) {
		this.make = make;
		return this;
	}

	public String getModel() {
		return model;
	}

	public CarBuilder setModel(String model) {
		this.model = model;
		return this;
	}

	public String getManufacturingYear() {
		return manufacturingYear;
	}

	public CarBuilder setManufacturingYear(String manufacturingYear) {
		this.manufacturingYear = manufacturingYear;
		return this;
		
	}

	public String getColor() {
		return color;
	}

	public CarBuilder setColor(String color) {
		this.color = color;
		return this;
	}

	public String getTransmission() {
		return transmission;
	}

	public CarBuilder setTransmission(String transmission) {
		this.transmission = transmission;
		return this;
	}

	public String getTrim() {
		return trim;
	}

	public CarBuilder setTrim(String trim) {
		this.trim = trim;
		return this;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public CarBuilder setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
		return this;
	}

	public String getFuelType() {
		return fuelType;
	}

	public CarBuilder setFuelType(String fuelType) {
		this.fuelType = fuelType;
		return this;
	}


	
	public CarBuilder() {
		make = "Toyota";
		model = "Corolla";
		manufacturingYear = "2021";
		color = "Blue";
		transmission = "Automatic";
		trim = "Ac";
		engineCapacity = "2.0 L";
		fuelType = "gasoline";
				
				
	}
	
	public Cars build() {
		return new Cars(make, model, manufacturingYear,color, transmission, trim, engineCapacity, fuelType);
	}

}
