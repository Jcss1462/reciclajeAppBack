package com.reciclajeApp.service;

import com.reciclajeApp.domain.Solicitudesrecoleccion;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface SolicitudesrecoleccionService extends GenericService<Solicitudesrecoleccion, Integer> {
	
	public List<Solicitudesrecoleccion> findMultiplesSolicitudes(String email, Integer idCarroDonacion);
	
	public List<Solicitudesrecoleccion> findSolicitudesByCarID(Integer idCarroDonacion);
}
