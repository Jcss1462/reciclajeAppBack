package com.reciclajeApp.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public class DonacionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer iddonacion;
    private Integer idtiporesiduo_Tiporesiduo;
    @NotNull
    private String emailPropietario;
    private String tipo;
	
    public DonacionDTO() {
		super();
	}

	public DonacionDTO(Integer iddonacion, Integer idtiporesiduo_Tiporesiduo,@NotNull String emailPropietario,String tipo) {
		super();
		this.iddonacion = iddonacion;
		this.idtiporesiduo_Tiporesiduo = idtiporesiduo_Tiporesiduo;
		this.emailPropietario=emailPropietario;
		this.tipo=tipo;
	}

	public Integer getIddonacion() {
		return iddonacion;
	}

	public void setIddonacion(Integer iddonacion) {
		this.iddonacion = iddonacion;
	}

	public Integer getIdtiporesiduo_Tiporesiduo() {
		return idtiporesiduo_Tiporesiduo;
	}

	public void setIdtiporesiduo_Tiporesiduo(Integer idtiporesiduo_Tiporesiduo) {
		this.idtiporesiduo_Tiporesiduo = idtiporesiduo_Tiporesiduo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmailPropietario() {
		return emailPropietario;
	}

	public void setEmailPropietario(String emailPropietario) {
		this.emailPropietario = emailPropietario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
	
    
    
}
