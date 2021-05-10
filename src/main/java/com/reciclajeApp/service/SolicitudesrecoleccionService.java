package com.reciclajeApp.service;

import java.util.List;

import com.reciclajeApp.domain.Solicitudesrecoleccion;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface SolicitudesrecoleccionService extends GenericService<Solicitudesrecoleccion, Integer> {
	
	public List<Solicitudesrecoleccion> findMultiplesSolicitudes(String email, Integer idCarroDonacion) throws Exception;
	
	public List<Solicitudesrecoleccion> findSolicitudesByCarID(Integer idCarroDonacion) throws Exception;
	
	public List<Solicitudesrecoleccion> findMyAplicatiosByReciclador(String email) throws Exception;
}
