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

public class EstadovisitaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String estado;
    @NotNull
    private Integer idestadovisita;
	
    public EstadovisitaDTO() {
		super();
	}

	public EstadovisitaDTO(@NotNull @NotEmpty @Size(max = 255) String estado, @NotNull Integer idestadovisita) {
		super();
		this.estado = estado;
		this.idestadovisita = idestadovisita;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdestadovisita() {
		return idestadovisita;
	}

	public void setIdestadovisita(Integer idestadovisita) {
		this.idestadovisita = idestadovisita;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
