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
public class EstadoventaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String estadoventa;
    @NotNull
    private Integer idestadoventa;
	
    public EstadoventaDTO() {
		super();
	}

	public EstadoventaDTO(@NotNull @NotEmpty @Size(max = 255) String estadoventa, @NotNull Integer idestadoventa) {
		super();
		this.estadoventa = estadoventa;
		this.idestadoventa = idestadoventa;
	}

	public String getEstadoventa() {
		return estadoventa;
	}

	public void setEstadoventa(String estadoventa) {
		this.estadoventa = estadoventa;
	}

	public Integer getIdestadoventa() {
		return idestadoventa;
	}

	public void setIdestadoventa(Integer idestadoventa) {
		this.idestadoventa = idestadoventa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
