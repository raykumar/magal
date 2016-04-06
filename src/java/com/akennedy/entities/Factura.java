package com.akennedy.entities;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="factura", schema = "maestros")
@XmlRootElement
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="fac_id")
    private Long fac_id;
    
    @Column(name="fac_timbrado")
    private String fac_timbrado;
    
    @Column(name="fac_sucursal")
    private String fac_sucursal;
    
    @Column(name="fac_caja")
    private String fac_caja;
    
    @Column(name="fac_nro_inicio")
    private Integer fac_nro_inicio;
    
    @Column(name="fac_nro_fin")
    private Integer fac_nro_fin;
    
    @Column(name="fac_fecha_venc")
    private Date fac_fecha_venc;

    public Factura() {
    }

    public Factura(Long fac_id, String fac_timbrado, String fac_sucursal, String fac_caja, Integer fac_nro_inicio, Integer fac_nro_fin, Date fac_fecha_venc) {
        this.fac_id = fac_id;
        this.fac_timbrado = fac_timbrado;
        this.fac_sucursal = fac_sucursal;
        this.fac_caja = fac_caja;
        this.fac_nro_inicio = fac_nro_inicio;
        this.fac_nro_fin = fac_nro_fin;
        this.fac_fecha_venc = fac_fecha_venc;
    }

    public Long getFac_id() {
        return fac_id;
    }

    public void setFac_id(Long fac_id) {
        this.fac_id = fac_id;
    }

    public String getFac_timbrado() {
        return fac_timbrado;
    }

    public void setFac_timbrado(String fac_timbrado) {
        this.fac_timbrado = fac_timbrado;
    }

    public String getFac_sucursal() {
        return fac_sucursal;
    }

    public void setFac_sucursal(String fac_sucursal) {
        this.fac_sucursal = fac_sucursal;
    }

    public String getFac_caja() {
        return fac_caja;
    }

    public void setFac_caja(String fac_caja) {
        this.fac_caja = fac_caja;
    }

    public Integer getFac_nro_inicio() {
        return fac_nro_inicio;
    }

    public void setFac_nro_inicio(Integer fac_nro_inicio) {
        this.fac_nro_inicio = fac_nro_inicio;
    }

    public Integer getFac_nro_fin() {
        return fac_nro_fin;
    }

    public void setFac_nro_fin(Integer fac_nro_fin) {
        this.fac_nro_fin = fac_nro_fin;
    }

    public Date getFac_fecha_venc() {
        return fac_fecha_venc;
    }

    public void setFac_fecha_venc(Date fac_fecha_venc) {
        this.fac_fecha_venc = fac_fecha_venc;
    }
    
    


}
