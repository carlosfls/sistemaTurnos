package com.springboot.sistematurnos.core.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sistematurnos.core.entity.OperacionVehiculo;

public interface OpVehiculoRepo extends JpaRepository<OperacionVehiculo, Long>{
	
	List<OperacionVehiculo>findByVehiculoId(String vehiculoId);
	
	List<OperacionVehiculo>findByTurnoId(Long turnoId);
}
