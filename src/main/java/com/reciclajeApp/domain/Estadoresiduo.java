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
@Table(name = "estadoresiduo", schema = "public")
public class Estadoresiduo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idestadoresiduo", unique = true, nullable = false)
	@NotNull
	private Integer idestadoresiduo;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "estado", nullable = false)
	private String estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoresiduo")
	private List<VentaHasEstadoresiduo> ventaHasEstadoresiduos = new ArrayList<>();

	public Estadoresiduo() {
		super();
	}

	public Estadoresiduo(@NotNull Integer idestadoresiduo, @NotNull @NotEmpty @Size(max = 255) String estado,
			List<VentaHasEstadoresiduo> ventaHasEstadoresiduos) {
		super();
		this.idestadoresiduo = idestadoresiduo;
		this.estado = estado;
		this.ventaHasEstadoresiduos = ventaHasEstadoresiduos;
	}

	public Integer getIdestadoresiduo() {
		return idestadoresiduo;
	}

	public void setIdestadoresiduo(Integer idestadoresiduo) {
		this.idestadoresiduo = idestadoresiduo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<VentaHasEstadoresiduo> getVentaHasEstadoresiduos() {
		return ventaHasEstadoresiduos;
	}

	public void setVentaHasEstadoresiduos(List<VentaHasEstadoresiduo> ventaHasEstadoresiduos) {
		this.ventaHasEstadoresiduos = ventaHasEstadoresiduos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

} 