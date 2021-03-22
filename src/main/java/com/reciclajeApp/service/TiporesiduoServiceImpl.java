package  com.reciclajeApp.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Tiporesiduo;
import com.reciclajeApp.repository.TiporesiduoRepository;

/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class TiporesiduoServiceImpl implements TiporesiduoService{

	@Autowired
	private TiporesiduoRepository tiporesiduoRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Tiporesiduo> findAll() {
		// TODO Auto-generated method stub
		return tiporesiduoRepository.findAll();
	}

	@Override
	public Optional<Tiporesiduo> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tiporesiduo save(Tiporesiduo entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tiporesiduo update(Tiporesiduo entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tiporesiduo entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Tiporesiduo entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
                
    	
}
