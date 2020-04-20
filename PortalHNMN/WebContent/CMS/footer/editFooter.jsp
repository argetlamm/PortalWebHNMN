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
<title>Editar Footer | Herbario Nacional de Nicaragua</title>
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

DT_publicaciones dtpub = new DT_publicaciones();
ArrayList<Tbl_publicaciones> listaAyudas = new ArrayList<Tbl_publicaciones>();
listaAyudas = dtpub.recuperarAyudas();

String ayudaT = "";
String ayudaC = "";
String footerT = "footer";

for(Tbl_publicaciones tbpub : listaAyudas)
{
	if(tbpub.getGuid().trim().equals(footerT))
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
	  	<jsp:include page="../../CMS/layouts/menu8.jsp"></jsp:include>
	<!-- SIDEBAR -->
	
	  <!-- Content Wrapper. Contains page content -->
	  <div class="content-wrapper">
	    <!-- Content Header (Page header) -->
	    <section class="content-header">
	      <div class="container-fluid">
	        <div class="row mb-2">
	          <div class="col-sm-6">
	            <h1>Editar [Footer]</h1>
	          </div>
	          <div class="col-sm-6">
	            <ol class="breadcrumb float-sm-right">
	              <li class="breadcrumb-item"><a href="editFooter.jsp">Footer</a></li>
	              <li class="breadcrumb-item active">Edición del Footer</li>
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
                <h3 class="card-title">Edición del Footer</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form role="form" action="${pageContext.request.contextPath}/SL_footer" method="post">
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
                   <% 
				    DT_publicaciones dtpb = new DT_publicaciones();
					ArrayList<Tbl_publicaciones> listaItems = new ArrayList<Tbl_publicaciones>();
					ArrayList<Tbl_publicaciones> listaTitulos = new ArrayList<Tbl_publicaciones>();
					listaItems = dtpb.itemsFtr();
					listaTitulos = dtpb.titulosFtr();
					//Acá trabajamos con dos listas, la de los items de cada "espacio" del footer
					//Y la de los títulos 
					//Acá sólo está explicado las diferencias con el editMenu, para mejor explicación,
					//lean los comentarios del editMenu.jsp
					Collections.sort(listaItems);
					Collections.sort(listaTitulos);
					
					String publicado = "publicado";
					String parrafo = "parrafo";
					String enlace = "enlace";
					//Utilizo dos variables debido a que, por cada título hay uno o más items, entonces
					//Las variables  a comprar del título deben de ser constantes hasta pasar al siguiente apartado
					//Del footer, o sea, hacia otro título, mientras que la de los items deberían de ir variando.
					//En teoría, con el .sort de la listaItems, tendría que tenerlos en el orden del footer, pero
					//Para no arriesgar, hago las comparaciones adecuadas.
					String guidT = "", guidI = "";
					String nameT = "", nameI ="";
					String texto = "";
					String url = "";
					String tipo = "";
					int idT = 0, idI = 0;
					int contador = 0, contadorM = 0, contadorT=0;
					try{
					for (Tbl_publicaciones tpublc: listaTitulos)
					{
						if(tpublc.getPublic_estado().trim().equals(publicado))
						{
							//Para cada título, que tendrá items debajo, crearemos su debido espacio
							contadorM = 0;
							texto = tpublc.getPublic_titulo();
							guidT = tpublc.getGuid();
							idT = tpublc.getMenu_order();
							nameT = tpublc.getPublic_name();
							tipo = tpublc.getPublic_tipo();
							contadorT++;
	                  		if(guidT.trim().equals(parrafo))
	                  		{
	                  			//El contador sólo aumenta hasta crear el espacio adecuado 
	                  			//según el guid, o sea, si lo que posee debajo es un párrafo simple
	                  			//si posee una lista de enlaces debajo o si posee una lista simple)
								//Notarlo en el título
	                  			contador++;
	                  		%>
					<label for="exampleInputEmail1">Título #<%=contadorT %> (Con párrafo debajo)</label>
                    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=idT %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guidT %>" required>
					<input type="hidden" id="tipo<%=contador%>" name="tipo<%=contador%>" class="form-control" value="<%=tipo %>" required>
	                  			<%
	                  			for(Tbl_publicaciones tbpublc: listaItems)
	                  			{
	                  				//Luego, al crear el espacio para el título que posea párrafo debajo
	                  				//Procedemos a recorrer la lista de los items para encontrar él 
	                  				//párrafo que está debajo
	                  				if(tbpublc.getPublic_estado().trim().equals(publicado))
	                  				{
	                  					texto = tbpublc.getPublic_content();
	                  					guidI = tbpublc.getGuid();
	          							idI = tbpublc.getMenu_order();
	          							nameI = tbpublc.getPublic_name();
	          							tipo = tbpublc.getPublic_tipo();
	                  					if(guidI.trim().equals(guidT.trim()))
	                  					{
	                  						//Donde, si guid del item es igual al guid del título
	                  						if(nameT.trim().equals(nameI.trim()))
	                  						{
	                  							//E igual si su nombre es igual 
	                  							//(Uso dos variables para comparar debido a que hay dos tipos
	                  							//de listas con enlaces, enlaces externos al sitio web y enlaces del sitio)
	                  							texto = texto.replace("<br>","\n");
	                  							//Utilizo un nuevo contador para ver la cantidad de items por título
	                  							//Pero siempre aumento el contador normal para ver cuándo items estoy
	                  							//mandado a editar al servlet
	                  							contadorM++;
	                  							contador++;
	                  							%>
	                <label for="exampleInputEmail1">Item #<%=contadorM %> (Párrafo)</label>
                    <textarea id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" rows="5" maxlength="5000" 
                    required><%=texto.trim() %> </textarea>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=idI %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guidI %>" required>
	               	<input type="hidden" id="tipo<%=contador%>" name="tipo<%=contador%>" class="form-control" value="<%=tipo %>" required>
	                  							<% 
	                  						}
	                  					}
	                  				}
	                  			}
	                  		}
	                  		else
	                  		{
	                  			if(guidT.trim().equals(enlace))
	                  			{
	                  				//Ahora, si el título posee enlaces debajo
	                  				contador++;
                  %>
                  	<hr style="border-width:2px;">
                  	<label for="exampleInputEmail1">Título #<%=contadorT %> (Con enlaces debajo)</label>
                    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=idT %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guidT %>" required>
             		<input type="hidden" id="tipo<%=contador%>" name="tipo<%=contador%>" class="form-control" value="<%=tipo %>" required>
                  <% 
				                  	for(Tbl_publicaciones tbpublc: listaItems)
				        			{
				        				if(tbpublc.getPublic_estado().trim().equals(publicado))
				        				{
				        					texto = tbpublc.getPublic_titulo();
				        					guidI = tbpublc.getGuid();
											idI = tbpublc.getMenu_order();
											nameI = tbpublc.getPublic_name();
											tipo = tbpublc.getPublic_tipo();
				        					if(guidI.trim().equals(guidT.trim()))
				        					{
				        						//Al saber que es un item con enlace, se asigna su valor a la variable url
				        						url = tbpublc.getPublic_enlace();
				        						if(nameT.trim().equals(nameI.trim()))
				        						{
				        							//Y luego comparamos si es un enlace externo o uno del propio sitio
				        							contadorM++;
				        							contador++;
				        							%>
				 	<label for="exampleInputEmail1">Item #<%=contadorM %> (Item con enlace)</label>
				    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
				    <label for="exampleInputEmail1">Enlace: </label>
                    <input type="text" id="enlace<%=contador%>" name="enlace<%=contador%>" class="form-control" value="<%=url.trim() %>" required>
			        <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=idI %>" required>
			        <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guidI %>" required>
				    <input type="hidden" id="tipo<%=contador%>" name="tipo<%=contador%>" class="form-control" value="<%=tipo %>" required>
				        							<% 
				        						}
				        					}
				        				}
				        			}
	                  			}
	                  			else
	                  			{
	                  				//Se aumenta el contador debido a que sólo hay tres opciones, párrafo, lista de
	                  				//enlaces, y esta última, lista "simple"
	                  				contador++;
                  %>
                  	<hr style="border-width:2px;">
                  	<label for="exampleInputEmail1">Título #<%=contadorT %> (Con una lista debajo)</label>
                    <input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
                    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=idT %>" required>
                    <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guidT %>" required>
                   	<input type="hidden" id="tipo<%=contador%>" name="tipo<%=contador%>" class="form-control" value="<%=tipo %>" required>
                   <% 
                   					for(Tbl_publicaciones tbpublc: listaItems)
                   					{
                   						texto = tbpublc.getPublic_titulo();
			        					guidI = tbpublc.getGuid();
										idI = tbpublc.getMenu_order();
										nameI = tbpublc.getPublic_name();
										tipo = tbpublc.getPublic_tipo();
										if(tbpublc.getPublic_estado().trim().equals(publicado))
										{
											if(guidI.trim().equals(guidT.trim()))
				        					{ 
				        						if(nameT.trim().equals(nameI.trim()))
				        						{
				        							//Hacemos la última comprobación debido a que la lista siempre
				        							//se recorre de 0, así que acá es necesario igualmente especificar
				        							//qué items pertenecen a este título
				        							contadorM++;
				        							contador++;
			     %>
			 		<label for="exampleInputEmail1">Item #<%=contadorM %> (Item sin enlace)</label>
					<input type="text" id="texto<%=contador%>" name="texto<%=contador%>" class="form-control" value="<%=texto.trim() %>" required>
				    <input type="hidden" id="id<%=contador%>" name="id<%=contador%>" class="form-control" value="<%=idI %>" required>
			        <input type="hidden" id="guid<%=contador%>" name="guid<%=contador%>" class="form-control" value="<%=guidI %>" required>
			    	<input type="hidden" id="tipo<%=contador%>" name="tipo<%=contador%>" class="form-control" value="<%=tipo %>" required>
			    <% 
				        						}
				        					}
										}
                   					}
		                  		}
		                  	}
						}
					}
				}catch(NullPointerException e)
				{
					e.printStackTrace();
					System.out.println("Error en la creación del formulario del Editar footer");
				}
                   %>
                   <input type="hidden" id="contador" name="contador" class="form-control" value="<%=contador %>" required>
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
        successAlert('Éxito', 'El footer ha sido modificado exitosamente.');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revise los datos e intente nuevamente!');
      }
    });
    </script>

</body>
</html>