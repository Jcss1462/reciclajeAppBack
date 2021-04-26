package com.reciclajeApp.dto;

import java.io.Serializable;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class CarrodonacionesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idcarrodonacion;
    private Integer idestadodonacion_Estadocarrodonacion;
    private String email_Usuario;
    private String email_Recolector;
	
    public CarrodonacionesDTO() {
		super();
	}

	public CarrodonacionesDTO(Integer idcarrodonacion, Integer idestadodonacion_Estadocarrodonacion,
			String email_Usuario, String email_Recolector) {
		super();
		this.idcarrodonacion = idcarrodonacion;
		this.idestadodonacion_Estadocarrodonacion = idestadodonacion_Estadocarrodonacion;
		this.email_Usuario = email_Usuario;
		this.email_Recolector = email_Recolector;
	}

	public Integer getIdcarrodonacion() {
		return idcarrodonacion;
	}

	public void setIdcarrodonacion(Integer idcarrodonacion) {
		this.idcarrodonacion = idcarrodonacion;
	}

	public Integer getIdestadodonacion_Estadocarrodonacion() {
		return idestadodonacion_Estadocarrodonacion;
	}

	public void setIdestadodonacion_Estadocarrodonacion(Integer idestadodonacion_Estadocarrodonacion) {
		this.idestadodonacion_Estadocarrodonacion = idestadodonacion_Estadocarrodonacion;
	}

	public String getEmail_Usuario() {
		return email_Usuario;
	}

	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
	}
	
	
	public String getEmail_Recolector() {
		return email_Recolector;
	}

	public void setEmail_Recolector(String email_Recolector) {
		this.email_Recolector = email_Recolector;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
