/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.HiloBean;
import net.daw.helper.Conexion;

/**
 *
 * @author José
 */
public class HiloDao extends GenericDaoImplementation<HiloBean> {

    public HiloDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "hilo");
    }

}
