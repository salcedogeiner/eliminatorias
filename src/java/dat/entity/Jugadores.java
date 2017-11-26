/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "jugadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugadores.findAll", query = "SELECT j FROM Jugadores j")
    , @NamedQuery(name = "Jugadores.findByCodJugador", query = "SELECT j FROM Jugadores j WHERE j.jugadoresPK.codJugador = :codJugador")
    , @NamedQuery(name = "Jugadores.findByCodEquipo", query = "SELECT j FROM Jugadores j WHERE j.jugadoresPK.codEquipo = :codEquipo")
    , @NamedQuery(name = "Jugadores.findByNomJugador", query = "SELECT j FROM Jugadores j WHERE j.nomJugador = :nomJugador")
    , @NamedQuery(name = "Jugadores.findByApeJugador", query = "SELECT j FROM Jugadores j WHERE j.apeJugador = :apeJugador")
    , @NamedQuery(name = "Jugadores.findByFNac", query = "SELECT j FROM Jugadores j WHERE j.fNac = :fNac")
    , @NamedQuery(name = "Jugadores.findByPosicionJugador", query = "SELECT j FROM Jugadores j WHERE j.posicionJugador = :posicionJugador")})
public class Jugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected JugadoresPK jugadoresPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_jugador")
    private String nomJugador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ape_jugador")
    private String apeJugador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "f_nac")
    @Temporal(TemporalType.DATE)
    private Date fNac;
    @Size(max = 20)
    @Column(name = "posicion_jugador")
    private String posicionJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugadores")
    private Collection<Incide> incideCollection;
    @JoinColumn(name = "cod_equipo", referencedColumnName = "cod_equipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipos equipos;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Paises codPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jugadores")
    private Collection<Juega> juegaCollection;

    public Jugadores() {
    }

    public Jugadores(JugadoresPK jugadoresPK) {
        this.jugadoresPK = jugadoresPK;
    }

    public Jugadores(JugadoresPK jugadoresPK, String nomJugador, String apeJugador, Date fNac) {
        this.jugadoresPK = jugadoresPK;
        this.nomJugador = nomJugador;
        this.apeJugador = apeJugador;
        this.fNac = fNac;
    }

    public Jugadores(int codJugador, String codEquipo) {
        this.jugadoresPK = new JugadoresPK(codJugador, codEquipo);
    }

    public JugadoresPK getJugadoresPK() {
        return jugadoresPK;
    }

    public void setJugadoresPK(JugadoresPK jugadoresPK) {
        this.jugadoresPK = jugadoresPK;
    }

    public String getNomJugador() {
        return nomJugador;
    }

    public void setNomJugador(String nomJugador) {
        this.nomJugador = nomJugador;
    }

    public String getApeJugador() {
        return apeJugador;
    }

    public void setApeJugador(String apeJugador) {
        this.apeJugador = apeJugador;
    }

    public Date getFNac() {
        return fNac;
    }

    public void setFNac(Date fNac) {
        this.fNac = fNac;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    @XmlTransient
    public Collection<Incide> getIncideCollection() {
        return incideCollection;
    }

    public void setIncideCollection(Collection<Incide> incideCollection) {
        this.incideCollection = incideCollection;
    }

    public Equipos getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipos equipos) {
        this.equipos = equipos;
    }

    public Paises getCodPais() {
        return codPais;
    }

    public void setCodPais(Paises codPais) {
        this.codPais = codPais;
    }

    @XmlTransient
    public Collection<Juega> getJuegaCollection() {
        return juegaCollection;
    }

    public void setJuegaCollection(Collection<Juega> juegaCollection) {
        this.juegaCollection = juegaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jugadoresPK != null ? jugadoresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugadores)) {
            return false;
        }
        Jugadores other = (Jugadores) object;
        if ((this.jugadoresPK == null && other.jugadoresPK != null) || (this.jugadoresPK != null && !this.jugadoresPK.equals(other.jugadoresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dat.entity.Jugadores[ jugadoresPK=" + jugadoresPK + " ]";
    }
    
}
