package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.DT_usuario;

/**
 * Servlet implementation class SL_login_usuarios
 */
@WebServlet("/SL_login_usuarios")
public class SL_login_usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_login_usuarios() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
//		doGet(request, response);
		DT_usuario dtus = new DT_usuario();
		String login = "";
		String pwd = "";
		int rolId = 0;
		
		login = request.getParameter("login");
		pwd = request.getParameter("pwd");
		rolId = Integer.parseInt(request.getParameter("rol"));
		
		try
		{
			if(dtus.dtverificarLogin(login, pwd, rolId))
			{
				HttpSession hts = request.getSession(true);
				hts.setAttribute("login", login);
				hts.setAttribute("idRol", rolId);
				System.out.println("hts.getAttribute(\"idRol\") = " + hts.getAttribute("idRol"));
				response.sendRedirect("CMS/sistema.jsp");
				
			}
			else
			{
				response.sendRedirect("index.jsp?msg=ERROR");
			}
		}
		catch(Exception e)
		{
			System.out.println("Servlet: El error es: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
