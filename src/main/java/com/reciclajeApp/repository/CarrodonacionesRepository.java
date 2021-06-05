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

	// modo manual
	// seleccionos todos los carros de donacion disponibles no solicitados por el
	// reciclador
	@Query("SELECT cd FROM Carrodonaciones cd WHERE cd.estadocarrodonacion.idestadodonacion=1 AND cd.idcarrodonacion NOT IN( SELECT sr.carrodonaciones FROM Solicitudesrecoleccion sr WHERE  sr.emailReciclador.email=:email)")
	public List<Carrodonaciones> findAllByByEnableNoAplicados(String email);

	// modo manual
	// seleccionos todos los carros de donacion asignados al reciclador
	@Query("SELECT cd FROM Carrodonaciones cd WHERE cd.recolector.email=:email AND cd.estadocarrodonacion.idestadodonacion=3")
	public List<Carrodonaciones> findAllMyCarsAsign(String email);

	// modo manual
	// seleccionos todos los carros activos de un usuario
	@Query("SELECT cd FROM Carrodonaciones cd WHERE cd.usuario.email=:email AND cd.estadocarrodonacion.idestadodonacion=3")
	public List<Carrodonaciones> findAllByUserCarrosByAgend(String email);
}
