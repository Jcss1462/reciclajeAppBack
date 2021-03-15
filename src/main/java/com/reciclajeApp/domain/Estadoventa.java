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
@Table(name = "estadoventa", schema = "public")
public class Estadoventa implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idestadoventa", unique = true, nullable = false)
	@NotNull
	private Integer idestadoventa;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "estadoventa", nullable = false)
	private String estadoventa;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estadoventa")
	private List<Venta> ventas = new ArrayList<>();

	public Estadoventa() {
		super();
	}

	public Estadoventa(@NotNull Integer idestadoventa, @NotNull @NotEmpty @Size(max = 255) String estadoventa,
			List<Venta> ventas) {
		super();
		this.idestadoventa = idestadoventa;
		this.estadoventa = estadoventa;
		this.ventas = ventas;
	}

	public Integer getIdestadoventa() {
		return idestadoventa;
	}

	public void setIdestadoventa(Integer idestadoventa) {
		this.idestadoventa = idestadoventa;
	}

	public String getEstadoventa() {
		return estadoventa;
	}

	public void setEstadoventa(String estadoventa) {
		this.estadoventa = estadoventa;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}