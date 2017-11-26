/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "incide")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incide.findAll", query = "SELECT i FROM Incide i")
    , @NamedQuery(name = "Incide.findByCodEquipo", query = "SELECT i FROM Incide i WHERE i.incidePK.codEquipo = :codEquipo")
    , @NamedQuery(name = "Incide.findByCodJugador", query = "SELECT i FROM Incide i WHERE i.incidePK.codJugador = :codJugador")
    , @NamedQuery(name = "Incide.findByCodEstadio", query = "SELECT i FROM Incide i WHERE i.incidePK.codEstadio = :codEstadio")
    , @NamedQuery(name = "Incide.findByCodEquipoLocal", query = "SELECT i FROM Incide i WHERE i.incidePK.codEquipoLocal = :codEquipoLocal")
    , @NamedQuery(name = "Incide.findByCodEquipoVisitante", query = "SELECT i FROM Incide i WHERE i.incidePK.codEquipoVisitante = :codEquipoVisitante")
    , @NamedQuery(name = "Incide.findByFEnfrenta", query = "SELECT i FROM Incide i WHERE i.incidePK.fEnfrenta = :fEnfrenta")
    , @NamedQuery(name = "Incide.findByMinuto", query = "SELECT i FROM Incide i WHERE i.incidePK.minuto = :minuto")
    , @NamedQuery(name = "Incide.findByTipoIncidente", query = "SELECT i FROM Incide i WHERE i.incidePK.tipoIncidente = :tipoIncidente")})
public class Incide implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IncidePK incidePK;
    @JoinColumns({
        @JoinColumn(name = "cod_estadio", referencedColumnName = "cod_estadio", insertable = false, updatable = false)
        , @JoinColumn(name = "cod_equipo_local", referencedColumnName = "cod_equipo_local", insertable = false, updatable = false)
        , @JoinColumn(name = "cod_equipo_visitante", referencedColumnName = "cod_equipo_visitante", insertable = false, updatable = false)
        , @JoinColumn(name = "f_enfrenta", referencedColumnName = "f_enfrenta", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Enfrenta enfrenta;
    @JoinColumns({
        @JoinColumn(name = "cod_equipo", referencedColumnName = "cod_equipo", insertable = false, updatable = false)
        , @JoinColumn(name = "cod_jugador", referencedColumnName = "cod_jugador", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Jugadores jugadores;

    public Incide() {
    }

    public Incide(IncidePK incidePK) {
        this.incidePK = incidePK;
    }

    public Incide(String codEquipo, int codJugador, int codEstadio, String codEquipoLocal, String codEquipoVisitante, Date fEnfrenta, short minuto, String tipoIncidente) {
        this.incidePK = new IncidePK(codEquipo, codJugador, codEstadio, codEquipoLocal, codEquipoVisitante, fEnfrenta, minuto, tipoIncidente);
    }

    public IncidePK getIncidePK() {
        return incidePK;
    }

    public void setIncidePK(IncidePK incidePK) {
        this.incidePK = incidePK;
    }

    public Enfrenta getEnfrenta() {
        return enfrenta;
    }

    public void setEnfrenta(Enfrenta enfrenta) {
        this.enfrenta = enfrenta;
    }

    public Jugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugadores jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidePK != null ? incidePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incide)) {
            return false;
        }
        Incide other = (Incide) object;
        if ((this.incidePK == null && other.incidePK != null) || (this.incidePK != null && !this.incidePK.equals(other.incidePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Incide[ incidePK=" + incidePK + " ]";
    }
    
}
