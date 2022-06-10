package com.api.parkingcontrol.dtos;
/*Criado para receber e fazer as validações dos dados recebidos
  Pois se tiver dados errados, devem ser descartados e enviar uma bad request para o cliente */

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {

	/*Vai conter os atributos de ParkingSpotModel, menos o Id que é auto generate e o resgistrationDate que
	  terá uma "regrinha" para inserir, pois não será o cliente que irá digitar estes dois*/
	
	@NotBlank  //Verifica se o campo não nulo, se tem string vazia e etc.
	private String parkingSpotNumber;
	
	@NotBlank
	@Size(max = 7)  //Verifica se tem o máximo de 7 caracteres
	private String licensePlateCar;
	
	@NotBlank
	private String brandCar;
	
	@NotBlank
	private String modelCar;
	
	@NotBlank
	private String colorCar;
	
	@NotBlank
	private String responsibleName;
	
	@NotBlank	
	private String apartment;
	
	@NotBlank
	private String block;

	//Getters e Setters criado de forma automatica
	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}

	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}

	public String getLicensePlateCar() {
		return licensePlateCar;
	}

	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}
	
}
