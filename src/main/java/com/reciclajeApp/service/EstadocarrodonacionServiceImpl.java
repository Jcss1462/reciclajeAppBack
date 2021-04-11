package  com.reciclajeApp.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Estadocarrodonacion;
import com.reciclajeApp.repository.EstadocarrodonacionRepository;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class EstadocarrodonacionServiceImpl implements EstadocarrodonacionService{

	@Autowired
	private EstadocarrodonacionRepository estadocarrodonacionRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Estadocarrodonacion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Estadocarrodonacion> findById(Integer id) throws Exception {
		if(id==null) {
			throw new Exception("Id vacio");
		}
		if(!estadocarrodonacionRepository.existsById(id)) {
			
			throw new Exception("El estado de carroDonacion con id: "+id+" no existe");
		}
		return estadocarrodonacionRepository.findById(id);
	}

	@Override
	public Estadocarrodonacion save(Estadocarrodonacion entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadocarrodonacion update(Estadocarrodonacion entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Estadocarrodonacion entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Estadocarrodonacion entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
                
    
			
}
