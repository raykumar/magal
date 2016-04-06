package com.akennedy.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name="venta", schema = "maestros")
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ven_id")
    private Long ven_id;
    
    @OneToOne
    @JoinColumn(name="ven_cliente")     
    private Cliente cliente;
    
    @Column(name="ven_fecha")
    private Date ven_fecha;
    
    @Column(name="ven_activo")
    private Boolean ven_activo;
    
    @Column(name="ven_total")
    private Double ven_total;
    
    @Column(name="ven_total_letra")
    private String ven_total_letra;
    
    @Column(name="ven_total_iva")
    private Double ven_total_iva;

    public Venta() {
    }

    public Venta(Long ven_id, Cliente cliente, Date ven_fecha, Boolean ven_activo, Double ven_total, String ven_total_letra, Double ven_total_iva) {
        this.ven_id = ven_id;
        this.cliente = cliente;
        this.ven_fecha = ven_fecha;
        this.ven_activo = ven_activo;
        this.ven_total = ven_total;
        this.ven_total_letra = ven_total_letra;
        this.ven_total_iva = ven_total_iva;
    }

    public Long getVen_id() {
        return ven_id;
    }

    public void setVen_id(Long ven_id) {
        this.ven_id = ven_id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getVen_fecha() {
        return ven_fecha;
    }

    public void setVen_fecha(Date ven_fecha) {
        this.ven_fecha = ven_fecha;
    }

    public Boolean getVen_activo() {
        return ven_activo;
    }

    public void setVen_activo(Boolean ven_activo) {
        this.ven_activo = ven_activo;
    }

    public Double getVen_total() {
        return ven_total;
    }

    public void setVen_total(Double ven_total) {
        this.ven_total = ven_total;
    }

    public String getVen_total_letra() {
        return ven_total_letra;
    }

    public void setVen_total_letra(String ven_total_letra) {
        this.ven_total_letra = ven_total_letra;
    }

    public Double getVen_total_iva() {
        return ven_total_iva;
    }

    public void setVen_total_iva(Double ven_total_iva) {
        this.ven_total_iva = ven_total_iva;
    }
    
    
            

    
}
