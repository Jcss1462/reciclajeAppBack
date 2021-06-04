package com.reciclajeApp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Estadovisita;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.domain.Visitacivil;
import com.reciclajeApp.repository.EstadovisitaRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class EstadovisitaServiceImpl implements EstadovisitaService {

	@Autowired
	private EstadovisitaRepository estadovisitaRepository;

	@Autowired
	private Validator validator;

	@Override
	public List<Estadovisita> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Estadovisita> findById(Integer id) throws Exception {

		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!estadovisitaRepository.existsById(id)) {

			throw new Exception("El estado de visita con id: " + id + " no existe");
		}
		Optional<Estadovisita> estadoVisitaOptinal = estadovisitaRepository.findById(id);
		// TODO Auto-generated method stub
		return estadoVisitaOptinal;
	}

	@Override
	public Estadovisita save(Estadovisita entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadovisita update(Estadovisita entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Estadovisita entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Estadovisita entity) throws Exception {
		if (entity == null) {
			throw new Exception("El estado de visita es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Estadovisita>> constrintViolation = validator.validate(entity);
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

}
