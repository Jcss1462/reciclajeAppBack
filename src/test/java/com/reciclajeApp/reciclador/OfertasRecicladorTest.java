package com.reciclajeApp.reciclador;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

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

import com.reciclajeApp.domain.Aplicantesofertas;
import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.service.AplicantesofertasService;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.OfertasService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;
import com.reciclajeApp.service.VisitarecicladoresService;

@SpringBootTest
@Rollback(false)
@TestMethodOrder(OrderAnnotation.class)
class OfertasRecicladorTest {

	private final static Logger log = LoggerFactory.getLogger(OfertasRecicladorTest.class);

	@Autowired
	VentaService ventaService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	TiporesiduoService tipoResiduoService;

	@Autowired
	EstadoventaService estadoventaService;
	
	@Autowired
	VisitarecicladoresService visitaRecicladorService;

	@Autowired
	OfertasService ofertasService;
	
	@Autowired
	AplicantesofertasService aplicantesOfertasService;
	
	
	
	@Test
	@Order(1)
	void verOfertasDisponiblesByReciclador() throws Exception {
		ofertasService.findAllOfertasDisponiblesNoAplicadasPorReciclador("jcss1462@gmail.com");
	}
	
	
	@Test
	@Order(2)
	@Transactional
	void aplicarOferta() throws Exception {
		//obtengo una oferta
		Ofertas oferta = ofertasService.findById(46).get();
		Ofertas nuevaOferta= new Ofertas();
		
		nuevaOferta.setCupos(oferta.getCupos());
		nuevaOferta.setEmailCentroDeAcopio(oferta.getEmailCentroDeAcopio());
		nuevaOferta.setEstadooferta(oferta.getEstadooferta());
		nuevaOferta.setPrecioofrecidokl(oferta.getPrecioofrecidokl());
		nuevaOferta.setTiporesiduo(oferta.getTiporesiduo());
		
		nuevaOferta=ofertasService.save(nuevaOferta);
		
		//obtengo el usuario que va a aplicar
		Usuario reciclador =usuarioService.findById("jcss1462@gmail.com").get();
		
		Aplicantesofertas aplicacion = new Aplicantesofertas();
		
		aplicacion.setOfertas(nuevaOferta);
		aplicacion.setEmail_reciclador(reciclador);
		
		aplicantesOfertasService.save(aplicacion);
	}
	
	
	@Test
	@Order(3)
	void misAplicacionesReciclador() throws Exception {
		aplicantesOfertasService.getAplicacionesOfertasEnableByReciclador("jcss1462@gmail.com");
	}
	

}
