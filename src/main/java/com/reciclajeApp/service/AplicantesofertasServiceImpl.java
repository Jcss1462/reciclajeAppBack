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
import com.reciclajeApp.domain.Estadooferta;
import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.repository.AplicantesofertasRepository;
import com.reciclajeApp.repository.EstadoofertaRepository;
import com.reciclajeApp.repository.OfertasRepository;
import com.reciclajeApp.repository.UsuarioRepository;

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
	private UsuarioRepository usuarioRepository;

	@Autowired
	private EstadoofertaRepository estadoOfertaRepository;

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
		// valido
		validate(entity);

		// valido que no se exeda de los cupos
		Ofertas oferta = ofertaRepository.findById(entity.getOfertas().getIdoferta()).get();
		int cupos = oferta.getCupos();
		int aplicantesActuales = oferta.getAplicantesofertases().size();

		if (aplicantesActuales >= cupos) {
			throw new Exception("la oferta con id: " + entity.getOfertas().getIdoferta() + " ya esta llena");
		}

		// valido que el usuario no haya aplicado repetidas veces a la oferta
		for (Aplicantesofertas aplicante : oferta.getAplicantesofertases()) {
			if (entity.getEmail_reciclador().getEmail() == aplicante.getEmail_reciclador().getEmail()) {
				throw new Exception("ya aplicate a esta oferta");
			}
		}

		// guardo la aplicacion
		entity = aplicantesofertasRepository.save(entity);

		// si se llena el cupo modifico el estado de la oferta
		oferta = ofertaRepository.findById(entity.getOfertas().getIdoferta()).get();
		cupos = oferta.getCupos();
		aplicantesActuales = oferta.getAplicantesofertases().size() + 1;

		log.info("cupos" + cupos);
		log.info("aplicantes actuales" + aplicantesActuales);

		if (cupos == aplicantesActuales) {
			Estadooferta estadoLleno = estadoOfertaRepository.findById(2).get();
			oferta.setEstadooferta(estadoLleno);
			ofertaRepository.save(oferta);
		}

		// guardo la donacion
		return entity;
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
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!aplicantesofertasRepository.existsById(id)) {
			throw new Exception("La aplicacion a oferta con id: " + id + " no existe");
		}
		// solo se elimina la oferta si su estado es disponible
		Aplicantesofertas aplicacion = aplicantesofertasRepository.findById(id).get();
		if (aplicacion.getOfertas().getEstadooferta().getIdestadooferta() != 1) {
			throw new Exception("La oferta con id: " + id + " ya no se encuentra disponible para eliminar");
		}

		aplicantesofertasRepository.deleteById(id);
	}

	@Override
	public void validate(Aplicantesofertas entity) throws Exception {

		if (entity == null) {
			throw new Exception("La aplicacion es nula");
		}

		// valido que la oferta existe
		if (!ofertaRepository.existsById(entity.getOfertas().getIdoferta())) {
			throw new Exception("la oferta con id: " + entity.getOfertas().getIdoferta() + " no existe");
		}

		// valido que el usuario existe
		if (!usuarioRepository.existsById(entity.getEmail_reciclador().getEmail())) {
			throw new Exception("El usuario : " + entity.getEmail_reciclador().getEmail() + " no existe");
		}

		// valido que el usuario sea reciclador
		if (usuarioRepository.findById(entity.getEmail_reciclador().getEmail()).get().getTipousuario()
				.getIdtipousuario() != 1) {
			throw new Exception("El usuario : " + entity.getEmail_reciclador().getEmail()
					+ " no es reciclador, solo los usuarios recicladores pueden ofertar");
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
			throw new Exception("La oferta con id: " + idOferta + " No existe");
		}

		// TODO Auto-generated method stub
		return aplicantesofertasRepository.getAplicantesByOferta(idOferta);
	}

	@Override
	public List<Aplicantesofertas> getAplicacionesOfertasEnableByReciclador(String email) throws Exception {
		if (email == null || email.isBlank()) {
			throw new Exception("Email no ingresado");
		}

		// TODO Auto-generated method stub
		return aplicantesofertasRepository.getAplicacionesOfertasEnableByReciclador(email);
	}

}
