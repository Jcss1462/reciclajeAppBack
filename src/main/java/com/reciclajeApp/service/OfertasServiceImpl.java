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

import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Venta;
import com.reciclajeApp.repository.OfertasRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class OfertasServiceImpl implements OfertasService {

	@Autowired
	private OfertasRepository ofertaRepository;

	@Autowired
	private Validator validator;

	private final static Logger log = LoggerFactory.getLogger(OfertasServiceImpl.class);

	@Override
	public List<Ofertas> findAll() {
		// TODO Auto-generated method stub
		return ofertaRepository.findAll();
	}

	@Override
	public Optional<Ofertas> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!ofertaRepository.existsById(id)) {

			throw new Exception("La oferta con id: " + id + " no existe");
		}
		Optional<Ofertas> ofertaOptional = ofertaRepository.findById(id);
		// TODO Auto-generated method stub
		return ofertaOptional;
	}

	@Override
	public Ofertas save(Ofertas entity) throws Exception {
		// valido
		validate(entity);
		// TODO Auto-generated method stub
		return ofertaRepository.save(entity);
	}

	@Override
	public Ofertas update(Ofertas entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Ofertas entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!ofertaRepository.existsById(id)) {
			throw new Exception("La oferta con id: " + id + " no existe");
		}
		//solo se elimina la oferta si su estado es disponible
		Ofertas oferta= ofertaRepository.findById(id).get();
		if(oferta.getAplicantesofertases().size()>0) {
			throw new Exception("La oferta con id: " + id + " ya fue aplicada, y no se puede eliminar");
		}
		
		ofertaRepository.deleteById(id);
	}

	@Override
	public void validate(Ofertas entity) throws Exception {
		
		if (entity == null) {
			throw new Exception("La oferta es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Ofertas>> constrintViolation = validator.validate(entity);
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
	public List<Ofertas> findOfertasDisponiblesByUser(String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}
		// TODO Auto-generated method stub
		return ofertaRepository.findOfertasDisponiblesByUser(email);
	}

	@Override
	public List<Ofertas> findAllOfertasDisponibles() throws Exception {
		// TODO Auto-generated method stub
		return ofertaRepository.findAllOfertasDisponibles();
	}

	@Override
	public List<Ofertas> findAllOfertasDisponiblesNoAplicadasPorReciclador(String email) throws Exception {
		// TODO Auto-generated method stub
		return ofertaRepository.findAllOfertasDisponiblesNoAplicadasBayReciclador(email);
	}


}
