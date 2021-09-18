package com.reciclajeApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "ofertas", schema = "public")
public class Ofertas implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
   
    @Id
    @Column(name = "idoferta", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idoferta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestadooferta")
    @NotNull
    private Estadooferta estadooferta;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtiporesiduo")
    @NotNull
    private Tiporesiduo tiporesiduo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_centrodeacopio")
    @NotNull
    private Usuario emailCentroDeAcopio;
    
    @NotNull
    @Column(name = "cupos", nullable = false)
    private Integer cupos;
   
    @NotNull
    @Column(name = "precioofrecidokl", nullable = false)
    private Double precioofrecidokl;
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="ofertas")
	private List<Aplicantesofertas> aplicantesofertases = new ArrayList<>();

	public Ofertas() {
		super();
	}

	public Ofertas(Integer idoferta, @NotNull Estadooferta estadooferta, @NotNull Tiporesiduo tiporesiduo,
			@NotNull Usuario emailCentroDeAcopio, @NotNull Integer cupos, @NotNull Double precioofrecidokl,
			List<com.reciclajeApp.domain.Aplicantesofertas> aplicantesofertases) {
		super();
		this.idoferta = idoferta;
		this.estadooferta = estadooferta;
		this.tiporesiduo = tiporesiduo;
		this.emailCentroDeAcopio = emailCentroDeAcopio;
		this.cupos = cupos;
		this.precioofrecidokl = precioofrecidokl;
		this.aplicantesofertases = aplicantesofertases;
	}

	public Integer getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(Integer idoferta) {
		this.idoferta = idoferta;
	}

	public Estadooferta getEstadooferta() {
		return estadooferta;
	}

	public void setEstadooferta(Estadooferta estadooferta) {
		this.estadooferta = estadooferta;
	}

	public Tiporesiduo getTiporesiduo() {
		return tiporesiduo;
	}

	public void setTiporesiduo(Tiporesiduo tiporesiduo) {
		this.tiporesiduo = tiporesiduo;
	}

	public Usuario getEmailCentroDeAcopio() {
		return emailCentroDeAcopio;
	}

	public void setEmailCentroDeAcopio(Usuario emailCentroDeAcopio) {
		this.emailCentroDeAcopio = emailCentroDeAcopio;
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

	public List<Aplicantesofertas> getAplicantesofertases() {
		return aplicantesofertases;
	}

	public void setAplicantesofertases(List<Aplicantesofertas> aplicantesofertases) {
		this.aplicantesofertases = aplicantesofertases;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
