package com.reciclajeApp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Entity
@Table(name = "visitarecicladores", schema = "public")
public class Visitarecicladores implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idvisitareciclador", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idvisitareciclador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idestadovisita")
	@NotNull
	private Estadovisita estadovisita;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email_centrodeacopio")
	@NotNull
	private Usuario emailCentroDeAcopio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idventa")
	@NotNull
	private Venta venta;
	
	@NotNull
	@Column(name = "fechahora", nullable = false)
	private Date fechahora;

	public Visitarecicladores() {
		super();
	}

	public Visitarecicladores(Integer idvisitareciclador, @NotNull Estadovisita estadovisita,
			@NotNull Usuario emailCentroDeAcopio, @NotNull Venta venta, @NotNull Date fechahora) {
		super();
		this.idvisitareciclador = idvisitareciclador;
		this.estadovisita = estadovisita;
		this.emailCentroDeAcopio = emailCentroDeAcopio;
		this.venta = venta;
		this.fechahora = fechahora;
	}

	public Integer getIdvisitareciclador() {
		return idvisitareciclador;
	}

	public void setIdvisitareciclador(Integer idvisitareciclador) {
		this.idvisitareciclador = idvisitareciclador;
	}

	public Estadovisita getEstadovisita() {
		return estadovisita;
	}

	public void setEstadovisita(Estadovisita estadovisita) {
		this.estadovisita = estadovisita;
	}

	public Usuario getEmailCentroDeAcopio() {
		return emailCentroDeAcopio;
	}

	public void setEmailCentroDeAcopio(Usuario emailCentroDeAcopio) {
		this.emailCentroDeAcopio = emailCentroDeAcopio;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Date getFechahora() {
		return fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
