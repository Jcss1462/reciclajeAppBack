package com.reciclajeApp.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
@Embeddable
public class VentaHasTiporesiduoId implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
    private Integer idventa;
    @NotNull
    private Integer idtiporesiduo;

    public VentaHasTiporesiduoId() {
    }

    @Column(name = "idventa", nullable = false)
    public Integer getIdventa() {
        return this.idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    @Column(name = "idtiporesiduo", nullable = false)
    public Integer getIdtiporesiduo() {
        return this.idtiporesiduo;
    }

    public void setIdtiporesiduo(Integer idtiporesiduo) {
        this.idtiporesiduo = idtiporesiduo;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }

        if ((other == null)) {
            return false;
        }

        if (!(other instanceof VentaHasTiporesiduoId)) {
            return false;
        }

        VentaHasTiporesiduoId castOther = (VentaHasTiporesiduoId) other;

        return ((this.getIdventa() == castOther.getIdventa()) ||
        ((this.getIdventa() != null) && (castOther.getIdventa() != null) &&
        this.getIdventa().equals(castOther.getIdventa()))) &&
        ((this.getIdtiporesiduo() == castOther.getIdtiporesiduo()) ||
        ((this.getIdtiporesiduo() != null) &&
        (castOther.getIdtiporesiduo() != null) &&
        this.getIdtiporesiduo().equals(castOther.getIdtiporesiduo())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getIdventa() == null) ? 0 : this.getIdventa().hashCode());
        result = (37 * result) +
            ((getIdtiporesiduo() == null) ? 0 : this.getIdtiporesiduo()
                                                    .hashCode());

        return result;
    }
}
