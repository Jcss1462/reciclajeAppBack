package  com.reciclajeApp.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Estadoresiduo;
import com.reciclajeApp.repository.EstadoresiduoRepository;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class EstadoresiduoServiceImpl implements EstadoresiduoService{

	@Autowired
	private EstadoresiduoRepository estadoresiduoRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Estadoresiduo> findAll() {
		// TODO Auto-generated method stub
		return estadoresiduoRepository.findAll();
	}

	@Override
	public Optional<Estadoresiduo> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadoresiduo save(Estadoresiduo entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadoresiduo update(Estadoresiduo entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Estadoresiduo entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Estadoresiduo entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
                
    
			
}
