package com.springboot.sistematurnos.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springboot.sistematurnos.core.entity.Producto;
import com.springboot.sistematurnos.core.mapper.ProductoMapper;

@Service
public class ExistenciasDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Producto>getAllProductos(){
		return jdbcTemplate
				.query("SELECT * FROM EXISTENCIAS_MCVS_HABANA", new ProductoMapper());
	}
	
	public List<Producto>getMax20Productos(){
		return jdbcTemplate
				.query("SELECT TOP 20 * FROM EXISTENCIAS_MCVS_HABANA", new ProductoMapper());
	}
}
