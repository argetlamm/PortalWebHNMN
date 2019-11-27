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

/* OBTENEMOS LOS DATOS DEL MENU A SER EDITADOS */
Tbl_publicaciones tpub = new Tbl_publicaciones();
DT_publicaciones dtpb = new DT_publicaciones();
ArrayList<Tbl_publicaciones> listaItems = new ArrayList<Tbl_publicaciones>();
listaItems = dtpb.itemMenu();

String publicado = "publicado";
String item1="", item2="", item3="", item4="", item5="", item6="", item7="", item8="";
for (Tbl_publicaciones tpublc : listaItems){
	if(tpublc.getPublic_estado().trim().equals(publicado)){
		if(tpublc.getMenu_order() == 1){
			item1 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 2){
			item2 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 3){
			item3 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 4){
			item4 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 5){
			item5 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 6){
			item6 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 7){
			item7 = tpublc.getPublic_titulo();
		}else if(tpublc.getMenu_order() == 8){
			item8 = tpublc.getPublic_titulo();
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
                  <div class="form-group">
                    <label for="exampleInputEmail1">Nombre del 1er Item:</label>
                    <input type="text" id="item1" name="item1" class="form-control" value="<%=item1.trim() %>" required>
                    <label for="exampleInputEmail1">Nombre del 2do Item:</label>
                    <input type="text" id="item2" name="item2" class="form-control" value="<%=item2.trim() %>" required>
                    <label for="exampleInputEmail1">Nombre del 3r Item:</label>
                    <input type="text" id="item3" name="item3" class="form-control" value="<%=item3.trim() %>" required>
                    <label for="exampleInputEmail1">Nombre del 4to Item (Menú desplegable):</label>
                    <input type="text" id="item4" name="item4" class="form-control" value="<%=item4.trim() %>" required>
                    <label for="exampleInputEmail1">Nombre del 5to Item (Item del menú desplegable):</label>
                    <input type="text" id="item5" name="item5" class="form-control" value="<%=item5.trim() %>" required>
                    <label for="exampleInputEmail1">Nombre del 6xto Item (Item del menú desplegable):</label>
                    <input type="text" id="item6" name="item6" class="form-control" value="<%=item6.trim() %>" required>
                    <label for="exampleInputEmail1">Nombre del 7mo Item (Item del menú desplegable):</label>
                    <input type="text" id="item7" name="item7" class="form-control" value="<%=item7.trim() %>" required>
                  	<label for="exampleInputEmail1">Nombre del 8vo Item:</label>
                    <input type="text" id="item8" name="item8" class="form-control" value="<%=item8.trim() %>" required>
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
        successAlert('Éxito', 'El menu ha sido modificado!!!');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
      }
    });
    </script>

</body>
</html>