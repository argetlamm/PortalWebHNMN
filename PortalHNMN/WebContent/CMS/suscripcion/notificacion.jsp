<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*"%>
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
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <link rel="Shortcut Icon" href="../dist/img/favicon.ico"/>
  <title>Envío de Notificaciones | Herbario Nacional de Nicaragua</title>

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
    
    String totalCorreos = "";
	totalCorreos = request.getParameter("totalCorreos");
	totalCorreos = totalCorreos==null?"":totalCorreos;
  %>

</head>

<body class="hold-transition sidebar-mini">

<div class="wrapper">

  <!-- Navbar -->
	  	<jsp:include page="../../CMS/layouts/topbar.jsp"></jsp:include>
	<!-- /.navbar -->
	
	<!-- SIDEBAR -->
	  	<jsp:include page="../../CMS/layouts/menu5.jsp"></jsp:include>
	<!-- SIDEBAR -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Envío de Notificaciones</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Suscripción</a></li>
              <li class="breadcrumb-item active">Envío de Notificaciones</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <div class="card card-default">
              <div class="card-header">

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-remove"></i></button>
                </div>
              </div>
              
              <!-- /.card-header -->
              <div class="card-body">
	              <form method="POST" action="${pageContext.request.contextPath}/SL_emailSender" role="form" name="formEstCan" id="formEstCan">
	              
	                <div class="row">
	                  <div class="col-lg-6">
	                    <div class="card card-info">
	                      <div class="card-header">
	                        <h3 class="card-title">Lista de Correos de Usuarios Registrados</h3>
	                      </div>
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
	                        <div class="input-group mb-3">
			                  	<div class="input-group-prepend">
			                    	<span class="input-group-text"><i class="fas fa-envelope"></i></span>
			                    </div>
			                    <input type="text" id="correosEst" name="correosEst" class="agregar form-control" placeholder="Email">
			                  </div>
	                        <button type="button" class="pasar btn btn-block btn-info">Agregar</button>
	                        <!-- /input-group -->
	                      </div>
	                      <!-- /.card-body -->
	                    </div>
	                    <!-- /.card -->
	                  </div>
	
	                  <div class="col-lg-6">
	                    <!-- Horizontal Form -->
	                    <div class="card card-info">
	                      <div class="card-header">
	                        <h3 class="card-title">Correos a enviar</h3>
	                      </div>
	                      <!-- /.card-header -->
	                      <!-- form start -->
	                      <div class="card-body">
	                        <div class="form-group row">
	                          <select name="destino" id="destino" multiple="multiple" class="form-control" size="8">
	                          </select>
	                          <input name="destinoInput" id="destinoInput" type="hidden" required>
	                        </div>
	                        <div class="form-group row">
		                	  <label for="inputName" class="col-sm-4 col-form-label">Total de Correos:</label> 
		                      <div class="col-sm-2">
		                        <input type="text" id="totalCorreos" name="totalCorreos" class="form-control" value="0"  readonly="readonly">
		                      </div>
		               		</div> 
	                      </div>
	                      <!-- /.card-body -->
	                      <div class="card-footer">
	                        <button type="button" class="quitar btn btn-warning">Quitar</button>
	                        <button type="button" class="quitartodos btn btn-danger">Quitar todos</button>
	                      </div>
	                      <!-- /.card-footer -->
	                    </div>
	                    <!-- /.card -->
	                  </div>
	                </div>
	
	                <!-- Main content -->
	                <section class="content">
	                  <div class="row">
	                    <div class="col-md-12">
	                      <div class="card card-primary">
	                        <div class="card-header" style="background-color: rgb(21, 146, 166)">
	                          <h3 class="card-title" >Editar datos de envío</h3>
	
	                            <div class="card-tools">
	                              <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
	                                <i class="fas fa-minus"></i></button>
	                            </div>
	                        </div>
	                        <div class="card-body">
	                          <div class="form-group">
	                            <label for="inputName">Nombre del remitente</label>
	                            <input type="text" id="nombreCompleto" name="nombreCompleto" class="form-control" placeholder="Nombre del remitente" required>
	                          </div>
	                          <div class="form-group">
	                            <label for="inputName">Correo</label>
	                            <input type="email" id="correo" name="correo" class="form-control" placeholder="Correo del remitente" required>
	                          </div>
	                          <div class="form-group">	
	                            <label for="inputName">Contraseña de correo</label>
	                            <input type="password" id="password" name="password" class="form-control" placeholder="Contraseña del correo del remitente" required>
	                            <span style="float: right; margin-right: 5px; margin-top: -25px; position: relative; z-index: 2;"
	                                  toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span>
	                          </div>
	                          <div class="form-group">
	                            <label for="inputName">Asunto</label>
	                            <input type="text" id="asunto"  name="asunto" class="form-control" placeholder="Asunto" required>
	                          </div>
	                          <div class="form-group">
	                            <label for="inputDescription">Cuerpo del Correo </label>
	                            <textarea placeholder="Cuerpo del correo" type="text" name="cuerpoDelCorreo" id="cuerpoDelCorreo" class="form-control" rows="4" required></textarea>
	                          </div>
	                        </div>
	                        <!-- /.card-body -->
	                      </div>
	                      <!-- /.card -->
	                      <!-- /.card-body -->
	                      <div class="card-footer">
	                        <button type="submit" class="enviar btn btn-primary">Enviar correos</button>
	                        <button type="reset" class="cancelar btn btn-danger">Cancelar</button>
	                      </div>
	                      <!-- /.card-footer -->
	                    </div>
	                    <!-- /.card-body -->
	                  </div>
	            </section>
	            <!-- End Main content -->
	
	            </form>
	          </div>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col-md-6 -->
      </div>
      <!-- /.row -->
    </div>
    <!-- /.container-fluid -->
  </div>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->
<!-- Footer -->
<jsp:include page="/CMS/layouts/footer.jsp"></jsp:include>
<!-- ./Footer -->

<!-- ./wrapper -->

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
    /////////// VARIABLES DE CONTROL MSJ ///////////
    var nuevo = 0;
    nuevo = "<%=mensaje%>";
    var totalOptions = 0;
	totalOptions = "<%=totalCorreos%>"

    if(nuevo == "1")
    {
        successAlert('Éxito', 'El correo ha sido enviado a ' + totalOptions + ' usuario(s)');
    }
	if(nuevo == "2")
    {
        errorAlert('Error', 'Credenciales inválidas de autenticación');
    }
});
</script>

</body>
</html>