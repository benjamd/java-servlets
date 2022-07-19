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

/**
 *
 * @author benja
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //simulando valores correctos
        String usuarioOK = "juan";
        String passwordOK = "123";
        
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        
        PrintWriter out = resp.getWriter();
        
        if(usuarioOK.equals(usuario) && passwordOK.equals(password)){
            out.println("<h1>");
            out.println("Datos correctos");
            out.println("<br/>Usuario: " + usuario);
            out.println("<br/>Password: " + password);
            out.println("</h1>");
        } else {
            resp.sendError(resp.SC_UNAUTHORIZED, "Las credenciales son incorrectas");
            
        }
        
        out.close();
    }
    
    
    
}
