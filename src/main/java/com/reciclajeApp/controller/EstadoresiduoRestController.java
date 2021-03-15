package com.reciclajeApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.Estadoresiduo;
import com.reciclajeApp.dto.EstadoresiduoDTO;
import com.reciclajeApp.mapper.EstadoresiduoMapper;
import com.reciclajeApp.service.EstadoresiduoService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/estadoresiduo")
@CrossOrigin(origins = "*")
public class EstadoresiduoRestController {

	private final static Logger log = LoggerFactory.getLogger(EstadoresiduoRestController.class);

	@Autowired
	private EstadoresiduoService estadoresiduoService;
	@Autowired
	private EstadoresiduoMapper estadoresiduoMapper;

	// Get http
	@GetMapping("/findAll")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findAll() throws Exception {

		// lista de customers
		List<Estadoresiduo> estadoResiduo = estadoresiduoService.findAll();
		// uso el mapper par convertir la lista de custommers a los dtos
		List<EstadoresiduoDTO> estadoResiduoDto = estadoresiduoMapper.listEstadoresiduoToListEstadoresiduoDTO(estadoResiduo);

		return ResponseEntity.ok().body(estadoResiduoDto);

	}
}
