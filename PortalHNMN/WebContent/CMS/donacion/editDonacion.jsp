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
<title>Editar Donaciones | Herbario Nacional de Nicaragua</title>
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

/* OBTENEMOS LOS DATOS DEL MENU A SER EDITADOS */
Tbl_publicaciones tpub = new Tbl_publicaciones();
DT_publicaciones dtpb = new DT_publicaciones();
ArrayList<Tbl_publicaciones> listaDonaciones = new ArrayList<Tbl_publicaciones>();
listaDonaciones = dtpb.itemsDonaciones();

String publicado = "publicado";
String item1="", item2="", item3="";
int item11=0, item22=0, item33=0;
for (Tbl_publicaciones tpublc : listaDonaciones){
	if(tpublc.getPublic_estado().trim().equals(publicado)){
		if(tpublc.getMenu_order() == 1){
			item1 = tpublc.getPublic_content();
			item11 = tpublc.getMenu_order();
		}else if(tpublc.getMenu_order() == 2){
			item2 = tpublc.getPublic_content();
			item22 = tpublc.getMenu_order();
		}else if(tpublc.getMenu_order() == 3){
			item3 = tpublc.getPublic_content();
			item33 = tpublc.getMenu_order();
		}
	}
}

//tpub = dtpb.obtenerMenu(item1);

%>


</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
	<!-- Navbar -->
	  	<jsp:include page="../../CMS/layouts/topbar.jsp"></jsp:include>
	<!-- /.navbar -->
	
	<!-- SIDEBAR -->
	  	<jsp:include page="../../CMS/layouts/menu6.jsp"></jsp:include>
	<!-- SIDEBAR -->
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1>Editar Donaciones</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editDonacion.jsp">Donaciones</a></li>
	              <li class="breadcrumb-item active">Edición de Donaciones</li>
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
              <form role="form" action="${pageContext.request.contextPath}/SL_donaciones" method="post">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Primer párrafo:</label>
                    <input type="text" id="item1" name="item1" class="form-control" value="<%=item1 %>" required>
                    <input type="hidden" id="item11" name="item11" class="form-control" value="<%=item11 %>" required>
                    <label for="exampleInputEmail1">Segundo párrafo:</label>
                     <input type="text" id="item2" name="item2" class="form-control" value="<%=item2 %>" required>
                    <input type="hidden" id="item22" name="item22" class="form-control" value="<%=item22 %>" required>
                    <label for="exampleInputEmail1">Tercer párrafo:</label>
                    <input type="text" id="item3" name="item3" class="form-control" value="<%=item3 %>" required>
                    <input type="hidden" id="item33" name="item33" class="form-control" value="<%=item33 %>" required>
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
        successAlert('Éxito', 'Donaciones se ha editado exitosamente.');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente.');
      }
    });
    </script>

</body>
</html>