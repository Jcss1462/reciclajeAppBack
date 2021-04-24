package  com.reciclajeApp.service;


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
import com.reciclajeApp.repository.CarrodonacionesRepository;
import com.reciclajeApp.repository.UsuarioRepository;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class CarrodonacionesServiceImpl implements CarrodonacionesService{

	@Autowired
	private CarrodonacionesRepository carrodonacionesRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
		
		//verfico que no tenga carros activos
		List<Carrodonaciones> carrosActivos=findAllByUserCarrosByEnable(entity.getUsuario().getEmail());
		if(carrosActivos.size()!=0) {
			throw new Exception("El usuario "+entity.getUsuario().getEmail()+" ya tiene un carro activo");
		}
		
		return carrodonacionesRepository.save(entity);
		
	}

	@Override
	public Carrodonaciones update(Carrodonaciones entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		
		if (usuarioRepository.existsById(email)==false) {
			throw new Exception("El usuario con email "+email+" no existe");
		}

		
		return carrodonacionesRepository.findAllByUserCarrosByEnable(email);
	}

	@Override
	public List<Carrodonaciones> findAllByByEnable() throws Exception {
		// TODO Auto-generated method stub
		return carrodonacionesRepository.findAllByByEnable();
	}
                
    
			
}
