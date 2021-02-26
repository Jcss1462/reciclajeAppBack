package  com.reciclajeApp.service;



import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Tipousuario;
import com.reciclajeApp.repository.TipousuarioRepository;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class TipousuarioServiceImpl implements TipousuarioService{
	
	private final static Logger log = LoggerFactory.getLogger(TipousuarioServiceImpl.class);

	@Autowired
	private TipousuarioRepository tipousuarioRepository;
	
	@Autowired
	private Validator validator;

	@Override
	public List<Tipousuario> findAll() {
		// TODO Auto-generated method stub
		return tipousuarioRepository.findAll();
	}

	@Override
	public Optional<Tipousuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipousuario save(Tipousuario entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tipousuario update(Tipousuario entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Tipousuario entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate(Tipousuario entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}
                
    
			
}
