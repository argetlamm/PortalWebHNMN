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
 * Servlet implementation class SL_registro
 */
@WebServlet("/SL_registro")
public class SL_registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Tbl_user tus = new Tbl_user();
		DT_usuario dtus = new DT_usuario();
		
		try
		{
			int opcionA = 0;
			String opcion = request.getParameter("notificacion");
			if("a".trim().equals(opcion.trim())) {
				opcionA = 1;
				tus.setUsername(request.getParameter("username"));
				tus.setPassword(request.getParameter("password"));
				tus.setNombre1(request.getParameter("nombre1"));
				tus.setNombre2(request.getParameter("nombre2"));
				tus.setApellido1(request.getParameter("apellido1"));
				tus.setApellido2(request.getParameter("apellido2"));
				tus.setEmail(request.getParameter("email"));
				tus.setNotificacion(opcionA);
				if(dtus.guardarUser(tus))
				{
					response.sendRedirect(request.getContextPath()+ "/registro.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/registro.jsp?msj=2");
				}
			} else {
				opcionA = 2;
				tus.setUsername(request.getParameter("username"));
				tus.setPassword(request.getParameter("password"));
				tus.setNombre1(request.getParameter("nombre1"));
				tus.setNombre2(request.getParameter("nombre2"));
				tus.setApellido1(request.getParameter("apellido1"));
				tus.setApellido2(request.getParameter("apellido2"));
				tus.setEmail(request.getParameter("email"));
				tus.setNotificacion(opcionA);
				if(dtus.guardarUser(tus))
				{
					response.sendRedirect(request.getContextPath()+ "/registro.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/registro.jsp?msj=2");
				}
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al registrar el usuario!!!");
		}
	}

}
