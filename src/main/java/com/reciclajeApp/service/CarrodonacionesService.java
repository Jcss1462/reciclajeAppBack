package com.reciclajeApp.service;

import java.util.List;

import com.reciclajeApp.domain.Carrodonaciones;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface CarrodonacionesService extends GenericService<Carrodonaciones, Integer> {
	
	public List<Carrodonaciones> findAllByUserCarrosByEnable(String email) throws Exception;
	
	public List<Carrodonaciones> findAllByByEnable() throws Exception;
	
	public List<Carrodonaciones> findAllByByEnableNoAplicados(String email) throws Exception;
	
	public List<Carrodonaciones> findAllMyCarsAsign(String email) throws Exception;
	
	public Carrodonaciones removerDeLaRuta(Integer idCarroDonacion) throws Exception;
	
	public Carrodonaciones inhabililitarCarrosDonacionYCreaciondeUnoNuevo(String email) throws Exception;
}
