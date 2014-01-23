/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

/**
 *
 * @author Alvaro
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import net.daw.bean.DocumentoBean;
import net.daw.dao.DocumentoDao;
import net.daw.helper.Conexion;


public class DocumentoGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                DocumentoDao oDocumentoDAO = new DocumentoDao(Conexion.getConection());
                DocumentoBean oDocumento = new DocumentoBean();
                oDocumento.setId(Integer.parseInt(request.getParameter("id")));
                oDocumentoDAO.get(oDocumento);
                data = new Gson().toJson(oDocumento);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("DocumentoGetJson: View Error: " + e.getMessage());
        }
    }
}