/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.VotodocumentoBean;
import net.daw.helper.Conexion;

/**
 *
 * @author al037877
 */
public class VotodocumentoDao extends GenericDaoImplementation<VotodocumentoBean> {

    public VotodocumentoDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "votodocumento");
    }
}
