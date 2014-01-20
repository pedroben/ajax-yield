/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

/**
 *
 * @author al037431
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import net.daw.bean.MetadocumentoBean;
import net.daw.dao.MetadocumentoDao;
import net.daw.helper.Conexion;


public class MetadocumentoGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                MetadocumentoDao oMetadocumentoDAO = new MetadocumentoDao(Conexion.getConection());
                MetadocumentoBean oMetadocumento = new MetadocumentoBean();
                oMetadocumento.setId(Integer.parseInt(request.getParameter("id")));
                oMetadocumentoDAO.get(oMetadocumento);
                data = new Gson().toJson(oMetadocumento);
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("MetadocumentoGetJson: View Error: " + e.getMessage());
        }
    }
}
