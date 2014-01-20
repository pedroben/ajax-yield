/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import java.util.Date;

/**
 *
 * @author al037342
 */
public class RequerimientoBean {

    private Integer id = 0;
    private String enunaciado = "";
    private Date fechaalta = new Date();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnunaciado() {
        return enunaciado;
    }

    public void setEnunaciado(String enunaciado) {
        this.enunaciado = enunaciado;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }
    
    
    
    
    
}
