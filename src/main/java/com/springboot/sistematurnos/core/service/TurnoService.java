package com.springboot.sistematurnos.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sistematurnos.core.entity.Turno;
import com.springboot.sistematurnos.core.repo.TurnoRepo;

@Service
public class TurnoService {
	
	@Autowired
	TurnoRepo turnoRepo;
	
	public List<Turno>getAll(){
		return (List<Turno>) turnoRepo.findAll();
	}
	
	public List<Turno>getByEmpleado(String descEmpleado){
		return turnoRepo.findByDescEmpleado(descEmpleado);
	}
	
	public List<Turno>getByFecha(Date fecha){
		return turnoRepo.findByFechaLlegada(fecha);
	}
	
	public Turno crearTurno(Turno t) {
		return turnoRepo.save(t);
	}
	
	public void elimTurnPorId(Long id) {
		turnoRepo.deleteById(id);
	}
	
	public Turno getTurnoById(Long id) {
		return turnoRepo.findById(id).orElse(null);
	}
}
