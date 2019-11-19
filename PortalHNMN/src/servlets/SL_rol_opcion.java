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
       
    public SL_rol_opcion() {
        super();
        // TODO Auto-generated constructor stub
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String opc = request.getParameter("opc");
	int opcion = 0;
								
	opc = opc==null?"0":opc;
	System.out.println("opc: "+opc);
	opcion = Integer.parseInt(opc);
	System.out.println("opcion: "+opcion);
	
	String idEliminar = request.getParameter("rolOpcID");
	int idRolOpc = 0;
								
	idEliminar = idEliminar==null?"0":idEliminar;
	System.out.println("idEliminar: "+idEliminar);
	idRolOpc = Integer.parseInt(idEliminar);
	System.out.println("idRolOpc: "+idRolOpc);
						
	Tbl_rol_opcion trop = new Tbl_rol_opcion();
	DT_rol_opcion dtrop = new DT_rol_opcion();
						
	switch(opcion)
	{
		case 1:
		{
			try
			{
				trop.setId_rol_opcion(idRolOpc);
				
				if(dtrop.eliminarRolOpcion(trop))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/listRolOpcion.jsp?msj=3");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/listRolOpcion.jsp?msj=4");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Servlet: Error al eliminarRolOpcion()");
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
			response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/listRolOpcion.jsp?msj=ERROR");
		}
	}
}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?msj=2");

				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Servlet: Error al guardar rol opcion");
			}
			break;
		case 2:
			try {
				tropc.setId_rol_opcion(Integer.parseInt(request.getParameter("idRolOpc")));
				tropc.setId_rol(Integer.parseInt(request.getParameter("rol")));
				tropc.setId_opc(Integer.parseInt(request.getParameter("opcion")));				
				if(dtropc.editarRolOpcion(tropc))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/editRolOpcion.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/editRolOpcion.jsp?msj=2");

				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Servlet: Error al editar rol opcion 2");
			}
			break;
		default:
			response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?msj=ERROR");
		}
	}

}
