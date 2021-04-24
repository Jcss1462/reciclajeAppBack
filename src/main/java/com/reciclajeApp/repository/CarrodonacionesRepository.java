package com.reciclajeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclajeApp.domain.Carrodonaciones;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface CarrodonacionesRepository extends JpaRepository<Carrodonaciones, Integer> {

	// modo manual
	// seleccionos todos los carros activos de un usuario
	@Query("SELECT cd FROM Carrodonaciones cd WHERE cd.usuario.email=:email AND cd.estadocarrodonacion.idestadodonacion=1")
	public List<Carrodonaciones> findAllByUserCarrosByEnable(String email);

	// modo manual
	// seleccionos todos los carros de donacion disponibles
	@Query("SELECT cd FROM Carrodonaciones cd WHERE cd.estadocarrodonacion.idestadodonacion=1")
	public List<Carrodonaciones> findAllByByEnable();
}
