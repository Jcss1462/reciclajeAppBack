package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.sun.istack.NotNull;


/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "tipousuario", schema = "public")
public class Tipousuario implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idtipousuario", unique = true, nullable = false)
	@NotNull
	private Integer idtipousuario;

	@NotNull
	@NotEmpty
	@Size(max=255)
	@Column(name = "tipousuario", nullable = false)
	private String tipousuario;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipousuario")
	private List<Usuario> usuarios = new ArrayList<>();

	public Tipousuario() {
		super();
	}

	public Tipousuario(Integer idtipousuario, String tipousuario, List<Usuario> usuarios) {
		super();
		this.idtipousuario = idtipousuario;
		this.tipousuario = tipousuario;
		this.usuarios = usuarios;
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

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

}