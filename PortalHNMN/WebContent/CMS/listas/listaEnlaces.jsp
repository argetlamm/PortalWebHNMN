<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Enlaces - Herbario Nacional de Nicaragua</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <!-- css -->
  <link href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="../../css/bootstrap.css" rel="stylesheet" />
  <link href="../../css/bootstrap-responsive.css" rel="stylesheet" />
  <link href="../../css/fancybox/jquery.fancybox.css" rel="stylesheet">
  <link href="../../css/jcarousel.css" rel="stylesheet" />
  <link href="../../css/flexslider.css" rel="stylesheet" />
  <link href="../../css/style.css" rel="stylesheet" />
  <!-- Theme skin -->
  <link href="../../skins/default.css" rel="stylesheet" />
  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon" sizes="144x144" href="ico/apple-touch-icon-144.png" />
  <link rel="apple-touch-icon" sizes="114x114" href="ico/apple-touch-icon-114.png" />
  <link rel="apple-touch-icon" sizes="72x72" href="ico/apple-touch-icon-72.png" />
  <link rel="apple-touch-icon" sizes="57x57" href="ico/apple-touch-icon-57.png" />
  <link rel="shortcut icon" href="ico/favicon.png" type="image/x-icon" />
</head>

<body>
  <div id="wrapper">
    <!-- MENU -->
<%--   	<jsp:include page="../../WEB-INF/layouts/menu.jsp"></jsp:include> --%>
    <!-- MENU -->
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>Lista de Enlaces</h2>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="span12">
<!--             <h4><strong>Lista de todos los items con sus respectivas rutas de enlace</strong></h4> -->
            <div class="row">
              <div class="span3">
                <ul class="the-icons">
                  <li><strong>Inicio: </strong>index.jsp</li>
                  <li><strong>¿Quienes Somos?: </strong>acercade.jsp</li>
                  <li><strong>Colecciones: </strong>colecciones.jsp</li>
                </ul>
              </div>
              <div class="span3">
                <ul class="the-icons">
                  <li><strong>Noticias: </strong>noticias.jsp</li>
                  <li><strong>Publicaciones: </strong>articulos.jsp</li>
                  <li><strong>Eventos: </strong>eventos.jsp</li>
                </ul>
              </div>
              <div class="span3">
                <ul class="the-icons">
                  <li><strong>Cursos: </strong>cursos.jsp</li>
                  <li><strong>Contacto: </strong>contacto.jsp</li>
                  <li><strong>Donaciones: </strong>donaciones.jsp</li>
                </ul>
              </div>
              <div class="span3">
                <ul class="the-icons">
                  <li><strong>Colaboraciones: </strong>colaboraciones.jsp</li>
                  <li><strong>Productos: </strong>productos.jsp</li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  <!-- Footer -->
<%--   	<jsp:include page="../../WEB-INF/layouts/footer.jsp"></jsp:include> --%>
  <!-- ./Footer -->
  </div>
  <a href="#" class="scrollup"><i class="icon-chevron-up icon-square icon-32 active"></i></a>
  <!-- javascript
    ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="../../js/jquery.js"></script>
  <script src="../../js/jquery.easing.1.3.js"></script>
  <script src="../../js/bootstrap.js"></script>
  <script src="../../js/jcarousel/jquery.jcarousel.min.js"></script>
  <script src="../../js/jquery.fancybox.pack.js"></script>
  <script src="../../js/jquery.fancybox-media.js"></script>
  <script src="../../js/google-code-prettify/prettify.js"></script>
  <script src="../../js/portfolio/jquery.quicksand.js"></script>
  <script src="../../js/portfolio/setting.js"></script>
  <script src="../../js/jquery.flexslider.js"></script>
  <script src="../../js/jquery.nivo.slider.js"></script>
  <script src="../../js/modernizr.custom.js"></script>
  <script src="../../js/jquery.ba-cond.min.js"></script>
  <script src="../../js/jquery.slitslider.js"></script>
  <script src="../../js/animate.js"></script>

  <!-- Contact Form JavaScript File -->
  <script src="../../contactform/contactform.js"></script>

  <!-- Template Custom JavaScript File -->
  <script src="../../js/custom.js"></script>

</body>

</html>
