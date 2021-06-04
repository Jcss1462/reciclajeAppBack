package com.reciclajeApp.domain;

public class Agendar {
	
	String emailReciclador;
	Integer idVenta;
	
	public Agendar() {
		super();
	}
	
	public Agendar(String emailReciclador, Integer idVenta) {
		super();
		this.emailReciclador = emailReciclador;
		this.idVenta = idVenta;
	}

	public String getEmailReciclador() {
		return emailReciclador;
	}

	public void setEmailReciclador(String emailReciclador) {
		this.emailReciclador = emailReciclador;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	
	

}
