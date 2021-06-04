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
@Table(name = "estadovisita", schema = "public")

public class Estadovisita implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idestadovisita", unique = true, nullable = false)
	@NotNull
	private Integer idestadovisita;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "estado", nullable = false)
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadovisita")
	private List<Visitacivil> visitacivils = new ArrayList<>();
		

	public Estadovisita() {
		super();
	}

	public Estadovisita(@NotNull Integer idestadovisita, @NotNull @NotEmpty @Size(max = 255) String estado,
			List<Visitacivil> visitacivils) {
		super();
		this.idestadovisita = idestadovisita;
		this.estado = estado;
		this.visitacivils = visitacivils;
	}

	public Integer getIdestadovisita() {
		return idestadovisita;
	}

	public void setIdestadovisita(Integer idestadovisita) {
		this.idestadovisita = idestadovisita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Visitacivil> getVisitacivils() {
		return visitacivils;
	}

	public void setVisitacivils(List<Visitacivil> visitacivils) {
		this.visitacivils = visitacivils;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}