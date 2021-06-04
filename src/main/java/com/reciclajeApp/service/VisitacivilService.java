package com.reciclajeApp.service;

import com.reciclajeApp.domain.Agendar;
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
	
	public List<Visitacivil> misVisitasAgendadasReciclador(String email);
	
	public List<Visitacivil> misVisitasActivasCivil(String email);
	
	public Visitacivil cancelarVisitaReciclador(Agendar agenda) throws Exception;
	
	public Visitacivil confirmarRecoleccion(Integer idVisita) throws Exception;
	
}
