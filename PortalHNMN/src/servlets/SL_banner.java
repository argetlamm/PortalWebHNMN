package servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import datos.DT_publicaciones;
import entidades.Tbl_publicaciones;
import entidades.Tbl_user;

import java.io.File;
/**
 * Servlet implementation class SL_banner
 */
@WebServlet("/SL_banner")
public class SL_banner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SL_banner() {
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
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		DT_publicaciones dtpub = new DT_publicaciones();
		Tbl_publicaciones tpub = new Tbl_publicaciones();
		// req es la HttpServletRequest que recibimos del formulario.
		// Los items obtenidos serán cada uno de los campos del formulario,
		// tanto campos normales como ficheros subidos.
		List items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Se recorren todos los items, que son de tipo FileItem
		for (Object item : items) {
		   FileItem uploaded = (FileItem) item;

		   // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
		   // subido donde nos interese
		   if (!uploaded.isFormField()) {
		      // No es campo de formulario, guardamos el fichero en algún sitio
		      File fichero = new File("\\Users\\pc\\git\\PortalWebHNMN\\PortalHNMN\\WebContent\\img\\slides\\nivo", uploaded.getName());
		      String fichero1 = fichero.toString();
		      String fichero2 = fichero1.substring(50).trim();
		      String fichero3 = fichero2.replace("\\", "/");
		      try {
				uploaded.write(fichero);
				tpub.setPublic_titulo(fichero3);
				if(dtpub.guardarBanner(tpub))
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/menu/editBanner.jsp?msj=1");
				}
				else
				{
					response.sendRedirect(request.getContextPath()+ "/CMS/menu/editBanner.jsp?msj=2");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   } else {
		      // es un campo de formulario, podemos obtener clave y valor
		      String key = uploaded.getFieldName();
		      String valor = uploaded.getString();
		   }
		}
	}

}
