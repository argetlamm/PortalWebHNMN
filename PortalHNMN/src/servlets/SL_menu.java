package servlets;

import java.io.IOException;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//		doGet(request, response);
		
		String opc = request.getParameter("opc");
		int opcion = 0;

		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		Tbl_publicaciones tpb = new Tbl_publicaciones();
		DT_publicaciones dtpb = new DT_publicaciones();
		
		switch(opcion)
		{
			case 1:
			{
				try
				{
					
					tpb.setId_publicacion(Integer.parseInt(request.getParameter("Item1")));
					tpb.setPublic_titulo(request.getParameter("nombreMenu1"));
					
					
					if(dtpb.modificarMenu(tpb))
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
					System.out.println("Servlet: Error al editar el Menu!!!");
				}
				break;
			}
			
			default:
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=ERROR");
			}
		}
		
		
		
		
		
	}
}
