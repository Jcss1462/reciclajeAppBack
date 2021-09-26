package com.reciclajeApp.service;

import java.util.List;

import com.reciclajeApp.domain.Venta;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface VentaService extends GenericService<Venta, Integer> {
	
	public List<Venta> findAllVentasByUserDisponiblesNoAplicadas(String email) throws Exception;
	
	
	public List<Venta> findVentasDisponiblesNoAplicadasPorCentroDeAcopio(String email) throws Exception;
	
	
	public List<Venta> findVentasByCentroDeAcopio(String email) throws Exception;
	
	
	public List<Venta> findVentasDisponiblesByRecicladorAplicadas(String email) throws Exception;
	
	public List<Venta> findVentasVendidasByReciclador(String email) throws Exception;
	
}
