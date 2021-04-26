package com.springboot.sistematurnos.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
	
	private String productoId;
	
	private String productoDesc;
	
	private String almacenId;
	
	private double existenciaActual;
	
}
