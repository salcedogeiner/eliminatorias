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
@Table(name = "v_posiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoPosiciones.findAll", query = "SELECT v FROM VInfoPosiciones v")
    , @NamedQuery(name = "VInfoPosiciones.findByPosicion", query = "SELECT v FROM VInfoPosiciones v WHERE v.posicion = :posicion")
    , @NamedQuery(name = "VInfoPosiciones.findByCodEquipo", query = "SELECT v FROM VInfoPosiciones v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VInfoPosiciones.findByNomEquipo", query = "SELECT v FROM VInfoPosiciones v WHERE v.nomEquipo = :nomEquipo")
    , @NamedQuery(name = "VInfoPosiciones.findByCodConfederacion", query = "SELECT v FROM VInfoPosiciones v WHERE v.codConfederacion = :codConfederacion")
    , @NamedQuery(name = "VInfoPosiciones.findByNomConfederacion", query = "SELECT v FROM VInfoPosiciones v WHERE v.nomConfederacion = :nomConfederacion")
    , @NamedQuery(name = "VInfoPosiciones.findByCodPais", query = "SELECT v FROM VInfoPosiciones v WHERE v.codPais = :codPais")})
public class VInfoPosiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "posicion")
    private BigInteger posicion;
    @Size(max = 3)
    @Id
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Size(max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @Column(name = "cod_confederacion")
    private Integer codConfederacion;
    @Size(max = 50)
    @Column(name = "nom_confederacion")
    private String nomConfederacion;
    @Size(max = 3)
    @Column(name = "cod_pais")
    private String codPais;

    public VInfoPosiciones() {
    }

    public BigInteger getPosicion() {
        return posicion;
    }

    public void setPosicion(BigInteger posicion) {
        this.posicion = posicion;
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

    public String getNomConfederacion() {
        return nomConfederacion;
    }

    public void setNomConfederacion(String nomConfederacion) {
        this.nomConfederacion = nomConfederacion;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }
    
}
