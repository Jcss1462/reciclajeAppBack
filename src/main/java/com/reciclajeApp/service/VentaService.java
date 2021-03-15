package com.reciclajeApp.service;

import com.reciclajeApp.domain.Venta;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface VentaService extends GenericService<Venta, Integer> {
	
	public List<Venta> findAllVentasByUser(String email) throws Exception;
	
}
