package com.springboot.sistematurnos.core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.sistematurnos.core.dao.ExistenciasDAO;
import com.springboot.sistematurnos.core.entity.Producto;

@Controller
@RequestMapping("existencias")
public class ExistenciaController {

	@Autowired
	ExistenciasDAO existenciasDAO;
	
	@GetMapping("/")
	public String getExistencias(@ModelAttribute ("p") Producto p,Model modelo) {
		List<Producto>listadoProd=new ArrayList<>();
		existenciasDAO.getMax20Productos().forEach(listadoProd::add);
		modelo.addAttribute("listadoProd", listadoProd);
		
		return "existHome";
	}
	
	@PostMapping("/")
	public String filtrarProd(@ModelAttribute ("p") Producto p,Model modelo) {
		List<Producto>listadoProd=new ArrayList<>();
		existenciasDAO.getAllProductos()
		.stream()
		.filter(p2 -> p2.getProductoDesc().contains(p.getProductoDesc()))
		.forEach(listadoProd::add);
		
		modelo.addAttribute("listadoProd", listadoProd);
		
		return "existHome";
	}
}
