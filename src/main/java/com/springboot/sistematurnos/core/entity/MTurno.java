package com.springboot.sistematurnos.core.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MTurno{
	
	private Long id;
	
	private String descCliente;
	
	private String tipoServicio;
	
	private String tipoVehiculo;
	
	private String modelo;
	
	private String descVehiculo;
	
	private String descEmpleado;
	
	private String observaciones;
	
	private List<Operacion>operaciones;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaLlegada;

	public MTurno() {
		operaciones = new ArrayList<>();
	}

	
	
	public MTurno(String descCliente, String descVehiculo, String descEmpleado, String observaciones,
			Date fechaLlegada) {
		this.descCliente = descCliente;
		this.descVehiculo = descVehiculo;
		this.descEmpleado = descEmpleado;
		this.observaciones = observaciones;
		this.fechaLlegada = fechaLlegada;
		operaciones = new ArrayList<>();
	}
	
	public void addOperacion(Operacion op) {
		operaciones.add(op);
	}

	public MTurno(Long id, String descCliente, String tipoServicio, String tipoVehiculo, String modelo,
			String descVehiculo, String descEmpleado, String observaciones,Date fechaLlegada) {
		this.id = id;
		this.descCliente = descCliente;
		this.tipoServicio = tipoServicio;
		this.tipoVehiculo = tipoVehiculo;
		this.modelo = modelo;
		this.descVehiculo = descVehiculo;
		this.descEmpleado = descEmpleado;
		this.observaciones = observaciones;
		this.fechaLlegada = fechaLlegada;
	}
}
