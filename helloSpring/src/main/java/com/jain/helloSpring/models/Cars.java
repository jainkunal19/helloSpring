package com.jain.helloSpring.models;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@Getter
@Setter
public class Cars {
	
	private String make;
	private String model;
	private String manufacturingYear;
	private String color;
	private String transmission;
	private String trim;
	private String engineCapacity;
	private String fuelType;
	
	public Cars(String make2, String model2, String manufacturingYear2, String color2, String transmission2,
			String trim2, String engineCapacity2, String fuelType2) {
		// TODO Auto-generated constructor stub
	}

}
