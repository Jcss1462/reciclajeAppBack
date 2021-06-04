package com.reciclajeApp.repository;

import com.reciclajeApp.domain.Carrodonaciones;
import com.reciclajeApp.domain.Visitacivil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface VisitacivilRepository extends JpaRepository<Visitacivil, Integer> {

	// modo manual
	// seleccionos todAS LAS VISITAS DISPONIBLES
	@Query("SELECT vc FROM Visitacivil vc WHERE vc.estadovisita.idestadovisita=1")
	public List<Visitacivil> findAllByByEnable();

}
