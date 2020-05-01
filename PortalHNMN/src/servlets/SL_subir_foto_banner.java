package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_publicaciones;
import entidades.Tbl_publicaciones;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class Sl_subir_foto_banner
 */
@WebServlet("/SL_subir_foto_banner")
public class SL_subir_foto_banner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_subir_foto_banner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			DT_publicaciones dtpub = new DT_publicaciones();
			Tbl_publicaciones tpub = new Tbl_publicaciones();
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String path = getServletContext().getRealPath("/");
			List<FileItem> items = upload.parseRequest(request);
			File fichero = null;
			File fichero2 = null;
		
			String rutaFichero = null;
			
			for(FileItem item : items)
			{
				FileItem uploaded = item;
				if(!uploaded.isFormField())
				{
					/////////TAMA�O DEL ARCHIVO ////////
					long size = uploaded.getSize();
					
					/////// GUARDAMOS EN UN ARREGLO LOS FORMATOS QUE SE DESEAN PERMITIR
					List<String> formatos = Arrays.asList("image/jpeg");
					
					////// COMPROBAR SI EL TAMA�O Y FORMATO SON PERMITIDOS //////////
					if(formatos.contains(uploaded.getContentType()))
					{

						int contador = dtpub.obtenerMenuOrder();
						rutaFichero = "foto-banner"+contador+".jpg";
						//path = "C:\\Users\\pc\\git\\PortalWebHNMN\\PortalHNMN\\WebContent\\img\\slides\\nivo\\";
						path = "C:\\Users\\pc\\Desktop\\Programas\\glassfish-5.1.0\\glassfish5\\glassfish\\domains\\domain1\\imagenesBanner\\";
						String url2 = "imagenesBanner/";
						//String url2 = path.substring(52);
						//url2 = url2.replace("\\", "/");
						
						//File image = new File(getServletContext().getInitParameter("upload.location")+rutaFichero);
						
						fichero = new File(url2+rutaFichero);
						fichero2 = new File(path+rutaFichero);
						
						///////// GUARDAR EN EL SERVIDOR //////////////
						uploaded.write(fichero2);

						/////// ACTUALIZAMOS EL CAMPO URLFOTO EN LA BASE DE DATOS
						String url = fichero.toString();
						tpub.setPublic_titulo(url);
						if(dtpub.guardarBanner(tpub))
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/menu/editBanner.jsp?msj=1");
						}
						else 
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/menu/editBanner.jsp?msj=2");
						}
					}
					else
					{
						System.out.println("SERVIDOR: VERIFIQUE QUE EL ARCHIVO CUMPLA CON LAS ESPECIFICACIONES REQUERIDAS!!!");
						response.sendRedirect(request.getContextPath()+ "/CMS/menu/editBanner.jsp?msj=3");						
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("SERVLET: ERROR AL SUBIR LA FOTO: " + e.getMessage());
		}
	}

}
