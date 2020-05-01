package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_publicaciones;
import entidades.Tbl_publicaciones;

/**
 * Servlet implementation class SL_footer
 */
@WebServlet("/SL_servicios")
public class SL_servicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_servicios() {
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
		
		int contador = Integer.parseInt(request.getParameter("contador"));
		//Creamos los dos ArrayList, uno para los items y otro para los títulos
		ArrayList<Tbl_publicaciones> items = new ArrayList<Tbl_publicaciones>();
		ArrayList<Tbl_publicaciones> titulos = new ArrayList<Tbl_publicaciones>();
		//Creamos una variable tipo que compararemos para saber qué agregaremos a cuál ArrayList
		String tipo = "";
		String contenido ="";
		DT_publicaciones dtpus = new DT_publicaciones();
		
		try {
			for(int i = 1; i<contador+1; i++)
			{
				Tbl_publicaciones tpus = new Tbl_publicaciones();
				tipo = request.getParameter("guid"+i);
				if(tipo.trim().equals("muestreoIndividualTitulo") || tipo.trim().equals("muestreoColectivoTitulo"))
				{
					tpus.setPublic_titulo(request.getParameter("texto"+i));
					tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
					tpus.setGuid(tipo);
					tpus.setPublic_name(request.getParameter("name"+i));
					titulos.add(tpus);
				}
				else
				{
					if(tipo.trim().equals("muestreoIndividual") || tipo.trim().equals("muestreoColectivo"))
					{
						tpus.setPublic_titulo(request.getParameter("texto"+i));
						tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
						tpus.setGuid(tipo);
						tpus.setPublic_name(request.getParameter("name"+i));
						items.add(tpus);
					}
				}
			}
			if(dtpus.modificarItemsServicios(items))
			{							
				if(dtpus.modificarTitulosServicios(titulos))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/servicios/editServicios.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/servicios/editServicios.jsp?msj=2");
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/servicios/editServicios.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar los servicios" + e);
		}
	}

}
