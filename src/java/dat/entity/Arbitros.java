/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "arbitros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arbitros.findAll", query = "SELECT a FROM Arbitros a")
    , @NamedQuery(name = "Arbitros.findByCodArbitro", query = "SELECT a FROM Arbitros a WHERE a.codArbitro = :codArbitro")
    , @NamedQuery(name = "Arbitros.findByNomArbitro", query = "SELECT a FROM Arbitros a WHERE a.nomArbitro = :nomArbitro")
    , @NamedQuery(name = "Arbitros.findByApeArbitro", query = "SELECT a FROM Arbitros a WHERE a.apeArbitro = :apeArbitro")})
public class Arbitros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_arbitro")
    private Integer codArbitro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_arbitro")
    private String nomArbitro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ape_arbitro")
    private String apeArbitro;
    @JoinTable(name = "regula", joinColumns = {
        @JoinColumn(name = "cod_arbitro", referencedColumnName = "cod_arbitro")}, inverseJoinColumns = {
        @JoinColumn(name = "cod_estadio", referencedColumnName = "cod_estadio")
        , @JoinColumn(name = "cod_equipo_local", referencedColumnName = "cod_equipo_local")
        , @JoinColumn(name = "cod_equipo_visitante", referencedColumnName = "cod_equipo_visitante")
        , @JoinColumn(name = "f_enfrenta", referencedColumnName = "f_enfrenta")})
    @ManyToMany
    private Collection<Enfrenta> enfrentaCollection;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Paises codPais;

    public Arbitros() {
    }

    public Arbitros(Integer codArbitro) {
        this.codArbitro = codArbitro;
    }

    public Arbitros(Integer codArbitro, String nomArbitro, String apeArbitro) {
        this.codArbitro = codArbitro;
        this.nomArbitro = nomArbitro;
        this.apeArbitro = apeArbitro;
    }

    public Integer getCodArbitro() {
        return codArbitro;
    }

    public void setCodArbitro(Integer codArbitro) {
        this.codArbitro = codArbitro;
    }

    public String getNomArbitro() {
        return nomArbitro;
    }

    public void setNomArbitro(String nomArbitro) {
        this.nomArbitro = nomArbitro;
    }

    public String getApeArbitro() {
        return apeArbitro;
    }

    public void setApeArbitro(String apeArbitro) {
        this.apeArbitro = apeArbitro;
    }

    @XmlTransient
    public Collection<Enfrenta> getEnfrentaCollection() {
        return enfrentaCollection;
    }

    public void setEnfrentaCollection(Collection<Enfrenta> enfrentaCollection) {
        this.enfrentaCollection = enfrentaCollection;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArbitro != null ? codArbitro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbitros)) {
            return false;
        }
        Arbitros other = (Arbitros) object;
        if ((this.codArbitro == null && other.codArbitro != null) || (this.codArbitro != null && !this.codArbitro.equals(other.codArbitro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Arbitros[ codArbitro=" + codArbitro + " ]";
    }
    
}
