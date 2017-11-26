/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Salcedo
 */
@Embeddable
public class EnfrentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_estadio")
    private int codEstadio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo_local")
    private String codEquipoLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo_visitante")
    private String codEquipoVisitante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_enfrenta")
    @Temporal(TemporalType.DATE)
    private Date fEnfrenta;

    public EnfrentaPK() {
    }

    public EnfrentaPK(int codEstadio, String codEquipoLocal, String codEquipoVisitante, Date fEnfrenta) {
        this.codEstadio = codEstadio;
        this.codEquipoLocal = codEquipoLocal;
        this.codEquipoVisitante = codEquipoVisitante;
        this.fEnfrenta = fEnfrenta;
    }

    public int getCodEstadio() {
        return codEstadio;
    }

    public void setCodEstadio(int codEstadio) {
        this.codEstadio = codEstadio;
    }

    public String getCodEquipoLocal() {
        return codEquipoLocal;
    }

    public void setCodEquipoLocal(String codEquipoLocal) {
        this.codEquipoLocal = codEquipoLocal;
    }

    public String getCodEquipoVisitante() {
        return codEquipoVisitante;
    }

    public void setCodEquipoVisitante(String codEquipoVisitante) {
        this.codEquipoVisitante = codEquipoVisitante;
    }

    public Date getFEnfrenta() {
        return fEnfrenta;
    }

    public void setFEnfrenta(Date fEnfrenta) {
        this.fEnfrenta = fEnfrenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codEstadio;
        hash += (codEquipoLocal != null ? codEquipoLocal.hashCode() : 0);
        hash += (codEquipoVisitante != null ? codEquipoVisitante.hashCode() : 0);
        hash += (fEnfrenta != null ? fEnfrenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfrentaPK)) {
            return false;
        }
        EnfrentaPK other = (EnfrentaPK) object;
        if (this.codEstadio != other.codEstadio) {
            return false;
        }
        if ((this.codEquipoLocal == null && other.codEquipoLocal != null) || (this.codEquipoLocal != null && !this.codEquipoLocal.equals(other.codEquipoLocal))) {
            return false;
        }
        if ((this.codEquipoVisitante == null && other.codEquipoVisitante != null) || (this.codEquipoVisitante != null && !this.codEquipoVisitante.equals(other.codEquipoVisitante))) {
            return false;
        }
        if ((this.fEnfrenta == null && other.fEnfrenta != null) || (this.fEnfrenta != null && !this.fEnfrenta.equals(other.fEnfrenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.EnfrentaPK[ codEstadio=" + codEstadio + ", codEquipoLocal=" + codEquipoLocal + ", codEquipoVisitante=" + codEquipoVisitante + ", fEnfrenta=" + fEnfrenta + " ]";
    }
    
}
