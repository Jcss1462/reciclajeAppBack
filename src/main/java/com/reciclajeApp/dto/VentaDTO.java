package com.reciclajeApp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/

public class VentaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Date fechaventa;
    @NotNull
    private Integer idventa;
    @NotNull
    private Double peso;
    @NotNull
    private Double total;
    private Integer idestadoventa_Estadoventa;
    private String email_Usuario;
	
    public VentaDTO() {
		super();
	}

	public VentaDTO(@NotNull Date fechaventa, @NotNull Integer idventa, @NotNull Double peso, @NotNull Double total,
			Integer idestadoventa_Estadoventa, String email_Usuario) {
		super();
		this.fechaventa = fechaventa;
		this.idventa = idventa;
		this.peso = peso;
		this.total = total;
		this.idestadoventa_Estadoventa = idestadoventa_Estadoventa;
		this.email_Usuario = email_Usuario;
	}

	public Date getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(Date fechaventa) {
		this.fechaventa = fechaventa;
	}

	public Integer getIdventa() {
		return idventa;
	}

	public void setIdventa(Integer idventa) {
		this.idventa = idventa;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getIdestadoventa_Estadoventa() {
		return idestadoventa_Estadoventa;
	}

	public void setIdestadoventa_Estadoventa(Integer idestadoventa_Estadoventa) {
		this.idestadoventa_Estadoventa = idestadoventa_Estadoventa;
	}

	public String getEmail_Usuario() {
		return email_Usuario;
	}

	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
