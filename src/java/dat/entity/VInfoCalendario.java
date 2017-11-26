/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "v_info_calendario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoCalendario.findAll", query = "SELECT v FROM VInfoCalendario v")
    , @NamedQuery(name = "VInfoCalendario.findByFEnfrenta", query = "SELECT v FROM VInfoCalendario v WHERE v.fEnfrenta = :fEnfrenta")
    , @NamedQuery(name = "VInfoCalendario.findByNomEquipoLocal", query = "SELECT v FROM VInfoCalendario v WHERE v.nomEquipoLocal = :nomEquipoLocal")
    , @NamedQuery(name = "VInfoCalendario.findByNomEquipoVisitante", query = "SELECT v FROM VInfoCalendario v WHERE v.nomEquipoVisitante = :nomEquipoVisitante")
    , @NamedQuery(name = "VInfoCalendario.findByNomEstadio", query = "SELECT v FROM VInfoCalendario v WHERE v.nomEstadio = :nomEstadio")
    , @NamedQuery(name = "VInfoCalendario.findByGolesLocal", query = "SELECT v FROM VInfoCalendario v WHERE v.golesLocal = :golesLocal")
    , @NamedQuery(name = "VInfoCalendario.findByGolesVisitante", query = "SELECT v FROM VInfoCalendario v WHERE v.golesVisitante = :golesVisitante")
    , @NamedQuery(name = "VInfoCalendario.findByNomArbitro", query = "SELECT v FROM VInfoCalendario v WHERE v.nomArbitro = :nomArbitro")
    , @NamedQuery(name = "VInfoCalendario.findByApeArbitro", query = "SELECT v FROM VInfoCalendario v WHERE v.apeArbitro = :apeArbitro")
    , @NamedQuery(name = "VInfoCalendario.findByNacionalidadArbitro", query = "SELECT v FROM VInfoCalendario v WHERE v.nacionalidadArbitro = :nacionalidadArbitro")
    , @NamedQuery(name = "VInfoCalendario.findByNomCiudad", query = "SELECT v FROM VInfoCalendario v WHERE v.nomCiudad = :nomCiudad")})
public class VInfoCalendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "f_enfrenta")
    @Temporal(TemporalType.DATE)
    private Date fEnfrenta;
    @Id
    @Size(max = 30)
    @Column(name = "nom_equipo_local")
    private String nomEquipoLocal;
    @Size(max = 30)
    @Column(name = "nom_equipo_visitante")
    private String nomEquipoVisitante;
    @Size(max = 50)
    @Column(name = "nom_estadio")
    private String nomEstadio;
    @Column(name = "goles_local")
    private BigInteger golesLocal;
    @Column(name = "goles_visitante")
    private BigInteger golesVisitante;
    @Size(max = 20)
    @Column(name = "nom_arbitro")
    private String nomArbitro;
    @Size(max = 30)
    @Column(name = "ape_arbitro")
    private String apeArbitro;
    @Size(max = 20)
    @Column(name = "nacionalidad_arbitro")
    private String nacionalidadArbitro;
    @Size(max = 20)
    @Column(name = "nom_ciudad")
    private String nomCiudad;

    public VInfoCalendario() {
    }

    public Date getFEnfrenta() {
        return fEnfrenta;
    }

    public void setFEnfrenta(Date fEnfrenta) {
        this.fEnfrenta = fEnfrenta;
    }

    public String getNomEquipoLocal() {
        return nomEquipoLocal;
    }

    public void setNomEquipoLocal(String nomEquipoLocal) {
        this.nomEquipoLocal = nomEquipoLocal;
    }

    public String getNomEquipoVisitante() {
        return nomEquipoVisitante;
    }

    public void setNomEquipoVisitante(String nomEquipoVisitante) {
        this.nomEquipoVisitante = nomEquipoVisitante;
    }

    public String getNomEstadio() {
        return nomEstadio;
    }

    public void setNomEstadio(String nomEstadio) {
        this.nomEstadio = nomEstadio;
    }

    public BigInteger getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(BigInteger golesLocal) {
        this.golesLocal = golesLocal;
    }

    public BigInteger getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(BigInteger golesVisitante) {
        this.golesVisitante = golesVisitante;
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

    public String getNacionalidadArbitro() {
        return nacionalidadArbitro;
    }

    public void setNacionalidadArbitro(String nacionalidadArbitro) {
        this.nacionalidadArbitro = nacionalidadArbitro;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }
    
}
