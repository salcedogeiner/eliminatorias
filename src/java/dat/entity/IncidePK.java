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
public class IncidePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_jugador")
    private int codJugador;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "minuto")
    private short minuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_incidente")
    private String tipoIncidente;

    public IncidePK() {
    }

    public IncidePK(String codEquipo, int codJugador, int codEstadio, String codEquipoLocal, String codEquipoVisitante, Date fEnfrenta, short minuto, String tipoIncidente) {
        this.codEquipo = codEquipo;
        this.codJugador = codJugador;
        this.codEstadio = codEstadio;
        this.codEquipoLocal = codEquipoLocal;
        this.codEquipoVisitante = codEquipoVisitante;
        this.fEnfrenta = fEnfrenta;
        this.minuto = minuto;
        this.tipoIncidente = tipoIncidente;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
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

    public short getMinuto() {
        return minuto;
    }

    public void setMinuto(short minuto) {
        this.minuto = minuto;
    }

    public String getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(String tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquipo != null ? codEquipo.hashCode() : 0);
        hash += (int) codJugador;
        hash += (int) codEstadio;
        hash += (codEquipoLocal != null ? codEquipoLocal.hashCode() : 0);
        hash += (codEquipoVisitante != null ? codEquipoVisitante.hashCode() : 0);
        hash += (fEnfrenta != null ? fEnfrenta.hashCode() : 0);
        hash += (int) minuto;
        hash += (tipoIncidente != null ? tipoIncidente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncidePK)) {
            return false;
        }
        IncidePK other = (IncidePK) object;
        if ((this.codEquipo == null && other.codEquipo != null) || (this.codEquipo != null && !this.codEquipo.equals(other.codEquipo))) {
            return false;
        }
        if (this.codJugador != other.codJugador) {
            return false;
        }
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
        if (this.minuto != other.minuto) {
            return false;
        }
        if ((this.tipoIncidente == null && other.tipoIncidente != null) || (this.tipoIncidente != null && !this.tipoIncidente.equals(other.tipoIncidente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.IncidePK[ codEquipo=" + codEquipo + ", codJugador=" + codJugador + ", codEstadio=" + codEstadio + ", codEquipoLocal=" + codEquipoLocal + ", codEquipoVisitante=" + codEquipoVisitante + ", fEnfrenta=" + fEnfrenta + ", minuto=" + minuto + ", tipoIncidente=" + tipoIncidente + " ]";
    }
    
}
