package com.springboot.sistematurnos.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sistematurnos.core.entity.OperacionVehiculo;
import com.springboot.sistematurnos.core.repo.OpVehiculoRepo;

@Service
public class OpVehiculoService {

	@Autowired
	OpVehiculoRepo opVehiculoRepo;
	
	public void insertarOpVehic(OperacionVehiculo opVeh) {
		opVehiculoRepo.save(opVeh);
	}
	
	public List<OperacionVehiculo>getAllByIdVehic(String idVehiculo){
		return opVehiculoRepo.findByVehiculoId(idVehiculo);
	}
	
	public List<OperacionVehiculo>getAllByIdTurno(Long turnoId){
		return opVehiculoRepo.findByTurnoId(turnoId);
	}
	
	public void deleteOperByTurnoId(Long Turnoid) {
		List<OperacionVehiculo>operAEliminar=opVehiculoRepo.findByTurnoId(Turnoid);
		opVehiculoRepo.deleteAll(operAEliminar);
	}
}
