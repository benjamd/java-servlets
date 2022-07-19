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
@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
            //indicamos el tipo de respuesta al navegador
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
            
            //indicar que no guarde info previa
            //siempre que haga click sea informacion nueva
            //y que no guarde cache en el navegador
            //Cada vez que se haga click en el link se genera info nueva
            resp.setHeader("Pragma", "no-cache");
            resp.setHeader("Cache", "no-store");
            resp.setDateHeader("Exprires", -1);
            
            //desplegamos la informacion al cliente
            
            PrintWriter out = resp.getWriter();
            out.println("\tValores");
            out.println("\t1");
            out.println("\t2");
            out.println("Total\t=SUMA(B2:B3");
            out.close();
            
    }
    
    
    
}
