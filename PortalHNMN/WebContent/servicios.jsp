 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Servicios - Herbario Nacional de Nicaragua</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="css/bootstrap.css" rel="stylesheet" />
  <link href="css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="css/fancybox/jquery.fancybox.css" rel="stylesheet">
  <link href="css/jcarousel.css" rel="stylesheet" />
  <link href="css/flexslider.css" rel="stylesheet" />
  <link href="css/style.css" rel="stylesheet" />

  <link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
  <!-- Theme skin -->
  <link href="skins/default.css" rel="stylesheet" />
  <!-- Fav and touch icons -->
 <link rel="apple-touch-icon" sizes="144x144" href="ico/apple-touch-icon-144.png" />
  <link rel="apple-touch-icon" sizes="114x114" href="ico/apple-touch-icon-114.png" />
  <link rel="apple-touch-icon" sizes="72x72" href="ico/apple-touch-icon-72.png" />
  <link rel="apple-touch-icon" sizes="57x57" href="ico/apple-touch-icon-57.png" />
  <link rel="shortcut icon" href="ico/favicon.png" type="image/x-icon" />

  <!-- =======================================================
    Theme Name: Flattern
    Theme URL: https://bootstrapmade.com/flattern-multipurpose-bootstrap-template/
    Author: BootstrapMade.com
    Author URL: https://bootstrapmade.com
  ======================================================= -->
</head>

<body>
  <div id="wrapper" class="boxed">
  	<!-- MENU -->
  	<jsp:include page="WEB-INF/layouts/menu.jsp"></jsp:include>
    <!-- MENU -->
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>Servicios</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li class="active">Servicios</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="span12">
            <h4>Lista de <strong>servicios</strong></h4>
          </div>
          <%
          ArrayList<Tbl_publicaciones> titulos = new ArrayList<Tbl_publicaciones>();
          ArrayList<Tbl_publicaciones> items = new ArrayList<Tbl_publicaciones>();
          DT_publicaciones dtpus = new DT_publicaciones();
          titulos = dtpus.titulosServicios();
          items = dtpus.itemsServicios();
          Collections.sort(titulos);
          Collections.sort(items);
          
          //Usaremos dos títulos, que es el nombre del campo donde se está almacenando el contenido a mostrar, 
          //en la base de datos (public_titulo), uno para imprimir el título del servicio, y otro para imprimir
          //el título del item; se podía rehusar la misma variable, pero por orden lo preferí así.
          String tituloT = "", tituloI = "";
          //Usaremos, también, dos tipos, pero esta vez, porque los compararemos entre ellos, para saber si el tipo del item
          //a comparar será  igual al tipo del título puesto (los títulos siempre se imprimirán, ya que constan de un orden)
          //según su menu_order de la bdd, y con el Collections.sort ordenamos la lista que la bdd nos devuelve
          //se podía también modificar la sentencia sql y usar el ORDER BY, pero de nuevo, prefiero usar el .sort.
          String tipoT = "", tipoI = "";
          //Nuevamente, dos nombres, para comparar el título con el item
          String nameT = "", nameI = "";
          //Usamos varias variables con nombres que nunca van a cambiar, primero, para saber si el título tendrá
          //el encabezado de "Precio por muestra", que equivaldría a muestreoIndividualTitulo, o, "Precios"
          //que equivaldríaa muestreoColectivoTitulo, y posteriormente, lo mismo con el item
          //Luego en el código se verá como se compara el item con el título ya que la cadena es distinta
          String muestreoIT = "muestreoIndividualTitulo", muestreoI = "muestreoIndividual";
          String muestreoCT = "muestreoColectivoTitulo", muestreoC = "muestreoColectivo";
          //Usaremos un contador para llevar el número de items por título y así compararlo con el menu_order
          //que de nuevo, lo devolvemos ordenado con el Collections.sort
          int contador = 0, orden = 0;
          //Estas variables son las que se usarán para comparar a qué tipo de muestreo pertecen
          int tipoMT = 0, tipoMI = 0; 
          
          for(Tbl_publicaciones tbpub : titulos)
          {
        	  //El contador se inicializa en 1 por cada título para comparar con el primer item, que debería de tener el
        	  //menu_order 1.
        	  contador = 1;
        	  tituloT = tbpub.getPublic_titulo();
        	  tipoT = tbpub.getGuid();
        	  nameT = tbpub.getPublic_name();
        	  if(tipoT.trim().equals(muestreoIT))
        	  {
        		  //Si el tipo es igual a "muestreoIndividualTitulo", asignaremos 1 a la variable de comparación
        		  tipoMT = 1;
        		  %>
        		  <div class="span3">
            		<div class="pricing-box-alt">
              			<div class="pricing-heading">
                			<h3><%=tituloT %></h3>
              			</div>
             			<div class="pricing-terms">
                			<h6>Precio por muestra</h6>
             			</div>
              			<div class="pricing-content">
               				<ul>
               				<%
               				for(Tbl_publicaciones tblpub : items)
                      	  	{
                      		  	tituloI = tblpub.getPublic_titulo();
                      		  	tipoI = tblpub.getGuid();
                      		  	nameI = tblpub.getPublic_name();
                      		  	orden = tblpub.getMenu_order();
                  		  		if(tipoI.trim().equals(muestreoI))
                      		  	{
                  		  			//Si el tipo es igual a "muestreoIndividual", asignaremos 1 a la variable de comparacion
                      		  		tipoMI = 1;
                  		  			//Y luego compararemos si poseen el mismo tipo que el título
                      		  		if(tipoMT == tipoMI)
                      		  		{
                      		  			//Si lo poseen, pasamos a comparar el nombre, que este sería su identificativo
                      		  			//el nombre es exactamente lo que se muestra en el formulario, lo que sería
                      		  			//el encabezado del servicio
	                      		  		if(nameI.trim().equals(nameT.trim()))
	                      			  	{
	                      		  			//Si el nombre es igual, significa que es un item del título que se está trabajando
	                      		  			//y luego pasamos a comparar el menu_order con el contador
	                      			  		if(orden == contador)
	                      				  	{
	                      			  			//Si es igual, el contador aumentará y pasaremos al siguiente item.
	                      			  			//Ojo, al tener ordenados los items con el Collecions.sort, esta comparación
	                      			  			//puede ser innecesario, pero prefiero dejarla.
	                      					  	contador++;
	                      					  	%>
	                      					  	<li><i class="icon-ok"></i><%=tituloI %></li>
	                      					  	<%
	                      				  	}
	                      			  	}
                      		  		}
                      		  	}
                      	  	}
               				%>
                			</ul>
              			</div>
              			<div class="pricing-action">
                			<div class="btn btn-medium btn-theme">* Si tiene dificultad para realizar el pago, por favor, comunicarse con la responsable del Herbario</div>
           				</div>
          		   </div>
          		</div>
        		  <%
        	  }
        	  else
        	  {
        		  if(tipoT.trim().equals(muestreoCT))
        		  {
        			  //Si el tipo es igual a "muestreoColectivoTitulo", asignaremos 2 a la variable de comparación
        			  tipoMT = 2;
        			  %>
            		  <div class="span3">
                		<div class="pricing-box-alt">
                  			<div class="pricing-heading">
                    			<h3><%=tituloT %></h3>
                  			</div>
                 			<div class="pricing-terms">
                    			<h6>Precios</h6>
                 			</div>
                  			<div class="pricing-content">
                   				<ul>
                   				<%
                   				for(Tbl_publicaciones tblpub : items)
                          	  	{
                          		  	tituloI = tblpub.getPublic_titulo();
                          		  	tipoI = tblpub.getGuid();
                          		  	nameI = tblpub.getPublic_name();
                          		  	orden = tblpub.getMenu_order();
                          		  
                          		  	if(tipoI.trim().equals(muestreoC))
                          		  	{
                          		  		//Si el tipo es igual a "muestreoColectivo", asignaremos 2 a la variable de comparacion
                          		  		tipoMI = 2;
                          		  		if(tipoMT == tipoMI)
                          		  		{
	                          			  	if(nameI.trim().equals(nameT.trim()))
	                          			  	{
	                          					if(orden == contador)
	                          				  	{
	                          					  	contador++;
	                          					  	%>
	                          					  	<li><i class="icon-ok"></i><%=tituloI %></li>
	                          					  	<%
	                          				  	}
	                          			  	}
                          		  		}
                          		  	}
                          	  	}
                   				%>
                    			</ul>
                  			</div>
                  			<div class="pricing-action">
                    			<div class="btn btn-medium btn-theme">Si desea más información, por favor, comunicarse con la responsable del Herbario</div>
               				</div>
              		   </div>
              		</div>
            		  <%        			  
        		  }
        	  }
          }
          %>
      	</div>
      </div>
    </section>
	<!-- Footer -->
  	<jsp:include page="WEB-INF/layouts/footer.jsp"></jsp:include>
  	<!-- ./Footer -->
  </div>
  <a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
  <!-- javascript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="js/jquery.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/jcarousel/jquery.jcarousel.min.js"></script>
  <script src="js/jquery.fancybox.pack.js"></script>
  <script src="js/jquery.fancybox-media.js"></script>
  <script src="js/google-code-prettify/prettify.js"></script>
  <script src="js/portfolio/jquery.quicksand.js"></script>
  <script src="js/portfolio/setting.js"></script>
  <script src="js/jquery.flexslider.js"></script>
  <script src="js/jquery.nivo.slider.js"></script>
  <script src="js/modernizr.custom.js"></script>
  <script src="js/jquery.ba-cond.min.js"></script>
  <script src="js/jquery.slitslider.js"></script>
  <script src="js/animate.js"></script>

  <!-- Template Custom JavaScript File -->
  <script src="js/custom.js"></script>

<script async type="text/javascript" src="https://userlike-cdn-widgets.s3-eu-west-1.amazonaws.com/0af277ee13dc0508efad8915517bf694eb1dbc21bb4152cf920a8ae1b3d35228.js"></script>
</body>

</html>