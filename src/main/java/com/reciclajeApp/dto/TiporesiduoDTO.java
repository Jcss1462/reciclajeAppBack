package com.reciclajeApp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class TiporesiduoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Date fechaactualizacion;
    @NotNull
    private Integer idtiporesiduo;
    @NotNull
    private Double precio;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String tipo;
	
    public TiporesiduoDTO() {
		super();
	}

	public TiporesiduoDTO(@NotNull Date fechaactualizacion, @NotNull Integer idtiporesiduo, @NotNull Double precio,
			@NotNull @NotEmpty @Size(max = 255) String tipo) {
		super();
		this.fechaactualizacion = fechaactualizacion;
		this.idtiporesiduo = idtiporesiduo;
		this.precio = precio;
		this.tipo = tipo;
	}

	public Date getFechaactualizacion() {
		return fechaactualizacion;
	}

	public void setFechaactualizacion(Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Integer getIdtiporesiduo() {
		return idtiporesiduo;
	}

	public void setIdtiporesiduo(Integer idtiporesiduo) {
		this.idtiporesiduo = idtiporesiduo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
