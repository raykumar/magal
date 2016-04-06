/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.akennedy.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Alejandro Kennedy <alekennedy at gmail.com>
 */
@Entity
@Table(name="ciudad", schema = "maestros")
@XmlRootElement
public class Ciudad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ciu_id")
    private Long ciu_id;
    
    @Column(name="ciu_nombre")
    private String ciu_nombre;
    
    @Column(name="activo")
    private Boolean activo;

    public Ciudad() {
    }

    public Ciudad(Long ciu_id, String ciu_nombre) {
        this.ciu_id = ciu_id;
        this.ciu_nombre = ciu_nombre;
    }

    public Long getCiu_id() {
        return ciu_id;
    }

    public void setCiu_id(Long ciu_id) {
        this.ciu_id = ciu_id;
    }

    public String getCiu_nombre() {
        return ciu_nombre;
    }

    public void setCiu_nombre(String ciu_nombre) {
        this.ciu_nombre = ciu_nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
           
    public boolean validarCiudad(){
        if(this.getCiu_nombre().isEmpty()){
            return false;
        }
        return true;
    }

    
}
