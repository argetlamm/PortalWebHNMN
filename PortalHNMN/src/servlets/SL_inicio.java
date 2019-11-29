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

/**
 * Servlet implementation class SL_inicio
 */
@WebServlet("/SL_inicio")
public class SL_inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_inicio() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Tbl_publicaciones tpus1 = new Tbl_publicaciones();
		Tbl_publicaciones tpus2 = new Tbl_publicaciones();
		Tbl_publicaciones tpus3 = new Tbl_publicaciones();
		Tbl_publicaciones tpus4 = new Tbl_publicaciones();
		DT_publicaciones dtpus = new DT_publicaciones();
				
		ArrayList<Tbl_publicaciones> tpus = new ArrayList<Tbl_publicaciones>();
				
		try
		{	
			tpus1.setPublic_content(request.getParameter("item1"));
			tpus1.setMenu_order(Integer.parseInt(request.getParameter("item11")));
			tpus2.setPublic_content(request.getParameter("item2"));
			tpus2.setMenu_order(Integer.parseInt(request.getParameter("item22")));
			tpus3.setPublic_content(request.getParameter("item3"));
			tpus3.setMenu_order(Integer.parseInt(request.getParameter("item33")));
			tpus4.setPublic_content(request.getParameter("item4"));
			tpus4.setMenu_order(Integer.parseInt(request.getParameter("item44")));
			tpus.add(tpus1);
			tpus.add(tpus2);
			tpus.add(tpus3);
			tpus.add(tpus4);

			if(dtpus.modificarInicio(tpus))
			{											
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editInicio.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/menu/editInicio.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar el inicio");
		}
	}

}
