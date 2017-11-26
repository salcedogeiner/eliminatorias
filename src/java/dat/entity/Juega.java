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
import javax.persistence.JoinColumns;
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
@Table(name = "juega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juega.findAll", query = "SELECT j FROM Juega j")
    , @NamedQuery(name = "Juega.findByCodJugador", query = "SELECT j FROM Juega j WHERE j.juegaPK.codJugador = :codJugador")
    , @NamedQuery(name = "Juega.findByCodEquipo", query = "SELECT j FROM Juega j WHERE j.juegaPK.codEquipo = :codEquipo")
    , @NamedQuery(name = "Juega.findByIdTorneo", query = "SELECT j FROM Juega j WHERE j.juegaPK.idTorneo = :idTorneo")
    , @NamedQuery(name = "Juega.findByGoles", query = "SELECT j FROM Juega j WHERE j.goles = :goles")
    , @NamedQuery(name = "Juega.findByGanados", query = "SELECT j FROM Juega j WHERE j.ganados = :ganados")
    , @NamedQuery(name = "Juega.findByEmpatados", query = "SELECT j FROM Juega j WHERE j.empatados = :empatados")
    , @NamedQuery(name = "Juega.findByPerdidos", query = "SELECT j FROM Juega j WHERE j.perdidos = :perdidos")})
public class Juega implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JuegaPK juegaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "goles")
    private short goles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ganados")
    private short ganados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empatados")
    private short empatados;
    @Basic(optional = false)
    @NotNull
    @Column(name = "perdidos")
    private short perdidos;
    @JoinColumns({
        @JoinColumn(name = "cod_jugador", referencedColumnName = "cod_jugador", insertable = false, updatable = false)
        , @JoinColumn(name = "cod_equipo", referencedColumnName = "cod_equipo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Jugadores jugadores;
    @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Torneos torneos;

    public Juega() {
    }

    public Juega(JuegaPK juegaPK) {
        this.juegaPK = juegaPK;
    }

    public Juega(JuegaPK juegaPK, short goles, short ganados, short empatados, short perdidos) {
        this.juegaPK = juegaPK;
        this.goles = goles;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
    }

    public Juega(int codJugador, String codEquipo, int idTorneo) {
        this.juegaPK = new JuegaPK(codJugador, codEquipo, idTorneo);
    }

    public JuegaPK getJuegaPK() {
        return juegaPK;
    }

    public void setJuegaPK(JuegaPK juegaPK) {
        this.juegaPK = juegaPK;
    }

    public short getGoles() {
        return goles;
    }

    public void setGoles(short goles) {
        this.goles = goles;
    }

    public short getGanados() {
        return ganados;
    }

    public void setGanados(short ganados) {
        this.ganados = ganados;
    }

    public short getEmpatados() {
        return empatados;
    }

    public void setEmpatados(short empatados) {
        this.empatados = empatados;
    }

    public short getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(short perdidos) {
        this.perdidos = perdidos;
    }

    public Jugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugadores jugadores) {
        this.jugadores = jugadores;
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
        hash += (juegaPK != null ? juegaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juega)) {
            return false;
        }
        Juega other = (Juega) object;
        if ((this.juegaPK == null && other.juegaPK != null) || (this.juegaPK != null && !this.juegaPK.equals(other.juegaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Juega[ juegaPK=" + juegaPK + " ]";
    }
    
}
