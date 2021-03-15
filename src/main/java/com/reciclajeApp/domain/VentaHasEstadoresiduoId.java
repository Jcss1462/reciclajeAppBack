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
public class VentaHasEstadoresiduoId implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
    private Integer idventa;
    @NotNull
    private Integer idestadoresiduo;

    public VentaHasEstadoresiduoId() {
    }

    @Column(name = "idventa", nullable = false)
    public Integer getIdventa() {
        return this.idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    @Column(name = "idestadoresiduo", nullable = false)
    public Integer getIdestadoresiduo() {
        return this.idestadoresiduo;
    }

    public void setIdestadoresiduo(Integer idestadoresiduo) {
        this.idestadoresiduo = idestadoresiduo;
    }

    public boolean equals(Object other) {
        if ((this == other)) {
            return true;
        }

        if ((other == null)) {
            return false;
        }

        if (!(other instanceof VentaHasEstadoresiduoId)) {
            return false;
        }

        VentaHasEstadoresiduoId castOther = (VentaHasEstadoresiduoId) other;

        return ((this.getIdventa() == castOther.getIdventa()) ||
        ((this.getIdventa() != null) && (castOther.getIdventa() != null) &&
        this.getIdventa().equals(castOther.getIdventa()))) &&
        ((this.getIdestadoresiduo() == castOther.getIdestadoresiduo()) ||
        ((this.getIdestadoresiduo() != null) &&
        (castOther.getIdestadoresiduo() != null) &&
        this.getIdestadoresiduo().equals(castOther.getIdestadoresiduo())));
    }

    public int hashCode() {
        int result = 17;

        result = (37 * result) +
            ((getIdventa() == null) ? 0 : this.getIdventa().hashCode());
        result = (37 * result) +
            ((getIdestadoresiduo() == null) ? 0
                                            : this.getIdestadoresiduo()
                                                  .hashCode());

        return result;
    }
}
