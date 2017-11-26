/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Salcedo
 */
@Embeddable
public class TienePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_estadio")
    private int codEstadio;

    public TienePK() {
    }

    public TienePK(String codEquipo, int codEstadio) {
        this.codEquipo = codEquipo;
        this.codEstadio = codEstadio;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public int getCodEstadio() {
        return codEstadio;
    }

    public void setCodEstadio(int codEstadio) {
        this.codEstadio = codEstadio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquipo != null ? codEquipo.hashCode() : 0);
        hash += (int) codEstadio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TienePK)) {
            return false;
        }
        TienePK other = (TienePK) object;
        if ((this.codEquipo == null && other.codEquipo != null) || (this.codEquipo != null && !this.codEquipo.equals(other.codEquipo))) {
            return false;
        }
        if (this.codEstadio != other.codEstadio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.TienePK[ codEquipo=" + codEquipo + ", codEstadio=" + codEstadio + " ]";
    }
    
}
