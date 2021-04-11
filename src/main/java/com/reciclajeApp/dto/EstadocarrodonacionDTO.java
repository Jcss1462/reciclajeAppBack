package com.reciclajeApp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class EstadocarrodonacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String estado;
    @NotNull
    private Integer idestadodonacion;
	
    public EstadocarrodonacionDTO() {
		super();
	}

	public EstadocarrodonacionDTO(@NotNull @NotEmpty @Size(max = 255) String estado,
			@NotNull Integer idestadodonacion) {
		super();
		this.estado = estado;
		this.idestadodonacion = idestadodonacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdestadodonacion() {
		return idestadodonacion;
	}

	public void setIdestadodonacion(Integer idestadodonacion) {
		this.idestadodonacion = idestadodonacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
   
}
