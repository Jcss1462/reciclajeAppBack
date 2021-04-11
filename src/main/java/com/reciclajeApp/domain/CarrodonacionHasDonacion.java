package com.reciclajeApp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "carrodonacion_has_donacion", schema = "public")
public class CarrodonacionHasDonacion implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idcarrohasdonacion", unique = true, nullable = false)
    @NotNull
    private Integer idcarrohasdonacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcarrodonacion")
    @NotNull
    private Carrodonaciones carrodonaciones;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iddonacion")
    @NotNull
    private Donacion donacion;
	
    public CarrodonacionHasDonacion() {
		super();
	}

	public CarrodonacionHasDonacion(@NotNull Integer idcarrohasdonacion, @NotNull Carrodonaciones carrodonaciones,
			@NotNull Donacion donacion) {
		super();
		this.idcarrohasdonacion = idcarrohasdonacion;
		this.carrodonaciones = carrodonaciones;
		this.donacion = donacion;
	}

	public Integer getIdcarrohasdonacion() {
		return idcarrohasdonacion;
	}

	public void setIdcarrohasdonacion(Integer idcarrohasdonacion) {
		this.idcarrohasdonacion = idcarrohasdonacion;
	}

	public Carrodonaciones getCarrodonaciones() {
		return carrodonaciones;
	}

	public void setCarrodonaciones(Carrodonaciones carrodonaciones) {
		this.carrodonaciones = carrodonaciones;
	}

	public Donacion getDonacion() {
		return donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}
