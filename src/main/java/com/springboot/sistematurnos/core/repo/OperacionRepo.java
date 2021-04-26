package com.springboot.sistematurnos.core.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.sistematurnos.core.entity.Operacion;

public interface OperacionRepo extends JpaRepository<Operacion, Long>{

	Optional<Operacion>findByOpId(String opId);
	
}
