package servlets;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DT_EmailSessionBean;
import datos.DT_publicaciones;
import datos.DT_usuario;
import entidades.Tbl_publicaciones;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.Part;


/**
 * Servlet implementation class Sl_subirArticuloImagen
 */
@WebServlet("/SL_subirArticuloImagen")
@MultipartConfig
public class SL_subirArticuloImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_subirArticuloImagen() {
        super();
        // TODO Auto-generated constructor stub
    }
    @EJB
    private DT_EmailSessionBean emailBean;
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
			//Variables necesarias para obtener la información para el envío de correos
			String to = "";
	        String nombre = "";
	        String cpCorreo = "";
	        String asunto= "";
	        String remitente = "";
	        String pass = "";
			
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
	                		}
	                	}
	                }
	                if(fieldName.trim().equals("destinoInput")) {
	                	to = fieldValue;
	                } else if(fieldName.trim().equals("nombreCompleto")) {
                		nombre = fieldValue;
                	} else if(fieldName.trim().equals("cuerpoDelCorreo")) {
            			cpCorreo = fieldValue;
            		}else if(fieldName.trim().equals("asunto")) {
            			asunto = fieldValue;
            		} else if(fieldName.trim().equals("correo")) {
    					remitente = fieldValue;
    				}else if(fieldName.trim().equals("password")) {
						pass = fieldValue;
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
						int contador = dtpub.obtenerMenuOrderImgArt();
						rutaFichero = "foto-articulo"+contador+".jpg";
						path = getServletContext().getRealPath("/")+rutaDinamica;
						String url = "img/articles/";
						
						fichero = new File(url+rutaFichero);
						fichero2 = new File(path+rutaFichero);
						System.out.println("Fichero a subir: "+fichero2);
						System.out.println("Fichero a guardar: "+fichero);
						///////// GUARDAR EN EL SERVIDOR //////////////
						uploaded.write(fichero2);

						/////// ACTUALIZAMOS EL CAMPO URLFOTO EN LA BASE DE DATOS
						String url2 = fichero.toString();
						
						tpub.setPublic_imagen_art(url2);
						tpub.setGuid(redactor);
						tpub.setPublic_content(contenido);
						tpub.setPublic_titulo(titulo);
						tpub.setPublic_previa(previa);
						tpub.setPublic_tipo(categoria);
						
						if(dtpub.guardarArticuloImagen(tpub))
						{
							System.out.println("Se guardo el articulo, entramos al proceso de notis");
					        boolean enviado = false;

					        String[] correos = to.split("/");
					        DT_usuario dtus = new DT_usuario();
					        for (String remit : correos ) {
					        	System.out.println("Correo dentro del FOR: "+remit);
					        	if(dtus.obtenerUsername(remit).getNotificacion()==1) {					        		
					        		try {
						        		enviado = emailBean.sendEmail(remit, asunto,"Estimado "+dtus.obtenerUsername(remit).getUsername()+cpCorreo+dtpub.obtenerEnlacePublico().getPublic_enlace(), nombre, remitente, pass);
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
					        	}else {
					        		enviado = true;
					        	}
					        }				
							if(enviado) {
								response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulosImagen.jsp?msj=1");
							} else
							{
								response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulosImagen.jsp?msj=2");
							}	
						}
						else 
						{
							response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulosImagen.jsp?msj=2");
						}
					}
					else
					{
						System.out.println("Servidor: Verifique que la imagen del artículo cumpla con los requisitos");
						response.sendRedirect(request.getContextPath()+ "/CMS/publicaciones/newArticulosImagen.jsp?msj=3");						
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
