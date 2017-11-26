/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Salcedo
 */
@Entity
@Table(name = "v_info_equipos_goles_puntos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoEquiposGolesPuntos.findAll", query = "SELECT v FROM VInfoEquiposGolesPuntos v")
    , @NamedQuery(name = "VInfoEquiposGolesPuntos.findByCodEquipo", query = "SELECT v FROM VInfoEquiposGolesPuntos v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VInfoEquiposGolesPuntos.findByNomEquipo", query = "SELECT v FROM VInfoEquiposGolesPuntos v WHERE v.nomEquipo = :nomEquipo")
    , @NamedQuery(name = "VInfoEquiposGolesPuntos.findByPuntos", query = "SELECT v FROM VInfoEquiposGolesPuntos v WHERE v.puntos = :puntos")
    , @NamedQuery(name = "VInfoEquiposGolesPuntos.findByDg", query = "SELECT v FROM VInfoEquiposGolesPuntos v WHERE v.dg = :dg")
    , @NamedQuery(name = "VInfoEquiposGolesPuntos.findByGf", query = "SELECT v FROM VInfoEquiposGolesPuntos v WHERE v.gf = :gf")
    , @NamedQuery(name = "VInfoEquiposGolesPuntos.findByGc", query = "SELECT v FROM VInfoEquiposGolesPuntos v WHERE v.gc = :gc")})
public class VInfoEquiposGolesPuntos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Size(max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @Column(name = "puntos")
    private BigInteger puntos;
    @Column(name = "dg")
    private Integer dg;
    @Column(name = "gf")
    private Integer gf;
    @Column(name = "gc")
    private Integer gc;

    public VInfoEquiposGolesPuntos() {
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public String getNomEquipo() {
        return nomEquipo;
    }

    public void setNomEquipo(String nomEquipo) {
        this.nomEquipo = nomEquipo;
    }

    public BigInteger getPuntos() {
        return puntos;
    }

    public void setPuntos(BigInteger puntos) {
        this.puntos = puntos;
    }

    public Integer getDg() {
        return dg;
    }

    public void setDg(Integer dg) {
        this.dg = dg;
    }

    public Integer getGf() {
        return gf;
    }

    public void setGf(Integer gf) {
        this.gf = gf;
    }

    public Integer getGc() {
        return gc;
    }

    public void setGc(Integer gc) {
        this.gc = gc;
    }
    
}
