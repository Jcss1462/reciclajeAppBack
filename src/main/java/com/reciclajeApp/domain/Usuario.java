package com.reciclajeApp.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "email", unique = true, nullable = false)
	@NotNull
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtipousuario")
	@NotNull
	private Tipousuario tipousuario;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "apellido", nullable = false)
	private String apellido;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@Column(name = "enable", nullable = false)
	private Boolean enable;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "password", nullable = false)
	private String password;

	public Usuario() {
		super();
	}

	public Usuario(@NotNull String email, @NotNull Tipousuario tipousuario,
			@NotNull @NotEmpty @Size(max = 255) String apellido, @NotNull @NotEmpty @Size(max = 255) String direccion,
			@NotNull @NotEmpty @Size(max = 255) Boolean enable, @NotNull @NotEmpty @Size(max = 255) String nombre,
			@NotNull @NotEmpty @Size(max = 255) String password) {
		super();
		this.email = email;
		this.tipousuario = tipousuario;
		this.apellido = apellido;
		this.direccion = direccion;
		this.enable = enable;
		this.nombre = nombre;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Tipousuario getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(Tipousuario tipousuario) {
		this.tipousuario = tipousuario;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
