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
   
    private Date fechaventa;
    
    private Integer idventa;
    @NotNull
    private Double peso;
    @NotNull
    private Double total;
    private Integer idestadoventa_Estadoventa;
    private Integer idtiporesiduo_Tiporesiduo;
    private String email_Usuario;
    private String tipo;
    private Double precioPorKiloTipo;
	
    public VentaDTO() {
		super();
	}

	public VentaDTO(Date fechaventa, Integer idventa, @NotNull Double peso, @NotNull Double total,
			Integer idestadoventa_Estadoventa, Integer idtiporesiduo_Tiporesiduo, String email_Usuario, String tipo, Double precioPorKiloTipo) {
		super();
		this.fechaventa = fechaventa;
		this.idventa = idventa;
		this.peso = peso;
		this.total = total;
		this.idestadoventa_Estadoventa = idestadoventa_Estadoventa;
		this.idtiporesiduo_Tiporesiduo = idtiporesiduo_Tiporesiduo;
		this.email_Usuario = email_Usuario;
		this.tipo=tipo;
		this.precioPorKiloTipo=precioPorKiloTipo;
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

	public Integer getIdtiporesiduo_Tiporesiduo() {
		return idtiporesiduo_Tiporesiduo;
	}

	public void setIdtiporesiduo_Tiporesiduo(Integer idtiporesiduo_Tiporesiduo) {
		this.idtiporesiduo_Tiporesiduo = idtiporesiduo_Tiporesiduo;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPrecioPorKiloTipo() {
		return precioPorKiloTipo;
	}

	public void setPrecioPorKiloTipo(Double precioPorKiloTipo) {
		this.precioPorKiloTipo = precioPorKiloTipo;
	}
	

    
    
}
