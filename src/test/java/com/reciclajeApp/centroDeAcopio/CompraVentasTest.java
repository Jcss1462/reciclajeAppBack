package com.reciclajeApp.centroDeAcopio;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.domain.Visitarecicladores;
import com.reciclajeApp.dto.VisitarecicladoresDTO;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.EstadovisitaService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;
import com.reciclajeApp.service.VisitarecicladoresService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class CompraVentasTest {

	private final static Logger log = LoggerFactory.getLogger(CompraVentasTest.class);

	@Autowired
	VentaService ventaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TiporesiduoService tipoResiduoService;

	@Autowired
	EstadoventaService estadoventaService;
	
	@Autowired
	CarrodonacionesService carroDonacionService;
	
	@Autowired
	VisitarecicladoresService visitaRecicladorService;
	
	@Autowired
	EstadovisitaService estadoVisitasService;


	@Test
	@Order(1)
	void ventasDisponiblesNoAplicadasPorCentroDeAcopio() throws Exception {
		ventaService.findVentasDisponiblesNoAplicadasPorCentroDeAcopio("danielachocue3@gmail.com");
	}
	
	@Test
	@Order(2)
	void aplicarAVenta() throws Exception {
		//obtengo la informacion de una venta que guardare como nueva
		Venta venta=ventaService.findById(37).get();
		venta.setIdventa(null);
		venta=ventaService.save(venta);
		
		int idVenta=venta.getIdventa();
		
		
		//obtengo la informacion del usuario
		Usuario centroDeAcopio = usuarioService.findById("danielachocue3@gmail.com").get();
		
		//obtengo el estado de la visita
		Estadovisita estadoVisita =estadoVisitasService.findById(1).get();
		
		//creo una nueva aplicacion
		Visitarecicladores visitaRecicladores = new  Visitarecicladores();
		
		//coloco una fecha para la visita
		Date fechaActual =  new GregorianCalendar(2021, 12, 30).getTime();
		
		visitaRecicladores.setEmailCentroDeAcopio(centroDeAcopio);
		visitaRecicladores.setEstadovisita(estadoVisita);
		visitaRecicladores.setFechahora(fechaActual);
		visitaRecicladores.setVenta(venta);
		
		
		visitaRecicladorService.save(visitaRecicladores);
		
	}
	
	
	@Test
	@Order(3)
	void comprasRealizadas() throws Exception {
		ventaService.findVentasByCentroDeAcopio("danielachocue3@gmail.com");
	}
	
	
	

}
