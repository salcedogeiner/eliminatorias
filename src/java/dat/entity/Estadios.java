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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "estadios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadios.findAll", query = "SELECT e FROM Estadios e")
    , @NamedQuery(name = "Estadios.findByCodEstadio", query = "SELECT e FROM Estadios e WHERE e.codEstadio = :codEstadio")
    , @NamedQuery(name = "Estadios.findByNomEstadio", query = "SELECT e FROM Estadios e WHERE e.nomEstadio = :nomEstadio")})
public class Estadios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_estadio")
    private Integer codEstadio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_estadio")
    private String nomEstadio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadios")
    private Collection<Tiene> tieneCollection;
    @JoinColumn(name = "cod_ciudad", referencedColumnName = "cod_ciudad")
    @ManyToOne(optional = false)
    private Ciudades codCiudad;

    public Estadios() {
    }

    public Estadios(Integer codEstadio) {
        this.codEstadio = codEstadio;
    }

    public Estadios(Integer codEstadio, String nomEstadio) {
        this.codEstadio = codEstadio;
        this.nomEstadio = nomEstadio;
    }

    public Integer getCodEstadio() {
        return codEstadio;
    }

    public void setCodEstadio(Integer codEstadio) {
        this.codEstadio = codEstadio;
    }

    public String getNomEstadio() {
        return nomEstadio;
    }

    public void setNomEstadio(String nomEstadio) {
        this.nomEstadio = nomEstadio;
    }

    @XmlTransient
    public Collection<Tiene> getTieneCollection() {
        return tieneCollection;
    }

    public void setTieneCollection(Collection<Tiene> tieneCollection) {
        this.tieneCollection = tieneCollection;
    }

    public Ciudades getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Ciudades codCiudad) {
        this.codCiudad = codCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstadio != null ? codEstadio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadios)) {
            return false;
        }
        Estadios other = (Estadios) object;
        if ((this.codEstadio == null && other.codEstadio != null) || (this.codEstadio != null && !this.codEstadio.equals(other.codEstadio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Estadios[ codEstadio=" + codEstadio + " ]";
    }
    
}
