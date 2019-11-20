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
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Control de Roles | Herbario Nacional de Nicaragua</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../plugins/fontawesome-free/css/all.min.css">
  <!-- DataTables -->
  <link href="../plugins/datatables-bs4/css/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- DataTables buttons-->
  <link href="../plugins/DataTablesNew/Buttons-1.5.6/css/buttons.dataTables.min.css" rel="stylesheet">
  <!-- Theme style -->
  <link rel="stylesheet" href="../dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="../dist/css/source-sans-pro.css" rel="stylesheet">
  <link href="../plugins/jAlert/dist/jAlert.css" rel="stylesheet">
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
            <h1>Control de Roles</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="tblRol.jsp">Seguridad</a></li>
              <li class="breadcrumb-item active">Control de Roles</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header" style="text-align:right;">
              <a href="newRol.jsp" class="btn btn-primary">
          	  <i class="fas fa-plus"></i>     Registrar Nuevo Rol</a>
              </div>
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>Id</th>
                  <th>Rol</th>
                  <th>Descripcion</th>
                  <th>Estado</th>
                  <th>Opciones</th>
                </tr>
                </thead>
                <tbody>
                <%
                	DT_rol drol = new DT_rol();
  	        		ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>();
  	        		listRol = drol.listRol();
  	        		
  	        		String estado = "";
  	        		for(Tbl_rol trl : listRol)
  	        		{
  	        			estado = trl.getEstado()==1||trl.getEstado()==2?"ACTIVO":"";
                %>
	                <tr>
	                  <td><%=trl.getId_rol() %></td>
	                  <td><%=trl.getRol_name() %></td>
	                  <td><%=trl.getRol_desc() %></td>
	                  <td><%=estado %></td>
	                  <td>
	                  	<a href="#" onclick="linkEditRol('<%=trl.getId_rol()%>');"><i class="far fa-edit" title="Editar"></i></a>&nbsp;&nbsp;
	                  	<a href="#" onclick="deleteRol('<%=trl.getId_rol()%>');"><i class="far fa-trash-alt" title="Eliminar"></i> </a>
	                  	
	                  </td>
	                </tr>
	             <%
	        		}   
	             %>
                </tbody>
                <tfoot>
                <tr>
                  <th>Id</th>
                  <th>Rol</th>
                  <th>Descripcion</th>
                  <th>Estado</th>
                  <th>Opciones</th>
                </tr>
                </tfoot>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <!-- Footer -->
  	<jsp:include page="/CMS/layouts/footer.jsp"></jsp:include>
  <!-- ./Footer -->
  
  
  
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="../plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<!-- <script src="../plugins/datatables/jquery.dataTables.js"></script> -->
<script src="../plugins/DataTablesNew/DataTables-1.10.18/js/jquery.dataTables.js"></script>
<script src="../plugins/datatables-bs4/js/dataTables.bootstrap4.js"></script>
<script src="../plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="../plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="../plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="../plugins/pdfmake/pdfmake.min.js"></script>
<script src="../plugins/pdfmake/vfs_fonts.js"></script>
<script src="../plugins/jszip/jszip.min.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
<script src="../plugins/jAlert/dist/jAlert.min.js"></script>
<script src="../plugins/jAlert/dist/jAlert-functions.min.js"></script>

<!-- jAlert js -->
<script src="../plugins/jAlert/dist/jAlert.min.js"></script>
<script src="../plugins/jAlert/dist/jAlert-functions.min.js"> </script>

<script>
function linkEditRol(rol)
{
	var idRol = rol;
	window.location.href="${pageContext.request.contextPath}/CMS/seguridad/editRol.jsp?rolID="+idRol;	
}
</script>
<script>
function deleteRol(rol)
{
	var idRol = rol;
	confirm(function(e,btn)
     { 	//event + button clicked
     	e.preventDefault();
     	window.location.href="${pageContext.request.contextPath}/SL_rol?opc=1&rolID="+idRol;
       	//successAlert('Confirmed!');
     }, 
     function(e,btn)
     {
       e.preventDefault();
       //errorAlert('Denied!');
     });
	
}
</script>


<script>
  $(function () {
    $("#example1").DataTable();
//     $('#example2').DataTable({
//       "paging": true,
//       "lengthChange": false,
//       "searching": true,
//       "ordering": false,
//       "info": true,
//       "autoWidth": false,
      
//     });
    $('#example2').DataTable({
        dom: 'Bfrtip',
        buttons: [
        'pdf',
        'excel',
        'print'
        ]

      });
  });
  
</script>
<script>
  $(document).ready(function ()
  {
   
    /////////// VARIABLES DE CONTROL MSJ ///////////
    var msj = 0;
    msj = "<%=mensaje%>";

    if(msj == "1")
    {
      successAlert('Éxito', 'El registro ha sido editado!!!');
    }
    if(msj == "3")
    {
      successAlert('Éxito', 'El registro ha sido eliminado!!!');
    }
    if(msj == "2" || msj == "4")
    {
      errorAlert('Error', 'Revise los datos e intente nuevamente!!!');
    }
    if(msj == "ERROR")
    {
      errorAlert('Error', 'CONSULTE CON EL ADMINISTRADOR DEL SISTEMA!!!');
    }
   
  
    

  });
  </script>
</body>
</html>
