package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.DT_usuario;
import entidades.Tbl_user;

/**
 * Servlet implementation class SL_ayudas
 */
@WebServlet("/SL_ayudas")
public class SL_ayudas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_ayudas() {
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
		
		try
		{
			Tbl_user tbUser = new Tbl_user();
			DT_usuario dtUser = new DT_usuario();
			String login = "";
			int opcionA = 0;
			
			//Recupero, en opcion, el value del radio button seleccionado vía el nombre (option)
			//O sea, me devolverá "a" o "b" (Revisar los values dados en sistema.jsp)
			String opcion = request.getParameter("option");
			//Creo una sesión para darle los valores de la sesión activa
			HttpSession hts =  request.getSession(true);
			
			//Vía esa sesión, solicito el login del usuario para poder buscar posteriormente qué usuario es al que se le
			//cambiará la opción de ayuda
			login = (String) hts.getAttribute("login");
			login = login==null?"":login;
			
			//Si la opción recuperada del formulario en sistema.jsp es "a", entrará al if
			if("a".trim().equals(opcion.trim()))
			{
				//Asigno a una variable el valor de 1 para seteárselo a un objeto de tbl_user,
				//(Me gusta hacerlo así, aunque perfectamente puedo setearlo simplemente poniendo 1 en el setAyuda)
				//Asigno, también, el login, que es con el que se ubicará qué usuario se editará
				opcionA = 1;
				tbUser.setUsername(login);
				tbUser.setAyuda(opcionA);
				
				if(dtUser.modificarAyuda(tbUser))
				{
					//Si modificar ayuda devuelve true, el cambio se realizó y volverá a sistema con el "msj1"
					//Ahorita el mensaje de confirmación está borrado, tal vez lo agrego después.
					response.sendRedirect(request.getContextPath()+ "/CMS/sistema.jsp?msj=1");
				}
				else
				{
					//Si devuelve false, el método no funcionó e igual redireccionará pero la opción no cambiará
					response.sendRedirect(request.getContextPath()+ "/CMS/sistema.jsp?msj=2");
				}
			}
			else
			{
				//Si la opción recuperada del formulario en sistema.jsp es "b", pasará al else
				//Asigno a una variable el valor de 2 para seteárselo a un objeto de tbl_user
				opcionA = 2;
				tbUser.setUsername(login);
				tbUser.setAyuda(opcionA);
				
				//Y exactamente la misma lógica del if
				if(dtUser.modificarAyuda(tbUser))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/sistema.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/sistema.jsp?msj=2");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Servlet: Error al cambiar la opción de ayuda - " + e.getMessage());
		}
	}

}
