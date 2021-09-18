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
@Table(name = "aplicantesofertas", schema = "public")
public class Aplicantesofertas implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idaplicacion", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idaplicacion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idoferta")
    @NotNull
    private Ofertas ofertas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_reciclador")
    @NotNull
    private Usuario email_reciclador;

	public Aplicantesofertas() {
		super();
	}

	public Aplicantesofertas(Integer idaplicacion, @NotNull Ofertas ofertas, @NotNull Usuario email_reciclador) {
		super();
		this.idaplicacion = idaplicacion;
		this.ofertas = ofertas;
		this.email_reciclador = email_reciclador;
	}

	public Integer getIdaplicacion() {
		return idaplicacion;
	}

	public void setIdaplicacion(Integer idaplicacion) {
		this.idaplicacion = idaplicacion;
	}

	public Ofertas getOfertas() {
		return ofertas;
	}

	public void setOfertas(Ofertas ofertas) {
		this.ofertas = ofertas;
	}

	public Usuario getEmail_reciclador() {
		return email_reciclador;
	}

	public void setEmail_reciclador(Usuario email_reciclador) {
		this.email_reciclador = email_reciclador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
