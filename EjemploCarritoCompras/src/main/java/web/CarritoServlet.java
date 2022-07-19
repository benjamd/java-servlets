/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
       
        
        //creamos o recuperamos el objeto httpsession
        HttpSession sesion = req.getSession();
        
        //recuperamos la lista de articulos agregados previamente si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        
        if(articulos == null){
            //inicializamos la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
            
        }
        
        //procesamos el nuevo articulo
        String articuloNuevo = req.getParameter("articulo");
        
        //revisamos y agregamos el articulo nuevo
        if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
            articulos.add(articuloNuevo);
        }
        
        //sintaxis try-with-resources
        try (
            //Imprimimos la lista de articulos    
            PrintWriter out = resp.getWriter()) {
            out.println("<h1>Lista de Articulos</h1>");
            out.println("<br/>");
            
            //iteramos todos los articulos
            for (String articulo: articulos){
                out.println("<li>" + articulo + "</li>");
            }
            //agregamos un link para regresar al inicio
            out.println("<br/>");
            out.println("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
        }
    }
    
    
    
}
