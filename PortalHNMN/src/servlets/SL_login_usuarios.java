package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.DT_usuario;
import datos.DT_user_rol;
import entidades.Tbl_user;
import entidades.V_tbl_Usuario_Rol;

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
		DT_user_rol dtur = new DT_user_rol();
		String login = "";
		String pwd = "";
		
		login = request.getParameter("login");
		pwd = request.getParameter("pwd");
		
		try
		{
			if(dtus.dtverificarLogin(login, pwd))
			{
				Tbl_user user = dtus.obtenerUserLogin(login);
				int idUser = user.getId_user();
				
				V_tbl_Usuario_Rol userrol = dtur.getUserRol(idUser);
				
				int tipo_rol = userrol.getTipo_rol();
				System.out.println("IDUSER: "+idUser);
				System.out.println("TIPOROL: "+tipo_rol);
				if(tipo_rol==1) {
					int ayuda = user.getAyuda();
					String ayudaString = Integer.toString(ayuda);
					String nombre = user.getNombre1();
					String apellido = user.getApellido1();
					HttpSession hts = request.getSession(true);
					hts.setAttribute("login", login);
					hts.setAttribute("idRol", 1);
					hts.setAttribute("ayuda", ayudaString);
					hts.setAttribute("nombre", nombre);
					hts.setAttribute("appelido", apellido);
					response.sendRedirect("CMS/sistema.jsp");
				}else {
					HttpSession hts = request.getSession(true);
					hts.setAttribute("login", login);
					response.sendRedirect(request.getContextPath()+ "/index.jsp?msj=1");
				}				
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/index.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			System.out.println("Servlet: El error es: "+e.getMessage());
			e.printStackTrace();
		}
		
	}

}
