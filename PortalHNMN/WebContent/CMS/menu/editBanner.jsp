<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.DT_usuario, java.util.*;"%>

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
<title>Editar Banner | Herbario Nacional de Nicaragua</title>
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

/* RECUPERAMOS EL VALOR DE LA VARIABLE userID */
String idUser = "";
idUser = request.getParameter("userID");
idUser = idUser==null?"0":idUser;

int user = 0;
user = Integer.parseInt(idUser); 

/* OBTENEMOS LOS DATOS DE USUARIO A SER EDITADOS */
Tbl_user tus = new Tbl_user();
DT_usuario dtus = new DT_usuario();

tus = dtus.obtenerUserId(user);

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
	            <h1>Nuevo [Banner]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="tblusuarios.jsp">Inicio</a></li>
	              <li class="breadcrumb-item active">Nueva imagen del banner</li>
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
                <h3 class="card-title">Nueva imagen del Banner</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <br>
         <div id="foto" class="panel">
			<form class="form" name="Frm-foto" method="post" action="${pageContext.request.contextPath}/SL_subir_foto_banner" enctype="multipart/form-data">
				<table class="table table-hover table-heading table-datatable" id="datatable-1">
					<tbody>
						<tr>
							<td>
								<p>
								<b>Estimado usuario, por favor atienda las siguientes recomendaciones para subir su foto:</b>
								</p>
							</td>
						</tr>
						<tr>
							<td>
								<ul>
									<p>Foto de orientaci�n horizontal.</p>
									<p>Formato y dimensiones: el formato debe ser jpg, la foto debe de ser 1900 x 600 px para que se adec�e al tama�o del banner.</p>
								</ul>
							</td>
						</tr>
						<tr align="center">
							<td>
								<div class="cuadro-fotoNima" align="center">
									<img id="preview" src="../../imagenesBanner/foto-banner1.jpg" name="preview"  alt="Foto NIMA"
									style="width: 1000px; height: 350px; border-bottom-color: white; margin: 2px;" />
								</div> &nbsp;
							</td>
						</tr>
						<tr align="center">
							<td>
								<input type="file" id="foto" name="foto"
								onchange="Test.UpdatePreview(this)" required="required">
								&nbsp; <input type="hidden" name="idNIMA" value="">
								&nbsp; <input type="hidden" name="codNIMA" value="">
							</td>
						</tr>
					</tbody>
				</table>
				<input class="action" type="submit" value="Subir imagen"/>
			</form>
		</div>
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
  function pwdEquals()
  {
	  var pwd1 = "";
	  var pwd2 = "";
	  
	  pwd1 = $("#password").val();
	  pwd2 = $("#password2").val();
	  
	  if(pwd1 != pwd2)
	  {
		  errorAlert('Error', 'Revise la contrase�a ingresada');
		  $("#password").css("border-color", "red");
		  $("#password").val("");
		  $("#password2").css("border-color", "red");
		  $("#password2").val("");
	  }
	  else
		{
		  $("#password").css("border-color", "#ced4da");
		  $("#password2").css("border-color", "#ced4da");
		}
		  
  }
  </script>
  
  <script>
    $(document).ready(function ()
    {
    	
    	Test = {
    	        UpdatePreview: function(obj)
    	        {
    	          // if IE < 10 doesn't support FileReader
    	          if(!window.FileReader)
    	          {
    	             
    	          } 
    	          else 
    	          {
    	             var reader = new FileReader();
    	             var target = null;
    	             
    	             reader.onload = function(e) 
    	             {
    	              target =  e.target || e.srcElement;
    	               $("#preview").prop("src", target.result);
    	             };
    	              reader.readAsDataURL(obj.files[0]);
    	          }
    	        }
    	    };

    	///////////// VALIDAR QUE LAS CONTRASE�AS SON LAS MISMAS ///////////////
     
      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('�xito', 'La imagen se ha insertado correctamente en el banner.');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise la imagen insertada e intente de nuevo.');
      }
      if(nuevo == "3")
   	  {
    	errorAlert('Error', 'Revise que la imagen cumpla con el formato requerido.')  
      }
    
      

    });
    </script>

</body>
</html>