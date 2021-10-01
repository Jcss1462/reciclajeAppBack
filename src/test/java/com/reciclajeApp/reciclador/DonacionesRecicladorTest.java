package com.reciclajeApp.reciclador;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.reciclajeApp.controller.CarritoVentasRestController;
import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class DonacionesRecicladorTest {

	private final static Logger log = LoggerFactory.getLogger(DonacionesRecicladorTest.class);

	@Autowired
	VentaService ventaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TiporesiduoService tipoResiduoService;

	@Autowired
	EstadoventaService estadoventaService;
	
	@Autowired
	CarrodonacionesService carroDonacionService;;


	@Test
	@Order(1)
	void donacionesDesponiblesPorReciclador() throws Exception {

		carroDonacionService.findAllByByEnableNoAplicados("jcss1462@gmail.com");

	}
	
	@Test
	@Order(2)
	void donasionesAsignadas() throws Exception {

		carroDonacionService.findAllMyCarsAsign("jcss1462@gmail.com");

	}


	

}
