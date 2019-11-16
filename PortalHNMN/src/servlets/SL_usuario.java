package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Tbl_user;
import datos.DT_usuario;

/**
 * Servlet implementation class SL_usuario
 */
@WebServlet("/SL_usuario")
public class SL_usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_usuario() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//////////////////// VARIABLE DE CONTROL //////////////////////
		String opc = request.getParameter("opc");
		int opcion = 0;

		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		///////// RECUPERAMOS EL ID DEL USUARIO A ELIMINAR //////////
		String idEliminar = request.getParameter("userID");
		int idUser = 0;
		
		idEliminar = idEliminar==null?"0":idEliminar;
		System.out.println("idEliminar: "+idEliminar);
		idUser = Integer.parseInt(idEliminar);
		System.out.println("idUser: "+idUser);
		
		Tbl_user tus = new Tbl_user();
		DT_usuario dtus = new DT_usuario();
		switch(opcion)
		{
			case 1:
			{
				try
				{
					tus.setId_user(idUser);
					
					if(dtus.eliminarUser(tus))
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblusuarios.jsp?msj=3");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblusuarios.jsp?msj=4");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error eliminarUser()");
				}
				break;
			}
			case 2:
			{
				//SIN CODIGO AUN
				break;
			}
			
			default:
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblusuarios.jsp?msj=ERROR");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
		
		Tbl_user tus = new Tbl_user();
		DT_usuario dtus = new DT_usuario();
		
		switch(opcion)
		{
			case 1:
			{
				try
				{
					tus.setUsername(request.getParameter("username"));
					tus.setPassword(request.getParameter("password"));
					tus.setNombre1(request.getParameter("nombre1"));
					tus.setNombre2(request.getParameter("nombre2"));
					tus.setApellido1(request.getParameter("apellido1"));
					tus.setApellido2(request.getParameter("apellido2"));
					tus.setEmail(request.getParameter("email"));
					
					System.out.println("Estoy entrando al servlet");
					
					if(dtus.guardarUser(tus))
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/newUser.jsp?msj=1");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/newUser.jsp?msj=2");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error al guardar el Usuario!!!");
				}
				break;
			}
			case 2:
			{
				try
				{
					tus.setId_user(Integer.parseInt(request.getParameter("IdUser")));
					tus.setUsername(request.getParameter("username"));
					tus.setPassword(request.getParameter("password"));
					tus.setNombre1(request.getParameter("nombre1"));
					tus.setNombre2(request.getParameter("nombre2"));
					tus.setApellido1(request.getParameter("apellido1"));
					tus.setApellido2(request.getParameter("apellido2"));
					tus.setEmail(request.getParameter("email"));
					
					if(dtus.modificarUser(tus))
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblusuarios.jsp?msj=1");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblusuarios.jsp?msj=2");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error al editar el Usuario!!!");
				}
				break;
			}
			
			default:
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/newUser.jsp?msj=ERROR");
			}
		}
		
		
		
		
		
	}

}