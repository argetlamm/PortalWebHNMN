<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Artículo - Herbario Nacional de Nicaragua</title>
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
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png" />
  <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png" />
  <link rel="shortcut icon" href="ico/favicon.png" />

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
              <h2>Nuevo artículo</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="noticias.jsp">Noticias</a><i class="icon-angle-right"></i></li>
              <li><a href="articulos.jsp">Artículos</a><i class="icon-angle-right"></i></li>
              <li class="active">Nuevo artículo</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="span4">
            <aside class="left-sidebar">
              <div class="widget">
                <form class="form-search">
                  <input placeholder="Type something" type="text" class="input-medium search-query">
                  <button type="submit" class="btn btn-square btn-theme">Search</button>
                </form>
              </div>
              <div class="widget">
                <h5 class="widgetheading">Categorias</h5>
                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="articulos.jsp">Científicos</a><span> (2)</span></li>
                  <li><i class="icon-angle-right"></i><a href="articulos.jsp">Culturales</a><span> (0)</span></li>
                  <li><i class="icon-angle-right"></i><a href="articulos.jsp">Curiosidades</a><span> (0)</span></li>
                </ul>
              </div>
              <div class="widget">
                <h5 class="widgetheading">Últimos artículos</h5>
                <ul class="recent">
                  <li>
                    <img src="img/dummies/blog/65x65/thumb1.jpg" class="pull-left" alt="" />
                    <h6><a href="articulo-individual.jsp">Artículo 1</a></h6>
                    <p>
                      El cuido de plantas es importante...
                    </p>
                  </li>
                  <li>
                    <a href="#"><img src="img/dummies/blog/65x65/thumb2.jpg" class="pull-left" alt="" /></a>
                    <h6><a href="articulo-individual.jsp">Artículo 2</a></h6>
                    <p>
                      Inicio en el campo de herbología...
                    </p>
                  </li>
                </ul>
              </div>
              <div class="widget">
                <h5 class="widgetheading">Etiquetas populares</h5>
                <ul class="tags">
                  <li><a href="cursos.jsp">Cursos</a></li>
                  <li><a href="colecciones.jsp">Coleccion</a></li>
                  <li><a href="eventos.jsp">Eventos</a></li>
                  <li><a href="contacto.jsp">Contacto</a></li>
                  <li><a href="muestra-individual.jsp">Palo</a></li>
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
            <article>
              <div class="row">
                <div class="span8">
                  <div class="post-image">
                    <div class="post-heading">
                      <h3><a href="articulo-individual.jsp">Artículo 1</a></h3>
                    </div>
                    <img src="img/dummies/blog/img1.jpg" alt="" />
                  </div>
                  <p>
                    No ahoge sus plantas, se cree que está bien echarles agua en cantidades excesivas, pero esto tiene que controlarse.
                  </p>
                  <blockquote>
                    <i class="icon-quote-left"></i> Todo en exceso es malo...
                  </blockquote>
                  <p>
	                Hay que tener un límite de agua que echarle a las plantas
                  </p>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"> 7 de Noviembre de 2019</a></li>
                      <li><i class="icon-user"></i><a href="#"> Administrador</a></li>
                      <li><i class="icon-folder-open"></i><a href="articulos.jsp"> Articulos</a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </article>
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