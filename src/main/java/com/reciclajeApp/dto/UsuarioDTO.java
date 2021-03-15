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

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String apellido;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String direccion;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String email;
  
    private Boolean enable;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String password;
    
    private Integer idtipousuario_Tipousuario;
	
    public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(@NotNull @NotEmpty @Size(max = 255) String apellido,
			@NotNull @NotEmpty @Size(max = 255) String direccion, @NotNull @NotEmpty @Size(max = 255) String email,
			@NotNull @NotEmpty @Size(max = 255) Boolean enable, @NotNull @NotEmpty @Size(max = 255) String nombre,
			@NotNull @NotEmpty @Size(max = 255) String password, Integer idtipousuario_Tipousuario) {
		super();
		this.apellido = apellido;
		this.direccion = direccion;
		this.email = email;
		this.enable = enable;
		this.nombre = nombre;
		this.password = password;
		this.idtipousuario_Tipousuario = idtipousuario_Tipousuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIdtipousuario_Tipousuario() {
		return idtipousuario_Tipousuario;
	}

	public void setIdtipousuario_Tipousuario(Integer idtipousuario_Tipousuario) {
		this.idtipousuario_Tipousuario = idtipousuario_Tipousuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
}
