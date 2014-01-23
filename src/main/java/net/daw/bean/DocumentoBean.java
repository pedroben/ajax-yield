/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.bean;

import java.util.Date;

/**
 *
 * @author Alvaro
 */
public class DocumentoBean {

    private Integer id = 0;
    private String titulo = "";
    private String contenido = "";
    private Date fecha = new Date();
    private Integer nota = 0;
    //private UsuarioBean usuario = null;
    private String etiquetas = "";

    public DocumentoBean() {

    }

    public DocumentoBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

//    public UsuarioBean getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(UsuarioBean usuario) {
//        this.usuario = usuario;
//    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    

}
