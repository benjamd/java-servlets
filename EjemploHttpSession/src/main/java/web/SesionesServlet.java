/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author benja
 */
@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = req.getSession();
        String titulo = null;
        
        //Pedir el atributo contadorVisitas a la sesion
        Integer contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
        // si es nulo es la primera vez
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez!";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente!";
            
        }
        //agregamos el nuevo valor a la sesion
        session.setAttribute("contadorVisitas", contadorVisitas);
        
        //mandamos la respuesta al cliente
        PrintWriter out = resp.getWriter();
        out.println(titulo);
        out.println("<br/>");
        out.println("no. acceso al recurso: " + contadorVisitas);
        out.println("<br/>");
        out.println("ID de la sesion: "+ session.getId());
        out.close();
    }
    
    
    
}
