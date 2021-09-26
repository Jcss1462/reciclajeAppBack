package com.reciclajeApp.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.ControladorVisita;
import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.domain.Visitarecicladores;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.dto.VisitarecicladoresDTO;
import com.reciclajeApp.mapper.VentaMapper;
import com.reciclajeApp.mapper.VisitarecicladoresMapper;
import com.reciclajeApp.repository.VentaRepository;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.EstadovisitaService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;
import com.reciclajeApp.service.VisitarecicladoresService;

@RestController
@RequestMapping("/api/v1/visitasRecicladores")
@CrossOrigin(origins = "*")
public class VisitasRecicladoresController {

	private final static Logger log = LoggerFactory.getLogger(VisitasRecicladoresController.class);

	@Autowired
	private VentaService ventaService;

	@Autowired
	private VentaMapper ventaMapper;

	@Autowired
	private VisitarecicladoresService visitaRecicadorService;

	@Autowired
	private VisitarecicladoresMapper visitaRecicladorMapper;

	@Autowired
	private EstadovisitaService estadoVisitaService;

	@Autowired
	private EstadoventaService estadoVentaService;

	@Autowired
	private UsuarioService usuaioService;

	// CENTRO DE ACOPIO
	@GetMapping("/ventasDisponiblesNoaplicadasPorCentroDeAcopio/{email}")
	public ResponseEntity<?> ventasDisponiblesNoaplicadasPorCentroDeAcopio(@PathVariable("email") String email)
			throws Exception {
		List<Venta> ventas = ventaService.findVentasDisponiblesNoAplicadasPorCentroDeAcopio(email);
		List<VentaDTO> ventaDto = ventaMapper.listVentaToListVentaDTO(ventas);
		return ResponseEntity.ok().body(ventaDto);
	}

	@PostMapping("/aplicarVisitaVenta")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> aplicarVisitaVenta(@Valid @RequestBody VisitarecicladoresDTO visitaDto) throws Exception {

		Visitarecicladores visita = visitaRecicladorMapper.visitarecicladoresDTOToVisitarecicladores(visitaDto);

		// establesco todavisita nueva como disponible
		Estadovisita estadoVisita = estadoVisitaService.findById(1).get();
		visita.setEstadovisita(estadoVisita);

		visita = visitaRecicadorService.save(visita);

		visitaDto = visitaRecicladorMapper.visitarecicladoresToVisitarecicladoresDTO(visita);

		return ResponseEntity.ok().body(visitaDto);

	}

	@GetMapping("/visitasAceptadas/{email}")
	public ResponseEntity<?> visitasAceptadas(@PathVariable("email") String email) throws Exception {
		List<Venta> ventas = ventaService.findVentasByCentroDeAcopio(email);
		List<VentaDTO> ventaDto = ventaMapper.listVentaToListVentaDTO(ventas);
		return ResponseEntity.ok().body(ventaDto);
	}

	// RECICLADOR
	@GetMapping("/ventasAplicadas/{email}")
	public ResponseEntity<?> ventasAplicadas(@PathVariable("email") String email) throws Exception {
		List<Venta> ventas = ventaService.findVentasDisponiblesByRecicladorAplicadas(email);
		List<VentaDTO> ventaDto = ventaMapper.listVentaToListVentaDTO(ventas);
		return ResponseEntity.ok().body(ventaDto);
	}

	@GetMapping("/visitasByVentas/{idVenta}")
	public ResponseEntity<?> visitasByVentas(@PathVariable("idVenta") Integer idVenta) throws Exception {
		List<Visitarecicladores> visitaRecicladores = visitaRecicadorService.visitasByVentas(idVenta);
		List<VisitarecicladoresDTO> visitaDto = visitaRecicladorMapper
				.listVisitarecicladoresToListVisitarecicladoresDTO(visitaRecicladores);
		return ResponseEntity.ok().body(visitaDto);
	}

	@PutMapping("/aceptarVisita")
	public ResponseEntity<?> aceptarVisita(@RequestBody ControladorVisita controladorVisita) throws Exception {

		Visitarecicladores visita = visitaRecicadorService.findById(controladorVisita.getIdVisita()).get();

		// obtengo la venta aceptada
		Venta venta = ventaService.findById(visita.getVenta().getIdventa()).get();

		VentaDTO ventaDto = ventaMapper.ventaToVentaDTO(venta);

		// obtengo el usuario de la visita y el nuevo estado de la venta
		Usuario comprador = usuaioService.findById(visita.getEmailCentroDeAcopio().getEmail()).get();
		Estadoventa estado = estadoVentaService.findById(2).get();

		ventaDto.setEmailCentroDeAcopio(comprador.getEmail());
		ventaDto.setIdestadoventa_Estadoventa(estado.getIdestadoventa());

		venta = ventaMapper.ventaDTOToVenta(ventaDto);
		venta = ventaService.update(venta);
		ventaDto = ventaMapper.ventaToVentaDTO(venta);

		return ResponseEntity.ok().body(ventaDto);

	}

	// Get http
	@DeleteMapping("/deleteVisita/{id}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> deleteVisita(@PathVariable("id") Integer id) throws Exception {
	
		// borro
		visitaRecicadorService.deleteById(id);

		return ResponseEntity.ok().build();

	}
	
	
	@GetMapping("/ventasVendidasReciclador/{email}")
	public ResponseEntity<?> ventasVendidasReciclador(@PathVariable("email") String email) throws Exception {
		List<Venta> ventas = ventaService.findVentasVendidasByReciclador(email);
		List<VentaDTO> ventaDto = ventaMapper
				.listVentaToListVentaDTO(ventas);
		return ResponseEntity.ok().body(ventaDto);
	}

}
