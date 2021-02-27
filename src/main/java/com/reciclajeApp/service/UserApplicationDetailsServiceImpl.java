package com.reciclajeApp.service;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reciclajeApp.security.UserApplication;


/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Service
public class UserApplicationDetailsServiceImpl implements UserDetailsService {

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		UserApplication userApplication = new UserApplication("jcss1462", bCryptPasswordEncoder.encode("accion13"));

		return new User(userApplication.getUsername(), userApplication.getPassword(), emptyList());
	}

}
