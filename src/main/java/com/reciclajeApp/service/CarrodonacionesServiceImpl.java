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
import com.reciclajeApp.domain.Estadocarrodonacion;
import com.reciclajeApp.repository.CarrodonacionesRepository;
import com.reciclajeApp.repository.EstadocarrodonacionRepository;
import com.reciclajeApp.repository.UsuarioRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class CarrodonacionesServiceImpl implements CarrodonacionesService {

	@Autowired
	private CarrodonacionesRepository carrodonacionesRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EstadocarrodonacionRepository estadocarrodonacionRepository;

	@Autowired
	private Validator validator;

	@Override
	public List<Carrodonaciones> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Carrodonaciones> findById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("Id vacio");
		}
		if (!carrodonacionesRepository.existsById(id)) {

			throw new Exception("el carro de donacion con id: " + id + " no existe");
		}
		Optional<Carrodonaciones> carroDonacionOptinal = carrodonacionesRepository.findById(id);
		// TODO Auto-generated method stub
		return carroDonacionOptinal;
	}

	@Override
	public Carrodonaciones save(Carrodonaciones entity) throws Exception {

		// valido
		validate(entity);

		// verfico que no tenga carros activos
		List<Carrodonaciones> carrosActivos = findAllByUserCarrosByEnable(entity.getUsuario().getEmail());
		if (carrosActivos.size() != 0) {
			throw new Exception("El usuario " + entity.getUsuario().getEmail() + " ya tiene un carro activo");
		}
		

		return carrodonacionesRepository.save(entity);

	}

	@Override
	public Carrodonaciones update(Carrodonaciones entity) throws Exception {
		// valido
		validate(entity);

		// verifico que el recolector exista
		if (usuarioRepository.existsById(entity.getRecolector().getEmail()) == false) {
			throw new Exception("El reciclaor con email " + entity.getRecolector().getEmail() + " no existe");
		}

		// verifico que el recolector sea de tipo reciclador
		if (usuarioRepository.findById(entity.getRecolector().getEmail()).get().getTipousuario()
				.getIdtipousuario() != 1) {
			throw new Exception("No se puede asignar este carro porque el usuario recolector no es reciclador");
		}

		return carrodonacionesRepository.save(entity);
	}

	@Override
	public void delete(Carrodonaciones entity) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Carrodonaciones entity) throws Exception {
		if (entity == null) {
			throw new Exception("La venta es nula");
		}

		// validator
		// retorna una lista de los constraint violados
		Set<ConstraintViolation<Carrodonaciones>> constrintViolation = validator.validate(entity);
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
	public List<Carrodonaciones> findAllByUserCarrosByEnable(String email) throws Exception {
		if (email == null) {
			throw new Exception("email vacio");
		}

		if (usuarioRepository.existsById(email) == false) {
			throw new Exception("El usuario con email " + email + " no existe");
		}
		
		
		return carrodonacionesRepository.findAllByUserCarrosByEnable(email);
	}

	@Override
	public List<Carrodonaciones> findAllByByEnable() throws Exception {
		// TODO Auto-generated method stub
		return carrodonacionesRepository.findAllByByEnable();
	}

	@Override
	public List<Carrodonaciones> findAllByByEnableNoAplicados(String email) throws Exception {
		if (email == null) {
			throw new Exception("email vacio");
		}

		if (usuarioRepository.existsById(email) == false) {
			throw new Exception("El usuario con email " + email + " no existe");
		}

		return carrodonacionesRepository.findAllByByEnableNoAplicados(email);
	}

	@Override
	public List<Carrodonaciones> findAllMyCarsAsign(String email) throws Exception {
		if (email == null) {
			throw new Exception("email vacio");
		}

		if (usuarioRepository.existsById(email) == false) {
			throw new Exception("El usuario con email " + email + " no existe");
		}

		return carrodonacionesRepository.findAllMyCarsAsign(email);
	}

	@Override
	public Carrodonaciones removerDeLaRuta(Integer idCarroDonacion) throws Exception {
		
		//valido que el carro de doncion exista
		if(!carrodonacionesRepository.existsById(idCarroDonacion)) {
			throw new Exception("El carro de donacion con id: " + idCarroDonacion + " no existe");
		}
		
		Carrodonaciones carro=carrodonacionesRepository.findById(idCarroDonacion).get();
		
		//valido que en este moemento el carro este asignado
		if(carro.getEstadocarrodonacion().getIdestadodonacion()!=3) {
			throw new Exception("El carro de donacion con id: " + idCarroDonacion + " no se puede remover de la ruta porque no esta asignado");
		}
		
		//valido que tenga un usuario recolector
		if(carro.getRecolector()==null) {
			throw new Exception("El carro de donacion con id: " + idCarroDonacion + " no se puede remover de la ruta porque no tirnr un recolector");
		}
		
		//si todo sale bien
		
		//establesco el estado del carro a disponible y remuevo al recolector
		Estadocarrodonacion estado= estadocarrodonacionRepository.findById(1).get();
		
		carro.setEstadocarrodonacion(estado);
		carro.setRecolector(null);
		
		//actualizo
		carro=carrodonacionesRepository.save(carro);
		
		return carro;
	}

}
