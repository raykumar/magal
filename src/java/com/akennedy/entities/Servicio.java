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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name="servicio", schema = "maestros")
@XmlRootElement
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="serv_id")
    private Long serv_id;
    
    @Column(name="serv_cod")
    private String serv_cod;
    
    @Column(name="serv_nombre")
    private String serv_nombre;
    
    @Column(name="serv_impuesto")
    private Impuesto serv_impuesto;
    
    @Column(name="serv_precio_1")
    private Double serv_precio_1;
    
    @Column(name="serv_precio_2")
    private Double serv_precio_2;
    
    @Column(name="serv_precio_3")
    private Double serv_precio_3;
    
    @Column(name="serv_precio_4")
    private Double serv_precio_4;
    

    public Servicio() {
    }

    public Servicio(Long serv_id, String serv_cod, String serv_nombre, Impuesto serv_impuesto, Double serv_precio_1, Double serv_precio_2, Double serv_precio_3, Double serv_precio_4) {
        this.serv_id = serv_id;
        this.serv_cod = serv_cod;
        this.serv_nombre = serv_nombre;
        this.serv_impuesto = serv_impuesto;
        this.serv_precio_1 = serv_precio_1;
        this.serv_precio_2 = serv_precio_2;
        this.serv_precio_3 = serv_precio_3;
        this.serv_precio_4 = serv_precio_4;
    }


    public Long getServ_id() {
        return serv_id;
    }

    public void setServ_id(Long serv_id) {
        this.serv_id = serv_id;
    }

    public String getServ_cod() {
        return serv_cod;
    }

    public void setServ_cod(String serv_cod) {
        this.serv_cod = serv_cod;
    }

    public String getServ_nombre() {
        return serv_nombre;
    }

    public void setServ_nombre(String serv_nombre) {
        this.serv_nombre = serv_nombre;
    }

    public Impuesto getServ_impuesto() {
        return serv_impuesto;
    }

    public void setServ_impuesto(Impuesto serv_impuesto) {
        this.serv_impuesto = serv_impuesto;
    }

    public Double getServ_precio_1() {
        return serv_precio_1;
    }

    public void setServ_precio_1(Double serv_precio_1) {
        this.serv_precio_1 = serv_precio_1;
    }

    public Double getServ_precio_2() {
        return serv_precio_2;
    }

    public void setServ_precio_2(Double serv_precio_2) {
        this.serv_precio_2 = serv_precio_2;
    }

    public Double getServ_precio_3() {
        return serv_precio_3;
    }

    public void setServ_precio_3(Double serv_precio_3) {
        this.serv_precio_3 = serv_precio_3;
    }

    public Double getServ_precio_4() {
        return serv_precio_4;
    }

    public void setServ_precio_4(Double serv_precio_4) {
        this.serv_precio_4 = serv_precio_4;
    }   
    
}
