package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_publicaciones;
import entidades.Tbl_publicaciones;
import java.util.*;

/**
 * Servlet implementation class SL_colecciones
 */
@WebServlet("/SL_colecciones")
public class SL_colecciones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_colecciones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Estoy entrando al servlet GET");
		int id=0;
		id = (Integer.parseInt(request.getParameter("IdUser")));
		System.out.println("id en sevlet: "+id);
		response.sendRedirect(request.getContextPath()+ "/muestra-individual.jsp?imagenID="+id);
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
		String guid = request.getParameter("colecciones");
		
		try
		{	
			tpus1.setPublic_content(contenido);
			tpus1.setGuid(guid);
			

			if(dtpus.modificarColeccionesParr(tpus1))
			{											
				response.sendRedirect(request.getContextPath()+ "/CMS/colecciones/editColecciones.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/colecciones/editColecciones.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar Productos!");
		}
	}

}
