package com.reciclajeApp.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "venta_has_estadoresiduo", schema = "public")
public class VentaHasEstadoresiduo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "idventa",column = @Column(name = "idventa",nullable = false)
        )
        , @AttributeOverride(name = "idestadoresiduo",column = @Column(name = "idestadoresiduo",nullable = false)
        )
    })
    @NotNull
    private VentaHasEstadoresiduoId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idestadoresiduo", insertable = false, updatable = false)
    @NotNull
    private Estadoresiduo estadoresiduo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idventa", insertable = false, updatable = false)
    @NotNull
    private Venta venta;
	
    public VentaHasEstadoresiduo() {
		super();
	}

	public VentaHasEstadoresiduo(@NotNull VentaHasEstadoresiduoId id, @NotNull Estadoresiduo estadoresiduo,
			@NotNull Venta venta) {
		super();
		this.id = id;
		this.estadoresiduo = estadoresiduo;
		this.venta = venta;
	}

	public VentaHasEstadoresiduoId getId() {
		return id;
	}

	public void setId(VentaHasEstadoresiduoId id) {
		this.id = id;
	}

	public Estadoresiduo getEstadoresiduo() {
		return estadoresiduo;
	}

	public void setEstadoresiduo(Estadoresiduo estadoresiduo) {
		this.estadoresiduo = estadoresiduo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
    
    
    
}
