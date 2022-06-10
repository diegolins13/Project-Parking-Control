package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //Permitindo que seja acessado de qualquer fonte
@RequestMapping("/parking_spot") // Criando o Mapping (URI) a nível de classe
public class ParkingSpotController {

	//Criando ponto de injeção de dependencias do ParkingSpotService
	
	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		super();
		this.parkingSpotService = parkingSpotService;
	}
	//Criando o método POST
	
	@PostMapping  
	public ResponseEntity<Object> savePakingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
		// Verificação se já existe registro dos dados: placa, numero da vaga e Apartamento and bloco. 
		if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
		}
		if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
		}
		if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
		}
		var parkingSpotModel = new ParkingSpotModel(); //Iniciando uma instância para salvar os dados em ParkingSpotModel
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); //Convertendo os dados inseridos em Dto para Model
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); //Setando a data de registro de forma automatica
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel)); // Não foi definido URI pois ja foi definido a nivel de clase no inicio
	}
	// saveParkingSpot: Método para salvar so dados digitados pelo cliente.
	/* ResponseEntity: Usado para montar uma resposta, tanto quanto status e corpo dessa resposta, 
	   colocado <Object> pois terá diferentes tipos de retorno */
	// @ResquestBody: Inserio para receber esse dados via JSON.
	// @Valid: Inserido para validar os dados inseridos pelo cliente.
	// var: Identifica o tipo da instância parkingSpotModel que é ParkingSpotModel (a partir do Java 8.0 em diante).
	//A hora será gerada com 3 horas a mais que o horário do Brasil.
	
		//Criando um método GET para exibicao da listagem de todas as vagas cadastradas no banco de dados.
		@GetMapping
		public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
			return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
	}
		//Criando um método GET para exibicao do cadastro por "id".
		@GetMapping("/{id}")
		public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){
			Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findByid(id); //Método findByid serve buscar o id no banco de dados e vai retornar um Optional de ParkingSpot model 
			//Condicao para verificar se aquele id digitado existe ou não.
			if(!parkingSpotModelOptional.isPresent()) { //Se este Optional não estiver presente, será retornado uma mensagem not found.
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
			}	
			return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
		}
}
