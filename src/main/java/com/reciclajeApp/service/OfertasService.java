package com.reciclajeApp.service;

import java.util.List;

import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Venta;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface OfertasService extends GenericService<Ofertas, Integer> {
	
	public List<Ofertas> findOfertasDisponiblesByUser(String email) throws Exception;
	
	public List<Ofertas> findAllOfertasDisponibles() throws Exception;
	
	public List<Ofertas> findAllOfertasDisponiblesNoAplicadasPorReciclador(String email) throws Exception;
	
}
