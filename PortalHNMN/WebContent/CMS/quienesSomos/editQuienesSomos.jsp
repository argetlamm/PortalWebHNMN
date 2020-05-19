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
<%
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
<title>Editar "¿Quiénes Somos?" | Herbario Nacional de Nicaragua</title>
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

/* OBTENEMOS LOS DATOS DEL QUIENES SOMOS A SER EDITADOS */
Tbl_publicaciones tpub = new Tbl_publicaciones();
DT_publicaciones dtpb = new DT_publicaciones();
ArrayList<Tbl_publicaciones> listaQuienesSomos = new ArrayList<Tbl_publicaciones>();
ArrayList<Tbl_publicaciones> listaAyudas = new ArrayList<Tbl_publicaciones>();
//El método recuperarAyudas() devuelve todos las ayudas del CMS
listaAyudas = dtpb.recuperarAyudas();
//El método quienesSomos() devuelve todos los datos del apartado Quienes Somos (acerca de)
//O sea, quiénes somos, historia, visión y misión
listaQuienesSomos = dtpb.quienesSomos();

String publicado = "publicado";
String quienesSomos = "quienesSomos";
String contenido = "";
String ayudaT = "";
String ayudaC = "";
String imagen = "";
int caracteresIniciales = 0;

//Recorremos la lista
for(Tbl_publicaciones tbpub : listaQuienesSomos)
{
	//Vemos, antes de comparar, que estén como "publicados", o sea, que tengan permitido aparecer
	if(tbpub.getPublic_estado().trim().equals(publicado))
	{
		//Si la variable Guid del objeto a comparar es "quienesSomos", encontramos los datos de este apartado
		if(tbpub.getGuid().trim().equals(quienesSomos))
		{
			//Y asignamos a una variable el contenido (Los párrafos) del objeto
			contenido = tbpub.getPublic_content();
			//Para tener en un inicio la cantidad de caracteres, se hace un .length() a esa variable y el valor 
			//Resultante se le asigna a una variable (usamos el .trim() debido a que, en la base de datos, los
			//saltos de línea se guardan como <br>, entonces, no afecta en el largo de la cadena el quitarlos)
			caracteresIniciales = contenido.trim().length();
			//Luego, en el contenido, reemplazamos los <br>, o sea, los saltos de línea de html, por los saltos de línea
			//de programación, o sea \n
			contenido = contenido.replace("<br>","\n");
			imagen = tbpub.getPublic_enlace();
		}
	}
}

//Recorremos la lista de ayudas
for(Tbl_publicaciones tbpub : listaAyudas)
{
	//Si la variable Guid del objeto a comparar es "quienesSomos", encontramos la ayuda de este apartado
	//Todas las ayudas tienen el mismo public_tipo, o sea, "ayudacms", cada una se diferencia si, por el guid
	if(tbpub.getGuid().trim().equals(quienesSomos))
	{
		//Si encontramos la solicitud, asignamos el título a una variable (que irá entre <h3>)
		ayudaT = tbpub.getPublic_titulo();
		//Y el contenido a otra, acá no es necesario reemplazar los <br> debido a que esto lo imprimimos propiamente
		//en el formulario html
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
	            <h1>Editar [Quiénes Somos]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editQuienesSomos.jsp">¿Quiénes somos?</a></li>
	              <li class="breadcrumb-item active">Edición del "¿Quiénes Somos?"</li>
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
                <h3 class="card-title">Edición del Quienes Somos</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <div id="foto" class="panel">
              <form role="form" name="Frm-foto" action="${pageContext.request.contextPath}/SL_quienesSomos" method="post" enctype="multipart/form-data">
                <div class="card-body">
               <%
               //Si el valor recuperado de ayuda es 1, o sea, que si desea ayuda, se imprimirá los datos recuperados
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
                    <label for="exampleInputEmail1">¿Quiénes Somos?:</label>
                    <textarea id="contenido" name="contenido" class="form-control" rows="4" maxlength="5000" required 
                    onkeyup="contar()" onkeydown="contar()"><%=contenido %></textarea> 
                    
                    <!-- Uso el atributo onkeyup y onkeydown para controlar cada vez que se presiona una tecla en el textarea,
                    o sea, cada vez que se borra o agrega algo. Cada vez que esto pasa, llamo a una función de javascript
                    escrita abajo que cuenta los caracteres -->
                    
                    <br>
                    
                    <!-- Este label comienza con el valor inicial del conteo hecho en la creación del formulario -->
                    
                 	<label style="float:right">Caracteres actuales: <input disabled size="3" value=<%=caracteresIniciales %> id="contador"> </label>
                 	<input type="hidden" id="quienesSomos" name="quienesSomos" class="form-control" value="quienesSomos" required>
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
        successAlert('Éxito', '"¿Quiénes Somos?" se ha editado exitosamente.');
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
    //Acá es la función que se manda a llamar cada vez que se presiona una tecla en el textarea
    function contar() {
    	//Simplemente asigna a una variable el contenido del textarea, con id "contenido"
        var cadena = document.getElementById("contenido").value;
    	//Y luego a otra variable se le asigna el valor devuelvo de la función .length
        var longitud = cadena.trim().length;
        
    	//Y se actualiza el input con el id contador con el nuevo valor de longitud
        document.getElementById("contador").value = longitud;
   	}
	</script>


</body>
</html>