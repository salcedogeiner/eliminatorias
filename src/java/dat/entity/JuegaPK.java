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
public class JuegaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_jugador")
    private int codJugador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_torneo")
    private int idTorneo;

    public JuegaPK() {
    }

    public JuegaPK(int codJugador, String codEquipo, int idTorneo) {
        this.codJugador = codJugador;
        this.codEquipo = codEquipo;
        this.idTorneo = idTorneo;
    }

    public int getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(int codJugador) {
        this.codJugador = codJugador;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codJugador;
        hash += (codEquipo != null ? codEquipo.hashCode() : 0);
        hash += (int) idTorneo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegaPK)) {
            return false;
        }
        JuegaPK other = (JuegaPK) object;
        if (this.codJugador != other.codJugador) {
            return false;
        }
        if ((this.codEquipo == null && other.codEquipo != null) || (this.codEquipo != null && !this.codEquipo.equals(other.codEquipo))) {
            return false;
        }
        if (this.idTorneo != other.idTorneo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.JuegaPK[ codJugador=" + codJugador + ", codEquipo=" + codEquipo + ", idTorneo=" + idTorneo + " ]";
    }
    
}
