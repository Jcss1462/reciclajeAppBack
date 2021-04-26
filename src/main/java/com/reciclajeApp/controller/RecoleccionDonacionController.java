package com.reciclajeApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.AceptarSolicitud;
import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Estadocarrodonacion;
import com.reciclajeApp.domain.Solicitudesrecoleccion;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.dto.CarrodonacionesDTO;
import com.reciclajeApp.dto.SolicitudesrecoleccionDTO;
import com.reciclajeApp.mapper.CarrodonacionesMapper;
import com.reciclajeApp.mapper.SolicitudesrecoleccionMapper;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.EstadocarrodonacionService;
import com.reciclajeApp.service.SolicitudesrecoleccionService;
import com.reciclajeApp.service.UsuarioService;

@RestController
@RequestMapping("/api/v1/recoleccion")
@CrossOrigin(origins = "*")
public class RecoleccionDonacionController {

	private final static Logger log = LoggerFactory.getLogger(RecoleccionDonacionController.class);

	@Autowired
	private CarrodonacionesService carroDonacionService;
	@Autowired
	private CarrodonacionesMapper carroDonacionMapper;
	@Autowired
	private SolicitudesrecoleccionService solicitudesrecoleccionService;
	@Autowired
	private SolicitudesrecoleccionMapper solicitudesrecoleccionMapper;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EstadocarrodonacionService estadoCarroDeDonacionService;

	// Get http
	@GetMapping("/allDonacionesByEnable")
	public ResponseEntity<?> allDonacionesByEnable() throws Exception {

		// obtengo la lista
		List<Carrodonaciones> listCarroDonaciones = carroDonacionService.findAllByByEnable();

		// convirto al dto
		List<CarrodonacionesDTO> listCarroDonacionesDto = carroDonacionMapper
				.listCarrodonacionesToListCarrodonacionesDTO(listCarroDonaciones);

		return ResponseEntity.ok().body(listCarroDonacionesDto);

	}

	@PostMapping("/aplicacionARecolectar")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> aplicacionARecolectar(
			@Valid @RequestBody SolicitudesrecoleccionDTO solicitudRecoleccionDto) throws Exception {

		Solicitudesrecoleccion solicitudRecoleccion = solicitudesrecoleccionMapper
				.solicitudesrecoleccionDTOToSolicitudesrecoleccion(solicitudRecoleccionDto);

		solicitudRecoleccion = solicitudesrecoleccionService.save(solicitudRecoleccion);

		solicitudRecoleccionDto = solicitudesrecoleccionMapper
				.solicitudesrecoleccionToSolicitudesrecoleccionDTO(solicitudRecoleccion);

		return ResponseEntity.ok().body(solicitudRecoleccionDto);
	}

	// Get http
	@GetMapping("/misSolicitudes/{cartId}")
	public ResponseEntity<?> misSolicitudes(@PathVariable("cartId") Integer cartId) throws Exception {

		// obtengo la lista
		List<Solicitudesrecoleccion> listSolicitudes = solicitudesrecoleccionService.findSolicitudesByCarID(cartId);

		// convirto al dto
		List<SolicitudesrecoleccionDTO> listSolicitudesDto = solicitudesrecoleccionMapper
				.listSolicitudesrecoleccionToListSolicitudesrecoleccionDTO(listSolicitudes);

		return ResponseEntity.ok().body(listSolicitudesDto);

	}

	@PutMapping("/aceptarSolicitud")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> aceptarSolicitud(@Valid @RequestBody AceptarSolicitud aceptacion) throws Exception {

		
		//obtengo el email del usuario
		Usuario reciclador = usuarioService.findById(aceptacion.getEmail()).get();
		
		//obtengo el carro de donacion que acepto la solicitud
		Carrodonaciones carro= carroDonacionService.findById(aceptacion.getCarroDonacionId()).get();
		
		//obtengo el tipo de estado de Asignado
		Estadocarrodonacion estado=estadoCarroDeDonacionService.findById(3).get();
		
		//actualizo el usuario reciclador
		carro.setRecolector(reciclador);
		carro.setEstadocarrodonacion(estado);
		
		//conviero a dto
		carro=carroDonacionService.update(carro);
		
		CarrodonacionesDTO carroDto=carroDonacionMapper.carrodonacionesToCarrodonacionesDTO(carro);

		return ResponseEntity.ok().body(carroDto);

	}

}
