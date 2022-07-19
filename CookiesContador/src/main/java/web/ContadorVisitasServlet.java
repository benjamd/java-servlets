/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benja
 */

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //declaramos variable contador 
        int contador = 0;
        
        //Revisamos si existe la cookie contadorVisitas
        Cookie[] cookies = req.getCookies();
        if(cookies != null) {
            for(Cookie c: cookies){
                if(c.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(c.getValue());
                }
                    
            }
                  
        }
        
        //incrementamos el contador 
        contador++;
        //Agregamos la respuesta al navegadodr
        Cookie c = new Cookie("contadorVisitas",Integer.toString(contador));
        //la cookie se almacenara en el cliente por una hora (3600seg)
        c.setMaxAge(3600);
        resp.addCookie(c);
        
        //mandamos el mensaje al navegador
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Contador de visitas de cada cliente: " + contador);
        
    }
    
    
}
