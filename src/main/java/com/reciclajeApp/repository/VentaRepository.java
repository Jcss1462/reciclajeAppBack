package com.reciclajeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclajeApp.domain.Venta;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface VentaRepository extends JpaRepository<Venta, Integer> {

	// modo manual
	@Query("SELECT ven FROM Venta ven WHERE ven.usuario.email=:email")
	public List<Venta> findAllVentasByUser(String email);
	
}
