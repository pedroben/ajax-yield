/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.dao;

import net.daw.bean.OpcionBean;
import net.daw.helper.Conexion;

/**
 *
 * @author al037213
 */
public class OpcionDao extends GenericDaoImplementation<OpcionBean> {
  
    public OpcionDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion,"opcion");
    }
    
}

