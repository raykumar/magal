package com.akennedy.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * 
 * @author Alejandro Kennedy <alekennedypy at gmail.com>
 */
@Entity
@Table(name="cliente", schema = "maestros")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cli_id;
    
    @Column(name="cli_doc")
    private String cli_doc;
    
    @Column(name="cli_nombre")
    private String cli_nombre;
    
    @Column(name="cli_tel")
    private String cli_tel;
    
    @Column(name="cli_cel")
    private String cli_cel;
    
    @Column(name="cli_email")
    private String cli_email;
    
    @Column(name="cli_cumpleaños")
    private String cli_cumpleaños;
    
    @JoinColumn(name="cli_ciudad")
    private Ciudad cli_ciudad;
    
    @Column(name="activo")
    private Boolean activo;

    public Cliente() {
        
    }

    public Cliente(Long cli_id, String cli_doc, String cli_nombre, String cli_tel, String cli_cel, String cli_email, String cli_cumpleaños, Ciudad cli_ciudad, Boolean activo) {
        this.cli_id = cli_id;
        this.cli_doc = cli_doc;
        this.cli_nombre = cli_nombre;
        this.cli_tel = cli_tel;
        this.cli_cel = cli_cel;
        this.cli_email = cli_email;
        this.cli_cumpleaños = cli_cumpleaños;
        this.cli_ciudad = cli_ciudad;
        this.activo = activo;
    }

 
    public Long getCli_id() {
        return cli_id;
    }

    public void setCli_id(Long cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_doc() {
        return cli_doc;
    }

    public void setCli_doc(String cli_doc) {
        this.cli_doc = cli_doc;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_tel() {
        return cli_tel;
    }

    public void setCli_tel(String cli_tel) {
        this.cli_tel = cli_tel;
    }

    public String getCli_cel() {
        return cli_cel;
    }

    public void setCli_cel(String cli_cel) {
        this.cli_cel = cli_cel;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_cumpleaños() {
        return cli_cumpleaños;
    }

    public void setCli_cumpleaños(String cli_cumpleaños) {
        this.cli_cumpleaños = cli_cumpleaños;
    }

    public Ciudad getCli_ciudad() {
        return cli_ciudad;
    }

    public void setCli_ciudad(Ciudad cli_ciudad) {
        this.cli_ciudad = cli_ciudad;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
    
    
    

    
}
