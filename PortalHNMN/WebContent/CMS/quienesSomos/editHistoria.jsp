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
<title>Editar Historia | Herbario Nacional de Nicaragua</title>
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
ArrayList<Tbl_publicaciones> listaHistoria = new ArrayList<Tbl_publicaciones>();
listaHistoria = dtpb.quienesSomos();

String publicado = "publicado";
String historia = "historia";
String contenido = "";
int caracteresIniciales = 0;

for(Tbl_publicaciones tbpub : listaHistoria)
{
	if(tbpub.getPublic_estado().trim().equals(publicado))
	{
		if(tbpub.getGuid().trim().equals(historia))
		{
			contenido = tbpub.getPublic_content();
			contenido = contenido.replace("<br>","\n");
			caracteresIniciales = contenido.trim().length();
		}
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
	            <h1>Editar [Historia]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editHistoria.jsp">Historia</a></li>
	              <li class="breadcrumb-item active">Edici�n de la Historia</li>
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
                <h3 class="card-title">Edici�n de la Historia</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_historia" method="post">
                <div class="card-body">
                <h3 class="card-title"> Recomendaciones antes de la edici�n de la historia: </h3>
                <br>
                <p>
                Se recomienda, por cuesti�n de estilo del sitio web, que la cantidad de caracteres no rebase los 1000, luego de los 1000
                hay un peque�o margen, pero el orden del contenido tiende a deformarse. Por favor, evitar propasarse. 
                </p>
                <p>
                Si por casualidad parece ser que la caja de texto no permite escribir m�s, presionar la tecla "Supr" repetidas veces 
                estando posicionado al final de todo el texto; suele pasar que el �rea de texto detecta una cantidad incre�ble de 
                espacios luego del �ltimo punto y esto hace que se bloquee, para resolverlo es simplemente borrar ese espacio, y 
                la tecla "Supr" borra todo lo que est� hacia la derecha, o sea, el espacio.
                </p>
                <p>
                La caja de texto se puede agrandar, s�lo tiene que posicionar el cursor en la parte inferior derecha del espacio de texto
             	clickearlo y posteriormente jalarlo hacia abajo.
                </p>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Historia:</label>
                    <textarea id="contenido" name="contenido" class="form-control" rows="4" maxlength="5000" required 
                    onkeyup="contar()" onkeydown="contar()"><%=contenido %></textarea>
                    <br>
                 	<label style="float:right">Caracteres actuales: <input disabled size="3" value=<%=caracteresIniciales %> id="contador"> </label>
                 	<input type="hidden" id="historia" name="historia" class="form-control" value="historia" required>
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
        successAlert('�xito', '"Historia" se ha editado exitosamente.');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente.');
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