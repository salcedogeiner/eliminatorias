/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "participa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participa.findAll", query = "SELECT p FROM Participa p")
    , @NamedQuery(name = "Participa.findByCodEquipo", query = "SELECT p FROM Participa p WHERE p.participaPK.codEquipo = :codEquipo")
    , @NamedQuery(name = "Participa.findByIdTorneo", query = "SELECT p FROM Participa p WHERE p.participaPK.idTorneo = :idTorneo")
    , @NamedQuery(name = "Participa.findByPosicion", query = "SELECT p FROM Participa p WHERE p.posicion = :posicion")})
public class Participa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticipaPK participaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posicion")
    private short posicion;
    @JoinColumn(name = "cod_equipo", referencedColumnName = "cod_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Torneos torneos;

    public Participa() {
    }

    public Participa(ParticipaPK participaPK) {
        this.participaPK = participaPK;
    }

    public Participa(ParticipaPK participaPK, short posicion) {
        this.participaPK = participaPK;
        this.posicion = posicion;
    }

    public Participa(String codEquipo, int idTorneo) {
        this.participaPK = new ParticipaPK(codEquipo, idTorneo);
    }

    public ParticipaPK getParticipaPK() {
        return participaPK;
    }

    public void setParticipaPK(ParticipaPK participaPK) {
        this.participaPK = participaPK;
    }

    public short getPosicion() {
        return posicion;
    }

    public void setPosicion(short posicion) {
        this.posicion = posicion;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Torneos getTorneos() {
        return torneos;
    }

    public void setTorneos(Torneos torneos) {
        this.torneos = torneos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participaPK != null ? participaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participa)) {
            return false;
        }
        Participa other = (Participa) object;
        if ((this.participaPK == null && other.participaPK != null) || (this.participaPK != null && !this.participaPK.equals(other.participaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Participa[ participaPK=" + participaPK + " ]";
    }
    
}
