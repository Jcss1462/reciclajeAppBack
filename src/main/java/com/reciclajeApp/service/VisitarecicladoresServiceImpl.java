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

import com.reciclajeApp.domain.Visitacivil;
import com.reciclajeApp.domain.Visitarecicladores;
import com.reciclajeApp.repository.UsuarioRepository;
import com.reciclajeApp.repository.VentaRepository;
import com.reciclajeApp.repository.VisitarecicladoresRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class VisitarecicladoresServiceImpl implements VisitarecicladoresService {
	@Autowired
	private VisitarecicladoresRepository visitarecicladoresRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Visitarecicladores> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Visitarecicladores> findById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!visitarecicladoresRepository.existsById(id)) {

			throw new Exception("La visita con id: " + id + " no existe");
		}
		Optional<Visitarecicladores> visitaOptinal = visitarecicladoresRepository.findById(id);
		// TODO Auto-generated method stub
		return visitaOptinal;
	}

	@Override
	public Visitarecicladores save(Visitarecicladores entity) throws Exception {
		// valido
		validate(entity);

		// valido la exixstencia de la venta y del centro de acopio

		if (!usuarioRepository.existsById(entity.getEmailCentroDeAcopio().getEmail())) {
			throw new Exception("El usuario con email " + entity.getEmailCentroDeAcopio().getEmail() + " no existe");
		}
		
		
		if (!ventaRepository.existsById(entity.getVenta().getIdventa())) {
			throw new Exception("El venta con id " + entity.getVenta().getIdventa() + " no existe");
		}

		// TODO Auto-generated method stub
		return visitarecicladoresRepository.save(entity);
	}

	@Override
	public Visitarecicladores update(Visitarecicladores entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Visitarecicladores entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!visitarecicladoresRepository.existsById(id)) {

			throw new Exception("La visita con id: " + id + " no existe");
		}

		visitarecicladoresRepository.deleteById(id);
	}

	@Override
	public void validate(Visitarecicladores entity) throws Exception {

		if (entity == null) {
			throw new Exception("La visitaReciclador es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Visitarecicladores>> constrintViolation = validator.validate(entity);
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
	public List<Visitarecicladores> visitasByVentas(Integer idVenta) throws Exception {
		
		if(!ventaRepository.existsById(idVenta)) {
			throw new Exception("La venta con id: "+idVenta+" no existe");
		}
		// TODO Auto-generated method stub
		return visitarecicladoresRepository.visitasByVentas(idVenta);
	}

}
