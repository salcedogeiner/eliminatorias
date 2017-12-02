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
@Table(name = "v_goles_equipo_enfrenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VGolesEquipoEnfrenta.findAll", query = "SELECT v FROM VGolesEquipoEnfrenta v")
    , @NamedQuery(name = "VGolesEquipoEnfrenta.findByCodEquipo", query = "SELECT v FROM VGolesEquipoEnfrenta v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VGolesEquipoEnfrenta.findByCodEstadio", query = "SELECT v FROM VGolesEquipoEnfrenta v WHERE v.codEstadio = :codEstadio")
    , @NamedQuery(name = "VGolesEquipoEnfrenta.findByCodEquipoLocal", query = "SELECT v FROM VGolesEquipoEnfrenta v WHERE v.codEquipoLocal = :codEquipoLocal")
    , @NamedQuery(name = "VGolesEquipoEnfrenta.findByCodEquipoVisitante", query = "SELECT v FROM VGolesEquipoEnfrenta v WHERE v.codEquipoVisitante = :codEquipoVisitante")
    , @NamedQuery(name = "VGolesEquipoEnfrenta.findByFEnfrenta", query = "SELECT v FROM VGolesEquipoEnfrenta v WHERE v.fEnfrenta = :fEnfrenta")
    , @NamedQuery(name = "VGolesEquipoEnfrenta.findByGoles", query = "SELECT v FROM VGolesEquipoEnfrenta v WHERE v.goles = :goles")})
public class VGolesEquipoEnfrenta implements Serializable {

    @Column(name = "autogoles")
    private BigInteger autogoles;
    @Column(name = "golw")
    private BigInteger golw;

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Column(name = "cod_estadio")
    private Integer codEstadio;
    @Size(max = 3)
    @Column(name = "cod_equipo_local")
    private String codEquipoLocal;
    @Size(max = 3)
    @Column(name = "cod_equipo_visitante")
    private String codEquipoVisitante;
    @Column(name = "f_enfrenta")
    @Temporal(TemporalType.DATE)
    private Date fEnfrenta;
    @Column(name = "goles")
    private BigInteger goles;

    public VGolesEquipoEnfrenta() {
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public Integer getCodEstadio() {
        return codEstadio;
    }

    public void setCodEstadio(Integer codEstadio) {
        this.codEstadio = codEstadio;
    }

    public String getCodEquipoLocal() {
        return codEquipoLocal;
    }

    public void setCodEquipoLocal(String codEquipoLocal) {
        this.codEquipoLocal = codEquipoLocal;
    }

    public String getCodEquipoVisitante() {
        return codEquipoVisitante;
    }

    public void setCodEquipoVisitante(String codEquipoVisitante) {
        this.codEquipoVisitante = codEquipoVisitante;
    }

    public Date getFEnfrenta() {
        return fEnfrenta;
    }

    public void setFEnfrenta(Date fEnfrenta) {
        this.fEnfrenta = fEnfrenta;
    }

    public BigInteger getGoles() {
        return goles;
    }

    public void setGoles(BigInteger goles) {
        this.goles = goles;
    }

    public BigInteger getAutogoles() {
        return autogoles;
    }

    public void setAutogoles(BigInteger autogoles) {
        this.autogoles = autogoles;
    }

    public BigInteger getGolw() {
        return golw;
    }

    public void setGolw(BigInteger golw) {
        this.golw = golw;
    }
    
}
