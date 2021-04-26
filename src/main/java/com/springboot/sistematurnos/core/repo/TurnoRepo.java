package com.springboot.sistematurnos.core.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.springboot.sistematurnos.core.entity.Turno;

public interface TurnoRepo extends PagingAndSortingRepository<Turno, Long>{
	
	List<Turno>findByFechaLlegada(Date fechaLlegada);
	
	List<Turno>findByDescEmpleado(String descEmpleado);
	
	
}
