/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "enfrenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfrenta.findAll", query = "SELECT e FROM Enfrenta e")
    , @NamedQuery(name = "Enfrenta.findByCodEstadio", query = "SELECT e FROM Enfrenta e WHERE e.enfrentaPK.codEstadio = :codEstadio")
    , @NamedQuery(name = "Enfrenta.findByCodEquipoLocal", query = "SELECT e FROM Enfrenta e WHERE e.enfrentaPK.codEquipoLocal = :codEquipoLocal")
    , @NamedQuery(name = "Enfrenta.findByCodEquipoVisitante", query = "SELECT e FROM Enfrenta e WHERE e.enfrentaPK.codEquipoVisitante = :codEquipoVisitante")
    , @NamedQuery(name = "Enfrenta.findByFEnfrenta", query = "SELECT e FROM Enfrenta e WHERE e.enfrentaPK.fEnfrenta = :fEnfrenta")})
public class Enfrenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnfrentaPK enfrentaPK;
    @ManyToMany(mappedBy = "enfrentaCollection")
    private Collection<Arbitros> arbitrosCollection;
    @JoinColumn(name = "cod_equipo_visitante", referencedColumnName = "cod_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumns({
        @JoinColumn(name = "cod_estadio", referencedColumnName = "cod_estadio", insertable = false, updatable = false)
        , @JoinColumn(name = "cod_equipo_local", referencedColumnName = "cod_equipo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Tiene tiene;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enfrenta")
    private Collection<Incide> incideCollection;

    public Enfrenta() {
    }

    public Enfrenta(EnfrentaPK enfrentaPK) {
        this.enfrentaPK = enfrentaPK;
    }

    public Enfrenta(int codEstadio, String codEquipoLocal, String codEquipoVisitante, Date fEnfrenta) {
        this.enfrentaPK = new EnfrentaPK(codEstadio, codEquipoLocal, codEquipoVisitante, fEnfrenta);
    }

    public EnfrentaPK getEnfrentaPK() {
        return enfrentaPK;
    }

    public void setEnfrentaPK(EnfrentaPK enfrentaPK) {
        this.enfrentaPK = enfrentaPK;
    }

    @XmlTransient
    public Collection<Arbitros> getArbitrosCollection() {
        return arbitrosCollection;
    }

    public void setArbitrosCollection(Collection<Arbitros> arbitrosCollection) {
        this.arbitrosCollection = arbitrosCollection;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Tiene getTiene() {
        return tiene;
    }

    public void setTiene(Tiene tiene) {
        this.tiene = tiene;
    }

    @XmlTransient
    public Collection<Incide> getIncideCollection() {
        return incideCollection;
    }

    public void setIncideCollection(Collection<Incide> incideCollection) {
        this.incideCollection = incideCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (enfrentaPK != null ? enfrentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfrenta)) {
            return false;
        }
        Enfrenta other = (Enfrenta) object;
        if ((this.enfrentaPK == null && other.enfrentaPK != null) || (this.enfrentaPK != null && !this.enfrentaPK.equals(other.enfrentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Enfrenta[ enfrentaPK=" + enfrentaPK + " ]";
    }
    
}
