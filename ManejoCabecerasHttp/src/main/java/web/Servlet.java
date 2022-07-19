/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benja
 */

@WebServlet("/servlet-header")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Header HTTP</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Header HTTP</h1>");
        out.println("</br>");
        String metodoHttp = req.getMethod();
        out.println("Metodo Http: " + metodoHttp);
        out.println("</br>");
        String uri = req.getRequestURI();
        out.println("URI Solicitada: " + uri);
        out.println("</br>");

        out.println("</br>");
        out.println("</br>");
 
        Enumeration cabeceras = req.getHeaderNames();
        while(cabeceras.hasMoreElements()){
            String cabecera = (String) cabeceras.nextElement();
            out.println("<b>" + cabecera + "</b>: ");
            out.println(req.getHeader(cabecera));
            out.println("</br>");
            out.println("</br>");
 
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
                
    }
    
    
            
    
}
