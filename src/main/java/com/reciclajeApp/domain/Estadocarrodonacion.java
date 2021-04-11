package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "estadocarrodonacion", schema = "public")
public class Estadocarrodonacion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idestadodonacion", unique = true, nullable = false)
	@NotNull
	private Integer idestadodonacion;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "estado", nullable = false)
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadocarrodonacion")
	private List<Carrodonaciones> carrodonacioneses = new ArrayList<>();

	
	public Estadocarrodonacion() {
		super();
	}


	public Estadocarrodonacion(@NotNull Integer idestadodonacion, @NotNull @NotEmpty @Size(max = 255) String estado,
			List<Carrodonaciones> carrodonacioneses) {
		super();
		this.idestadodonacion = idestadodonacion;
		this.estado = estado;
		this.carrodonacioneses = carrodonacioneses;
	}


	public Integer getIdestadodonacion() {
		return idestadodonacion;
	}


	public void setIdestadodonacion(Integer idestadodonacion) {
		this.idestadodonacion = idestadodonacion;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Carrodonaciones> getCarrodonacioneses() {
		return carrodonacioneses;
	}


	public void setCarrodonacioneses(List<Carrodonaciones> carrodonacioneses) {
		this.carrodonacioneses = carrodonacioneses;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}