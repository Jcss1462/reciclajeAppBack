package com.reciclajeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclajeApp.domain.Ofertas;
import com.reciclajeApp.domain.Venta;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface OfertasRepository extends JpaRepository<Ofertas, Integer> {
	
	// modo manual
	@Query("SELECT ofer FROM Ofertas ofer WHERE ofer.emailCentroDeAcopio.email=:email AND ofer.estadooferta.idestadooferta IN(1,2)")
	public List<Ofertas> findOfertasDisponiblesByUser(String email);
	
	
	@Query("SELECT ofer FROM Ofertas ofer WHERE ofer.estadooferta.idestadooferta IN(1)")
	public List<Ofertas> findAllOfertasDisponibles();
	
	
	@Query("SELECT ofer FROM Ofertas ofer WHERE ofer.estadooferta.idestadooferta IN(1) AND ofer NOT IN (SELECT apli.ofertas FROM Aplicantesofertas apli WHERE  apli.email_reciclador.email=:email)")
	public List<Ofertas> findAllOfertasDisponiblesNoAplicadasBayReciclador(String email);
	
}
