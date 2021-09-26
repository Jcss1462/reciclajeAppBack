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

	// modo manual
	@Query("SELECT ven FROM Venta ven WHERE ven.estadoventa.idestadoventa=1 AND ven.usuario.email=:email AND ven.visitarecicladoreses.size=0")
	public List<Venta> findAllVentasByRecicladorDisponiblesNoAplicadas(String email);

	// modo manual
	@Query("SELECT ven FROM Venta ven WHERE ven.estadoventa.idestadoventa=1 AND ven NOT IN (SELECT visR.venta FROM Visitarecicladores visR WHERE visR.emailCentroDeAcopio.email=:email)")
	public List<Venta> findVentasDisponiblesNoAplicadasPorCentroDeAcopio(String email);

	// modo manual
	@Query("SELECT ven FROM Venta ven WHERE ven.emailCentroDeAcopio.email=:email")
	public List<Venta> findVentasByCentroDeAcopio(String email);

	// modo manual
	@Query("SELECT ven FROM Venta ven WHERE ven.estadoventa.idestadoventa=1 AND ven.usuario.email=:email AND ven.visitarecicladoreses.size>0 ")
	public List<Venta> findVentasDisponiblesByRecicladorAplicadas(String email);

	// modo manual
	@Query("SELECT ven FROM Venta ven WHERE ven.estadoventa.idestadoventa=2 AND ven.usuario.email=:email")
	public List<Venta> findVentasVendidasByReciclador(String email);

}
