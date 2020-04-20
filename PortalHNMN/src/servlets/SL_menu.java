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
		//
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//Pedimos como par�metro el valor del input hidden, contador, o sea, la cantidad de datos
		//Esto para usarlos como limitante en el for
		int contador = Integer.parseInt(request.getParameter("contador"));
		ArrayList<Tbl_publicaciones> atpus = new ArrayList<Tbl_publicaciones>();
		DT_publicaciones dtpus = new DT_publicaciones();
		
		try {
			
			for(int i = 1; i<contador+1; i++)
			{
				//Vamos creando un objeto de Tbl_publicaciones por cada entrada a guardar
				//Donde s�lo modificaremos lo que dice y el enlace (el menu order se manda, pero nunca se altera, lo ped�
				//por si las moscas, hice lo mismo con el guid, debido a que estos dos par�metros
				//la posici�n y que si ser�n un men�, un item normal, o un item del men� desplegable
				//No se toman en cuenta en la creaci�n del men�, son s�lo para detallar qu� son en el apartado
				//de edici�n del cms, la estructura del men� no es editable).
				Tbl_publicaciones tpus = new Tbl_publicaciones();
				tpus.setPublic_titulo(request.getParameter("texto"+i));
				tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
				tpus.setPublic_enlace(request.getParameter("enlace"+i));
				tpus.setGuid(request.getParameter("guid"+i));
				//Se a�ade el objeto a un ArrayList.
				atpus.add(tpus);
			}
			if(dtpus.modificarMenu(atpus))
			{							
				//Si el m�todo devuelve true, el men� fue actualizado correctamente.
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editMenu.jsp?msj=2");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar el Men�");
		}
	}
}
