package com.reciclajeApp.service;

import static java.util.Collections.emptyList;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reciclajeApp.controller.CarritoVentasRestController;
import com.reciclajeApp.domain.Usuario;
import com.reciclajeApp.security.UserApplication;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Service
public class UserApplicationDetailsServiceImpl implements UserDetailsService {

	private final static Logger log = LoggerFactory.getLogger(UserApplicationDetailsServiceImpl.class);

	// inyecto el servicio
	@Autowired
	UsuarioService usuarioService;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("username:" + username);

		if (username == null) {
			throw new UsernameNotFoundException(username);
		}

		if (username.isBlank() == true) {
			throw new UsernameNotFoundException(username);
		}

		Optional<Usuario> usuario = null;
		try {
			usuario = usuarioService.findById(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (usuario.isPresent() == false) {
			throw new UsernameNotFoundException(username);
		}

		if (usuario.get().getEnable()==false) {
			throw new UsernameNotFoundException("El usuario esta inabilitado");
		}

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		UserApplication userApplication = new UserApplication(usuario.get().getEmail(), bCryptPasswordEncoder.encode(usuario.get().getPassword()));

		return new User(userApplication.getUsername(), userApplication.getPassword(), emptyList());
	}

}
