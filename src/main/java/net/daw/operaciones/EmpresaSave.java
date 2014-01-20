/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operaciones;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.EmpresaBean;
import net.daw.dao.EmpresaDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;

/**
 *
 * @author AntonioNP
 */
public class EmpresaSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            EmpresaDao oEntradaDAO = new EmpresaDao(Conexion.getConection());
            EmpresaBean oEntrada = new EmpresaBean();
            Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oEntrada = gson.fromJson(jason, oEntrada.getClass());
            Map<String, String> data = new HashMap<>();
            if (oEntrada != null) {
                oEntrada = oEntradaDAO.set(oEntrada);
                data.put("status", "200");
                data.put("message", Integer.toString(oEntrada.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("EntradaSaveJson: View Error: " + e.getMessage());
        }
    }
}
