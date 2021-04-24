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
import com.reciclajeApp.domain.Solicitudesrecoleccion;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.repository.SolicitudesrecoleccionRepository;
import com.reciclajeApp.repository.UsuarioRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class SolicitudesrecoleccionServiceImpl implements SolicitudesrecoleccionService {
	@Autowired
	private SolicitudesrecoleccionRepository solicitudesrecoleccionRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Solicitudesrecoleccion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Solicitudesrecoleccion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solicitudesrecoleccion save(Solicitudesrecoleccion entity) throws Exception {
		// valido
		validate(entity);
		
		
		//verifico que el usuario exista
		if (!usuarioRepository.existsById(entity.getEmailReciclador().getEmail())) {

			throw new Exception("el usuario : " + entity.getEmailReciclador().getEmail() + " no existe");
		}
		
		Usuario usuario=usuarioRepository.findById(entity.getEmailReciclador().getEmail()).get();
		
		//verifico que el aplicante sea reciclador
		if (usuario.getTipousuario().getIdtipousuario()!=1) {

			throw new Exception("el usuario no es reciclador");
		}
		
		//verifico que nohaya aplicado antes a la recoleccion
		List<Solicitudesrecoleccion> listaDeSolicitudes=findMultiplesSolicitudes(entity.getEmailReciclador().getEmail(),entity.getCarrodonaciones().getIdcarrodonacion());
		
		if(listaDeSolicitudes.size()>0) {
			throw new Exception("Ya aplicaste a este carro");
		}
		
		
		return solicitudesrecoleccionRepository.save(entity);
	}

	@Override
	public Solicitudesrecoleccion update(Solicitudesrecoleccion entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Solicitudesrecoleccion entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Solicitudesrecoleccion entity) throws Exception {

		if (entity == null) {
			throw new Exception("La solicitud es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Solicitudesrecoleccion>> constrintViolation = validator.validate(entity);
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
	public List<Solicitudesrecoleccion> findMultiplesSolicitudes(String email, Integer idCarroDonacion) {
		// TODO Auto-generated method stub
		return solicitudesrecoleccionRepository.findMultiplesSolicitudes(email, idCarroDonacion);
	}

}
