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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Roles de Usuario | Herbario Nacional de Nicaragua</title>
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
            <h1>Control de Roles de Usuario</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="listUserRol.jsp">Seguridad</a></li>
              <li class="breadcrumb-item active">Lista Roles de Usuario</li>
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
             <a href="addUserRol.jsp" class="btn btn-primary">
          	  <i class="fas fa-plus"></i>     Asignar Rol a Usuario</a>
              </div>            
            <!-- /.card-header -->
            <div class="card-body">
              <table id="example2" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>ID User-Rol</th>
                  <th>ID Usuario</th>
                  <th>Username</th>
                  <th>Password</th>
                  <th>ID Rol</th>
                  <th>Nombre del Rol</th>
                  <th>Opciones</th>
                </tr>
                </thead>
                <tbody>
                <%
                	DT_user_rol dtur = new DT_user_rol();
                     ArrayList<V_tbl_Usuario_Rol> listUsRol = new ArrayList<V_tbl_Usuario_Rol>();
                     listUsRol = dtur.vlistUserRol();
                     	        		
                     	        		
                     for(V_tbl_Usuario_Rol vlistaUserRol : listUsRol)
                     {
                %>
	                <tr>
	                  <td><%=vlistaUserRol.getId_user_rol()%></td>
	                  <td><%=vlistaUserRol.getId_user() %></td>
	                  <td><%=vlistaUserRol.getUsername() %></td>
	                  <td><%=vlistaUserRol.getPassword() %></td>
	                  <td><%=vlistaUserRol.getId_rol()%></td>
	                  <td><%=vlistaUserRol.getRol_name() %></td>
	                  <td style="text-align:center;">
	                  	<a href="#" onclick="linkEditUserRol(<%=vlistaUserRol.getId_user_rol()%>);"><i class="far fa-edit" title="Editar"></i></a>&nbsp;&nbsp;
	                  	<a href="#" onclick="deleteUserRol(<%=vlistaUserRol.getId_user_rol()%>)"><i class="far fa-trash-alt" title="Eliminar"></i> </a>
	                  	
	                  </td>
	                </tr>
	             <%
	        		}   
	             %>
                </tbody>
                <tfoot>
                <tr>
                  <th>ID User-Rol</th>
                  <th>ID Usuario</th>
                  <th>Username</th>
                  <th>Password</th>
                  <th>ID Rol</th>
                  <th>Nombre del Rol</th>
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
function linkEditUserRol(userRol)
{
	var idUserRol = userRol;
	window.location.href="${pageContext.request.contextPath}/CMS/seguridad/editUserRol.jsp?userRolID="+idUserRol;	
}
</script>

<script>
function deleteUserRol(userRolID){
	var idUserRol = userRolID;
	
	confirm(function(e,btn){ 	
     	e.preventDefault();
     	window.location.href="${pageContext.request.contextPath}/SL_user_rol?opc=1&userRolID="+idUserRol;
     }, 
     function(e,btn)
     {
       e.preventDefault();
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