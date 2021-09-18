package com.reciclajeApp.service;

import java.util.List;

import com.reciclajeApp.domain.Aplicantesofertas;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface AplicantesofertasService extends GenericService<Aplicantesofertas, Integer> {
	
	public List<Aplicantesofertas> getAplicantesByOferta(Integer idOferta) throws Exception;
	
}
