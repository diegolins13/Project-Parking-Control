package com.api.parkingcontrol.services;
//O Service fica entre o Controller e o Repository

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service  //Por ser uma camada de servico, deve inserir o esteriótipo @Service
public class ParkingSpotService {
	
	//Criando ponto de injeção de dependencias do ParkingSpotRepository
	//O Autowired pode ser declarado como construtor dessa forma:
	
	final ParkingSpotRepository parkingSpotRepository;

	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		super();
		this.parkingSpotRepository = parkingSpotRepository;
	}

	//Método criado para salvar os dados de Service para Model (parkingSpotService.save(parkingSpotModel)), presente no Controller.
	@Transactional  //Em uso de métodos construtivos ou destrutivos, é importante usar o @Transactional, principalmente quando tem relacionamento.
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.save(parkingSpotModel);
	}

	//Métodos criados para verificar se já existe os dados inseridos pelo cliente na classe Controller.
	//Para funcionar foram declarados em Repository.
	public boolean existsByLicensePlateCar(String licensePlateCar) {
		return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
	}

	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}

	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block) ;
	}

	//Método criado para exibir todas as vagas cadastradas solicitado pelo Controller.
	public List<ParkingSpotModel> findAll() {
		return parkingSpotRepository.findAll();
	}
	//Método criado para buscas (pesquisar) no banco de dados o id através do Controller.
	public Optional<ParkingSpotModel> findByid(UUID id) {
		return parkingSpotRepository.findById(id);
	}
		 
}
	/*Autowired: Serve para informar ao Spring que em determinados momentos 
	  ele vai ter que injetar dependencias de ParkingSpotRepository dentro de ParkingSpotService */
	
	/*Criando pontos de injeção de dependencias
	
	@Autowired  
	ParkingSpotRepository parkingSpotRepository; */

