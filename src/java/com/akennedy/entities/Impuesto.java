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
 * @author Alejandro Kennedy <alekennedypy at gmail.com>
 */
@Entity
@Table(name="impuesto", schema = "maestros")
@XmlRootElement
public class Impuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="imp_id")
    private Long imp_id;
    
    @Column(name="imp_descripcion")
    private String imp_descripcion;
    
    @Column(name="imp_valor")
    private float imp_valor;

    public Impuesto() {
    }

    public Impuesto(Long imp_id, String imp_descripcion, float imp_valor) {
        this.imp_id = imp_id;
        this.imp_descripcion = imp_descripcion;
        this.imp_valor = imp_valor;
    }

    public Long getImp_id() {
        return imp_id;
    }

    public void setImp_id(Long imp_id) {
        this.imp_id = imp_id;
    }

    public String getImp_descripcion() {
        return imp_descripcion;
    }

    public void setImp_descripcion(String imp_descripcion) {
        this.imp_descripcion = imp_descripcion;
    }

    public float getImp_valor() {
        return imp_valor;
    }

    public void setImp_valor(float imp_valor) {
        this.imp_valor = imp_valor;
    }    
}
