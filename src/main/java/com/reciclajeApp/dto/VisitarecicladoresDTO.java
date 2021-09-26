package com.reciclajeApp.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class VisitarecicladoresDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private Integer idvisitareciclador;
    private Integer idestadovisita_Estadovisita;
    
    @NotNull
    private String emailCentroDeAcopio;
    
    @NotNull
    private Integer idventa_Venta;
      
    @NotNull
    private Date fechahora;
	
    public VisitarecicladoresDTO() {
		super();
	}

	public VisitarecicladoresDTO(Integer idvisitareciclador, Integer idestadovisita_Estadovisita,
			@NotNull String emailCentroDeAcopio, @NotNull Integer idventa_Venta, @NotNull Date fechahora) {
		super();
		this.idvisitareciclador = idvisitareciclador;
		this.idestadovisita_Estadovisita = idestadovisita_Estadovisita;
		this.emailCentroDeAcopio = emailCentroDeAcopio;
		this.idventa_Venta = idventa_Venta;
		this.fechahora = fechahora;
	}

	public Integer getIdvisitareciclador() {
		return idvisitareciclador;
	}

	public void setIdvisitareciclador(Integer idvisitareciclador) {
		this.idvisitareciclador = idvisitareciclador;
	}

	public Integer getIdestadovisita_Estadovisita() {
		return idestadovisita_Estadovisita;
	}

	public void setIdestadovisita_Estadovisita(Integer idestadovisita_Estadovisita) {
		this.idestadovisita_Estadovisita = idestadovisita_Estadovisita;
	}

	public String getEmailCentroDeAcopio() {
		return emailCentroDeAcopio;
	}

	public void setEmailCentroDeAcopio(String emailCentroDeAcopio) {
		this.emailCentroDeAcopio = emailCentroDeAcopio;
	}

	public Integer getIdventa_Venta() {
		return idventa_Venta;
	}

	public void setIdventa_Venta(Integer idventa_Venta) {
		this.idventa_Venta = idventa_Venta;
	}

	public Date getFechahora() {
		return fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}
