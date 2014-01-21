/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class ProfesorGet implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                ProfesorDao oProfesorDAO = new ProfesorDao(Conexion.getConection());
                ProfesorBean ProfesorBean = new ProfesorBean();
                ProfesorBean.setId(Integer.parseInt(request.getParameter("id")));
                oProfesorDAO.get(ProfesorBean);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(ProfesorBean);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("ProfesorGetJson: View Error: " + e.getMessage());
        }
    }
}