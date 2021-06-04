package com.reciclajeApp.domain;

public class Agendar {
	
	String emailReciclador;
	Integer idVisita;
	
	public Agendar() {
		super();
	}
	
	public Agendar(String emailReciclador, Integer idVenta) {
		super();
		this.emailReciclador = emailReciclador;
		this.idVisita = idVenta;
	}

	public String getEmailReciclador() {
		return emailReciclador;
	}

	public void setEmailReciclador(String emailReciclador) {
		this.emailReciclador = emailReciclador;
	}

	public Integer getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
	}

	
	
	

}
