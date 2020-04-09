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

@WebServlet("/SL_menu")
public class SL_menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al get");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Entró al post");
		
		int contador = Integer.parseInt(request.getParameter("contador"));
		System.out.println("Llegaron "+contador+ " objetos");
		ArrayList<Tbl_publicaciones> atpus = new ArrayList<Tbl_publicaciones>();
		DT_publicaciones dtpus = new DT_publicaciones();
		
		try {
			
			for(int i = 1; i<contador+1; i++)
			{
				Tbl_publicaciones tpus = new Tbl_publicaciones();
				tpus.setPublic_titulo(request.getParameter("texto"+i));
				tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
				tpus.setPublic_enlace(request.getParameter("enlace"+i));
				tpus.setGuid(request.getParameter("guid"+i));
				atpus.add(tpus);
			}
			if(dtpus.modificarMenu(atpus))
			{											
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=2");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar el Menú");
		}
	}
}
