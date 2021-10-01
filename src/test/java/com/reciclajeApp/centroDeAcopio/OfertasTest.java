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

import com.reciclajeApp.domain.Estadooferta;
import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.domain.Visitarecicladores;
import com.reciclajeApp.dto.VisitarecicladoresDTO;
import com.reciclajeApp.service.AplicantesofertasService;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.EstadoofertaService;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.EstadovisitaService;
import com.reciclajeApp.service.OfertasService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;
import com.reciclajeApp.service.VisitarecicladoresService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class OfertasTest {

	private final static Logger log = LoggerFactory.getLogger(OfertasTest.class);

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

	@Autowired
	OfertasService ofertasService;
	
	@Autowired
	EstadoofertaService estadoOfertaService;
	
	@Autowired
	AplicantesofertasService aplicantesOfertas;

	@Test
	@Order(1)
	void crearOfertas() throws Exception {
		
		//obtengo la informacion del usuario
		Usuario centroDeAcopio = usuarioService.findById("danielachocue3@gmail.com").get();
		
		//obtengo el estado de oferte disponible
		Estadooferta estadoOferta=estadoOfertaService.findById(1).get();
		
		//obtengo el po de residuo
		Tiporesiduo tipoResiduo=tipoResiduoService.findById(1).get();
		
		Ofertas nuevaOferta= new Ofertas();
		
		nuevaOferta.setCupos(3);
		nuevaOferta.setEmailCentroDeAcopio(centroDeAcopio);
		nuevaOferta.setEstadooferta(estadoOferta);
		nuevaOferta.setPrecioofrecidokl(50.000);
		nuevaOferta.setTiporesiduo(tipoResiduo);
		
		ofertasService.save(nuevaOferta);
	
	}
	
	@Test
	@Order(2)
	void misOfertas() throws Exception {
		//obtengo la informacion del usuario
		ofertasService.findOfertasDisponiblesByUser("danielachocue3@gmail.com");
	}
	
	@Test
	@Order(3)
	void aplicantesByOferta() throws Exception {
		//obtengo la informacion del usuario
		aplicantesOfertas.getAplicantesByOferta(23);
	}


}
