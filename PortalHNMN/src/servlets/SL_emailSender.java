package servlets;

import java.io.IOException;
//import java.util.Enumeration;

import javax.ejb.EJB;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.DT_EmailSessionBean;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/SL_emailSender")
public class SL_emailSender extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @EJB
    private DT_EmailSessionBean emailBean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to = request.getParameter("destinoInput");
        String nombre = request.getParameter("nombreCompleto");
        String cpCorreo = request.getParameter("cuerpoDelCorreo");
        String asunto= request.getParameter("asunto");
        String remitente = request.getParameter("correo");
        String pass = request.getParameter("password");
        String totalCorreos = request.getParameter("totalCorreos");
        boolean enviado = false;

        String[] correos = to.split("/");

        for (String remit : correos ) {
        	enviado = emailBean.sendEmail(remit, asunto, cpCorreo, nombre, remitente, pass);
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (enviado) {
        	try {
                response.sendRedirect("./CMS/suscripcion/notificacion.jsp?msj=1&totalCorreos="+totalCorreos);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                out.close();
            }
        } else {
        	try {
                response.sendRedirect("./CMS/suscripcion/notificacion.jsp?msj=2&totalCorreos="+totalCorreos);
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                out.close();
            }
        }
        
    }

}