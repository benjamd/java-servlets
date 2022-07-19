
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benja
 */
@WebServlet("/CookiesServlet")
public class CookiesServlet extends  HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        //suponemos que el usuario visita x primera vez el sitio
        boolean nuevoUsuario = true;
        
        //Obtenemos el arregle de cookies
        Cookie[] cookies = req.getCookies();
        
        //buscamos si ya existe cookie creada con anterioridad
        if(cookies != null){
            for(Cookie c: cookies){
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {
                    //si ya existe es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
                 
            }
        }
        String mensaje = null;
        if(nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("visitanteRecurrente","si");
            resp.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar nuevamente nuestro sitio";
        }
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Mensaje: " + mensaje);
        out.close();
            
    }
}
