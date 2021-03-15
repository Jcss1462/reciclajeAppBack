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
public class EstadoresiduoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String estado;
    @NotNull
    private Integer idestadoresiduo;
	
    public EstadoresiduoDTO() {
		super();
	}

	public EstadoresiduoDTO(@NotNull @NotEmpty @Size(max = 255) String estado, @NotNull Integer idestadoresiduo) {
		super();
		this.estado = estado;
		this.idestadoresiduo = idestadoresiduo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdestadoresiduo() {
		return idestadoresiduo;
	}

	public void setIdestadoresiduo(Integer idestadoresiduo) {
		this.idestadoresiduo = idestadoresiduo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
