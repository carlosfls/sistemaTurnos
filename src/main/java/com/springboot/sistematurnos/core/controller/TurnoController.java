package com.springboot.sistematurnos.core.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springboot.sistematurnos.core.entity.MTurno;
import com.springboot.sistematurnos.core.entity.Operacion;
import com.springboot.sistematurnos.core.entity.OperacionVehiculo;
import com.springboot.sistematurnos.core.entity.Turno;
import com.springboot.sistematurnos.core.service.OpVehiculoService;
import com.springboot.sistematurnos.core.service.OperacionService;
import com.springboot.sistematurnos.core.service.TurnoService;

@Controller
@RequestMapping("turnos")
public class TurnoController {
	
	@Autowired
	TurnoService turnoService;
	
	@Autowired
	OperacionService operacionService;

	@Autowired
	OpVehiculoService opVehiculoService;
	
	@ModelAttribute("servicios")
	public List<String> getServicios(){
		List<String>servicios=Arrays.asList(
				"MECANICA",
				"ELECTRICIDAD",
				"CHAPISTERIA",
				"PINTURA"
				);
		
		return servicios;
	}
	
	@ModelAttribute("vehiculos")
	public List<String> getVehiculos(){
		List<String>servicios=Arrays.asList(
				"PESADO",
				"FURGONETA",
				"LIGERO"
				);
		
		return servicios;
	}
	
	@ModelAttribute("listadoOp")
	public List<Operacion>getOperaciones(){
		return operacionService.getAll();
	}
	
	@GetMapping("/")
	public String listarTurnos(Model modelo) {
		List<Turno> listado = new ArrayList<>();
		turnoService.getAll().forEach(listado::add);
		modelo.addAttribute("turnoFiltrar", new Turno());
		modelo.addAttribute("listadoTurnos", listado);

		return "turnosHome";
	}
	
	@PostMapping("/filtrar")
	public String listarTurnoByFecha(@ModelAttribute(name = "turnoFiltrar")Turno t, Model modelo) {
		if(t.getFechaLlegada() == null) {
			return "redirect:/turnos/"; 
		}
		List<Turno> turnosFiltr = new ArrayList<>();
		turnoService.getByFecha(t.getFechaLlegada()).forEach(turnosFiltr::add);
		modelo.addAttribute("listadoTurnos", turnosFiltr);

		return "turnosHome";
	}


	@GetMapping("nuevo")
	public String getTurnoForm(@ModelAttribute("turno") MTurno mt,Model modelo) {
		modelo.addAttribute("titulo", "NUEVO");
		return "turnoForm";
	}

	@PostMapping("salvar")
	public String salvarTurno(@ModelAttribute("turno") MTurno mt) {
		Turno t = null;
		
		t = new Turno(mt.getId(),mt.getDescCliente(),
				mt.getTipoServicio(),mt.getTipoVehiculo(),
				mt.getModelo(),mt.getDescVehiculo(),mt.getDescEmpleado(),
				mt.getObservaciones(),mt.getFechaLlegada());
		
		Turno t2 = turnoService.crearTurno(t);
		
		Long id = t2.getId();
	
		for(Operacion op : mt.getOperaciones()) {
			OperacionVehiculo opV=new OperacionVehiculo(op.getOpId(),mt.getDescVehiculo(),id,op.getOpDesc());
			opVehiculoService.insertarOpVehic(opV);
		}
		
		return "redirect:/turnos/";
	}
	
	@GetMapping("detalles/{id}")
	public String busqTurno(@PathVariable(name = "id")Long id,Model modelo) {
		Turno tbusq = turnoService.getTurnoById(id);
		if(tbusq!=null) {
			MTurno mt = new MTurno(
					id,
					tbusq.getDescCliente(),
					tbusq.getTipoServicio(),
					tbusq.getTipoVehiculo(),
					tbusq.getModelo(),
					tbusq.getDescVehiculo(),
					tbusq.getDescEmpleado(),
					tbusq.getObservaciones(),
					tbusq.getFechaLlegada()
					);
			List<OperacionVehiculo>operacionesPdtes=opVehiculoService.getAllByIdTurno(id);
			modelo.addAttribute("operacionesPdtes", operacionesPdtes);
			modelo.addAttribute("turno", mt);
			modelo.addAttribute("titulo", "Detalles Turno "+tbusq.getId());
			
			return "turnoForm";
		}
		
		return "redirect:/turnos/";
	}
	
	@GetMapping("eliminar/{id}")
	public String eliminarTurno(@PathVariable(name = "id") Long id) {
		turnoService.elimTurnPorId(id);
		opVehiculoService.deleteOperByTurnoId(id);
		
		return "redirect:/turnos/";
	}
}
