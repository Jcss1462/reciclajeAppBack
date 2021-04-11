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

import com.reciclajeApp.domain.CarrodonacionHasDonacion;
import com.reciclajeApp.repository.CarrodonacionHasDonacionRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class CarrodonacionHasDonacionServiceImpl implements CarrodonacionHasDonacionService {
	@Autowired
	private CarrodonacionHasDonacionRepository carrodonacionHasDonacionRepository;
	@Autowired
	private Validator validator;

	@Override
	public List<CarrodonacionHasDonacion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CarrodonacionHasDonacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarrodonacionHasDonacion save(CarrodonacionHasDonacion entity) throws Exception {
		// valido
		validate(entity);

		return carrodonacionHasDonacionRepository.save(entity);
	}

	@Override
	public CarrodonacionHasDonacion update(CarrodonacionHasDonacion entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CarrodonacionHasDonacion entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(CarrodonacionHasDonacion entity) throws Exception {
		if (entity == null) {
			throw new Exception("La asignacion de la doncaion al carro es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<CarrodonacionHasDonacion>> constrintViolation = validator.validate(entity);
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
