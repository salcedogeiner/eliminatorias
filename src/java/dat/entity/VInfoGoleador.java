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
@Table(name = "v_info_goleador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoGoleador.findAll", query = "SELECT v FROM VInfoGoleador v")
    , @NamedQuery(name = "VInfoGoleador.findByCodJugador", query = "SELECT v FROM VInfoGoleador v WHERE v.codJugador = :codJugador")
    , @NamedQuery(name = "VInfoGoleador.findByNomJugador", query = "SELECT v FROM VInfoGoleador v WHERE v.nomJugador = :nomJugador")
    , @NamedQuery(name = "VInfoGoleador.findByApeJugador", query = "SELECT v FROM VInfoGoleador v WHERE v.apeJugador = :apeJugador")
    , @NamedQuery(name = "VInfoGoleador.findByGoles", query = "SELECT v FROM VInfoGoleador v WHERE v.goles = :goles")
    , @NamedQuery(name = "VInfoGoleador.findByCodEquipo", query = "SELECT v FROM VInfoGoleador v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VInfoGoleador.findByNomEquipo", query = "SELECT v FROM VInfoGoleador v WHERE v.nomEquipo = :nomEquipo")
    , @NamedQuery(name = "VInfoGoleador.findByEdadAnios", query = "SELECT v FROM VInfoGoleador v WHERE v.edadAnios = :edadAnios")
    , @NamedQuery(name = "VInfoGoleador.findByPosicion", query = "SELECT v FROM VInfoGoleador v WHERE v.posicion = :posicion")})
public class VInfoGoleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_jugador")
    private Integer codJugador;
    @Size(max = 30)
    @Column(name = "nom_jugador")
    private String nomJugador;
    @Size(max = 30)
    @Column(name = "ape_jugador")
    private String apeJugador;
    @Column(name = "goles")
    private Integer goles;
    @Size(max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Size(max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @Column(name = "edad_anios")
    private BigInteger edadAnios;
    @Size(max = 20)
    @Column(name = "posicion")
    private String posicion;

    public VInfoGoleador() {
    }

    public Integer getCodJugador() {
        return codJugador;
    }

    public void setCodJugador(Integer codJugador) {
        this.codJugador = codJugador;
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

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
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

    public BigInteger getEdadAnios() {
        return edadAnios;
    }

    public void setEdadAnios(BigInteger edadAnios) {
        this.edadAnios = edadAnios;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
}
