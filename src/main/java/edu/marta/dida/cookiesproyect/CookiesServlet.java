/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.marta.dida.cookiesproyect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "CookiesServlet", urlPatterns = {"/CookiesServlet"})
public class CookiesServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        boolean nuevoUsuario = true;
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies!=null){
            for (Cookie c : cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio web";
        } else{
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio web";
        }
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.println("Mensaje: " + mensaje);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
