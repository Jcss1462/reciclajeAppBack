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
* www.zathuracode.org
*
*/
@Entity
@Table(name = "visitacivil", schema = "public")

public class Visitacivil implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idvisita", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idvisita;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestadovisita")
    @NotNull
    private Estadovisita estadovisita;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_propietario")
    @NotNull
    private Usuario emailPropietario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_recolector")
    private Usuario emailRecolector;
    
    @NotNull
    @Column(name = "fechahora", nullable = false)
    private Date fechahora;
	
    public Visitacivil() {
		super();
	}

	public Visitacivil(Integer idvisita, @NotNull Estadovisita estadovisita,
			@NotNull Usuario emailPropietario,Usuario emailRecolector,
			@NotNull Date fechahora) {
		super();
		this.idvisita = idvisita;
		this.estadovisita = estadovisita;
		this.emailPropietario = emailPropietario;
		this.emailRecolector = emailRecolector;
		this.fechahora = fechahora;
	}

	public Integer getIdvisita() {
		return idvisita;
	}

	public void setIdvisita(Integer idvisita) {
		this.idvisita = idvisita;
	}

	public Estadovisita getEstadovisita() {
		return estadovisita;
	}

	public void setEstadovisita(Estadovisita estadovisita) {
		this.estadovisita = estadovisita;
	}
	
	public Usuario getEmailPropietario() {
		return emailPropietario;
	}

	public void setEmailPropietario(Usuario emailPropietario) {
		this.emailPropietario = emailPropietario;
	}

	public Usuario getEmailRecolector() {
		return emailRecolector;
	}

	public void setEmailRecolector(Usuario emailRecolector) {
		this.emailRecolector = emailRecolector;
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
