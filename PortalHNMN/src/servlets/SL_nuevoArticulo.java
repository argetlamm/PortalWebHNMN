package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.DT_EmailSessionBean;
import datos.DT_publicaciones;
import datos.DT_usuario;
import entidades.Tbl_publicaciones;

@WebServlet("/SL_nuevoArticulo")
public class SL_nuevoArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_nuevoArticulo() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    private DT_EmailSessionBean emailBean;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
		contenido = contenido.replace("\n","<br>");
		String redactor = request.getParameter("redactor");
		String previa ="";
		if(contenido.length()>200)
		{
			previa = contenido.substring(0, 200);
		}
		else
		{
			previa = contenido;
		}
		String categoria = request.getParameter("categoria");
		Tbl_publicaciones tpub = new Tbl_publicaciones();
		DT_publicaciones dpub = new DT_publicaciones();
		try
		{
			tpub.setGuid(redactor);
			tpub.setPublic_content(contenido);
			tpub.setPublic_titulo(titulo);
			tpub.setPublic_previa(previa);
			tpub.setPublic_tipo(categoria);
			
			if(dpub.guardarArticuloTexto(tpub))
			{
				String to = request.getParameter("destinoInput");
		        String nombre = request.getParameter("nombreCompleto");
		        String cpCorreo = request.getParameter("cuerpoDelCorreo");
		        String asunto= request.getParameter("asunto");
		        String remitente = request.getParameter("correo");
		        String pass = request.getParameter("password");
		        //String totalCorreos = request.getParameter("totalCorreos");
		        boolean enviado = false;

		        String[] correos = to.split("/");
		        DT_usuario dtus = new DT_usuario();
		        for (String remit : correos ) {
		        	if(dtus.obtenerUsername(remit).getNotificacion()==1) {
		        		try {
			        		enviado = emailBean.sendEmail(remit, asunto,"Estimado "+dtus.obtenerUsername(remit).getUsername()+cpCorreo+dpub.obtenerEnlacePublico().getPublic_enlace(), nombre, remitente, pass);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		        	}else {
		        		enviado = true;
		        	}
		        }				
				if(enviado) {
					response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulos.jsp?msj=1");
				} else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulos.jsp?msj=2");
				}				
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulos.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al crear un nuevo artículo");
		}
		
		
	}

}
