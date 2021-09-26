package com.reciclajeApp.service;

import java.util.List;

import com.reciclajeApp.domain.Visitarecicladores;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface VisitarecicladoresService extends GenericService<Visitarecicladores, Integer> {
	
	public List<Visitarecicladores> visitasByVentas(Integer idVenta) throws Exception;
	
}
