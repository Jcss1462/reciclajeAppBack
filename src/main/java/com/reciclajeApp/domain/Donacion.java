package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "donacion", schema = "public")
public class Donacion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "iddonacion", unique = true, nullable = false)
	@NotNull
	private Integer iddonacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtiporesiduo")
	@NotNull
	private Tiporesiduo tiporesiduo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "donacion")
	private List<CarrodonacionHasDonacion> carrodonacionHasDonacions = new ArrayList<>();

	public Donacion() {
		super();
	}

	public Donacion(@NotNull Integer iddonacion, @NotNull Tiporesiduo tiporesiduo,
			List<CarrodonacionHasDonacion> carrodonacionHasDonacions) {
		super();
		this.iddonacion = iddonacion;
		this.tiporesiduo = tiporesiduo;
		this.carrodonacionHasDonacions = carrodonacionHasDonacions;
	}

	public Integer getIddonacion() {
		return iddonacion;
	}

	public void setIddonacion(Integer iddonacion) {
		this.iddonacion = iddonacion;
	}

	public Tiporesiduo getTiporesiduo() {
		return tiporesiduo;
	}

	public void setTiporesiduo(Tiporesiduo tiporesiduo) {
		this.tiporesiduo = tiporesiduo;
	}

	public List<CarrodonacionHasDonacion> getCarrodonacionHasDonacions() {
		return carrodonacionHasDonacions;
	}

	public void setCarrodonacionHasDonacions(List<CarrodonacionHasDonacion> carrodonacionHasDonacions) {
		this.carrodonacionHasDonacions = carrodonacionHasDonacions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}