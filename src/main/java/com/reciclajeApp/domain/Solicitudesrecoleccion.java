package com.reciclajeApp.domain;

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
* www.zathuracode.org
*
*/
@Entity
@Table(name = "solicitudesrecoleccion", schema = "public")
public class Solicitudesrecoleccion implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idsolicitud", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsolicitud;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcarrodonacion")
    @NotNull
    private Carrodonaciones carrodonaciones;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_Reciclador")
    @NotNull
    private Usuario emailReciclador;
	
    public Solicitudesrecoleccion() {
		super();
	}

	public Solicitudesrecoleccion(Integer idsolicitud, @NotNull Carrodonaciones carrodonaciones,
			@NotNull Usuario emailReciclador) {
		super();
		this.idsolicitud = idsolicitud;
		this.carrodonaciones = carrodonaciones;
		this.emailReciclador = emailReciclador;
	}

	public Integer getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(Integer idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public Carrodonaciones getCarrodonaciones() {
		return carrodonaciones;
	}

	public void setCarrodonaciones(Carrodonaciones carrodonaciones) {
		this.carrodonaciones = carrodonaciones;
	}

	public Usuario getEmailReciclador() {
		return emailReciclador;
	}

	public void setEmailReciclador(Usuario emailReciclador) {
		this.emailReciclador = emailReciclador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
    
    
}
