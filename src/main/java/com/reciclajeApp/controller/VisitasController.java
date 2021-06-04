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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.Agendar;
import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.domain.Visitacivil;
import com.reciclajeApp.dto.CarrodonacionesDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.dto.VisitacivilDTO;
import com.reciclajeApp.mapper.VisitacivilMapper;
import com.reciclajeApp.service.EstadovisitaService;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VisitacivilService;

@RestController
@RequestMapping("/api/v1/visitas")
@CrossOrigin(origins = "*")
public class VisitasController {

	private final static Logger log = LoggerFactory.getLogger(VisitasController.class);

	@Autowired
	private VisitacivilService visitasCivilService;
	@Autowired
	private VisitacivilMapper visitasCivilMapper;

	@Autowired
	private EstadovisitaService estadoVisitaService;

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/nuevaVisita")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> nuevaVisita(@Valid @RequestBody VisitacivilDTO visitaDto) throws Exception {

		Visitacivil visita = visitasCivilMapper.visitacivilDTOToVisitacivil(visitaDto);

		// establesco todavisita nueva como disponible
		Estadovisita estadoVisita = estadoVisitaService.findById(1).get();
		visita.setEstadovisita(estadoVisita);
		visita.setEmailRecolector(null);

		visita = visitasCivilService.save(visita);

		visitaDto = visitasCivilMapper.visitacivilToVisitacivilDTO(visita);

		return ResponseEntity.ok().body(visitaDto);

	}

	// Get http
	@GetMapping("/visitasDisponibles")
	public ResponseEntity<?> visitasDisponibles() throws Exception {

		// obtengo la lista
		List<Visitacivil> listVisitaCivil = visitasCivilService.findAllByByEnable();

		// convirto al dto
		List<VisitacivilDTO> listVisitaCivilDto = visitasCivilMapper
				.listVisitacivilToListVisitacivilDTO(listVisitaCivil);

		return ResponseEntity.ok().body(listVisitaCivilDto);

	}

	@PutMapping("/agendar")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> agendar(@Valid @RequestBody Agendar agendar) throws Exception {

		// obtengo la visita y el usuario de la agend
		Visitacivil visita = visitasCivilService.findById(agendar.getIdVisita()).get();
		Usuario recilcador = usuarioService.findById(agendar.getEmailReciclador()).get();

		// valido que el usuario sea reciclador
		if (recilcador.getTipousuario().getIdtipousuario() != 1) {
			throw new Exception("El usuario: " + recilcador.getEmail() + " no es reciclador");
		}
		
		//verifico que la visita no tenga un reciclador asignado actualmente
		if(visita.getEmailRecolector()!=null||visita.getEstadovisita().getIdestadovisita()!=1) {
			throw new Exception("La visita con id: " + visita.getIdvisita() + " ya esta asignada");
		}

		// Obtengo el estado de agendado
		Estadovisita estadoVisita = estadoVisitaService.findById(2).get();

		// seteo los datos
		visita.setEmailRecolector(recilcador);
		visita.setEstadovisita(estadoVisita);

		// actualizo la visita
		visita = visitasCivilService.update(visita);

		// convierto lo guardado a dto para retornarlo
		VisitacivilDTO visitaCivilDto = visitasCivilMapper.visitacivilToVisitacivilDTO(visita);

		return ResponseEntity.ok().body(visitaCivilDto);

	}

	// Get http
	@GetMapping("/misVisitasAgendadasReciclador/{email}")
	public ResponseEntity<?> misVisitasAgendadasReciclador(@PathVariable("email") String email) throws Exception {

		// obtengo la lista
		List<Visitacivil> listVisitaCivil = visitasCivilService.misVisitasAgendadasReciclador(email);

		// convirto al dto
		List<VisitacivilDTO> listVisitaCivilDto = visitasCivilMapper
				.listVisitacivilToListVisitacivilDTO(listVisitaCivil);

		return ResponseEntity.ok().body(listVisitaCivilDto);

	}

	// Get http
	@GetMapping("/misVisitasActivasCivil/{email}")
	public ResponseEntity<?> misVisitasActivasCivil(@PathVariable("email") String email) throws Exception {

		// obtengo la lista
		List<Visitacivil> listVisitaCivil = visitasCivilService.misVisitasActivasCivil(email);

		// convirto al dto
		List<VisitacivilDTO> listVisitaCivilDto = visitasCivilMapper
				.listVisitacivilToListVisitacivilDTO(listVisitaCivil);

		return ResponseEntity.ok().body(listVisitaCivilDto);

	}

	@PutMapping("/cancelarVisitaReciclador")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> cancelarVisitaReciclador(@Valid @RequestBody Agendar agendar) throws Exception {

		// obtengo la visita y el usuario de la agend
		Visitacivil visita = visitasCivilService.cancelarVisitaReciclador(agendar);

		// convierto lo guardado a dto para retornarlo
		VisitacivilDTO visitaCivilDto = visitasCivilMapper.visitacivilToVisitacivilDTO(visita);

		return ResponseEntity.ok().body(visitaCivilDto);

	}

	// Get http
	@DeleteMapping("/eliminarVisitaCivil/{id}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> eliminarVisitaCivil(@PathVariable("id") Integer id) throws Exception {

		// borro
		visitasCivilService.deleteById(id);

		return ResponseEntity.ok().build();

	}

}
