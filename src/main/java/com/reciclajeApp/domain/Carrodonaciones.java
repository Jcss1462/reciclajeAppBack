package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "carrodonaciones", schema = "public")
public class Carrodonaciones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idcarrodonacion", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcarrodonacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idestadodonacion")
	@NotNull
	private Estadocarrodonacion estadocarrodonacion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_propietario")
	@NotNull
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_recolector")
	private Usuario recolector;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrodonaciones")
	private List<CarrodonacionHasDonacion> carrodonacionHasDonacions = new ArrayList<>();
	
	

	public Carrodonaciones() {
		super();
	}



	public Carrodonaciones(Integer idcarrodonacion, @NotNull Estadocarrodonacion estadocarrodonacion,
			@NotNull Usuario usuario,Usuario recolector ,List<CarrodonacionHasDonacion> carrodonacionHasDonacions) {
		super();
		this.idcarrodonacion = idcarrodonacion;
		this.estadocarrodonacion = estadocarrodonacion;
		this.usuario = usuario;
		this.carrodonacionHasDonacions = carrodonacionHasDonacions;
		this.recolector=recolector;
	}



	public Integer getIdcarrodonacion() {
		return idcarrodonacion;
	}



	public void setIdcarrodonacion(Integer idcarrodonacion) {
		this.idcarrodonacion = idcarrodonacion;
	}



	public Estadocarrodonacion getEstadocarrodonacion() {
		return estadocarrodonacion;
	}



	public void setEstadocarrodonacion(Estadocarrodonacion estadocarrodonacion) {
		this.estadocarrodonacion = estadocarrodonacion;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Usuario getRecolector() {
		return recolector;
	}



	public void setRecolector(Usuario recolector) {
		this.recolector = recolector;
	}



	public List<CarrodonacionHasDonacion> getCarrodonacionHasDonacions() {
		return carrodonacionHasDonacions;
	}



	public void setCarrodonacionHasDonacions(List<CarrodonacionHasDonacion> carrodonacionHasDonacions) {
		this.carrodonacionHasDonacions = carrodonacionHasDonacions;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}