/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

/**
 *
 * @author al037877
 */
public class TipodocumentoBean {
    private Integer id = 0;
    private String descripcion = "";
    private boolean privado = false;

    public TipodocumentoBean() {
        
    }

    public TipodocumentoBean(Integer id) {
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }
    
    
}
