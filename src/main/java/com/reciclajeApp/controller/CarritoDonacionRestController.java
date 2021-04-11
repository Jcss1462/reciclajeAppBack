package com.reciclajeApp.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Estadocarrodonacion;
import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.dto.CarrodonacionesDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.mapper.CarrodonacionesMapper;
import com.reciclajeApp.mapper.TiporesiduoMapper;
import com.reciclajeApp.mapper.VentaMapper;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.EstadocarrodonacionService;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.VentaService;

@RestController
@RequestMapping("/api/v1/carritoDonacion")
@CrossOrigin(origins = "*")
public class CarritoDonacionRestController {

	private final static Logger log = LoggerFactory.getLogger(CarritoDonacionRestController.class);

	@Autowired
	private CarrodonacionesService carroDonacionService;
	@Autowired
	private EstadocarrodonacionService estadoCarroDeDonacionService;
	@Autowired
	private CarrodonacionesMapper carroDonacionMapper;
	
	
	
	@PostMapping("/nuevoCarroDonacion")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> nuevoCarroDonacion(@Valid @RequestBody CarrodonacionesDTO carroDonacionDto) throws Exception {

		Carrodonaciones carroDonacion = carroDonacionMapper.carrodonacionesDTOToCarrodonaciones(carroDonacionDto);

		
		// establesco toda nueva vebta como disponible
		Estadocarrodonacion estadoCarroDonacion = estadoCarroDeDonacionService.findById(1).get();
		carroDonacion.setEstadocarrodonacion(estadoCarroDonacion);

		carroDonacion = carroDonacionService.save(carroDonacion);

		carroDonacionDto = carroDonacionMapper.carrodonacionesToCarrodonacionesDTO(carroDonacion);
		
		
		return ResponseEntity.ok().body(carroDonacionDto);

	}

	

}
