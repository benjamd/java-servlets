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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
       
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =   resp.getWriter();
        
        
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        String tecnologias[] = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String musica[] = req.getParameterValues("musica");
        String comentarios = req.getParameter("comentarios");
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Parametros procesados por el Servlet</h1>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>");
        out.println("usuario");
        out.println("</td>");
        out.println("<td>");
        out.println(usuario);
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println("password");
        out.println("</td>");
        out.println("<td>");
        out.println(password);
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>");
        out.println("tecnologias");
        out.println("</td>");
        out.println("<td>");
        for (String tec: tecnologias){
            out.println(tec);
            out.println("");
        
        }
        out.println("</td>");
        out.println("</tr>");        
       
        out.println("<tr>");
        out.println("<td>");
        out.println("genero");
        out.println("</td>");
        out.println("<td>");
        out.println(genero);
        out.println("</td>");
        out.println("</tr>");
     
        out.println("<tr>");
        out.println("<td>");
        out.println("ocupacion");
        out.println("</td>");
        out.println("<td>");
        switch (Integer.parseInt(ocupacion)) {
            case 1:
                out.println("Profesor");
                break;
            case 2:
                out.println("Ingeniero");
                break;
            case 3:
                out.println("Jubilado");
                break;
            case 4:
                out.println("Otro");
                break;    
            default:
                break;
        }
        out.println("</td>");
        out.println("</tr>");
        
        
        out.println("<tr>");
        out.println("<td>");
        out.println("musica");
        out.println("</td>");
        out.println("<td>");
        if(musica != null) {
            for (String mu: musica){
                out.println(mu);
                out.println("");
            }    
        }
        out.println("</td>");
        out.println("</tr>");        
        
        
        out.println("<tr>");
        out.println("<td>");
        out.println("comentarios");
        out.println("</td>");
        out.println("<td>");
        out.println(comentarios);
        out.println("</td>");
        out.println("</tr>");
        
        out.println("</tabla>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
    
    
    
}
