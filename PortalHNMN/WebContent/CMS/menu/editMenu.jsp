<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.DT_publicaciones, java.util.*;"%>

<%
	ArrayList <V_tbl_Rol_Opcion> listOpciones = new ArrayList <V_tbl_Rol_Opcion>();
	//Recuperamos el Arraylist de la sesion creada en sistema.jsp
	listOpciones = (ArrayList <V_tbl_Rol_Opcion>) session.getAttribute("listOpciones");
	//Recuperamos la url de la pag actual
	int index = request.getRequestURL().lastIndexOf("/");
	String miPagina = request.getRequestURL().substring(index+1);
	System.out.println("miPagina ="+miPagina);
	boolean permiso = false;
	String opcionActual = "";
	//Buscamos si el rol tiene permisos para ver esta pagina
	for(V_tbl_Rol_Opcion vro : listOpciones)
	{
		opcionActual = vro.getOpcion().trim();
		System.out.println("opcionActual ="+opcionActual);
		if(opcionActual.equals(miPagina.trim()))
		{
	permiso = true;
	break;
		}
		else
		{
	permiso = false;
		}
		
	}
	
	if(!permiso)
	{
		response.sendRedirect("../Error.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Menu | Herbario Nacional de Nicaragua</title>
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
<!-- jAlert css  -->
<link rel="stylesheet" href="../plugins/jAlert/dist/jAlert.css" />


<%
/* RECUPERAMOS EL VALOR DE LA VARIABLE MSJ */
String mensaje = "";
mensaje = request.getParameter("msj");
mensaje = mensaje==null?"":mensaje;

%>


</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
	<!-- Navbar -->
	  	<jsp:include page="../../CMS/layouts/topbar.jsp"></jsp:include>
	<!-- /.navbar -->
	
	<!-- SIDEBAR -->
	  	<jsp:include page="../../CMS/layouts/menu3.jsp"></jsp:include>
	<!-- SIDEBAR -->
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1>Editar [Menu]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editMenu.jsp">Menu</a></li>
	              <li class="breadcrumb-item active">Edición del Menu</li>
	            </ol>
	          </div>
	        </div>
	      </div><!-- /.container-fluid -->
	    </section>
	
	<!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Edición del Menu</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_menu" method="post">
                <div class="card-body">
                <h3 class="card-title"> Recomendaciones antes de cambiar los enlaces de cada inciso del menú: </h3>
                <br>
                <p>Por favor, no ingrese ningún enlace nuevo, copie y pegue los ya existentes. Aclarar que, al cambiar
                el nombre de algún inciso del menú, su enlace seguirá siendo el mismo, ejemplo: Inicio = index.jsp, también
                note que cada enlace termina en .jsp, por favor, evitar borrar esta extensión, y también tener en cuenta qué
                al cambiar un inciso (cambiarle la posición, no el nombre), su enlace no cambiará automáticamente con él,
                esta acción es manual. La estructura se tiene que mantener de la manera ya existente. 
                O sea, tres incisos estáticos, luego un menú desplegable con tres sub incisos, luego otro inciso estático, 
                y por último, otro menú desplegable con tres sub incisos igual. </p>
                  <div class="form-group">
                   <% 
				    DT_publicaciones dtpb = new DT_publicaciones();
					ArrayList<Tbl_publicaciones> listaItems = new ArrayList<Tbl_publicaciones>();
					listaItems = dtpb.itemMenu();
					
					Collections.sort(listaItems);
					
					String publicado = "publicado";
					String estatico = "estatico";
					String menu = "menu";
					String guid = "";
					String texto = "";
					String enlace = "";
					int id = 0;
					int contador = 0;
					try{
					for (Tbl_publicaciones tpublc: listaItems)
					{
						if(tpublc.getPublic_estado().trim().equals(publicado))
						{
							texto = tpublc.getPublic_titulo();
							enlace = tpublc.getPublic_enlace();
							guid = tpublc.getGuid();
							id = tpublc.getMenu_order();
							contador++;
	                  		if(guid.trim().equals(estatico))
	                  		{
                  %>
              		<label for="exampleInputEmail1">Item #<%=contador %></label>
                    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
                    <label for="exampleInputEmail1">Enlace: </label>
                    <input type="text" id="enlace<%=contador%>" name="enlace<%=contador%>" class="form-control" value="<%=enlace.trim() %>" required>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=id %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guid %>" required>
                    <hr style="border-width:2px;">
                  <%
	                  		}
	                  		else
	                  		{
	                  			if(guid.trim().equals(menu))
	                  			{
                  %>
                  	<label for="exampleInputEmail1">Item #<%=contador %> (Menú desplegable)</label>
                    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
                    <label for="exampleInputEmail1">Enlace: </label>
                    <input type="text" id="enlace<%=contador%>" name="enlace<%=contador%>" class="form-control" value="<%=enlace.trim() %>" required>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=id %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guid %>" required>
                  	<hr style="border-width:2px;">
                  <% 
	                  			}
	                  			else
	                  			{
                  %>
                  	<label for="exampleInputEmail1">Item #<%=contador %> (Item del menú desplegable)</label>
                    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
                    <label for="exampleInputEmail1">Enlace: </label>
                    <input type="text" id="enlace<%=contador%>" name="enlace<%=contador%>" class="form-control" value="<%=enlace.trim() %>" required>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=id %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guid %>" required>
                   	<hr style="border-width:2px;">
                   <% 
		                  			}
		                  		}
							}
						}
					}catch(NullPointerException e)
					{
						e.printStackTrace();
						System.out.println("Error en la creación del formulario del Editar menú");
					}
                   %>
                   <input type="hidden" id="contador" name="contador" class="form-control" value="<%=id %>" required>
                  </div>
                </div>
                <!-- /.card-body -->	
                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Guardar</button>
                  <button type="button" class="btn btn-danger">Cancelar</button>
                </div>
             </form>
            </div>
            <!-- /.card -->
           </div>
          </div>
         </div>       
    </section>
    <!-- /.content -->

</div>
<!-- Footer -->
  		<jsp:include page="/CMS/layouts/footer.jsp"></jsp:include>
  	<!-- ./Footer -->
<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
 <!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
 <!-- jAlert js -->
  <script src="../plugins/jAlert/dist/jAlert.min.js"></script>
  <script src="../plugins/jAlert/dist/jAlert-functions.min.js"> </script>
  <script src="../plugins/select2/js/select2.full.min.js"></script>
  
    
  <script>
    $(document).ready(function ()
    {
	/////////////// ASIGNAR VALORES A LOS CONTROLES AL CARGAR LA PAGINA ///////////////

      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('Éxito', 'El menú ha sido modificado exitosamente.');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
      }
    });
    </script>

</body>
</html>