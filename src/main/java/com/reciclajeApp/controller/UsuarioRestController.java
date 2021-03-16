package com.reciclajeApp.controller;

import com.reciclajeApp.domain.*;

import com.reciclajeApp.dto.UsuarioDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.mapper.UsuarioMapper;

import com.reciclajeApp.service.UsuarioService;

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

import java.util.List;

import javax.validation.Valid;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioRestController {

	private final static Logger log = LoggerFactory.getLogger(UsuarioRestController.class);

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioMapper usuarioMapper;

	// Get http
	@GetMapping("/findAll")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findAll() throws Exception {

		// lista de customers
		List<Usuario> usuarios = usuarioService.findAll();
		// uso el mapper par convertir la lista de custommers a los dtos
		List<UsuarioDTO> usuariosDto = usuarioMapper.listUsuarioToListUsuarioDTO(usuarios);

		return ResponseEntity.ok().body(usuariosDto);

	}

	@PostMapping("/save")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> save(@Valid @RequestBody UsuarioDTO usuarioDTO) throws Exception {

		// mapeo lo que recibo a usuario
		Usuario usuario = usuarioMapper.usuarioDTOToUsuario(usuarioDTO);
		// guardo el customer
		usuario = usuarioService.save(usuario);
		// convierto lo guardo a dto para retornarlo
		usuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuario);

		return ResponseEntity.ok().body(usuarioDTO);

	}

	// Get http
	@GetMapping("/findById/{email}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findById(@PathVariable("email") String email) throws Exception {

		Usuario usuario = usuarioService.findById(email).get();
		UsuarioDTO usuarioDTO = usuarioMapper.usuarioToUsuarioDTO(usuario);

		return ResponseEntity.ok().body(usuarioDTO);

	}

}
