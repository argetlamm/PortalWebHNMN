package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_publicaciones;
import datos.DT_usuario;
import entidades.Tbl_publicaciones;
import entidades.Tbl_user;

public class SL_menu {
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
		
		Tbl_publicaciones tpus1 = new Tbl_publicaciones();
		Tbl_publicaciones tpus2 = new Tbl_publicaciones();
		Tbl_publicaciones tpus3 = new Tbl_publicaciones();
		Tbl_publicaciones tpus4 = new Tbl_publicaciones();
		Tbl_publicaciones tpus5 = new Tbl_publicaciones();
		Tbl_publicaciones tpus6 = new Tbl_publicaciones();
		Tbl_publicaciones tpus7 = new Tbl_publicaciones();
		Tbl_publicaciones tpus8 = new Tbl_publicaciones();
		DT_publicaciones dtpus = new DT_publicaciones();
		
		ArrayList<Tbl_publicaciones> tpus = new ArrayList<Tbl_publicaciones>();
		
		try
		{	
			tpus1.setPublic_titulo(request.getParameter("item1"));
			tpus2.setPublic_titulo(request.getParameter("item2"));
			tpus3.setPublic_titulo(request.getParameter("item3"));
			tpus4.setPublic_titulo(request.getParameter("item4"));
			tpus5.setPublic_titulo(request.getParameter("item5"));
			tpus6.setPublic_titulo(request.getParameter("item6"));
			tpus7.setPublic_titulo(request.getParameter("item7"));
			tpus8.setPublic_titulo(request.getParameter("item8"));
			
			tpus.add(tpus1);
			tpus.add(tpus2);
			tpus.add(tpus3);
			tpus.add(tpus4);
			tpus.add(tpus5);
			tpus.add(tpus6);
			tpus.add(tpus7);
			tpus.add(tpus8);
			
			if(dtpus.modificarMenu(tpus))
			{											
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar el Menú!!!");
		}
	}
}
