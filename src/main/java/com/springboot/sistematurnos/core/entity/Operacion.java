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
@Table(name = "operacion")
public class Operacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String opId;
	
	private String opDesc;
	
	public Operacion() {
	}

	public Operacion(String opId, String opDesc) {
		this.opId = opId;
		this.opDesc = opDesc;
	}

	
	
}
