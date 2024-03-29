package com.reciclajeApp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.repository.VentaRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository ventaRepository;

	@Autowired
	private Validator validator;

	private final static Logger log = LoggerFactory.getLogger(VentaServiceImpl.class);

	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}

	@Override
	public Optional<Venta> findById(Integer id) throws Exception {

		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!ventaRepository.existsById(id)) {

			throw new Exception("La venta con id: " + id + " no existe");
		}
		Optional<Venta> ventaOptinal = ventaRepository.findById(id);
		// TODO Auto-generated method stub
		return ventaOptinal;
	}

	@Override
	public Venta save(Venta entity) throws Exception {
		// valido
		validate(entity);

		// TODO Auto-generated method stub
		return ventaRepository.save(entity);
	}

	@Override
	public Venta update(Venta entity) throws Exception {
		// si es nulo o esta en blanco
		if (entity.getIdventa() == null) {
			throw new Exception("El idVenta es obligatorio");
		}

		// valido
		validate(entity);

		// si no existe lanza el error
		if (ventaRepository.existsById(entity.getIdventa()) == false) {
			throw new Exception("La venta con id:" + entity.getIdventa() + " no existe");
		}

		return ventaRepository.save(entity);
	}

	@Override
	public void delete(Venta entity) throws Exception {

		validate(entity);

		ventaRepository.delete(entity);

	}

	@Override
	public void deleteById(Integer id) throws Exception {

		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!ventaRepository.existsById(id)) {

			throw new Exception("La venta con id: " + id + " no existe");
		}

		ventaRepository.deleteById(id);

	}

	@Override
	public void validate(Venta entity) throws Exception {

		if (entity == null) {
			throw new Exception("La venta es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Venta>> constrintViolation = validator.validate(entity);
		// si no esta vacia lanza el error
		if (constrintViolation.isEmpty() == false) {
			throw new ConstraintViolationException(constrintViolation);
		}

	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> findAllVentasByUserDisponiblesNoAplicadas(String email) throws Exception {

		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}

		// TODO Auto-generated method stub
		return ventaRepository.findAllVentasByRecicladorDisponiblesNoAplicadas(email);
	}

	@Override
	public List<Venta> findVentasDisponiblesNoAplicadasPorCentroDeAcopio(String email) throws Exception {
		
		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}

		return ventaRepository.findVentasDisponiblesNoAplicadasPorCentroDeAcopio(email);
	}

	@Override
	public List<Venta> findVentasByCentroDeAcopio(String email) throws Exception {
		
		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}

		return ventaRepository.findVentasByCentroDeAcopio(email);
	}

	@Override
	public List<Venta> findVentasDisponiblesByRecicladorAplicadas(String email) throws Exception {
		
		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}

		return ventaRepository.findVentasDisponiblesByRecicladorAplicadas(email);
		
	}

	@Override
	public List<Venta> findVentasVendidasByReciclador(String email) throws Exception {
		

		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}
		
		return ventaRepository.findVentasVendidasByReciclador(email);
	}

}
