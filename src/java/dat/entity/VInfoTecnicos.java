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
@Table(name = "v_info_tecnicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInfoTecnicos.findAll", query = "SELECT v FROM VInfoTecnicos v")
    , @NamedQuery(name = "VInfoTecnicos.findByCodEquipo", query = "SELECT v FROM VInfoTecnicos v WHERE v.codEquipo = :codEquipo")
    , @NamedQuery(name = "VInfoTecnicos.findByNomEquipo", query = "SELECT v FROM VInfoTecnicos v WHERE v.nomEquipo = :nomEquipo")
    , @NamedQuery(name = "VInfoTecnicos.findByCodTecnico", query = "SELECT v FROM VInfoTecnicos v WHERE v.codTecnico = :codTecnico")
    , @NamedQuery(name = "VInfoTecnicos.findByNomTecnico", query = "SELECT v FROM VInfoTecnicos v WHERE v.nomTecnico = :nomTecnico")
    , @NamedQuery(name = "VInfoTecnicos.findByApeTecnico", query = "SELECT v FROM VInfoTecnicos v WHERE v.apeTecnico = :apeTecnico")
    , @NamedQuery(name = "VInfoTecnicos.findByCodPais", query = "SELECT v FROM VInfoTecnicos v WHERE v.codPais = :codPais")})
public class VInfoTecnicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 3)
    @Column(name = "cod_equipo")
    private String codEquipo;
    @Size(max = 30)
    @Column(name = "nom_equipo")
    private String nomEquipo;
    @Column(name = "cod_tecnico")
    private Integer codTecnico;
    @Size(max = 30)
    @Column(name = "nom_tecnico")
    private String nomTecnico;
    @Size(max = 30)
    @Column(name = "ape_tecnico")
    private String apeTecnico;
    @Size(max = 3)
    @Column(name = "cod_pais")
    private String codPais;

    public VInfoTecnicos() {
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

    public Integer getCodTecnico() {
        return codTecnico;
    }

    public void setCodTecnico(Integer codTecnico) {
        this.codTecnico = codTecnico;
    }

    public String getNomTecnico() {
        return nomTecnico;
    }

    public void setNomTecnico(String nomTecnico) {
        this.nomTecnico = nomTecnico;
    }

    public String getApeTecnico() {
        return apeTecnico;
    }

    public void setApeTecnico(String apeTecnico) {
        this.apeTecnico = apeTecnico;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }
    
}
