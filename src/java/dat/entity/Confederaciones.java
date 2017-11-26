/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "confederaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Confederaciones.findAll", query = "SELECT c FROM Confederaciones c")
    , @NamedQuery(name = "Confederaciones.findByCodConfederacion", query = "SELECT c FROM Confederaciones c WHERE c.codConfederacion = :codConfederacion")
    , @NamedQuery(name = "Confederaciones.findByNomConfederacion", query = "SELECT c FROM Confederaciones c WHERE c.nomConfederacion = :nomConfederacion")
    , @NamedQuery(name = "Confederaciones.findByAbrConfederacion", query = "SELECT c FROM Confederaciones c WHERE c.abrConfederacion = :abrConfederacion")
    , @NamedQuery(name = "Confederaciones.findByCupos", query = "SELECT c FROM Confederaciones c WHERE c.cupos = :cupos")})
public class Confederaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_confederacion")
    private Integer codConfederacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_confederacion")
    private String nomConfederacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "abr_confederacion")
    private String abrConfederacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupos")
    private BigDecimal cupos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codConfederacion")
    private Collection<Equipos> equiposCollection;

    public Confederaciones() {
    }

    public Confederaciones(Integer codConfederacion) {
        this.codConfederacion = codConfederacion;
    }

    public Confederaciones(Integer codConfederacion, String nomConfederacion, String abrConfederacion, BigDecimal cupos) {
        this.codConfederacion = codConfederacion;
        this.nomConfederacion = nomConfederacion;
        this.abrConfederacion = abrConfederacion;
        this.cupos = cupos;
    }

    public Integer getCodConfederacion() {
        return codConfederacion;
    }

    public void setCodConfederacion(Integer codConfederacion) {
        this.codConfederacion = codConfederacion;
    }

    public String getNomConfederacion() {
        return nomConfederacion;
    }

    public void setNomConfederacion(String nomConfederacion) {
        this.nomConfederacion = nomConfederacion;
    }

    public String getAbrConfederacion() {
        return abrConfederacion;
    }

    public void setAbrConfederacion(String abrConfederacion) {
        this.abrConfederacion = abrConfederacion;
    }

    public BigDecimal getCupos() {
        return cupos;
    }

    public void setCupos(BigDecimal cupos) {
        this.cupos = cupos;
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
        hash += (codConfederacion != null ? codConfederacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Confederaciones)) {
            return false;
        }
        Confederaciones other = (Confederaciones) object;
        if ((this.codConfederacion == null && other.codConfederacion != null) || (this.codConfederacion != null && !this.codConfederacion.equals(other.codConfederacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Confederaciones[ codConfederacion=" + codConfederacion + " ]";
    }
    
}
