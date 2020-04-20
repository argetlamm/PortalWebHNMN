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
 * Servlet implementation class SL_footer
 */
@WebServlet("/SL_footer")
public class SL_footer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_footer() {
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
		//Creamos los dos ArrayList, uno para los items y otro para los títulos
		ArrayList<Tbl_publicaciones> items = new ArrayList<Tbl_publicaciones>();
		ArrayList<Tbl_publicaciones> titulos = new ArrayList<Tbl_publicaciones>();
		//Creamos una variable tipo que compararemos para saber qué agregaremos a cuál ArrayList
		String tipo = "";
		String contenido ="";
		DT_publicaciones dtpus = new DT_publicaciones();
		
		try {
			for(int i = 1; i<contador+1; i++)
			{
				Tbl_publicaciones tpus = new Tbl_publicaciones();
				tipo = request.getParameter("tipo"+i);
				//Creamos el objeto a agregar al arreglo y recuperamos el tipo específico 
				//Este es almacenado en la base de datos como public_tipo y se guardaba en el fomulario
				//editFooter en un input insivible con nombre "tipoN".
				if(tipo.trim().equals("footerT"))
				{
					//Si el tipo es un título, este se agrega al ArrayList de títulos
					tpus.setPublic_titulo(request.getParameter("texto"+i));
					tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
					titulos.add(tpus);
				}
				else
				{
					tipo = request.getParameter("tipo"+i);
					//Si no es un título, entrará al else, pero igual se compara, por si acaso
					//si es un item del footer
					if(tipo.trim().equals("itemf"))
					{
						//Si lo es, solicitamos el guid, para realizar acciones específicas para cada caso
						String guid = request.getParameter("guid"+i);
						if(guid.trim().equals("parrafo"))
						{
							//Si es un párrafo, se tienen que reemplazar, del contenido, los saltos de línea 
							//De programación \n por los <br> de html.
							contenido = request.getParameter("texto"+i);
							contenido = contenido.replace("\n", "<br>");
							tpus.setGuid(guid);
							tpus.setPublic_content(contenido);
							tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
							//Y posteriormente se agrega al ArrayList del items
							items.add(tpus);
						}
						else
						{
							if(guid.trim().equals("enlace"))
							{
								//Si es un enlace, se tiene que solicitar el enlace de cada texto
								//Prefiero no hacerlo general para evitar algún nullPointerException
								//en los casos que no tenga enlace (como los párrafos y la lista normal)
								//Prefiero esto a guardar en la base de datos un #.
								tpus.setGuid(guid);
								tpus.setPublic_titulo(request.getParameter("texto"+i));
								tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
								tpus.setPublic_enlace(request.getParameter("enlace"+i));
								items.add(tpus);
							}
							else
							{
								//Si es una lista común, sólo se solicitará el texto y el menu_order
								tpus.setGuid(guid);
								tpus.setPublic_titulo(request.getParameter("texto"+i));
								tpus.setMenu_order(Integer.parseInt(request.getParameter("id"+i)));
								items.add(tpus);
							}
						}
					}
				}
			}
			if(dtpus.modificarItemsFooter(items))
			{							
				//Si los items se guardan correctamente
				if(dtpus.modificarTitulosFooter(titulos))
				{
					//Y los títulos, daremos un mensaje de confirmación.
					//No importa mucho el orden si se modifican primeramente los títulos o los items.
					response.sendRedirect(request.getContextPath()+ "/CMS/footer/editFooter.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/footer/editFooter.jsp?msj=2");
				}
			}
			else
			{
				response.sendRedirect(request.getContextPath()+ "/CMS/footer/editFooter.jsp?msj=2");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar el Footer" + e);
		}
	}

}
