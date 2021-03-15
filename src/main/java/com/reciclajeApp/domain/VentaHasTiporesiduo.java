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
@Table(name = "venta_has_tiporesiduo", schema = "public")
public class VentaHasTiporesiduo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @AttributeOverrides({@AttributeOverride(name = "idventa",column = @Column(name = "idventa",nullable = false)
        )
        , @AttributeOverride(name = "idtiporesiduo",column = @Column(name = "idtiporesiduo",nullable = false)
        )
    })
    @NotNull
    private VentaHasTiporesiduoId id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtiporesiduo", insertable = false, updatable = false)
    @NotNull
    private Tiporesiduo tiporesiduo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idventa", insertable = false, updatable = false)
    @NotNull
    private Venta venta;
	
    public VentaHasTiporesiduo() {
		super();
	}

	public VentaHasTiporesiduo(@NotNull VentaHasTiporesiduoId id, @NotNull Tiporesiduo tiporesiduo,
			@NotNull Venta venta) {
		super();
		this.id = id;
		this.tiporesiduo = tiporesiduo;
		this.venta = venta;
	}

	public VentaHasTiporesiduoId getId() {
		return id;
	}

	public void setId(VentaHasTiporesiduoId id) {
		this.id = id;
	}

	public Tiporesiduo getTiporesiduo() {
		return tiporesiduo;
	}

	public void setTiporesiduo(Tiporesiduo tiporesiduo) {
		this.tiporesiduo = tiporesiduo;
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
