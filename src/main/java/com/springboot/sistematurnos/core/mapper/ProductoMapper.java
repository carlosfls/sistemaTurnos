package com.springboot.sistematurnos.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.sistematurnos.core.entity.Producto;

public class ProductoMapper implements RowMapper<Producto>{

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Producto(
				rs.getString("Id_Producto"),
				rs.getString("Desc_Producto"),
				rs.getString("Id_Almacen"),
				rs.getDouble("Existencia_Actual")
				);
	}

}
