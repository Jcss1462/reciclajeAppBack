package com.reciclajeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclajeApp.domain.Visitarecicladores;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface VisitarecicladoresRepository extends JpaRepository<Visitarecicladores, Integer> {

	// modo manual
	@Query("SELECT vr FROM Visitarecicladores vr WHERE vr.venta.idventa=:idVenta")
	public List<Visitarecicladores> visitasByVentas(Integer idVenta);

}
