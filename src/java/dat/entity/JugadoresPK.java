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
public class JugadoresPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_jugador")
    private int codJugador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;

    public JugadoresPK() {
    }

    public JugadoresPK(int codJugador, String codEquipo) {
        this.codJugador = codJugador;
        this.codEquipo = codEquipo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codJugador;
        hash += (codEquipo != null ? codEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JugadoresPK)) {
            return false;
        }
        JugadoresPK other = (JugadoresPK) object;
        if (this.codJugador != other.codJugador) {
            return false;
        }
        if ((this.codEquipo == null && other.codEquipo != null) || (this.codEquipo != null && !this.codEquipo.equals(other.codEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.JugadoresPK[ codJugador=" + codJugador + ", codEquipo=" + codEquipo + " ]";
    }
    
}
