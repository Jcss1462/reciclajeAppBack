package com.reciclajeApp.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reciclajeApp.domain.CarrodonacionHasDonacion;
import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Donacion;
import com.reciclajeApp.domain.Estadocarrodonacion;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.dto.CarrodonacionesDTO;
import com.reciclajeApp.dto.DonacionDTO;
import com.reciclajeApp.dto.VentaDTO;
import com.reciclajeApp.mapper.CarrodonacionesMapper;
import com.reciclajeApp.mapper.DonacionMapper;
import com.reciclajeApp.service.CarrodonacionHasDonacionService;
import com.reciclajeApp.service.CarrodonacionesService;
import com.reciclajeApp.service.DonacionService;
import com.reciclajeApp.service.EstadocarrodonacionService;

@RestController
@RequestMapping("/api/v1/carritoDonacion")
@CrossOrigin(origins = "*")
public class CarritoDonacionRestController {

	private final static Logger log = LoggerFactory.getLogger(CarritoDonacionRestController.class);

	@Autowired
	private CarrodonacionesService carroDonacionService;
	@Autowired
	private EstadocarrodonacionService estadoCarroDeDonacionService;
	@Autowired
	private CarrodonacionHasDonacionService carroHasDonacionService;
	@Autowired
	private DonacionService donacionService;
	@Autowired
	private CarrodonacionesMapper carroDonacionMapper;
	@Autowired
	private DonacionMapper donacionMapper;

	@PostMapping("/nuevoCarroDonacion")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> nuevoCarroDonacion(@Valid @RequestBody CarrodonacionesDTO carroDonacionDto)
			throws Exception {

		Carrodonaciones carroDonacion = carroDonacionMapper.carrodonacionesDTOToCarrodonaciones(carroDonacionDto);

		// establesco toda nueva vebta como disponible
		Estadocarrodonacion estadoCarroDonacion = estadoCarroDeDonacionService.findById(1).get();
		carroDonacion.setEstadocarrodonacion(estadoCarroDonacion);

		carroDonacion = carroDonacionService.save(carroDonacion);

		carroDonacionDto = carroDonacionMapper.carrodonacionesToCarrodonacionesDTO(carroDonacion);

		return ResponseEntity.ok().body(carroDonacionDto);

	}

	@PostMapping("/nuevaDonacion")
	// envio los datos por el body de la peticion http
	// @valid valida la entrada
	public ResponseEntity<?> nuevaDonacion(@Valid @RequestBody DonacionDTO donacionDto) throws Exception {

		Donacion donacion = donacionMapper.donacionDTOToDonacion(donacionDto);

		// Guardo la donacion
		donacion = donacionService.save(donacion);

		// obtengo el carro de doacion actual
		log.info("usuario: " + donacionDto.getEmailPropietario());
		Carrodonaciones carroActual = carroDonacionService
				.findAllByUserCarrosByEnable(donacionDto.getEmailPropietario()).get(0);

		// asigno la nueva donacion al carro activo
		CarrodonacionHasDonacion nuevoElemento = new CarrodonacionHasDonacion();
		nuevoElemento.setCarrodonaciones(carroActual);
		nuevoElemento.setDonacion(donacion);
		// gueardo el nuevo carro
		carroHasDonacionService.save(nuevoElemento);

		donacionDto = donacionMapper.donacionToDonacionDTO(donacion);
		return ResponseEntity.ok().body(donacionDto);

	}

	
	@DeleteMapping("/deleteDonacion/{id}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> deleteDonacion(@PathVariable("id") Integer id) throws Exception {

		// borro
		donacionService.deleteById(id);

		return ResponseEntity.ok().build();

	}

	// Get http
	@GetMapping("/misDonacionesActuales/{email}")
	// guardo lo mandado por el url en el parametro email
	// ? = puede retornar cualqier cosa
	public ResponseEntity<?> misDonacionesActuales(@PathVariable("email") String email) throws Exception {
		
		//obtengo el carro actual
		Carrodonaciones carroActual = carroDonacionService.findAllByUserCarrosByEnable(email).get(0);
		
		//obtengo las donaciones del carro actual
		List<DonacionDTO> response = new ArrayList<DonacionDTO>();
		
		List<CarrodonacionHasDonacion> ListaDonaciones=carroActual.getCarrodonacionHasDonacions();
		
		for (CarrodonacionHasDonacion val : ListaDonaciones) {
			response.add(donacionMapper.donacionToDonacionDTO(val.getDonacion()));
		}
		
		
		return ResponseEntity.ok().body(response);

	}

}
