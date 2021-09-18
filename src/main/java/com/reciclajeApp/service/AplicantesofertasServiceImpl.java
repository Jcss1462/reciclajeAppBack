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

import com.reciclajeApp.domain.Aplicantesofertas;
import com.reciclajeApp.repository.AplicantesofertasRepository;
import com.reciclajeApp.repository.OfertasRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class AplicantesofertasServiceImpl implements AplicantesofertasService {
	@Autowired
	private AplicantesofertasRepository aplicantesofertasRepository;

	@Autowired
	private OfertasRepository ofertaRepository;

	@Autowired
	private Validator validator;

	private final static Logger log = LoggerFactory.getLogger(AplicantesofertasServiceImpl.class);

	@Override
	public List<Aplicantesofertas> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Aplicantesofertas> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aplicantesofertas save(Aplicantesofertas entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aplicantesofertas update(Aplicantesofertas entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Aplicantesofertas entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Aplicantesofertas entity) throws Exception {

		if (entity == null) {
			throw new Exception("La aplicacion es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Aplicantesofertas>> constrintViolation = validator.validate(entity);
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
	public List<Aplicantesofertas> getAplicantesByOferta(Integer idOferta) throws Exception {
		
		// verifico que la oferta exista
		if (!ofertaRepository.existsById(idOferta)) {
			throw new Exception("La oferta con id: "+idOferta+" No existe");
		}

		// TODO Auto-generated method stub
		return aplicantesofertasRepository.getAplicantesByOferta(idOferta);
	}

}
