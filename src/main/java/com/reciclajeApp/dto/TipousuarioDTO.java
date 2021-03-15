package com.reciclajeApp.dto;



import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/

public class TipousuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private Integer idtipousuario;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String tipousuario;
	
    public TipousuarioDTO() {
		super();
	}

	public TipousuarioDTO(@NotNull Integer idtipousuario, @NotNull @NotEmpty @Size(max = 255) String tipousuario) {
		super();
		this.idtipousuario = idtipousuario;
		this.tipousuario = tipousuario;
	}

	public Integer getIdtipousuario() {
		return idtipousuario;
	}

	public void setIdtipousuario(Integer idtipousuario) {
		this.idtipousuario = idtipousuario;
	}

	public String getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
