package servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import datos.DT_publicaciones;
import entidades.Tbl_publicaciones;

/**
 * Servlet implementation class SL_vision
 */
@WebServlet("/SL_vision")
public class SL_vision extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_vision() {
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
		try
		{
			Tbl_publicaciones tpub = new Tbl_publicaciones();
			DT_publicaciones dpub = new DT_publicaciones();
		
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String path = "";
			String rutaDinamica = "\\img\\quienesSomos\\";
			List<FileItem> items = upload.parseRequest(request);
			File fichero = null;
			File fichero2 = null;
			String rutaFichero = null;
		
			String contenido = "";
			String guid = "";
			String url = "";
			
			for(FileItem item : items)
			{
				if(item.isFormField()) 
				{
					String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                if(fieldName.trim().equals("contenido"))
	                {
	                	contenido = fieldValue;
                		contenido = contenido.replace("\n","<br>");
	                }
	                else
	                {
	                	if(fieldName.trim().equals("vision"))
	                	{
	                		guid = fieldValue;
	                	}
	                	else
	                	{
	                		if(fieldName.trim().equals("url"))
	                		{
	                			url = fieldValue;
	                		}
	                	}
	                }
				}
			}
			
			for(FileItem item : items)
			{
				FileItem uploaded = item;
				if(!uploaded.isFormField())
				{
					/////////TAMAÑO DEL ARCHIVO ////////
					long size = uploaded.getSize();
					
					/////// GUARDAMOS EN UN ARREGLO LOS FORMATOS QUE SE DESEAN PERMITIR
					List<String> formatos = Arrays.asList("image/jpeg");
					
					////// COMPROBAR SI EL TAMAÑO Y FORMATO SON PERMITIDOS //////////
					if(formatos.contains(uploaded.getContentType()))
					{	
						rutaFichero = url.substring(17);
						path = getServletContext().getRealPath("/")+rutaDinamica;
						fichero2 = new File(path+rutaFichero);
						///////// GUARDAR EN EL SERVIDOR //////////////
						uploaded.write(fichero2);
						
						tpub.setPublic_content(contenido);
						tpub.setGuid(guid);
						
						if(dpub.modificarQuienesSomos(tpub))
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/quienesSomos/editVision.jsp?msj=1");
						}
						else 
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/quienesSomos/editVision.jsp?msj=2");
						}
					}
					else
					{
						System.out.println("Servidor: Verifique que la imagen de la visión cumpla con los requisitos");
						response.sendRedirect(request.getContextPath()+ "/CMS/quienesSomos/editVision.jsp?msj=3");						
					}
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Servlet: Error al editar la Visión");
		}
	}

}
