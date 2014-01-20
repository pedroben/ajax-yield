/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operaciones;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.ProfesorBean;
import net.daw.dao.ProfesorDao;
import net.daw.helper.Conexion;

/**
 *
 * @author AMPAROYPEDRO
 */
public class ProfesorRemove implements GenericOperation {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ProfesorDao oProfesorDao = new ProfesorDao(Conexion.getConection());
            ProfesorBean oProfesorBean = new ProfesorBean();                                           
            oProfesorBean.setId(Integer.parseInt(request.getParameter("id")));            
            Map<String, String> data = new HashMap<>();
            if (oProfesorBean != null) {
                oProfesorDao.remove(oProfesorBean);
                data.put("status", "200");
                data.put("message", "se ha eliminado el registro con id=" + oProfesorBean.getId());
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            Gson gson = new Gson();
            String resultado = gson.toJson(data);
            return resultado;        
        } catch (Exception e) {
            throw new ServletException("ProfesorRemoveJson: View Error: " + e.getMessage());
        }
    }
}
