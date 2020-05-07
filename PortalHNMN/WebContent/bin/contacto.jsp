<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Contacto - Herbario Nacional de Nicaragua</title>
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
              <h2>Contáctanos</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li class="active">Contacto</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
	<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d4638.840086815626!2d-86.27133344867765!3d12.126926332847736!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8f7155ef5b5b0717%3A0x52f30f8b3467ad29!2sUniversidad%20Centroamericana!5e0!3m2!1ses!2sni!4v1573106843722!5m2!1ses!2sni" width="100%" height="380" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
      <div class="container">
        <div class="row">
          <div class="span12">
            <h4>Contacta con nosotros llenando <strong>el siguiente formulario:</strong></h4>
			<form action="https://formspree.io/hjoshua2013@gmail.com" method="post" role="form" class="contact-form">
              <div class="row">
                <div class="span4 form-group">
                  <label><strong>Nombre:</strong></label><input type="text" name="Nombre" class="form-control" id="name" placeholder="Tu nombre" required/>
                  <div class="validation"></div>
                </div>
                <div class="span4 form-group">
                  <label><strong>Correo:</strong></label><input type="email" class="form-control" name="Correo" id="email" placeholder="Tu correo" required/>
                  <div class="validation"></div>
                </div>
                <div class="span4 form-group">
                  <label><strong>Asunto:</strong></label><input type="text" class="form-control" name="Asunto" id="subject" placeholder="Asunto" required/>
                  <div class="validation"></div>
                </div>
                <div class="span12 margintop10 form-group">
                  <label><strong>Mensaje:</strong></label><textarea class="form-control" name="Mensaje" rows="12" cols="500" placeholder="Mensaje" required></textarea>
                  <div class="validation"></div>
                  <p class="text-center">
                    <button class="btn btn-large btn-theme margintop10" type="submit">Enviar</button>
                  </p>
                </div>
              </div>
            </form>
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

  <!-- Contact Form JavaScript File -->
  <script src="contactform/contactform.js"></script>

  <!-- Template Custom JavaScript File -->
  <script src="js/custom.js"></script>

<script async type="text/javascript" src="https://userlike-cdn-widgets.s3-eu-west-1.amazonaws.com/54537da60973928bf0460f49379de0b7757d7a01cff914af08b8b9cf87bc6502.js"></script>
</body>

</html>
