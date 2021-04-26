package com.reciclajeApp.domain;

public class AceptarSolicitud {
	
	String email;
	Integer carroDonacionId;
	

	
	public AceptarSolicitud() {
		super();
	}
	public AceptarSolicitud(String email, Integer carroDonacionId) {
		super();
		this.email = email;
		this.carroDonacionId = carroDonacionId;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCarroDonacionId() {
		return carroDonacionId;
	}
	public void setCarroDonacionId(Integer carroDonacionId) {
		this.carroDonacionId = carroDonacionId;
	}
	
	

}
