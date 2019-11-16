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
<title>Editar Rol del Usuario</title>
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

/* RECUPERAMOS EL VALOR DE LA VARIABLE userRolID */
String idUserRol = "";
idUserRol = request.getParameter("userRolID");
idUserRol = idUserRol==null?"0":idUserRol;

int userRol = 0;
userRol = Integer.parseInt(idUserRol); 

/* OBTENEMOS LOS DATOS DE USER-ROL A SER EDITADOS */
Tbl_user_rol tur = new Tbl_user_rol();
DT_user_rol dtur = new DT_user_rol();

tur = dtur.obtenerUserRol(userRol);

%>


</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
	<!-- Navbar -->
	  	<jsp:include page="/CMS/layouts/topbar.jsp"></jsp:include>
	<!-- /.navbar -->
	
	<!-- SIDEBAR -->
	  	<jsp:include page="/CMS/layouts/menu2.jsp"></jsp:include>
	<!-- SIDEBAR -->
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1>Edición [Rol de Usuario]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="listUserRol.jsp">Seguridad</a></li>
	              <li class="breadcrumb-item active">Edición de Rol de Usuario</li>
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
                  <input name="IdUserRol" id="IdUserRol" type="hidden"> <!-- ESTE INPUT ES UTILIZADO EL ID_USER A EDITAR -->
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
	
	<!-- Footer -->
  		<jsp:include page="/CMS/layouts/footer.jsp"></jsp:include>
  	<!-- ./Footer -->

</div>
<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>

<!-- jAlert js -->
  <script src="../plugins/jAlert/dist/jAlert.min.js"></script>
  <script src="../plugins/jAlert/dist/jAlert-functions.min.js"> </script>
  
  
  <script>
    $(document).ready(function ()
    {
		/////////////// ASIGNAR VALORES A LOS CONTROLES AL CARGAR LA PAGINA ///////////////
    	
    	$("#user").val("<%=tur.getId_user()%>");
    	$("#rol").val("<%=tur.getId_rol()%>");
    	
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
    
      

    });
    </script>

</body>
</html>