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

import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Donacion;
import com.reciclajeApp.repository.DonacionRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class DonacionServiceImpl implements DonacionService {

	@Autowired
	private DonacionRepository donacionRepository;

	@Autowired
	private Validator validator;

	@Override
	public List<Donacion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Donacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Donacion save(Donacion entity) throws Exception {
		// valido
		validate(entity);
		//guardo la donacion
		return donacionRepository.save(entity);
	}

	@Override
	public Donacion update(Donacion entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Donacion entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!donacionRepository.existsById(id)) {

			throw new Exception("La donacion con id: " + id + " no existe");
		}

		donacionRepository.deleteById(id);
	}

	@Override
	public void validate(Donacion entity) throws Exception {
		if (entity == null) {
			throw new Exception("La donacion es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Donacion>> constrintViolation = validator.validate(entity);
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
