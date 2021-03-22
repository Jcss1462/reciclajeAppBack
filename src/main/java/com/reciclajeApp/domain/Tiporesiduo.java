package com.reciclajeApp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "tiporesiduo", schema = "public")
public class Tiporesiduo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idtiporesiduo", unique = true, nullable = false)
	@NotNull
	private Integer idtiporesiduo;

	@NotNull
	@Column(name = "fechaactualizacion", nullable = false)
	private Date fechaactualizacion;
	@NotNull
	@Column(name = "precio", nullable = false)
	private Double precio;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	
	public Tiporesiduo() {
		super();
	}
	
	
	
	public Tiporesiduo(@NotNull Integer idtiporesiduo, @NotNull Date fechaactualizacion, @NotNull Double precio,
			@NotNull @NotEmpty @Size(max = 255) String tipo) {
		super();
		this.idtiporesiduo = idtiporesiduo;
		this.fechaactualizacion = fechaactualizacion;
		this.precio = precio;
		this.tipo = tipo;
	}



	public Integer getIdtiporesiduo() {
		return idtiporesiduo;
	}
	public void setIdtiporesiduo(Integer idtiporesiduo) {
		this.idtiporesiduo = idtiporesiduo;
	}
	public Date getFechaactualizacion() {
		return fechaactualizacion;
	}
	public void setFechaactualizacion(Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	



}