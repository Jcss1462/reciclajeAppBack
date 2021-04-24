package com.reciclajeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclajeApp.domain.Solicitudesrecoleccion;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface SolicitudesrecoleccionRepository extends JpaRepository<Solicitudesrecoleccion, Integer> {

	// modo manual
	// Obtengo las solicitudes duplicadas
	@Query("SELECT sr FROM Solicitudesrecoleccion sr WHERE sr.emailReciclador.email=:email AND sr.carrodonaciones.idcarrodonacion=:idCarroDonacion")
	public List<Solicitudesrecoleccion> findMultiplesSolicitudes(String email, Integer idCarroDonacion);
	
	// modo manual
	//Obtengo ltodas las solicitudes del reciclador
	@Query("SELECT sr FROM Solicitudesrecoleccion sr WHERE sr.emailReciclador.email=:email")
	public List<Solicitudesrecoleccion> findSolicitudesByReciclador(String email);
}
