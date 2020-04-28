<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Colección - Herbario Nacional de Nicaragua</title>
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
	<!-- MENU -->
  	<jsp:include page="WEB-INF/layouts/menu.jsp"></jsp:include>
    <!-- MENU -->
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>Colección de muestras</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li class="active">Colección completa</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
        <%
            	String publicado = "publicado";
		        DT_publicaciones dtpusdos = new DT_publicaciones();
		        ArrayList<Tbl_publicaciones> listaParrafProd = new ArrayList<Tbl_publicaciones>();
		        listaParrafProd = dtpusdos.itemsParrafoColecciones();
		        String parrafo="";
		        for (Tbl_publicaciones tpublc : listaParrafProd){
		        	if(tpublc.getPublic_estado().trim().equals(publicado)){
		        			parrafo=tpublc.getPublic_content();
		
		        %>
		        <p><%=parrafo %></p>
		        <%
		       	 	}
		        }
        %>
          <div class="span12">
            <ul class="portfolio-categ filter">
              <li class="all active"><a href="#">Todas</a></li>
              <li class="pacifico"><a href="#" title="">Pacífico</a></li>
              <li class="caribe"><a href="#" title="">Caribe</a></li>
            </ul>
            <div class="clearfix">
            </div>
            <div class="row">
              <section id="projects">
                <ul id="thumbs" class="portfolio">
                  <!-- Item Project and Filter Name -->
                  <%
	        		DT_publicaciones dtpus = new DT_publicaciones();
	        		ArrayList<Tbl_publicaciones> listaColecciones = new ArrayList<Tbl_publicaciones>();
	        		listaColecciones = dtpus.imagenesColeccion();
	            	String url = "";
	            	String tipo = "";
	            	int id=0;

	            	for (Tbl_publicaciones tpublc : listaColecciones){
	            	if(tpublc.getPublic_estado().trim().equals(publicado)){
	            		url = tpublc.getPublic_titulo();
	            		tipo = tpublc.getPublic_tipo_img();
	            		id = tpublc.getMenu_order();
        			%>                                
                    <li class="item-thumbs span3 design" data-id="id-0" data-type="<%=tipo.trim()%>">
                    <!-- Fancybox - Gallery Enabled - Title - Full Image -->
                    <a class="hover-wrap fancybox" data-fancybox-group="gallery" title="Imagen" href="${pageContext.request.contextPath}/SL_colecciones?IdUser=<%=id%>">
						<span class="overlay-img"></span>                                                                                       
						<span class="overlay-img-thumb font-icon-plus"></span>
					</a>
                    <img src="<%=url %>">               
                    </li>
                  	<%
	            			}
	            		}
					%>   
                </ul>
              </section>
            </div>
          </div>
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
  
  <script>
  /*
	function mandarId(id)
	{
		var idImagen = id;
		confirm(function(e,btn)
	     { 
	     	e.preventDefault();
	     	window.location.href="${pageContext.request.contextPath}/SL_colecciones?opc=1&imagenID="+idImagen;
	     }, 
	     function(e,btn)
	     {
	       e.preventDefault();
	     });
	}
  */
  </script>

<script async type="text/javascript" src="https://userlike-cdn-widgets.s3-eu-west-1.amazonaws.com/54537da60973928bf0460f49379de0b7757d7a01cff914af08b8b9cf87bc6502.js"></script>

</body>

</html>