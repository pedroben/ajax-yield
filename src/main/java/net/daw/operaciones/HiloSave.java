/*
 * To change this template, choose Tools | Templates
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
import net.daw.bean.HiloBean;
import net.daw.dao.HiloDao;
import net.daw.helper.Conexion;
import net.daw.helper.EncodingUtil;



/**
 *
 * @author Alvaro
 */
public class HiloSave implements GenericOperation {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        try {
            HiloDao oHiloDAO = new HiloDao(Conexion.getConection());
            HiloBean oHilo = new HiloBean();
           Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
            String jason = request.getParameter("json");
            jason = EncodingUtil.decodeURIComponent(jason);
            oHilo = gson.fromJson(jason, oHilo.getClass());
            Map<String, String> data = new HashMap<>();
            if (oHilo != null) {
                oHilo = oHiloDAO.set(oHilo);
                data.put("status", "200");
                data.put("message", Integer.toString(oHilo.getId()));
            } else {
                data.put("status", "error");
                data.put("message", "error");
            }
            String resultado = gson.toJson(data);
            return resultado;
        } catch (Exception e) {
            throw new ServletException("HiloSaveJson: View Error: " + e.getMessage());
        }
    }
}
