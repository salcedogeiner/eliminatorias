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
@Table(name = "paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")
    , @NamedQuery(name = "Paises.findByCodPais", query = "SELECT p FROM Paises p WHERE p.codPais = :codPais")
    , @NamedQuery(name = "Paises.findByNomPais", query = "SELECT p FROM Paises p WHERE p.nomPais = :nomPais")
    , @NamedQuery(name = "Paises.findByNacionalidad", query = "SELECT p FROM Paises p WHERE p.nacionalidad = :nacionalidad")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "cod_pais")
    private String codPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_pais")
    private String nomPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPais")
    private Collection<Arbitros> arbitrosCollection;
    @OneToMany(mappedBy = "codPais")
    private Collection<Jugadores> jugadoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPais")
    private Collection<Tecnicos> tecnicosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPais")
    private Collection<Ciudades> ciudadesCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codPais")
    private Equipos equipos;

    public Paises() {
    }

    public Paises(String codPais) {
        this.codPais = codPais;
    }

    public Paises(String codPais, String nomPais, String nacionalidad) {
        this.codPais = codPais;
        this.nomPais = nomPais;
        this.nacionalidad = nacionalidad;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNomPais() {
        return nomPais;
    }

    public void setNomPais(String nomPais) {
        this.nomPais = nomPais;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @XmlTransient
    public Collection<Arbitros> getArbitrosCollection() {
        return arbitrosCollection;
    }

    public void setArbitrosCollection(Collection<Arbitros> arbitrosCollection) {
        this.arbitrosCollection = arbitrosCollection;
    }

    @XmlTransient
    public Collection<Jugadores> getJugadoresCollection() {
        return jugadoresCollection;
    }

    public void setJugadoresCollection(Collection<Jugadores> jugadoresCollection) {
        this.jugadoresCollection = jugadoresCollection;
    }

    @XmlTransient
    public Collection<Tecnicos> getTecnicosCollection() {
        return tecnicosCollection;
    }

    public void setTecnicosCollection(Collection<Tecnicos> tecnicosCollection) {
        this.tecnicosCollection = tecnicosCollection;
    }

    @XmlTransient
    public Collection<Ciudades> getCiudadesCollection() {
        return ciudadesCollection;
    }

    public void setCiudadesCollection(Collection<Ciudades> ciudadesCollection) {
        this.ciudadesCollection = ciudadesCollection;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Paises[ codPais=" + codPais + " ]";
    }
    
}
