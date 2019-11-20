<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>

<%
	ArrayList<V_tbl_Rol_Opcion> listOpciones = new ArrayList <V_tbl_Rol_Opcion>();
	//Recuperamos el Arraylist de la sesion creada en sistema.jsp
	listOpciones = (ArrayList<V_tbl_Rol_Opcion>) session.getAttribute("listOpciones");
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
		System.out.println("opcionActual = "+opcionActual);
		System.out.println("mipagina =" + miPagina);
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
<title>Agregar Rol a Usuario | Herbario Nacional de Nicaragua</title>
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
<!-- Select2 -->
<!-- <link rel="stylesheet" href="../plugins/select2/css/select2.min.css"> -->
<!-- <link rel="stylesheet" href="../plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css"> -->


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
	            <h1>Registro [Nuevo Rol a Usuario]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a>Seguridad</a></li>
	              <li class="breadcrumb-item active">Asignar Rol a Usuario</li>
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
                <h3 class="card-title">Nuevo Usuario Rol</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_user_rol" method="post">
                <div class="card-body">
                  <input name="opc" id="opc" type="hidden" value="1"> <!-- ESTE INPUT ES UTILIZADO PARA EL CASE DEL SERVLET -->
                  
                  	<div class="row">                  	
                  		<div class="col-md-6">
	                  		<div class="input-group mb-3">
		                   	  <label for="exampleInputEmail1">Usuario:</label>
					          <select class="form-control select2" name="user" style="width: 100%;" required="required">
					            <option value="0">Seleccione un usuario</option>
					            <%
            					DT_usuario dtus = new DT_usuario();
            	    			ArrayList<Tbl_user> listUser = new ArrayList<Tbl_user>();
            	   				listUser = dtus.listUser();
            	    
            	    			for(Tbl_user tus : listUser)
            	    			{
	            				%>
	            		 		<option value="<%=tus.getId_user()%>"><%=tus.getUsername() %> </option>
	            				<%	
	            					} 
	            				%>
					          </select>
					        </div>
	                  	</div>
	        		<div class="col-md-6">
	                  		<div class="input-group mb-3">
		                   	  <label for="exampleInputEmail1">Rol:</label>
					          <select class="form-control select2" name="rol" style="width: 100%;" required="required">
					            <option value="0">Seleccione un rol</option>
					            <%
					              DT_rol dtr = new DT_rol();
					              ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
					              listRol = dtr.listRol();
					
					              for(Tbl_rol tr : listRol)
					              {
					            %>
					            <option value="<%=tr.getId_rol()%>"><%=tr.getRol_name() %></option>
					            <%
					              }
					            %>
					          </select>
					        </div>
	                  	</div>
                </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Guardar</button>
                  <button type="reset" class="btn btn-danger">Cancelar</button>
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
     
      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";
      if(nuevo == "1")
      {
        successAlert('�xito', 'El nuevo registro ha sido almacenado!!!');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
      }
      if(nuevo == "3")
      {
        successAlert('Exito', 'El registro ha sido eliminado!!!');
      }
      if(nuevo == "4")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
      }
    
      
    });
    </script>
</body>
</html>