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

import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.dto.TiporesiduoDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.mapper.TiporesiduoMapper;
import com.reciclajeApp.mapper.VentaMapper;
import com.reciclajeApp.service.EstadoventaService;
import com.reciclajeApp.service.TiporesiduoService;
import com.reciclajeApp.service.VentaService;

@RestController
@RequestMapping("/api/v1/carritoVentas")
@CrossOrigin(origins = "*")
public class CarritoVentasRestController {

	private final static Logger log = LoggerFactory.getLogger(CarritoVentasRestController.class);

	@Autowired
	private VentaService ventaService;
	@Autowired
	private EstadoventaService estadoVentaService;
	@Autowired
	private TiporesiduoService tipoResiduoService;
	@Autowired
	private VentaMapper ventaMapper;
	@Autowired
	private TiporesiduoMapper tipoResiduoMapper;

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

		// coloco los datos por defecto de una nuevaventa
		// obtengo y seteo la fecha actual
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
		log.info("fecha actual:" + date1);
		venta.setFechaventa(date1);
		
		// establesco toda nueva vebta como disponible
		Estadoventa estadoVenta = estadoVentaService.findById(1).get();
		venta.setEstadoventa(estadoVenta);
		
		
		//seteo al comprador como nulo
		venta.setEmailCentroDeAcopio(null);
		

		venta = ventaService.save(venta);

		ventaDTO = ventaMapper.ventaToVentaDTO(venta);

		return ResponseEntity.ok().body(ventaDTO);

	}

	// Get http
	@GetMapping("/findMyVentas/{email}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> findMyVentas(@PathVariable("email") String email) throws Exception {

		List<Venta> ventas = ventaService.findAllVentasByUserDisponiblesNoAplicadas(email);

		List<VentaDTO> ventasDto = ventaMapper.listVentaToListVentaDTO(ventas);

		return ResponseEntity.ok().body(ventasDto);

	}

	// Get http
	@GetMapping("/ventaInfo/{id}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> ventaInfo(@PathVariable("id") Integer id) throws Exception {

		Venta venta = ventaService.findById(id).get();
		VentaDTO ventaDto = ventaMapper.ventaToVentaDTO(venta);

		return ResponseEntity.ok().body(ventaDto);

	}

	// Get http
	@GetMapping("/listTipoResiduo")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> listTipoResiduo() throws Exception {

		List<Tiporesiduo> tipoResiduos = tipoResiduoService.findAll();
		List<TiporesiduoDTO> tipoResiduosDTO = tipoResiduoMapper.listTiporesiduoToListTiporesiduoDTO(tipoResiduos);

		return ResponseEntity.ok().body(tipoResiduosDTO);

	}

	// Get http
	@DeleteMapping("/deleteVenta/{id}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> deleteVenta(@PathVariable("id") Integer id) throws Exception {

		// borro
		ventaService.deleteById(id);

		return ResponseEntity.ok().build();

	}

	@PutMapping("/updateVenta")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> updateVenta(@Valid @RequestBody VentaDTO ventaDTO) throws Exception {
		
		// mapeo lo que recibo a product
		Venta venta = ventaMapper.ventaDTOToVenta(ventaDTO);
		
		//prevengo error al mapear el centro de acopio nulo
		if(ventaDTO.getEmailCentroDeAcopio()==null) {
			venta.setEmailCentroDeAcopio(null);
		}

		// coloco la nueva fecha
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
		log.info("fecha actual:" + date1);
		venta.setFechaventa(date1);

		// actualizo
		venta = ventaService.update(venta);

		// convierto lo guardo a dto para retornarlo
		ventaDTO = ventaMapper.ventaToVentaDTO(venta);

		return ResponseEntity.ok().body(ventaDTO);

	}

}
