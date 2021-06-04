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
import com.reciclajeApp.domain.Visitacivil;
import com.reciclajeApp.repository.UsuarioRepository;
import com.reciclajeApp.repository.VisitacivilRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class VisitacivilServiceImpl implements VisitacivilService {
	@Autowired
	private VisitacivilRepository visitacivilRepository;
	@Autowired
	private Validator validator;
	@Autowired
	private UsuarioRepository usuarioRepository;

	private final static Logger log = LoggerFactory.getLogger(VisitacivilServiceImpl.class);

	@Override
	public List<Visitacivil> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Visitacivil> findById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!visitacivilRepository.existsById(id)) {

			throw new Exception("La visita con id: " + id + " no existe");
		}
		Optional<Visitacivil> visitaOptinal = visitacivilRepository.findById(id);
		// TODO Auto-generated method stub
		return visitaOptinal;
	}

	@Override
	public Visitacivil save(Visitacivil entity) throws Exception {
		// valido
		validate(entity);

		// valido que el propietario exista y que solo sea civil
		if (!usuarioRepository.existsById(entity.getEmailPropietario().getEmail())) {
			throw new Exception("El usuario con email " + entity.getEmailPropietario().getEmail() + " no existe");
		}
		Usuario usuario = usuarioRepository.findById(entity.getEmailPropietario().getEmail()).get();
		if (usuario.getTipousuario().getIdtipousuario() != 2) {
			throw new Exception("La propietario " + entity.getEmailPropietario().getEmail() + " no es civil");
		}

		// valido que la fecha no sea inferior a la fecha actual
		/**
		 * // obtengo y seteo la fecha actual en el formato correcto Date
		 * fechaHoraActual = java.sql.Timestamp.valueOf(LocalDateTime.now());
		 * log.info("Hora actual: "+fechaHoraActual.toString());
		 * 
		 * //obetngo la fecha de la visita en el formato correcto
		 * 
		 * 
		 * log.info("Hora visita: "+entity.getFechahora().getHours());
		 * 
		 */

		// TODO Auto-generated method stub
		return visitacivilRepository.save(entity);
	}

	@Override
	public Visitacivil update(Visitacivil entity) throws Exception {
		// si es nulo o esta en blanco
		if (entity.getIdvisita() == null) {
			throw new Exception("El idVisitaCivil es obligatorio");
		}

		// valido
		validate(entity);

		// si no existe lanza el error
		if (visitacivilRepository.existsById(entity.getIdvisita()) == false) {
			throw new Exception("La visita con id:" + entity.getIdvisita() + " no existe");
		}

		return visitacivilRepository.save(entity);
	}

	@Override
	public void delete(Visitacivil entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Visitacivil entity) throws Exception {
		if (entity == null) {
			throw new Exception("La visita es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Visitacivil>> constrintViolation = validator.validate(entity);
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
	public List<Visitacivil> findAllByByEnable() {
		// TODO Auto-generated method stub
		return visitacivilRepository.findAllByByEnable();
	}

}