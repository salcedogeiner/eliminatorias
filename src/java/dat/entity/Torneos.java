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
@Table(name = "torneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneos.findAll", query = "SELECT t FROM Torneos t")
    , @NamedQuery(name = "Torneos.findByIdTorneo", query = "SELECT t FROM Torneos t WHERE t.idTorneo = :idTorneo")
    , @NamedQuery(name = "Torneos.findByNomTorneo", query = "SELECT t FROM Torneos t WHERE t.nomTorneo = :nomTorneo")
    , @NamedQuery(name = "Torneos.findByTipoTorneo", query = "SELECT t FROM Torneos t WHERE t.tipoTorneo = :tipoTorneo")
    , @NamedQuery(name = "Torneos.findByAnio", query = "SELECT t FROM Torneos t WHERE t.anio = :anio")})
public class Torneos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_torneo")
    private Integer idTorneo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_torneo")
    private String nomTorneo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipo_torneo")
    private String tipoTorneo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio")
    private short anio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torneos")
    private Collection<Juega> juegaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torneos")
    private Collection<Participa> participaCollection;

    public Torneos() {
    }

    public Torneos(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Torneos(Integer idTorneo, String nomTorneo, String tipoTorneo, short anio) {
        this.idTorneo = idTorneo;
        this.nomTorneo = nomTorneo;
        this.tipoTorneo = tipoTorneo;
        this.anio = anio;
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNomTorneo() {
        return nomTorneo;
    }

    public void setNomTorneo(String nomTorneo) {
        this.nomTorneo = nomTorneo;
    }

    public String getTipoTorneo() {
        return tipoTorneo;
    }

    public void setTipoTorneo(String tipoTorneo) {
        this.tipoTorneo = tipoTorneo;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    @XmlTransient
    public Collection<Juega> getJuegaCollection() {
        return juegaCollection;
    }

    public void setJuegaCollection(Collection<Juega> juegaCollection) {
        this.juegaCollection = juegaCollection;
    }

    @XmlTransient
    public Collection<Participa> getParticipaCollection() {
        return participaCollection;
    }

    public void setParticipaCollection(Collection<Participa> participaCollection) {
        this.participaCollection = participaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTorneo != null ? idTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneos)) {
            return false;
        }
        Torneos other = (Torneos) object;
        if ((this.idTorneo == null && other.idTorneo != null) || (this.idTorneo != null && !this.idTorneo.equals(other.idTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "idTorneo=" + idTorneo + " nom_torneo="+nomTorneo;
    }
    
}
