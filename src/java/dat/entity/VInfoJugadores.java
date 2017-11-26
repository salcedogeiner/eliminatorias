/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.entity;

import java.io.Serializable;
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
@Table(name = "v_info_jugadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoJugadores.findAll", query = "SELECT v FROM VInfoJugadores v")
    , @NamedQuery(name = "VInfoJugadores.findByCodEquipo", query = "SELECT v FROM VInfoJugadores v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VInfoJugadores.findByNomEquipo", query = "SELECT v FROM VInfoJugadores v WHERE v.nomEquipo = :nomEquipo")
    , @NamedQuery(name = "VInfoJugadores.findByCodConfederacion", query = "SELECT v FROM VInfoJugadores v WHERE v.codConfederacion = :codConfederacion")
    , @NamedQuery(name = "VInfoJugadores.findByCodJugador", query = "SELECT v FROM VInfoJugadores v WHERE v.codJugador = :codJugador")
    , @NamedQuery(name = "VInfoJugadores.findByNomJugador", query = "SELECT v FROM VInfoJugadores v WHERE v.nomJugador = :nomJugador")
    , @NamedQuery(name = "VInfoJugadores.findByApeJugador", query = "SELECT v FROM VInfoJugadores v WHERE v.apeJugador = :apeJugador")
    , @NamedQuery(name = "VInfoJugadores.findByGoles", query = "SELECT v FROM VInfoJugadores v WHERE v.goles = :goles")
    , @NamedQuery(name = "VInfoJugadores.findByAmarillas", query = "SELECT v FROM VInfoJugadores v WHERE v.amarillas = :amarillas")
    , @NamedQuery(name = "VInfoJugadores.findByRojas", query = "SELECT v FROM VInfoJugadores v WHERE v.rojas = :rojas")
    , @NamedQuery(name = "VInfoJugadores.findByPartidos", query = "SELECT v FROM VInfoJugadores v WHERE v.partidos = :partidos")})
public class VInfoJugadores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Size(max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @Column(name = "cod_confederacion")
    private Integer codConfederacion;
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
    @Column(name = "amarillas")
    private Integer amarillas;
    @Column(name = "rojas")
    private Integer rojas;
    @Column(name = "partidos")
    private Integer partidos;

    public VInfoJugadores() {
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

    public Integer getCodConfederacion() {
        return codConfederacion;
    }

    public void setCodConfederacion(Integer codConfederacion) {
        this.codConfederacion = codConfederacion;
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

    public Integer getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(Integer amarillas) {
        this.amarillas = amarillas;
    }

    public Integer getRojas() {
        return rojas;
    }

    public void setRojas(Integer rojas) {
        this.rojas = rojas;
    }

    public Integer getPartidos() {
        return partidos;
    }

    public void setPartidos(Integer partidos) {
        this.partidos = partidos;
    }
    
}
