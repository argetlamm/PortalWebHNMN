package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_user_rol;
import entidades.Tbl_user_rol;

/**
 * Servlet implementation class SL_user_rol
 */
@WebServlet("/SL_user_rol")

public class SL_user_rol extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_user_rol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("Estoy entrando al servlet");
		String opc = request.getParameter("opc");
		int opcion = 0;

		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		Tbl_user_rol tur = new Tbl_user_rol();
		DT_user_rol dtur = new DT_user_rol();
		
		switch(opcion) {
			case 1:{
				try {
					System.out.println("Estoy entrando al case");
					tur.setId_user(Integer.parseInt(request.getParameter("user")));
					tur.setId_rol(Integer.parseInt(request.getParameter("rol")));
					if(dtur.guardarUserRol(tur)) {
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addUserRol.jsp?msj=1");
					}else {
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addUserRol.jsp?msj=2");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Servlet: Error al guardar la relacion de usuario y rol!!!");
				}
				break;
			}
			case 2:{
				try {
					tur.setId_user(Integer.parseInt(request.getParameter("id_user")));
					tur.setId_rol(Integer.parseInt(request.getParameter("id_rol")));					
					
					/*if(dtur.modificarUserRol(tur)) {
						response.sendRedirect("././seguridad/tblUserRol.jsp?msj=1");
					}else {
						response.sendRedirect("././seguridad/editUserRol.jsp?msj=2");
					}*/
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Servlet: Error al modificar la relacion de usuario y rol!!!");
				}
				break;
			}
			default:{
				response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/editRolOpcion.jsp?msj=ERROR");
			}
		}
		
	}


}
