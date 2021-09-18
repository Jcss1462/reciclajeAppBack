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
@Table(name = "estadooferta", schema = "public")
public class Estadooferta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idestadooferta", unique = true, nullable = false)
	@NotNull
	private Integer idestadooferta;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "estado", nullable = false)
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadooferta")
	private List<Ofertas> ofertases = new ArrayList<>();

	public Estadooferta() {
		super();
	}

	public Estadooferta(@NotNull Integer idestadooferta, @NotNull @NotEmpty @Size(max = 255) String estado,
			List<Ofertas> ofertases) {
		super();
		this.idestadooferta = idestadooferta;
		this.estado = estado;
		this.ofertases = ofertases;
	}

	public Integer getIdestadooferta() {
		return idestadooferta;
	}

	public void setIdestadooferta(Integer idestadooferta) {
		this.idestadooferta = idestadooferta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Ofertas> getOfertases() {
		return ofertases;
	}

	public void setOfertases(List<Ofertas> ofertases) {
		this.ofertases = ofertases;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}