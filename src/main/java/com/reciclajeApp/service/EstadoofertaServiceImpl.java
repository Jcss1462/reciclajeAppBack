package com.reciclajeApp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Estadooferta;
import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.repository.EstadoofertaRepository;
import com.reciclajeApp.repository.OfertasRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class EstadoofertaServiceImpl implements EstadoofertaService {

	@Autowired
	private EstadoofertaRepository estadoOfertaRepository;

	@Autowired
	private Validator validator;

	private final static Logger log = LoggerFactory.getLogger(EstadoofertaServiceImpl.class);

	@Override
	public List<Estadooferta> findAll() {
		// TODO Auto-generated method stub
		return estadoOfertaRepository.findAll();
	}

	@Override
	public Optional<Estadooferta> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!estadoOfertaRepository.existsById(id)) {

			throw new Exception("El estado de oferta con id: " + id + " no existe");
		}
		Optional<Estadooferta> estadoOfertaOptional = estadoOfertaRepository.findById(id);
		// TODO Auto-generated method stub
		return estadoOfertaOptional;
	}

	@Override
	public Estadooferta save(Estadooferta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadooferta update(Estadooferta entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Estadooferta entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Estadooferta entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

}
