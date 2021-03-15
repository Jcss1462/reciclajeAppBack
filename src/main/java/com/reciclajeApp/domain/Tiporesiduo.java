package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "tiporesiduo", schema = "public")
public class Tiporesiduo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idtiporesiduo", unique = true, nullable = false)
	@NotNull
	private Integer idtiporesiduo;

	@NotNull
	@Column(name = "fechaactualizacion", nullable = false)
	private Date fechaactualizacion;
	@NotNull
	@Column(name = "precio", nullable = false)
	private Double precio;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "tipo", nullable = false)
	private String tipo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tiporesiduo")
	private List<VentaHasTiporesiduo> ventaHasTiporesiduos = new ArrayList<>();

}