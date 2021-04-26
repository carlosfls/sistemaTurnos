package com.springboot.sistematurnos.core.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "op_veh")
public class OperacionVehiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String opId;
	
	private String vehiculoId;
	
	private Long turnoId;
	
	private String descOperacion;
	
	public OperacionVehiculo() {
	}

	public OperacionVehiculo(String opId, String vehiculoId,Long turnoId,String descOperacion) {
		this.opId = opId;
		this.vehiculoId = vehiculoId;
		this.turnoId = turnoId;
		this.descOperacion = descOperacion;
	}
	
	
}
