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

public class EstadoofertaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String estado;
    @NotNull
    private Integer idestadooferta;
	
    public EstadoofertaDTO() {
		super();
	}

	public EstadoofertaDTO(@NotNull @NotEmpty @Size(max = 255) String estado, @NotNull Integer idestadooferta) {
		super();
		this.estado = estado;
		this.idestadooferta = idestadooferta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdestadooferta() {
		return idestadooferta;
	}

	public void setIdestadooferta(Integer idestadooferta) {
		this.idestadooferta = idestadooferta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
