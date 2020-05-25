package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_publicaciones;
import entidades.Tbl_publicaciones;

/**
 * Servlet implementation class SL_colaboraciones
 */
@WebServlet("/SL_colaboraciones")
public class SL_colaboraciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_colaboraciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tbl_publicaciones tpus1 = new Tbl_publicaciones();
		DT_publicaciones dtpus = new DT_publicaciones();
		
		String contenido = request.getParameter("contenido");
		contenido = contenido.replace("\n","<br>");
		contenido = contenido.replace("\u2022","<li>");
		contenido = contenido.replace("*","<li>");
		contenido = contenido.replace("-","</li>");
		String guid = request.getParameter("colaboraciones");
		
		try
		{	
			tpus1.setPublic_content(contenido);
			tpus1.setGuid(guid);
			

			if(dtpus.modificarColaboraciones(tpus1))
			{											
				response.sendRedirect(request.getContextPath()+ "/CMS/colaboraciones/editColaboraciones.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/colaboraciones/editColaboraciones.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar Colaboraciones!");
		}
	}

}
