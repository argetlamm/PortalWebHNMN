package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Tbl_opcion;
import entidades.Tbl_rol;
import datos.DT_opcion;
import datos.DT_rol;
/**
 * Servlet implementation class SL_opcion
 */
@WebServlet("/SL_opcion")
public class SL_opcion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_opcion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String opc = request.getParameter("opc");
		int opcion = 0;
		
		opc = opc==null?"0":opc;
		System.out.println("opc: "+opc);
		opcion = Integer.parseInt(opc);
		System.out.println("opcion: "+opcion);
		
		String idEliminar = request.getParameter("opcID");
		int idOpc = 0;
		
		idEliminar = idEliminar==null?"0":idEliminar;
		System.out.println("idEliminar: "+idEliminar);
		idOpc = Integer.parseInt(idEliminar);
		System.out.println("idUser: "+idOpc);
		
		Tbl_opcion topc = new Tbl_opcion();
		DT_opcion dopc = new DT_opcion();
		
		switch(opcion)
		{
			case 1:
			{
				try
				{
					topc.setId_opcion(idOpc);
					
					if(dopc.eliminarOpcion(topc))
					{
						response.sendRedirect("./pages/seguridad/tblOpcion.jsp?msj=3");
					}
					else
					{
						response.sendRedirect("./pages/seguridad/tblOpcion.jsp?msj=4");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error eliminarOpcion()");
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
				response.sendRedirect("../seguridad/tblopcion.jsp?msj=ERROR");
			}
		}
	}

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
		
		Tbl_opcion top = new Tbl_opcion();
		DT_opcion dopc = new DT_opcion();
		
		switch (opcion) {
			case 1:{
				try {
					top.setOpcion(request.getParameter("opcioname"));
					top.setOpcion_desc(request.getParameter("opciondesc"));
					if(dopc.guardarOpcion(top)) {
						response.sendRedirect("./pages/seguridad/newOpcion.jsp?msj=1");
					}
					else
					{
						response.sendRedirect("./pages/seguridad/newOpcion.jsp?msj=2");
					}
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Servlet: Error al guardar la opcion!!!");
				}
				break;
			}
			case 2:
			{
				try
				{
					top.setId_opcion(Integer.parseInt(request.getParameter("IdOpc")));
					top.setOpcion(request.getParameter("opcioname"));
					top.setOpcion_desc(request.getParameter("opciondesc"));
					
					if(dopc.modificarOpcion(top))
					{
						response.sendRedirect("./pages/seguridad/tblOpcion.jsp?msj=1");
					}
					else
					{
						response.sendRedirect("./pages/seguridad/tblOpcion.jsp?msj=2");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("Servlet: Error al editar la opcion!!!");
				}
				break;
			}
		}	

	}
}
