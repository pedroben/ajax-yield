/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.dao;

import net.daw.bean.UsuarioBean;
import net.daw.helper.Conexion;

/**
 *
 * @author rafa
 */
public class UsuarioDao extends GenericDaoImplementation<UsuarioBean> {

    public UsuarioDao(Conexion.Tipo_conexion tipoConexion) throws Exception {
        super(tipoConexion, "usuario");
    }

    public UsuarioBean getFromLogin(UsuarioBean oUsuario) throws Exception {
        try {
            oMysql.conexion(enumTipoConexion);
            String strId = oMysql.getId("usuario", "login", oUsuario.getLogin());
            if (strId == null) {
                oUsuario.setId(0);
            } else {
                oUsuario.setId(Integer.parseInt(strId));
                oUsuario.setPassword(oMysql.getOne("usuario", "password", oUsuario.getId()));
            }
            oMysql.desconexion();
            return oUsuario;
        } catch (Exception e) {
            throw new Exception("UsuarioDao.getFromLogin: Error: " + e.getMessage());
        }
    }

}
