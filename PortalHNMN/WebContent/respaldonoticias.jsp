<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Noticias - Herbario Nacional de Nicaragua</title>
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
              <h2>�ltimas noticias</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li class="active">Noticias</li>
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
                  <input placeholder="Escribe algo" type="text" class="input-medium search-query">
                  <button type="submit" class="btn btn-square btn-theme">Buscar</button>
                </form>
              </div>
              <div class="widget">
                <h5 class="widgetheading">Categor�as</h5>
                <ul class="cat">
                  <li><i class="icon-angle-right"></i><a href="articulos.jsp">Art�culos</a><span> (2)</span></li>
                  <li><i class="icon-angle-right"></i><a href="eventos.jsp">Eventos</a><span> (0)</span></li>
                  <li><i class="icon-angle-right"></i><a href="cursos.jsp">Cursos</a><span> (3)</span></li>
                </ul>
              </div>
              <div class="widget">
                <h5 class="widgetheading">�ltimas noticias</h5>
                <ul class="recent">
                  <li>
                    <img src="img/dummies/blog/65x65/thumb1.jpg" class="pull-left" alt="" />
                    <h6><a href="cursos.jsp">Post 1</a></h6>
                    <p>
                     �Tenemos nuevo curso de... 
                    </p>
                  </li>
                  <li>
                    <a href="#"><img src="img/dummies/blog/65x65/thumb2.jpg" class="pull-left" alt="" /></a>
                    <h6><a href="cursos.jsp">Post 2</a></h6>
                    <p>
                      �Tenemos nuevo curso de... 
                    </p>
                  </li>
                  <li>
                    <a href="#"><img src="img/dummies/blog/65x65/thumb3.jpg" class="pull-left" alt="" /></a>
                    <h6><a href="articulo-individual.jsp">Post 3</a></h6>
                    <p>
                      Cuido de plantas...
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
                      <h3><a href="#">Noticia nueva</a></h3>
                    </div>
                    <img src="img/dummies/blog/img1.jpg" alt="" />
                  </div>
                  <p>
                    �Hay un nuevo curso disponible! Comenzaremos un nuevo curso acerca de herbolog�a avanzada...
                  </p>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"> 7 de Noviembre de 2019</a></li>
                      <li><i class="icon-user"></i><a href="#"> Administrador</a></li>
                      <li><i class="icon-folder-open"></i><a href="#"> Curso</a></li>
                    </ul>
                    <a href="cursos.jsp" class="pull-right">Continua leyendo...<i class="icon-angle-right"></i></a>
                  </div>
                </div>
              </div>
            </article>
            <article>
              <div class="row">
                <div class="span8">
                  <div class="post-slider">
                    <div class="post-heading">
                      <h3><a href="#">Noticia nueva</a></h3>
                    </div>
                    <!-- start flexslider -->
                    <div class="flexslider">
                      <ul class="slides">
                        <li>
                          <img src="img/dummies/blog/img1.jpg" alt="" />
                        </li>
                        <li>
                          <img src="img/dummies/blog/img2.jpg" alt="" />
                        </li>
                        <li>
                          <img src="img/dummies/blog/img3.jpg" alt="" />
                        </li>
                      </ul>
                    </div>
                    <!-- end flexslider -->
                  </div>
                  <p>
                    �Hay un nuevo curso disponible! Comenzaremos un nuevo curso acerca de biolog�a b�sica...
                  </p>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"> 7 de Noviembre de 2019</a></li>
                      <li><i class="icon-user"></i><a href="#"> Administrador</a></li>
                      <li><i class="icon-folder-open"></i><a href="#"> Curso</a></li>
                    </ul>
                    <a href="cursos.jsp" class="pull-right">Continua leyendo... <i class="icon-angle-right"></i></a>
                  </div>
                </div>
              </div>
            </article>
            <article>
              <div class="row">
                <div class="span8">
                  <div class="post-quote">
                    <div class="post-heading">
                      <h3><a href="#">Noticia nueva</a></h3>
                    </div>
                    <blockquote>
                      <i class="icon-quote-left"></i> Todo en exceso es malo, por eso, no ahoge sus plantas, ac� te ense�aremos como... 
                    </blockquote>
                  </div>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"> 7 de Noviembre de 2019</a></li>
                      <li><i class="icon-user"></i><a href="#"> Administrador</a></li>
                      <li><i class="icon-folder-open"></i><a href="#"> Curso</a></li>
                    </ul>
                    <a href="articulo-individual.jsp" class="pull-right">Continua leyendo... <i class="icon-angle-right"></i></a>
                  </div>
                </div>
              </div>
            </article>
            <article>
              <div class="row">
                <div class="span8">
                  <div class="post-video">
                    <div class="post-heading">
                      <h3><a href="#">Noticia nueva</a></h3>
                    </div>
                    <div class="video-container">
                      <iframe src="http://player.vimeo.com/video/30585464?title=0&amp;byline=0">
								</iframe>
                    </div>
                  </div>
                  <p>
                    �Te interesa saber c�mo iniciar en el campo de la herbolog�a? Este video te ayudar� mucho, contiene informaci�n acerca de...
                  </p>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"> 7 de Noviembre de 2019</a></li>
                      <li><i class="icon-user"></i><a href="#"> Administrador</a></li>
                      <li><i class="icon-folder-open"></i><a href="#"> Curso</a></li>
                    </ul>
                    <a href="articulo-individual.jsp" class="pull-right">Continua leyendo... <i class="icon-angle-right"></i></a>
                  </div>
                </div>
              </div>
            </article>
            <div id="pagination">
              <span class="all">P�gina 1 de 3</span>
              <span class="current">1</span>
              <a href="#" class="inactive">2</a>
              <a href="#" class="inactive">3</a>
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

</body>

</html>
