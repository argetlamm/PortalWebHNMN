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
	String ayudaS = "";
	int ayuda = 0;
	int rolId = 0;

	ayudaS = (String) session.getAttribute("ayuda");
	ayudaS = ayudaS==null?"":ayudaS;
	ayuda = Integer.parseInt(ayudaS);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Visi�n | Herbario Nacional de Nicaragua</title>
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

/* OBTENEMOS LOS DATOS DE LA HISTORIA A SER EDITADOS */
Tbl_publicaciones tpub = new Tbl_publicaciones();
DT_publicaciones dtpb = new DT_publicaciones();
ArrayList<Tbl_publicaciones> listaVision = new ArrayList<Tbl_publicaciones>();
ArrayList<Tbl_publicaciones> listaAyudas = new ArrayList<Tbl_publicaciones>();
listaAyudas = dtpb.recuperarAyudas();
listaVision = dtpb.quienesSomos();

String publicado = "publicado";
String vision = "vision";
String contenido = "";
String ayudaT = "";
String ayudaC = "";
String imagen = "";
int caracteresIniciales = 0;

for(Tbl_publicaciones tbpub : listaVision)
{
	if(tbpub.getPublic_estado().trim().equals(publicado))
	{
		if(tbpub.getGuid().trim().equals(vision))
		{
			contenido = tbpub.getPublic_content();
			caracteresIniciales = contenido.trim().length();
			contenido = contenido.replace("<br>","\n");
			imagen = tbpub.getPublic_enlace();
		}
	}
}

for(Tbl_publicaciones tbpub : listaAyudas)
{
	if(tbpub.getGuid().trim().equals(vision))
	{
		ayudaT = tbpub.getPublic_titulo();
		ayudaC = tbpub.getPublic_content();
	}
}

%>


</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
	<!-- Navbar -->
	  	<jsp:include page="../../CMS/layouts/topbar.jsp"></jsp:include>
	<!-- /.navbar -->
	
	<!-- SIDEBAR -->
	  	<jsp:include page="../../CMS/layouts/menu4.jsp"></jsp:include>
	<!-- SIDEBAR -->
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1>Editar [Visi�n]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editVision.jsp">Visi�n</a></li>
	              <li class="breadcrumb-item active">Edici�n de la Visi�n</li>
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
                <h3 class="card-title">Edici�n de la Visi�n</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <div id="foto" class="panel">
              <form role="form" name="Frm-foto" action="${pageContext.request.contextPath}/SL_vision" method="post" enctype="multipart/form-data">
                <div class="card-body">
                <%
               		if(ayuda==1)
               		{
               			%>
			            <h3 class="card-title"><%=ayudaT %></h3>
			            <br>
			            <p><%=ayudaC %></p>
               			<% 
               		}
               	%>      
                  <div class="form-group">
                  <div class="form-group">
                  	<table class="table table-hover table-heading table-datatable" id="datatable-1">
    	                  	<tbody>
    	                  		<tr align="center">
    								<td>
    									<div class="cuadro-fotoNima" align="center">
    										<img id="preview" src="../../<%=imagen %>" name="preview"  alt="Foto NIMA"
    										style="width: 870x; height: 350px; border-bottom-color: white; margin: 2px;" />
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
                    <label for="exampleInputEmail1">Visi�n:</label>
                    <textarea id="contenido" name="contenido" class="form-control" rows="4" maxlength="5000" required 
                    onkeyup="contar()" onkeydown="contar()"><%=contenido %></textarea>
                    <br>
                 	<label style="float:right">Caracteres actuales: <input disabled size="3" value=<%=caracteresIniciales %> id="contador"> </label>
                 	<input type="hidden" id="vision" name="vision" class="form-control" value="vision" required>
                 	<input type="hidden" id="url" name="url" class="form-control" value="<%=imagen %>" required>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Guardar</button>
                  <button type="button" class="btn btn-danger">Cancelar</button>
                </div>
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
      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('�xito', '"Visi�n" se ha editado exitosamente.');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente.');
      }
      if(nuevo == "3")
  	  {
  		errorAlert('Error', 'Revise que la imagen cumpla con el formato requerido.')  
  	  }
    });
    </script>
    
    <script>
    function contar() {
        var cadena = document.getElementById("contenido").value;
        var longitud = cadena.trim().length;
        
        document.getElementById("contador").value = longitud;
   	}
	</script>

</body>
</html>