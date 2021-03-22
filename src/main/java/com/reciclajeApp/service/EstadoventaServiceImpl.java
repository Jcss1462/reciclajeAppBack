package  com.reciclajeApp.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Estadoventa;
import com.reciclajeApp.repository.EstadoventaRepository;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class EstadoventaServiceImpl implements EstadoventaService{

	@Autowired
	private EstadoventaRepository estadoventaRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Estadoventa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Estadoventa> findById(Integer id) throws Exception {
		
		if(id==null) {
			throw new Exception("Id vacio");
		}
		if(!estadoventaRepository.existsById(id)) {
			
			throw new Exception("El estado de venta con id: "+id+" no existe");
		}
		return estadoventaRepository.findById(id);
	}

	@Override
	public Estadoventa save(Estadoventa entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadoventa update(Estadoventa entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Estadoventa entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Estadoventa entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
                
    
			
}
