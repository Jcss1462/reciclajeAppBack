package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "venta", schema = "public")
public class Venta implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idventa", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtiporesiduo")
	@NotNull
	private Tiporesiduo tiporesiduo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
	private List<VentaHasEstadoresiduo> ventaHasEstadoresiduos = new ArrayList<>();

	public Venta() {
		super();
	}

	public Venta(Integer idventa, @NotNull Estadoventa estadoventa, @NotNull Usuario usuario,
			@NotNull Date fechaventa, @NotNull Double peso, @NotNull Double total, @NotNull Tiporesiduo tiporesiduo,
			List<VentaHasEstadoresiduo> ventaHasEstadoresiduos) {
		super();
		this.idventa = idventa;
		this.estadoventa = estadoventa;
		this.usuario = usuario;
		this.fechaventa = fechaventa;
		this.peso = peso;
		this.total = total;
		this.tiporesiduo = tiporesiduo;
		this.ventaHasEstadoresiduos = ventaHasEstadoresiduos;
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

	public Tiporesiduo getTiporesiduo() {
		return tiporesiduo;
	}

	public void setTiporesiduo(Tiporesiduo tiporesiduo) {
		this.tiporesiduo = tiporesiduo;
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