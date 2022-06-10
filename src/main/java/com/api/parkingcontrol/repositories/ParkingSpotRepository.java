package com.api.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.ParkingSpotModel;

//Criado como interface e fiz o extends (herança) do JpaRepository
//Dentro do <> JpaRepository é passado qual o model e o tipo de identificador
//Foi utilizado o JpaRespository por ele já possuir métodos prontos para poder utilizar para transações com banco de dados

@Repository  //Usado para transações com o banco de dados
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {
	
	// Declarando os métodos aqui no Repository para serem chamados dentro do Service
	public boolean existsByLicensePlateCar(String licensePlateCar); 
	public boolean existsByParkingSpotNumber(String parkingSpotNumber);
	public boolean existsByApartmentAndBlock(String apartment, String block);
	
}
