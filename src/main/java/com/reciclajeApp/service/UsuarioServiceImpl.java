package com.reciclajeApp.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.repository.UsuarioRepository;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

   
}
