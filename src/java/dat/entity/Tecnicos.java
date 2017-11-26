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
@Table(name = "tecnicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tecnicos.findAll", query = "SELECT t FROM Tecnicos t")
    , @NamedQuery(name = "Tecnicos.findByCodTecnico", query = "SELECT t FROM Tecnicos t WHERE t.codTecnico = :codTecnico")
    , @NamedQuery(name = "Tecnicos.findByNomTecnico", query = "SELECT t FROM Tecnicos t WHERE t.nomTecnico = :nomTecnico")
    , @NamedQuery(name = "Tecnicos.findByApeTecnico", query = "SELECT t FROM Tecnicos t WHERE t.apeTecnico = :apeTecnico")})
public class Tecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_tecnico")
    private Integer codTecnico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_tecnico")
    private String nomTecnico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ape_tecnico")
    private String apeTecnico;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private Paises codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTecnico")
    private Collection<Equipos> equiposCollection;

    public Tecnicos() {
    }

    public Tecnicos(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }

    public Tecnicos(Integer codTecnico, String nomTecnico, String apeTecnico) {
        this.codTecnico = codTecnico;
        this.nomTecnico = nomTecnico;
        this.apeTecnico = apeTecnico;
    }

    public Integer getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }

    public String getApeTecnico() {
        return apeTecnico;
    }

    public void setApeTecnico(String apeTecnico) {
        this.apeTecnico = apeTecnico;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTecnico != null ? codTecnico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tecnicos)) {
            return false;
        }
        Tecnicos other = (Tecnicos) object;
        if ((this.codTecnico == null && other.codTecnico != null) || (this.codTecnico != null && !this.codTecnico.equals(other.codTecnico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Tecnicos[ codTecnico=" + codTecnico + " ]";
    }
    
}
