package com.reciclajeApp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/

public class AplicantesofertasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    

    private Integer idaplicacion;
    
    @NotNull
    private Integer idoferta_Ofertas;
    
    @NotNull
    private String email_Usuario;

	public AplicantesofertasDTO() {
		super();
	}

	public AplicantesofertasDTO(Integer idaplicacion, @NotNull Integer idoferta_Ofertas,
			@NotNull String email_Usuario) {
		super();
		this.idaplicacion = idaplicacion;
		this.idoferta_Ofertas = idoferta_Ofertas;
		this.email_Usuario = email_Usuario;
	}

	public Integer getIdaplicacion() {
		return idaplicacion;
	}

	public void setIdaplicacion(Integer idaplicacion) {
		this.idaplicacion = idaplicacion;
	}

	public Integer getIdoferta_Ofertas() {
		return idoferta_Ofertas;
	}

	public void setIdoferta_Ofertas(Integer idoferta_Ofertas) {
		this.idoferta_Ofertas = idoferta_Ofertas;
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
