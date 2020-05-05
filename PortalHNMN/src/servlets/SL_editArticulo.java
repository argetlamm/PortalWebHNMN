package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import javax.servlet.http.Part;


/**
 * Servlet implementation class Sl_subirArticuloImagen
 */
@WebServlet("/SL_editArticulo")
@MultipartConfig
public class SL_editArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_editArticulo() {
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
			//Variables necesarias para ambos procesos
			DT_publicaciones dtpub = new DT_publicaciones();
			Tbl_publicaciones tpub = new Tbl_publicaciones();
			
			//Variables necesarias para subir la imagen del artículo
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String path = "";
			String rutaDinamica = "\\img\\articles\\";
			List<FileItem> items = upload.parseRequest(request);
			File fichero = null;
			File fichero2 = null;
			String rutaFichero = null;
			
			//Variables necesarias para subir la información del artículo
			String titulo = "";
			String contenido = "";
			String previa = "";
			String categoria = "";
			String redactor = "";
			String urlArt = "";
			int idArt = 0;
			//Debido a que no se está en servlet 3.0 o más, el .getParameter() no funciona
			//con el multipart/form-data (requerido para subir archivos, en este caso, imágenes)
			//se tiene que recorrer la lista de FileItem "items" creada al inicio
			for(FileItem item : items)
			{
				//Identificar si es formField, o sea, input type="text|radio|checkbox|etc", select, etc
				if(item.isFormField()) 
				{
					//Si lo es, recuperar el fieldName y el String, que serían, el que antes
					//mandábamos como parámetro en el .getParameter() y su valor Respectivamente
					String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                //Y luego comparamos cada parámetro si es el que necesitamos
	                if(fieldName.trim().equals("titulo"))
	                {
	                	titulo = fieldValue;
	                }
	                else
	                {
	                	if(fieldName.trim().equals("contenido"))
	                	{
	                		contenido = fieldValue;
	                		previa ="";
	                		contenido = contenido.replace("\n","<br>");
	                		if(contenido.length()>200)
	            			{
	            				previa = contenido.substring(0, 200);
	            			}
	            			else
	            			{
	            				previa = contenido;
	            			}
	                	}
	                	else
	                	{
	                		if(fieldName.trim().equals("categoria"))
	                		{
	                			categoria = fieldValue;
	                		}
	                		else
	                		{
	                			if(fieldName.trim().equals("redactor"))
		                		{
		                			redactor = fieldValue;
		                		}
	                			else
	                			{
	                				if(fieldName.trim().equals("url"))
	                				{
	                					urlArt = "sin-imagen";
	                				}
	                				else
	                				{
	                					if(fieldName.trim().equals("idArt"))
	                					{
	                						idArt = Integer.parseInt(fieldValue);
	                					}
	                				}
	                			}
	                		}
	                	}
	                }
				}
			}		
			
			//Se comienza el proceso de subir la imagen.
			//Nótese que recorro la lista dos veces, es teoría no es necesario,
			//debería de funcionar mandando este proceso para el else del if(item.isFormField()),
			//pero, como me gusta asegurar, vuelvo a recorrer la lista y comparo si es distinto
			//de formField, o seas, de tipo file, que sería nuestra imagen
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
						//Obtenemos la ruta de la imagen del artículo a editar
						String urlEdit = dtpub.obtenerEnlaceImgArtEdit(idArt);
						//Hacemos un substring para sólo obtener la parte que nos interesa, o sea, qué foto es
						//Ej. img/articles/foto-articulo1.jpg
						//Substring: foto-articulo1.jpg
						rutaFichero = urlEdit.substring(13);
						path = getServletContext().getRealPath("/")+rutaDinamica;
						fichero2 = new File(path+rutaFichero);
						///////// GUARDAR EN EL SERVIDOR //////////////
						uploaded.write(fichero2);
						
						//No es necesario editar la ruta de la imagen ya que será siempre la misma, porque sobreescribimos
						//la imagen, no guardamos una nueva.
						tpub.setGuid(redactor);
						tpub.setPublic_content(contenido);
						tpub.setPublic_titulo(titulo);
						tpub.setPublic_previa(previa);
						tpub.setPublic_tipo(categoria);
						tpub.setMenu_order(idArt);
						
						if(dtpub.editarArticulo(tpub))
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/editArticuloIndividual.jsp?msj=1&idArt="+idArt);
						}
						else 
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/editArticuloIndividual.jsp?msj=2&idArt="+idArt);
						}
					}
					else
					{
						System.out.println("Servidor: Verifique que la imagen del artículo cumpla con los requisitos");
						response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/editArticuloIndividual.jsp?msj=3&idArt="+idArt);						
					}
				}
				else
				{
					tpub.setPublic_imagen_art(urlArt);
					tpub.setGuid(redactor);
					tpub.setPublic_content(contenido);
					tpub.setPublic_titulo(titulo);
					tpub.setPublic_previa(previa);
					tpub.setPublic_tipo(categoria);
					tpub.setMenu_order(idArt);
					
					if(dtpub.editarArticulo(tpub))
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/editArticuloIndividual.jsp?msj=1&idArt="+idArt);
					}
					else 
					{
						response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/editArticuloIndividual.jsp?msj=2&idArt="+idArt);
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Servlet: Error al subir el artículo con imagen" + e.getMessage());
		}
	}

}
