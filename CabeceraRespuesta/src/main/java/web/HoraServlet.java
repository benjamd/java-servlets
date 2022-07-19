/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benja
 */

@WebServlet("/HoraServlet")
public class HoraServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        //tipo de contenido que tiene la respuesta
        resp.setContentType("text/html;charset=UTF-8");
        //refrescar la informacion que mandamos al navegador cada 1 seg.
        resp.setHeader("refresh", "1");
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
        String horaConFormato = formatoFecha.format(fecha);
        
        PrintWriter out = resp.getWriter();
        
        out.println("<b>Hora con Formato</b>");
        out.println("<br/>");
        out.println("<h1>" + horaConFormato + "</h1>");
        out.close();
        
    }
    
    
    
}
