package com.reciclajeApp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.reciclajeApp.domain.Aplicantesofertas;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class OfertasDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    
    private Integer idoferta;
    
    @NotNull
    private Integer cupos;
    @NotNull
    private Double precioofrecidokl;
    private Integer idestadooferta_Estadooferta;
    private Integer idtiporesiduo_Tiporesiduo;
    private String email_Usuario;
    private List<Aplicantesofertas> aplicantesofertases;
    
    
    private Integer numeroDeAplicantes;
    private String estadoOferta;
    private String tipoResiduo;
    
	
    public OfertasDTO() {
		super();
	}


	public OfertasDTO(Integer idoferta, @NotNull Integer cupos, @NotNull Double precioofrecidokl,
			Integer idestadooferta_Estadooferta, Integer idtiporesiduo_Tiporesiduo, String email_Usuario,
			List<Aplicantesofertas> aplicantesofertases, Integer numeroDeAplicantes,
			 String estadoOferta, String tipoResiduo) {
		super();
		this.idoferta = idoferta;
		this.cupos = cupos;
		this.precioofrecidokl = precioofrecidokl;
		this.idestadooferta_Estadooferta = idestadooferta_Estadooferta;
		this.idtiporesiduo_Tiporesiduo = idtiporesiduo_Tiporesiduo;
		this.email_Usuario = email_Usuario;
		this.aplicantesofertases = aplicantesofertases;
		
		
		this.numeroDeAplicantes = numeroDeAplicantes;
		this.estadoOferta = estadoOferta;
		this.tipoResiduo = tipoResiduo;
	}


	public Integer getIdoferta() {
		return idoferta;
	}


	public void setIdoferta(Integer idoferta) {
		this.idoferta = idoferta;
	}


	public Integer getCupos() {
		return cupos;
	}


	public void setCupos(Integer cupos) {
		this.cupos = cupos;
	}


	public Double getPrecioofrecidokl() {
		return precioofrecidokl;
	}


	public void setPrecioofrecidokl(Double precioofrecidokl) {
		this.precioofrecidokl = precioofrecidokl;
	}


	public Integer getIdestadooferta_Estadooferta() {
		return idestadooferta_Estadooferta;
	}


	public void setIdestadooferta_Estadooferta(Integer idestadooferta_Estadooferta) {
		this.idestadooferta_Estadooferta = idestadooferta_Estadooferta;
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


	public void setAplicantesofertases(List<Aplicantesofertas> aplicantesofertases) {
		this.aplicantesofertases = aplicantesofertases;
	}


	public Integer getNumeroDeAplicantes() {
		return aplicantesofertases.size();
	}
	
	
	public String getEstadoOferta() {
		return estadoOferta;
	}


	public void setEstadoOferta(String estadoOferta) {
		this.estadoOferta = estadoOferta;
	}


	public String getTipoResiduo() {
		return tipoResiduo;
	}


	public void setTipoResiduo(String tipoResiduo) {
		this.tipoResiduo = tipoResiduo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
