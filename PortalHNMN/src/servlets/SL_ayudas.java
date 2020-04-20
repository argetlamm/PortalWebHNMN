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
			
			//Recupero, en opcion, el value del radio button seleccionado v�a el nombre (option)
			//O sea, me devolver� "a" o "b" (Revisar los values dados en sistema.jsp)
			String opcion = request.getParameter("option");
			//Creo una sesi�n para darle los valores de la sesi�n activa
			HttpSession hts =  request.getSession(true);
			
			//V�a esa sesi�n, solicito el login del usuario para poder buscar posteriormente qu� usuario es al que se le
			//cambiar� la opci�n de ayuda
			login = (String) hts.getAttribute("login");
			login = login==null?"":login;
			
			//Si la opci�n recuperada del formulario en sistema.jsp es "a", entrar� al if
			if("a".trim().equals(opcion.trim()))
			{
				//Asigno a una variable el valor de 1 para sete�rselo a un objeto de tbl_user,
				//(Me gusta hacerlo as�, aunque perfectamente puedo setearlo simplemente poniendo 1 en el setAyuda)
				//Asigno, tambi�n, el login, que es con el que se ubicar� qu� usuario se editar�
				opcionA = 1;
				tbUser.setUsername(login);
				tbUser.setAyuda(opcionA);
				
				if(dtUser.modificarAyuda(tbUser))
				{
					//Si modificar ayuda devuelve true, el cambio se realiz� y volver� a sistema con el "msj1"
					//Ahorita el mensaje de confirmaci�n est� borrado, tal vez lo agrego despu�s.
					response.sendRedirect(request.getContextPath()+ "/CMS/sistema.jsp?msj=1");
				}
				else
				{
					//Si devuelve false, el m�todo no funcion� e igual redireccionar� pero la opci�n no cambiar�
					response.sendRedirect(request.getContextPath()+ "/CMS/sistema.jsp?msj=2");
				}
			}
			else
			{
				//Si la opci�n recuperada del formulario en sistema.jsp es "b", pasar� al else
				//Asigno a una variable el valor de 2 para sete�rselo a un objeto de tbl_user
				opcionA = 2;
				tbUser.setUsername(login);
				tbUser.setAyuda(opcionA);
				
				//Y exactamente la misma l�gica del if
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
			System.out.println("Servlet: Error al cambiar la opci�n de ayuda - " + e.getMessage());
		}
	}

}
