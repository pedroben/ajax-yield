/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.daw.operaciones;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.daw.bean.EmpresaBean;
import net.daw.dao.EmpresaDao;
import net.daw.helper.Conexion;

/**
 *
 * @author AntonioNP
 */
public class EmpresaGet implements GenericOperation{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String data;         
        try {            
            if (request.getParameter("id") == null) {
                data = "{\"error\":\"id is mandatory\"}";
            } else {
                EmpresaDao oEntradaDAO = new EmpresaDao(Conexion.getConection());
                EmpresaBean oEntrada = new EmpresaBean();
                oEntrada.setId(Integer.parseInt(request.getParameter("id")));
                oEntradaDAO.get(oEntrada);
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("dd/MM/yyyy");
                Gson gson = gsonBuilder.create();
                data = gson.toJson(oEntrada);
                
            }
            return data;
        } catch (Exception e) {
            throw new ServletException("EntradaGetJson: View Error: " + e.getMessage());
        }
    }
}
