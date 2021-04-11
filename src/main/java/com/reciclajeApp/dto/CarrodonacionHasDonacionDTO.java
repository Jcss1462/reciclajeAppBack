package com.reciclajeApp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class CarrodonacionHasDonacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer idcarrohasdonacion;
    private Integer idcarrodonacion_Carrodonaciones;
    private Integer iddonacion_Donacion;
	
    public CarrodonacionHasDonacionDTO() {
		super();
	}
    
    

	public CarrodonacionHasDonacionDTO(@NotNull Integer idcarrohasdonacion, Integer idcarrodonacion_Carrodonaciones,
			Integer iddonacion_Donacion) {
		super();
		this.idcarrohasdonacion = idcarrohasdonacion;
		this.idcarrodonacion_Carrodonaciones = idcarrodonacion_Carrodonaciones;
		this.iddonacion_Donacion = iddonacion_Donacion;
	}



	public Integer getIdcarrohasdonacion() {
		return idcarrohasdonacion;
	}

	public void setIdcarrohasdonacion(Integer idcarrohasdonacion) {
		this.idcarrohasdonacion = idcarrohasdonacion;
	}

	public Integer getIdcarrodonacion_Carrodonaciones() {
		return idcarrodonacion_Carrodonaciones;
	}

	public void setIdcarrodonacion_Carrodonaciones(Integer idcarrodonacion_Carrodonaciones) {
		this.idcarrodonacion_Carrodonaciones = idcarrodonacion_Carrodonaciones;
	}

	public Integer getIddonacion_Donacion() {
		return iddonacion_Donacion;
	}

	public void setIddonacion_Donacion(Integer iddonacion_Donacion) {
		this.iddonacion_Donacion = iddonacion_Donacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
