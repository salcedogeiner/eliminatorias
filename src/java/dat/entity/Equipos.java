/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e")
    , @NamedQuery(name = "Equipos.findByCodEquipo", query = "SELECT e FROM Equipos e WHERE e.codEquipo = :codEquipo")
    , @NamedQuery(name = "Equipos.findByNomEquipo", query = "SELECT e FROM Equipos e WHERE e.nomEquipo = :nomEquipo")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private Collection<Enfrenta> enfrentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private Collection<Jugadores> jugadoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private Collection<Tiene> tieneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipos")
    private Collection<Participa> participaCollection;
    @JoinColumn(name = "cod_confederacion", referencedColumnName = "cod_confederacion")
    @ManyToOne(optional = false)
    private Confederaciones codConfederacion;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @OneToOne(optional = false)
    private Paises codPais;
    @JoinColumn(name = "cod_tecnico", referencedColumnName = "cod_tecnico")
    @ManyToOne(optional = false)
    private Tecnicos codTecnico;

    public Equipos() {
    }

    public Equipos(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Equipos(String codEquipo, String nomEquipo) {
        this.codEquipo = codEquipo;
        this.nomEquipo = nomEquipo;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    @XmlTransient
    public Collection<Enfrenta> getEnfrentaCollection() {
        return enfrentaCollection;
    }

    public void setEnfrentaCollection(Collection<Enfrenta> enfrentaCollection) {
        this.enfrentaCollection = enfrentaCollection;
    }

    @XmlTransient
    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
    }

    @XmlTransient
    public Collection<Tiene> getTieneCollection() {
        return tieneCollection;
    }

    public void setTieneCollection(Collection<Tiene> tieneCollection) {
        this.tieneCollection = tieneCollection;
    }

    @XmlTransient
    public Collection<Participa> getParticipaCollection() {
        return participaCollection;
    }

    public void setParticipaCollection(Collection<Participa> participaCollection) {
        this.participaCollection = participaCollection;
    }

    public Confederaciones getCodConfederacion() {
        return codConfederacion;
    }

    public void setCodConfederacion(Confederaciones codConfederacion) {
        this.codConfederacion = codConfederacion;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    public Tecnicos getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(Tecnicos codTecnico) {
        this.codTecnico = codTecnico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEquipo != null ? codEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.codEquipo == null && other.codEquipo != null) || (this.codEquipo != null && !this.codEquipo.equals(other.codEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Equipos[ codEquipo=" + codEquipo + " ]";
    }
    
}
