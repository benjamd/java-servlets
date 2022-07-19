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

@WebServlet("/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        ///Leer los parametros del formulario html
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        
        
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        
        PrintWriter out = resp.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("El parametro usuario es:" + usuario);
        out.print("<br/>");
        out.print("El parametro password es:" + password);
        out.print("</body>");
        out.print("</html>");
        out.close();
        
    }
    
    
    
}
