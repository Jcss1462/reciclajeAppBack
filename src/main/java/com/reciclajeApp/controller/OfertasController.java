package com.reciclajeApp.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.Aplicantesofertas;
import com.reciclajeApp.domain.Estadooferta;
import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.dto.AplicantesofertasDTO;
import com.reciclajeApp.dto.OfertasDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.mapper.AplicantesofertasMapper;
import com.reciclajeApp.mapper.DonacionMapper;
import com.reciclajeApp.mapper.OfertasMapper;
import com.reciclajeApp.service.AplicantesofertasService;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.EstadoofertaService;
import com.reciclajeApp.service.OfertasService;
import com.reciclajeApp.service.OfertasServiceImpl;

@RestController
@RequestMapping("/api/v1/ofertas")
@CrossOrigin(origins = "*")
public class OfertasController {

	private final static Logger log = LoggerFactory.getLogger(OfertasController.class);

	@Autowired
	private OfertasService ofertaService;
	
	@Autowired
	private AplicantesofertasService aplicantesOfertasService;

	@Autowired
	private EstadoofertaService estadoOfertaService;

	@Autowired
	private OfertasMapper ofertasMapper;
	
	@Autowired
	private AplicantesofertasMapper aplicantesOfertasMapper;
	
	
	//centro de acopio
	@PostMapping("/nuevaOferta")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> nuevaOferta(@Valid @RequestBody OfertasDTO ofertaDTO) throws Exception {
		Ofertas oferta = ofertasMapper.ofertasDTOToOfertas(ofertaDTO);
		// establesco toda oferta como disponible
		Estadooferta estadoOferta = estadoOfertaService.findById(1).get();
		oferta.setEstadooferta(estadoOferta);
		oferta = ofertaService.save(oferta);
		ofertaDTO = ofertasMapper.ofertasToOfertasDTO(oferta);
		return ResponseEntity.ok().body(ofertaDTO);
	}

	// Get http
	@GetMapping("/findMyOfertas/{email}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findMyOfertas(@PathVariable("email") String email) throws Exception {

		List<Ofertas> ofertas = ofertaService.findOfertasDisponiblesByUser(email);
		List<OfertasDTO> ofertasDto = ofertasMapper.listOfertasToListOfertasDTO(ofertas);
		return ResponseEntity.ok().body(ofertasDto);

	}
	
	// Get http
	@GetMapping("/aplicantesByOferta/{idOferta}")
	public ResponseEntity<?> aplicantesByOferta(@PathVariable("idOferta") Integer idOferta) throws Exception {

		List<Aplicantesofertas> aplicantesOfertas = aplicantesOfertasService.getAplicantesByOferta(idOferta);
		List<AplicantesofertasDTO> aplicantesOfertasDto = aplicantesOfertasMapper.listAplicantesofertasToListAplicantesofertasDTO(aplicantesOfertas);
		return ResponseEntity.ok().body(aplicantesOfertasDto);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//recicladores
	
	

}
