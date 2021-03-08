package com.reciclajeApp.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.repository.UsuarioRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final static Logger log = LoggerFactory.getLogger(TipousuarioServiceImpl.class);

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private Validator validator;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario save(Usuario entity) throws Exception {

		// valido
		validate(entity);

		// compruebo, si existe lanza el error
		if (usuarioRepository.existsById(entity.getEmail())) {
			throw new Exception("El usuario con id:" + entity.getEmail() + " ya existe");
		}

		// TODO Auto-generated method stub
		return usuarioRepository.save(entity);
	}

	@Override
	public Usuario update(Usuario entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Usuario entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Usuario entity) throws Exception {

		if (entity == null) {
			throw new Exception("El usuario es nulo");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Usuario>> constrintViolation = validator.validate(entity);
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
