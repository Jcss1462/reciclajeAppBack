package com.reciclajeApp.civil;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import com.reciclajeApp.domain.CarrodonacionHasDonacion;
import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Donacion;
import com.reciclajeApp.domain.Estadocarrodonacion;
import com.reciclajeApp.domain.Estadooferta;
import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.domain.Visitarecicladores;
import com.reciclajeApp.dto.DonacionDTO;
import com.reciclajeApp.dto.VisitarecicladoresDTO;
import com.reciclajeApp.service.AplicantesofertasService;
import com.reciclajeApp.service.CarrodonacionHasDonacionService;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.DonacionService;
import com.reciclajeApp.service.EstadocarrodonacionService;
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
class DonacionCivilTest {

	private final static Logger log = LoggerFactory.getLogger(DonacionCivilTest.class);

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
	@Autowired
	CarrodonacionesService carroDonacionesService;

	@Autowired
	EstadocarrodonacionService estadoCarroDonacionService;

	@Autowired
	DonacionService donacionService;

	@Autowired
	CarrodonacionHasDonacionService carroHasDonacionesService;

	@Test
	@Order(1)
	void desabilitarCarroActualYCrearNuevo() throws Exception {
		Carrodonaciones carroDonacion = carroDonacionesService
				.inhabililitarCarrosDonacionYCreaciondeUnoNuevo("juan.camilosalazarserna@yahoo.es");
	}

	@Test
	@Order(2)
	void nuevaDonacion() throws Exception {

		Carrodonaciones carroDonacion = carroDonacionesService.findById(76).get();

		// creo la nueva donacion y la guardo
		Donacion nuevaDonacion = new Donacion();
		Tiporesiduo tipoResiduo = tipoResiduoService.findById(1).get();
		nuevaDonacion.setTiporesiduo(tipoResiduo);
		nuevaDonacion = donacionService.save(nuevaDonacion);

		// agrego la donacion al carro
		CarrodonacionHasDonacion asignacion = new CarrodonacionHasDonacion();
		asignacion.setCarrodonaciones(carroDonacion);
		asignacion.setDonacion(nuevaDonacion);

		carroHasDonacionesService.save(asignacion);

	}

	@Test
	@Order(3)
	@Transactional()
	void misDonacionesActivas() throws Exception {

		// obtengo el carro actual
		Carrodonaciones carroActual = carroDonacionService
				.findAllByUserCarrosByEnable("juan.camilosalazarserna@yahoo.es").get(0);

		// obtengo las donaciones del carro actual
		List<Donacion> response = new ArrayList<Donacion>();

		List<CarrodonacionHasDonacion> ListaDonaciones = carroActual.getCarrodonacionHasDonacions();

		for (CarrodonacionHasDonacion val : ListaDonaciones) {
			response.add(val.getDonacion());
		}

	}

}
