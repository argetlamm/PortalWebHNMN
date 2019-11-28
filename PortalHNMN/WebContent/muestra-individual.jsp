<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Muestra - Herbario Nacional de Nicaragua</title>
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
  <div id="wrapper">
    <!-- MENU -->
  	<jsp:include page="WEB-INF/layouts/menu.jsp"></jsp:include>
    <!-- MENU -->
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>Datos específicos</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="colecciones.jsp">Colección</a><i class="icon-angle-right"></i></li>
              <li class="active">Datos específicos </li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    	<%
    	String idImagen = "";
    	idImagen = request.getParameter("imagenID");
    	int id = Integer.parseInt(idImagen);
    	
    	DT_publicaciones dtpus = new DT_publicaciones();
		ArrayList<Tbl_publicaciones> publicacion = new ArrayList<Tbl_publicaciones>();
		String publicado = "publicado";
		String url = "";
		String ecologia = "";
		String posicion = "";
		String creditos ="";
		String nombre ="";
		String nombreC ="";
		
		publicacion = dtpus.informacionColeccion(id);
		for (Tbl_publicaciones tpublc : publicacion){
        	if(tpublc.getPublic_estado().trim().equals(publicado)){
        		posicion=tpublc.getPublic_name();
        		if(posicion.trim().equals("urlImagen"))
        		{
        			url=tpublc.getPublic_titulo();
        		}
        		else
        		{
        			if(posicion.trim().equals("creditosImagen"))
        			{
        				creditos=tpublc.getPublic_titulo();
        			}
        			else
        			{
        				if(posicion.trim().equals("nombreComun"))
        				{
        					nombre=tpublc.getPublic_titulo();
        				}
        				else
        				{
        					if(posicion.trim().equals("nombreCientifico"))
        					{
        						nombreC=tpublc.getPublic_titulo();
        					}
        					else
        					{
        						if(posicion.trim().equals("ecologia"))
        						{
        							ecologia=tpublc.getPublic_content();
        						}
        					}
        				}
        			}
        		}
        	}
		}
    	%>
	    <section id="content">
	      <div class="container">
	        <div class="row">
	          <div class="span8">
	            <article>
	              <div class="top-wrapper">
	                <div class="post-heading">
	                  <h3>Información individual</h3>
	                </div>
	                <!-- start flexslider -->
	                <div class="flexslider">
	                  <ul class="slides">
	                    <li>
	                      <img src="<%=url %>" alt="" />
	                    </li>
	                  </ul>
	                </div>
	                <!-- end flexslider -->
	              </div>
	              <p>
	                <strong><%=creditos %></strong>
	              </p>
	            </article>
	          </div>
	          <div class="span4">
	            <aside class="right-sidebar">
	              <div class="widget">
	                <h5 class="widgetheading">Información de la muestra</h5>
	                <ul class="folio-detail">
	                  <li><label>Nombre: </label><%=nombre %></li>
	                  <li><label>Nombre científico: </label><%=nombreC %></li>
	                </ul>
	              </div>
	              <div class="widget">
	                <h5 class="widgetheading">Ecología</h5>
	                <p>
						<%=ecologia %>
	                </p>
	              </div>
	            </aside>
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

</body>

</html>