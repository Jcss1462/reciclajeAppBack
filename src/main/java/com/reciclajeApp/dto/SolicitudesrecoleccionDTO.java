package com.reciclajeApp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/

public class SolicitudesrecoleccionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idsolicitud;
    @NotNull
    private Integer idcarrodonacion_Carrodonaciones;
    @NotNull
    private String emailReciclador;
	
    public SolicitudesrecoleccionDTO() {
		super();
	}

	public SolicitudesrecoleccionDTO(Integer idsolicitud, Integer idcarrodonacion_Carrodonaciones,
			String emailReciclador) {
		super();
		this.idsolicitud = idsolicitud;
		this.idcarrodonacion_Carrodonaciones = idcarrodonacion_Carrodonaciones;
		this.emailReciclador = emailReciclador;
	}

	public Integer getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(Integer idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public Integer getIdcarrodonacion_Carrodonaciones() {
		return idcarrodonacion_Carrodonaciones;
	}

	public void setIdcarrodonacion_Carrodonaciones(Integer idcarrodonacion_Carrodonaciones) {
		this.idcarrodonacion_Carrodonaciones = idcarrodonacion_Carrodonaciones;
	}

	public String getEmailReciclador() {
		return emailReciclador;
	}

	public void setEmailReciclador(String emailReciclador) {
		this.emailReciclador = emailReciclador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
