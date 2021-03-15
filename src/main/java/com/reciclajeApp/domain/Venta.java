package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "venta", schema = "public")
public class Venta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idventa", unique = true, nullable = false)
	@NotNull
	private Integer idventa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idestadoventa")
	@NotNull
	private Estadoventa estadoventa;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_vendedor")
	@NotNull
	private Usuario usuario;

	@NotNull
	@Column(name = "fechaventa", nullable = false)
	private Date fechaventa;
	@NotNull
	@Column(name = "peso", nullable = false)
	private Double peso;
	@NotNull
	@Column(name = "total", nullable = false)
	private Double total;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
	private List<VentaHasEstadoresiduo> ventaHasEstadoresiduos = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
	private List<VentaHasTiporesiduo> ventaHasTiporesiduos = new ArrayList<>();
	
	public Venta() {
		super();
	}


	public Venta(@NotNull Integer idventa, @NotNull Estadoventa estadoventa, @NotNull Usuario usuario,
			@NotNull Date fechaventa, @NotNull Double peso, @NotNull Double total,
			List<VentaHasEstadoresiduo> ventaHasEstadoresiduos, List<VentaHasTiporesiduo> ventaHasTiporesiduos) {
		super();
		this.idventa = idventa;
		this.estadoventa = estadoventa;
		this.usuario = usuario;
		this.fechaventa = fechaventa;
		this.peso = peso;
		this.total = total;
		this.ventaHasEstadoresiduos = ventaHasEstadoresiduos;
		this.ventaHasTiporesiduos = ventaHasTiporesiduos;
	}



	public Integer getIdventa() {
		return idventa;
	}



	public void setIdventa(Integer idventa) {
		this.idventa = idventa;
	}



	public Estadoventa getEstadoventa() {
		return estadoventa;
	}



	public void setEstadoventa(Estadoventa estadoventa) {
		this.estadoventa = estadoventa;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Date getFechaventa() {
		return fechaventa;
	}



	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}



	public Double getPeso() {
		return peso;
	}



	public void setPeso(Double peso) {
		this.peso = peso;
	}



	public Double getTotal() {
		return total;
	}



	public void setTotal(Double total) {
		this.total = total;
	}



	public List<VentaHasEstadoresiduo> getVentaHasEstadoresiduos() {
		return ventaHasEstadoresiduos;
	}



	public void setVentaHasEstadoresiduos(List<VentaHasEstadoresiduo> ventaHasEstadoresiduos) {
		this.ventaHasEstadoresiduos = ventaHasEstadoresiduos;
	}



	public List<VentaHasTiporesiduo> getVentaHasTiporesiduos() {
		return ventaHasTiporesiduos;
	}



	public void setVentaHasTiporesiduos(List<VentaHasTiporesiduo> ventaHasTiporesiduos) {
		this.ventaHasTiporesiduos = ventaHasTiporesiduos;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}