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
    @NotNull
    private Integer iddonacion;
    private Integer idtiporesiduo_Tiporesiduo;
	
    public DonacionDTO() {
		super();
	}

	public DonacionDTO(@NotNull Integer iddonacion, Integer idtiporesiduo_Tiporesiduo) {
		super();
		this.iddonacion = iddonacion;
		this.idtiporesiduo_Tiporesiduo = idtiporesiduo_Tiporesiduo;
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
    
    
    
}
