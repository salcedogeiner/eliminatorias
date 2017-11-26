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
@Table(name = "ciudades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudades.findAll", query = "SELECT c FROM Ciudades c")
    , @NamedQuery(name = "Ciudades.findByCodCiudad", query = "SELECT c FROM Ciudades c WHERE c.codCiudad = :codCiudad")
    , @NamedQuery(name = "Ciudades.findByNomCiudad", query = "SELECT c FROM Ciudades c WHERE c.nomCiudad = :nomCiudad")})
public class Ciudades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_ciudad")
    private Integer codCiudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_ciudad")
    private String nomCiudad;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Paises codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCiudad")
    private Collection<Estadios> estadiosCollection;

    public Ciudades() {
    }

    public Ciudades(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public Ciudades(Integer codCiudad, String nomCiudad) {
        this.codCiudad = codCiudad;
        this.nomCiudad = nomCiudad;
    }

    public Integer getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public Collection<Estadios> getEstadiosCollection() {
        return estadiosCollection;
    }

    public void setEstadiosCollection(Collection<Estadios> estadiosCollection) {
        this.estadiosCollection = estadiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCiudad != null ? codCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudades)) {
            return false;
        }
        Ciudades other = (Ciudades) object;
        if ((this.codCiudad == null && other.codCiudad != null) || (this.codCiudad != null && !this.codCiudad.equals(other.codCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Ciudades[ codCiudad=" + codCiudad + " ]";
    }
    
}
