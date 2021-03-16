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

import com.reciclajeApp.domain.Usuario;
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
	public Optional<Venta> findById(Integer id) throws Exception{
		
		if(id==null) {
			throw new Exception("Id vacio");
		}
		if(!ventaRepository.existsById(id)) {
			
			throw new Exception("La venta con id: "+id+" no existe");
		}
		Optional<Venta> ventaOptinal=ventaRepository.findById(id);
		// TODO Auto-generated method stub
		return ventaOptinal;
	}

	@Override
	public Venta save(Venta entity) throws Exception {
		// valido
		validate(entity);
		// compruebo, si existe lanza el error
		if (ventaRepository.existsById(entity.getIdventa())) {
			throw new Exception("La venta con id:" + entity.getIdventa() + " ya existe");
		}
		// TODO Auto-generated method stub
		return ventaRepository.save(entity);
	}

	@Override
	public Venta update(Venta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Venta entity) throws Exception {
		
		validate(entity);
		
		ventaRepository.delete(entity);

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		
		if(id==null) {
			throw new Exception("Id vacio");
		}
		if(!ventaRepository.existsById(id)) {
			
			throw new Exception("La venta con id: "+id+" no existe");
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
	public List<Venta> findAllVentasByUser(String email) throws Exception{
		
		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}

		// TODO Auto-generated method stub
		return ventaRepository.findAllVentasByUser(email);
	}

}
