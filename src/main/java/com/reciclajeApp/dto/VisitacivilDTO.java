package com.reciclajeApp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/

public class VisitacivilDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Date fechahora;
    private Integer idvisita;
    private Integer idestadovisita_Estadovisita;
    private String emailPropietario;
    private String emailRecolector;
    private String direccion;
    private String estado;
    
	public VisitacivilDTO() {
		super();
	}
	
	public VisitacivilDTO(@NotNull Date fechahora,Integer idvisita, Integer idestadovisita_Estadovisita,
			String emailPropietario, String emailRecolector) {
		super();
		this.fechahora = fechahora;
		this.idvisita = idvisita;
		this.idestadovisita_Estadovisita = idestadovisita_Estadovisita;
		this.emailPropietario = emailPropietario;
		this.emailRecolector = emailRecolector;
	}

	public Date getFechahora() {
		return fechahora;
	}
	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}
	public Integer getIdvisita() {
		return idvisita;
	}
	public void setIdvisita(Integer idvisita) {
		this.idvisita = idvisita;
	}
	public Integer getIdestadovisita_Estadovisita() {
		return idestadovisita_Estadovisita;
	}
	public void setIdestadovisita_Estadovisita(Integer idestadovisita_Estadovisita) {
		this.idestadovisita_Estadovisita = idestadovisita_Estadovisita;
	}
	public String getEmailPropietario() {
		return emailPropietario;
	}
	public void setEmailPropietario(String emailPropietario) {
		this.emailPropietario = emailPropietario;
	}
	public String getEmailRecolector() {
		return emailRecolector;
	}
	public void setEmailRecolector(String emailRecolector) {
		this.emailRecolector = emailRecolector;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
    
    
    
    
}
