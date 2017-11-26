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
public class ParticipaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_torneo")
    private int idTorneo;

    public ParticipaPK() {
    }

    public ParticipaPK(String codEquipo, int idTorneo) {
        this.codEquipo = codEquipo;
        this.idTorneo = idTorneo;
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
        hash += (codEquipo != null ? codEquipo.hashCode() : 0);
        hash += (int) idTorneo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticipaPK)) {
            return false;
        }
        ParticipaPK other = (ParticipaPK) object;
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
        return "dat.entity.ParticipaPK[ codEquipo=" + codEquipo + ", idTorneo=" + idTorneo + " ]";
    }
    
}
