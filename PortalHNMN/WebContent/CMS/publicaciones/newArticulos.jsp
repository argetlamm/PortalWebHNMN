<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>

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

<%
	String nombre = "";
	String apellido = "";
	int rolId = 0;

	nombre = (String) session.getAttribute("nombre");
	nombre = nombre==null?"":nombre;
	apellido = (String) session.getAttribute("apellido");
	apellido = apellido==null?"":apellido;
	String nombreCompleto = nombre+apellido;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo artículo | Herbario Nacional de Nicaragua</title>
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
	  	<jsp:include page="../../CMS/layouts/menu7.jsp"></jsp:include>
	<!-- SIDEBAR -->
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1>Nuevo [Artículo - Sólo texto]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editMenu.jsp">Publicaciones</a></li>
	              <li class="breadcrumb-item active">Nuevo artículo - Sólo texto</li>
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
                <h3 class="card-title">Nuevo artículo (Sólo texto)</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_nuevoArticulo" method="post">
                <div class="card-body">
                  <div class="form-group">
                  	<label for="exampleInputEmail1">Título del artículo: </label>
                    <input type="text" id="titulo" name="titulo" class="cargaAutom form-control" value="" required>
                    <label for="exampleInputEmail1">Contenido del artículo: </label>
                    <textarea id="contenido" name="contenido" class="form-control" rows="5" maxlength="5000" required></textarea>
					<label for="exampleInputEmail1">Categoría del artículo: </label>
					<input type="text" id="categoria" name="categoria" class="form-control" value="" placeholder="Se recomienda poner la Categoría en mayúsculas, evitando el uso de palabras con tilde" required>
                    <label for="exampleInputEmail1">Artículo creado por: <%=nombreCompleto%></label>
                    <input type="hidden" id="redactor" name="redactor" class="form-control" value="<%=nombreCompleto%>" required>
                  </div>
                </div>
                <div class="card-body" style="display: none;">
	                <div class="row">
	                  <div class="col-lg-6">
	                    <div class="card card-info">
	                      <div class="card-body">
	                        <div class="form-group row">
	                          <select name="origen" id="origen"  multiple="multiple" class="form-control" size="8">
	                          <%
			                    DT_usuario dtus = new DT_usuario();
				        		ArrayList<Tbl_user> listEmail = new ArrayList<Tbl_user>();
				        		listEmail = dtus.listUser();
				        		int value = 0; 
				        		String estado = "";
				        		for(Tbl_user tus : listEmail)
				        		{
				        			value = value+1;
				        			System.out.println("valor de value: "+value);
				        			estado = tus.getEstado()==1||tus.getEstado()==2?"ACTIVO":"";
				              %>
				                <option><%=tus.getEmail()%></option>
					          <%
				        		}   
					          %>
	                          </select>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                  <div class="col-lg-6">
	                    <div class="card card-info">
	                      <div class="card-body">
	                        <div class="form-group row">
	                          <input name="destinoInput" id="destinoInput"required>
	                        </div>
	                        <div class="form-group row">
		                	  <label for="inputName" class="col-sm-4 col-form-label">Total de Correos:</label> 
		                      <div class="col-sm-2">
		                        <input type="text" id="totalCorreos" name="totalCorreos" class="form-control" value="0"  readonly="readonly">
		                      </div>
		               		</div> 
	                      </div>
	                    </div>
	                  </div>
	                </div>
	                <!-- Main content -->
	                <section class="content">
	                  <div class="row">
	                    <div class="col-md-12">
	                      <div class="card card-primary">
	                        <div class="card-body">
	                          <div class="form-group">
	                            <label for="inputName">Nombre del remitente</label>
	                            <input type="text" id="nombreCompleto" name="nombreCompleto" class="form-control" value="Herbario Nacional - UCA" required>
	                          </div>
	                          <div class="form-group">
	                            <label for="inputName">Correo</label>
	                            <input type="email" id="correo" name="correo" class="form-control" value="temporalherbariouca@gmail.com" required>
	                          </div>
	                          <div class="form-group">	
	                            <label for="inputName">Contraseña de correo</label>
	                            <input type="text" id="password" name="password" class="form-control" value="Usuario123#." required>
	                          </div>
	                          <div class="form-group">
	                            <label for="inputName">Asunto</label>
	                            <input type="text" id="asunto"  name="asunto" class="form-control" required>
	                          </div>
	                          <div class="form-group">
	                            <label for="inputDescription">Cuerpo del Correo </label>
	                            <textarea type="text" name="cuerpoDelCorreo" id="cuerpoDelCorreo" class="form-control" rows="4"
	                            >, tenemos una publicación nueva en el sitio, puedes acceder a ella a través del siguiente enlace: </textarea>
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	            </section>
	            <!-- End Main content -->
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

<!-- Funcionalidad de componentes js -->
<script src="../dist/js/suscripcion/funcionalidad-componentes.js" charset="UTF-8"></script> 
     
  <script>
    $(document).ready(function ()
    {
	/////////////// ASIGNAR VALORES A LOS CONTROLES AL CARGAR LA PAGINA ///////////////

      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('Éxito', 'El artículo ha sido agregado exitosamente');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'No se pudo crear el artículo.');
      }
    });
    </script>

</body>
</html>