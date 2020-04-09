package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_publicaciones;
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String contenido = request.getParameter("contenido");
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
				response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulos.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulos.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al crear un nuevo art�culo");
		}
		
		
	}

}
