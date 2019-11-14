package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Tbl_rol;
import entidades.Tbl_user;
import datos.DT_rol;
import datos.DT_usuario;
/**
 * Servlet implementation class SL_rol
 */
@WebServlet("/SL_rol")
public class SL_rol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_rol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		String opc = request.getParameter("opc");
		int opcion = 0;
		
		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		String idEliminar = request.getParameter("rolID");
		int idRol = 0;
		
		idEliminar = idEliminar==null?"0":idEliminar;
		System.out.println("idEliminar: "+idEliminar);
		idRol = Integer.parseInt(idEliminar);
		System.out.println("idUser: "+idRol);
		
		Tbl_rol trl = new Tbl_rol();
		DT_rol drol = new DT_rol();
		
		switch(opcion)
		{
			case 1:
			{
				try
				{
					trl.setId_rol(idRol);
					
					if(drol.eliminarRol(trl))
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblRol.jsp?msj=3");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblRol.jsp?msj=4");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error eliminarRol()");
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
				response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblrol.jsp?msj=ERROR");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String opc = request.getParameter("opc");
		int opcion = 0;

		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		Tbl_rol trl = new Tbl_rol();
		DT_rol drol = new DT_rol();
		
		switch (opcion) {
			case 1:{
				try {
					trl.setRol_name(request.getParameter("rolname"));
					trl.setRol_desc(request.getParameter("roldesc"));
					if(drol.guardarRol(trl)) {
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/newRol.jsp?msj=1");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/newRol.jsp?msj=2");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Servlet: Error al guardar el rol!!!");
				}
				break;
			}
			case 2:
			{
				try
				{
					trl.setId_rol(Integer.parseInt(request.getParameter("IdRol")));
					trl.setRol_name(request.getParameter("rolname"));
					trl.setRol_desc(request.getParameter("roldesc"));
					
					if(drol.modificarRol(trl))
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblRol.jsp?msj=1");
					}
					else
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tblRol.jsp?msj=2");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error al editar el rol!!!");
				}
				break;
			}
			
			default:
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/newRol.jsp?msj=ERROR");
			}
		}
	}

}
