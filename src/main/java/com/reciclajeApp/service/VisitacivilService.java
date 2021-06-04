package com.reciclajeApp.service;

import com.reciclajeApp.domain.Visitacivil;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface VisitacivilService extends GenericService<Visitacivil, Integer> {

	public List<Visitacivil> findAllByByEnable();
	
}
