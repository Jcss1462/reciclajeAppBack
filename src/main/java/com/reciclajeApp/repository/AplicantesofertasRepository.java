package com.reciclajeApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reciclajeApp.domain.Aplicantesofertas;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface AplicantesofertasRepository extends JpaRepository<Aplicantesofertas, Integer> {
	
	// seleccionos todos los aplicantes a una oferta
	@Query("SELECT apl FROM Aplicantesofertas apl WHERE apl.ofertas.idoferta=:idOferta")
	public List<Aplicantesofertas> getAplicantesByOferta(Integer idOferta);
	
}
