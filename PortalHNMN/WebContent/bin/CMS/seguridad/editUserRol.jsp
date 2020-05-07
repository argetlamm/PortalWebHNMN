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
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="Shortcut Icon" href="${pageContext.request.contextPath}/dist/img/favicon.ico"/>

<title>Editar Rol de Usuario | Herbario Nacional de Nicaragua</title>
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
<!-- <!-- Select2 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
<%
//Recuperamos el valor de la variable msj
String mensaje = "";
mensaje = request.getParameter("msj");
mensaje = mensaje==null?"":mensaje;

//Recuperamos el valor de la variable
String idUserRol = "";
idUserRol = request.getParameter("userRolID");
idUserRol = idUserRol==null?"0":idUserRol;
int userRol = 0;
userRol = Integer.parseInt(idUserRol);
System.out.println("idUserRol en editUserRol.jsp: "+userRol);
//Recuperamos los datos de usuario a ser editado
Tbl_user_rol tur = new Tbl_user_rol();
DT_user_rol dtur = new DT_user_rol();
V_tbl_Usuario_Rol vtur = new V_tbl_Usuario_Rol();
vtur = dtur.obtenerUserRol(userRol);
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
	            <h1>Editar [Rol de Usuario]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="listUserRol.jsp">Seguridad</a></li>
	              <li class="breadcrumb-item active">Edición Rol de Usuario</li>
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
                <h3 class="card-title">Edición de Rol de Usuario</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_user_rol" method="post">
                <div class="card-body">
                  <input name="opc" id="opc" type="hidden" value="2"> <!-- ESTE INPUT ES UTILIZADO PARA EL CASE DEL SERVLET -->
                  <input name="IdUserRol" id="IdUserRol" type="hidden" value="<%=vtur.getId_user_rol()%>"> <!-- ESTE INPUT ES UTILIZADO EL ID_USER A EDITAR -->
                <div class="row">                  	
                  		<div class="col-md-6">
	                  		<div class="input-group mb-3">
		                   	  <label for="exampleInputEmail1">Usuario:</label>
					          <select class="form-control select2" name="user" id="user" style="width: 100%;" required="required">
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
					          <select class="form-control select2" name="rol" id="rol" style="width: 100%;" required="required">
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
    	
    	$("#user").val("<%=vtur.getId_user()%>");
    	$("#rol").val("<%=vtur.getId_rol()%>");
    	$("#idUserRol").val("<%=vtur.getId_user_rol()%>");
    	///////////// VALIDAR QUE LAS CONTRASEÑAS SON LAS MISMAS ///////////////
     
      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('Éxito', 'El registro ha sido modificado!!!');
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