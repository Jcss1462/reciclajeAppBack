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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.dto.UsuarioDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.mapper.UsuarioMapper;
import com.reciclajeApp.mapper.VentaMapper;
import com.reciclajeApp.service.UsuarioService;
import com.reciclajeApp.service.VentaService;

@RestController
@RequestMapping("/api/v1/carritoVentas")
@CrossOrigin(origins = "*")
public class CarritoVentasRestController {

	private final static Logger log = LoggerFactory.getLogger(UsuarioRestController.class);

	@Autowired
	private VentaService ventaService;
	@Autowired
	private VentaMapper ventaMapper;

	// Get http
	@GetMapping("/findAll")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findAll() throws Exception {

		List<Venta> ventas = ventaService.findAll();
		List<VentaDTO> ventasDto = ventaMapper.listVentaToListVentaDTO(ventas);

		return ResponseEntity.ok().body(ventasDto);

	}

	@PostMapping("/nuevaVenta")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> nuevaVenta(@Valid @RequestBody VentaDTO ventaDTO) throws Exception {

		Venta venta = ventaMapper.ventaDTOToVenta(ventaDTO);

		venta = ventaService.save(venta);

		ventaDTO = ventaMapper.ventaToVentaDTO(venta);

		return ResponseEntity.ok().body(ventaDTO);

	}

	// Get http
	@GetMapping("/findMyVentas/{email}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findMyVentas(@PathVariable("email") String email) throws Exception {

		List<Venta> ventas = ventaService.findAllVentasByUser(email);
		List<VentaDTO> ventasDto = ventaMapper.listVentaToListVentaDTO(ventas);

		return ResponseEntity.ok().body(ventasDto);

	}

}
