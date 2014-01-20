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
import net.daw.helper.EncodingUtil;

/**
 *
 * @author AMPAROYPEDRO
 */
public class ProfesorSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            ProfesorDao oProfesorDao = new ProfesorDao(Conexion.getConection());
            ProfesorBean oProfesorBean = new ProfesorBean();
            Gson gson = new Gson();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oProfesorBean = gson.fromJson(jason, oProfesorBean.getClass());
            Map<String, String> data = new HashMap<>();
            if (oProfesorBean != null) {
                oProfesorBean = oProfesorDao.set(oProfesorBean);
                data.put("status", "200");
                data.put("message", Integer.toString(oProfesorBean.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("ProfesorSaveJson: View Error: " + e.getMessage());
        }
    }
}