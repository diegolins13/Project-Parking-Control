package com.api.parkingcontrol.models;
//Vaga de estacionamento

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity		//Tornando a classe uma entidade
@Table(name = "TB_PARKING_SPOT")	//Criando a tabela e definindo o nome
public class ParkingSpotModel implements Serializable{ 	//Serializable + serialVersionUID serve para fazer o controle das versões no JVM
	private static final long serialVersionUID = 1L;
	
	//nullable = false: Nao pode ser nullo
	//unique = true: Será unico, não vai poder ter dois cadastros de uma mesma vaga
	//length: Numero de caracteres definido da String
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //Gerando o Id de forma automatica
	private UUID id; //UUID tipo do identificador apropriado univesal, para melhor distribuicao
	
	@Column(nullable = false, unique = true, length = 10)
	private String parkingSpotNumber; //Numero da vaga de estacionamento
	
	@Column(nullable = false, unique = true, length = 7)
	private String licensePlateCar; //Placa do carro
	
	@Column(nullable = false, length = 70)
	private String brandCar;  //Marca do carro
	
	@Column(nullable = false, length = 70)
	private String modelCar; //Modelo do carro
	
	@Column(nullable = false, length = 70)
	private String colorCar; //Cor do carro
	
	@Column(nullable = false)
	private LocalDateTime registrationDate;  //Data de registro
	
	@Column(nullable = false, length = 130)
	private String responsibleName;  //Nome do responsavel
	
	@Column(nullable = false, length = 30)
	private String apartment; //Apartamento
	
	@Column(nullable = false, length = 30)
	private String block; //Bloco	
	
	//Getters e Setters criado de forma automatica
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
