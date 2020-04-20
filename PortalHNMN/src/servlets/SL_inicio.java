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
		
		int contador = Integer.parseInt(request.getParameter("contador"));
		ArrayList<Tbl_publicaciones> listaInicio = new ArrayList<Tbl_publicaciones>();
		DT_publicaciones dtpus = new DT_publicaciones();
		
		try
		{
			for(int i=1; i<contador+1; i++)
			{
				Tbl_publicaciones tpub = new Tbl_publicaciones();
				tpub.setPublic_titulo(request.getParameter("titulo"+i));
				tpub.setPublic_content(request.getParameter("contenido"+i));
				tpub.setPublic_enlace(request.getParameter("url"+i));
				tpub.setPublic_tipo_img(request.getParameter("icon"+i));
				tpub.setMenu_order(Integer.parseInt(request.getParameter("orden"+i)));
				listaInicio.add(tpub);
			}
			if(dtpus.modificarInicio(listaInicio))
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
			System.out.println("Servlet: Error en la edición del inicio- "+ e.getMessage());
		}
		
	}

}
