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
@Table(name = "v_info_equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoEquipos.findAll", query = "SELECT v FROM VInfoEquipos v")
    , @NamedQuery(name = "VInfoEquipos.findByCodEquipo", query = "SELECT v FROM VInfoEquipos v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VInfoEquipos.findByNomEquipo", query = "SELECT v FROM VInfoEquipos v WHERE v.nomEquipo = :nomEquipo")
    , @NamedQuery(name = "VInfoEquipos.findByPuntaje", query = "SELECT v FROM VInfoEquipos v WHERE v.puntaje = :puntaje")
    , @NamedQuery(name = "VInfoEquipos.findByClasifica", query = "SELECT v FROM VInfoEquipos v WHERE v.clasifica = :clasifica")
    , @NamedQuery(name = "VInfoEquipos.findBySedeOficial", query = "SELECT v FROM VInfoEquipos v WHERE v.sedeOficial = :sedeOficial")
    , @NamedQuery(name = "VInfoEquipos.findByParticipaciones", query = "SELECT v FROM VInfoEquipos v WHERE v.participaciones = :participaciones")
    , @NamedQuery(name = "VInfoEquipos.findByTitulos", query = "SELECT v FROM VInfoEquipos v WHERE v.titulos = :titulos")
    , @NamedQuery(name = "VInfoEquipos.findByGoles", query = "SELECT v FROM VInfoEquipos v WHERE v.goles = :goles")
    , @NamedQuery(name = "VInfoEquipos.findByGolesContra", query = "SELECT v FROM VInfoEquipos v WHERE v.golesContra = :golesContra")
    , @NamedQuery(name = "VInfoEquipos.findByDiferenciaGoles", query = "SELECT v FROM VInfoEquipos v WHERE v.diferenciaGoles = :diferenciaGoles")})
public class VInfoEquipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Size(max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @Column(name = "puntaje")
    private BigInteger puntaje;
    @Size(max = 2147483647)
    @Column(name = "clasifica")
    private String clasifica;
    @Size(max = 2147483647)
    @Column(name = "sede_oficial")
    private String sedeOficial;
    @Column(name = "participaciones")
    private BigInteger participaciones;
    @Column(name = "titulos")
    private BigInteger titulos;
    @Column(name = "goles")
    private Integer goles;
    @Column(name = "goles_contra")
    private Integer golesContra;
    @Column(name = "diferencia_goles")
    private Integer diferenciaGoles;

    public VInfoEquipos() {
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

    public BigInteger getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(BigInteger puntaje) {
        this.puntaje = puntaje;
    }

    public String getClasifica() {
        return clasifica;
    }

    public void setClasifica(String clasifica) {
        this.clasifica = clasifica;
    }

    public String getSedeOficial() {
        return sedeOficial;
    }

    public void setSedeOficial(String sedeOficial) {
        this.sedeOficial = sedeOficial;
    }

    public BigInteger getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(BigInteger participaciones) {
        this.participaciones = participaciones;
    }

    public BigInteger getTitulos() {
        return titulos;
    }

    public void setTitulos(BigInteger titulos) {
        this.titulos = titulos;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(Integer golesContra) {
        this.golesContra = golesContra;
    }

    public Integer getDiferenciaGoles() {
        return diferenciaGoles;
    }

    public void setDiferenciaGoles(Integer diferenciaGoles) {
        this.diferenciaGoles = diferenciaGoles;
    }
    
}
