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
 * Servlet implementation class SL_historia
 */
@WebServlet("/SL_historia")
public class SL_historia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_historia() {
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
		DT_publicaciones dtpus = new DT_publicaciones();
		
		ArrayList<Tbl_publicaciones> tpus = new ArrayList<Tbl_publicaciones>();
		
		try
		{	
			tpus1.setPublic_content(request.getParameter("item1"));
			tpus2.setPublic_content(request.getParameter("item2"));
			tpus3.setPublic_content(request.getParameter("item3"));
			
			tpus.add(tpus1);
			tpus.add(tpus2);
			tpus.add(tpus3);

			if(dtpus.modificarHistoria(tpus))
			{											
				response.sendRedirect(request.getContextPath()+ "/CMS/quienesSomos/editHistoria.jsp?msj=1");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/quienesSomos/editHistoria.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar la historia");
		}
	}

}
