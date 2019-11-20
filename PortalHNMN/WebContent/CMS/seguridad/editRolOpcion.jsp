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
<title>Editar Opción de Rol | Herbario Nacional de Nicaragua</title>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
<%
  //Recuperamos el valor de la variable msj
  String mensaje = "";
  mensaje = request.getParameter("msj");
  mensaje = mensaje==null?"":mensaje;
  
  //Recuperamos el valor de la variable userID
  String idRolOpc = "";
  idRolOpc = request.getParameter("rolOpcID");
  idRolOpc = idRolOpc==null?"0":idRolOpc;
  int rolOpc = 0;
  rolOpc = Integer.parseInt(idRolOpc);
  System.out.println("idrolOpc en editRolOpcion.jsp: "+rolOpc);
  //Recuperamos los datos de usuario a ser editado
  Tbl_rol_opcion trop = new Tbl_rol_opcion();
  DT_rol_opcion dtrop = new DT_rol_opcion();
  V_tbl_Rol_Opcion vtrop = new V_tbl_Rol_Opcion();
  vtrop = dtrop.obtenerRolOpcion(rolOpc);
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
	            <h1>Editar [Opción de Rol]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="listRolOpcion.jsp">Seguridad</a></li>
	              <li class="breadcrumb-item active">Edición Opción de Rol</li>
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
                <h3 class="card-title">Editar Opción a Rol</h3>

              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_rol_opcion" method="post">
                <div class="card-body">
                  <input name="opc" id="opc" type="hidden" value="2"> <!-- ESTE INPUT ES UTILIZADO PARA EL CASE DEL SERVLET -->
                  <input name="idRolOpc" id="idRolOpc" type="hidden" value="<%=vtrop.getId_rol_opcion()%>">
                  	<div class="row">                  	
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
	                                    
	                   <div class="col-md-6">
	                  		<div class="input-group mb-3">
		                   	  <label for="exampleInputEmail1">Opcion:</label>
					          <select class="form-control select2" name="opcion" id="opcion" style="width: 100%;" required="required">
					            <option value="0">Seleccione una opcion</option>
					            <%
					              DT_opcion dtopc = new DT_opcion();
					              ArrayList<Tbl_opcion> listOpc = new ArrayList<Tbl_opcion>();
					              listOpc = dtopc.listOpc();
					
					              for(Tbl_opcion topc : listOpc)
					              {
					            %>
					            <option value="<%=topc.getId_opcion()%>"><%=topc.getOpcion_desc()%> (<%= topc.getOpcion() %>)</option>
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
    	</div>    
    </section>
    <!-- /.content -->
	
	<!-- Footer -->
	<jsp:include page="/CMS/layouts/footer.jsp"></jsp:include>
	<!-- ./Footer -->

</div>
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
		//Asignar valores a los controles al cargar la pagina
		$("#rol").val("<%=vtrop.getId_rol()%>");
		$("#opcion").val("<%=vtrop.getId_opcion()%>");
		$("#idRolOpc").val("<%=vtrop.getId_rol_opcion()%>");

		
	  /////////// VARIABLES DE CONTROL MSJ ///////////
	  var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('Exito', 'El registro ha sido modificado!!!');
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