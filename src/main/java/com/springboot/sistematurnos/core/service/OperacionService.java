package com.springboot.sistematurnos.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sistematurnos.core.entity.Operacion;
import com.springboot.sistematurnos.core.repo.OperacionRepo;

@Service
public class OperacionService {

	@Autowired
	OperacionRepo operacionRepo;
	
	public List<Operacion>getAll(){
		return operacionRepo.findAll();
	}
}
