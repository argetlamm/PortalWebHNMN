package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_rol_opcion;
import entidades.Tbl_rol_opcion;

/**
 * Servlet implementation class SL_rol_opcion
 */
@WebServlet("/SL_rol_opcion")
public class SL_rol_opcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_rol_opcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String opc = request.getParameter("opc");
		int opcion = 0;
		
		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		Tbl_rol_opcion tropc = new Tbl_rol_opcion();
		DT_rol_opcion dtropc = new DT_rol_opcion();
		
		switch (opcion) {
		case 1:
			try {
				tropc.setId_rol(Integer.parseInt(request.getParameter("rol")));
				tropc.setId_opc(Integer.parseInt(request.getParameter("opcion")));				
				
				if(dtropc.guardarRolOpcion(tropc))
				{
					response.sendRedirect("./CMS/seguridad/tblOpcion.jsp?msj=1");
				}
				else
				{
					response.sendRedirect("./CMS/seguridad/tblOpcion.jsp?msj=2");
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Servlet: Error al guardar rol opcion");
			}
			break;
		case 2:
			try {
				tropc.setId_rol(Integer.parseInt(request.getParameter("rol")));
				tropc.setId_opc(Integer.parseInt(request.getParameter("opcion")));				
				
				/*if(dtropc.editarRolOpcion(tropc))
				{
					response.sendRedirect("./pages/seguridad/listarRolOpcion.jsp?msj=1");
				}
				else
				{
					//response.sendRedirect("./pages/seguridad/editarRolOpcion.jsp?msj=2");
					response.sendRedirect("./pages/seguridad/listarRolOpcion.jsp?msj=2");
				}*/
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Servlet: Error al editar rol opcion");
			}
			break;
		default:
			response.sendRedirect("../CMS/seguridad/addRolOpcion.jsp?msj=ERROR");
		}
	}

}
