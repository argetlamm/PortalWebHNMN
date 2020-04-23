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
	
	
	
	
						
	Tbl_rol_opcion trop = new Tbl_rol_opcion();
	DT_rol_opcion dtrop = new DT_rol_opcion();
						
	switch(opcion)
	{
		case 1:
		{
			try
			{
				////////////////////Variable de id_rol///////////////////////////////
				String idRolEliminar = request.getParameter("id_rol");
				int id_rol = 0;
											
				idRolEliminar = idRolEliminar==null?"0":idRolEliminar;
				System.out.println("idRolEliminar: "+idRolEliminar);
				id_rol = Integer.parseInt(idRolEliminar);
				System.out.println("id_rol: "+id_rol);
				
				////////////////////Variable de id_opcion///////////////////////////////
				
				String idOpcionEliminar = request.getParameter("id_opcion");
				int id_opcion = 0;
											
				idOpcionEliminar = idOpcionEliminar==null?"0":idOpcionEliminar;
				System.out.println("idOpcionEliminar: "+idOpcionEliminar);
				id_opcion = Integer.parseInt(idOpcionEliminar);
				System.out.println("id_opcion: "+id_opcion);
				
				if(dtrop.eliminarRolOpcion(id_opcion, id_rol))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tbldetalle_rolp.jsp?id_rol="+ id_rol+"&msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/tbldetalle_rolp.jsp?id_rol="+ id_rol+"&msj=2");
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
			try
			{
				////////////////////Variable de id_rol///////////////////////////////
				String idRolAsignar = request.getParameter("id_rol");
				int id_rol = 0;
											
				idRolAsignar = idRolAsignar==null?"0":idRolAsignar;
				System.out.println("idRolAsignar: "+idRolAsignar);
				id_rol = Integer.parseInt(idRolAsignar);
				System.out.println("id_rol: "+id_rol);
				
				////////////////////Variable de id_opcion (Strings) para el asignar rol_opcion/////////////////////////
								
				String idOpcionAsignar = request.getParameter("id_opciones");
				idOpcionAsignar = idOpcionAsignar==null?"0":idOpcionAsignar;
				System.out.println("idOpcionAsignar: "+idOpcionAsignar);
				
					
				if(dtrop.asignarOpcionesARol(id_rol, idOpcionAsignar))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?id_rol="+ id_rol+"&msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?id_rol="+ id_rol+"&msj=2");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Servlet: Error al asignarOpcionesARol()");
			}
			break;
		}
		
		default:
		{
			response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?msj=ERROR");
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
			/*try {
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
			break;*/
		case 2:
		{
			//SIN CODIGO AUN
			break;
		}
		
		default:
			response.sendRedirect(request.getContextPath()+ "/CMS/seguridad/addRolOpcion.jsp?msj=ERROR");
		}
	}

}
