/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.ProfesorBean;
import net.daw.helper.Conexion;

/**
 *
 * @author AMPAROYPEDRO
 */
public class ProfesorDao extends GenericDaoImplementation<ProfesorBean> {

    public ProfesorDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "profesor");
    }
}
