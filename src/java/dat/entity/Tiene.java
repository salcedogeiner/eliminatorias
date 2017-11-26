/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "tiene")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiene.findAll", query = "SELECT t FROM Tiene t")
    , @NamedQuery(name = "Tiene.findByCodEquipo", query = "SELECT t FROM Tiene t WHERE t.tienePK.codEquipo = :codEquipo")
    , @NamedQuery(name = "Tiene.findByCodEstadio", query = "SELECT t FROM Tiene t WHERE t.tienePK.codEstadio = :codEstadio")})
public class Tiene implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TienePK tienePK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiene")
    private Collection<Enfrenta> enfrentaCollection;
    @JoinColumn(name = "cod_equipo", referencedColumnName = "cod_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "cod_estadio", referencedColumnName = "cod_estadio", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estadios estadios;

    public Tiene() {
    }

    public Tiene(TienePK tienePK) {
        this.tienePK = tienePK;
    }

    public Tiene(String codEquipo, int codEstadio) {
        this.tienePK = new TienePK(codEquipo, codEstadio);
    }

    public TienePK getTienePK() {
        return tienePK;
    }

    public void setTienePK(TienePK tienePK) {
        this.tienePK = tienePK;
    }

    @XmlTransient
    public Collection<Enfrenta> getEnfrentaCollection() {
        return enfrentaCollection;
    }

    public void setEnfrentaCollection(Collection<Enfrenta> enfrentaCollection) {
        this.enfrentaCollection = enfrentaCollection;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Estadios getEstadios() {
        return estadios;
    }

    public void setEstadios(Estadios estadios) {
        this.estadios = estadios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tienePK != null ? tienePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiene)) {
            return false;
        }
        Tiene other = (Tiene) object;
        if ((this.tienePK == null && other.tienePK != null) || (this.tienePK != null && !this.tienePK.equals(other.tienePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Tiene[ tienePK=" + tienePK + " ]";
    }
    
}
