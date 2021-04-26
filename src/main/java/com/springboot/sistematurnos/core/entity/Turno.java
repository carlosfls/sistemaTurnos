package com.springboot.sistematurnos.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "turno")
public class Turno implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descCliente;
	
	private String tipoServicio;
	
	private String tipoVehiculo;
	
	private String modelo;
	
	private String descVehiculo;
	
	private String descEmpleado;
	
	private String observaciones;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaLlegada;

	public Turno() {
	}

	public Turno(Long id,String descCliente, String tipoServicio, String tipoVehiculo, String modelo, String descVehiculo,
			String descEmpleado, String observaciones, Date fechaLlegada) {
		this.id=id;
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
