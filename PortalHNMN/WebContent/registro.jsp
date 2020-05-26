<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.DT_usuario, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Registro - Herbario Nacional de Nicaragua</title>
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
  <!-- jAlert css  -->
  <link rel="stylesheet" href="js/jAlert/dist/jAlert.css" />
  
<%
/* RECUPERAMOS EL VALOR DE LA VARIABLE MSJ */
String mensaje = "";
mensaje = request.getParameter("msj");
mensaje = mensaje==null?"":mensaje;
System.out.println("mensaje1="+mensaje);
%>
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
              <h2>Registro</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li class="active">Registro</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
<div class="container">
        <div class="row">
          <div class="span12">
            <h3>Regístrate en el portal llenando el siguiente formulario:</h3><br>
            <h6>Estimado usuario, ahora mismo no existen los perfiles de usuarios, 
            al crear una cuenta sólo le permitirá recibir correos acerca de las últimas actualizaciones del sitio.</h6><br>

                <form role="form" action="${pageContext.request.contextPath}/SL_registro" method="post">
                <div class="card-body">
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">Nombre de Usuario:</label>
                    <input type="text" id="username" name="username" class="form-control" 
                    placeholder="Username" required>
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputPassword1">Contraseña: </label>
                    <input type="password" id="password" name="password" class="form-control" 
                    title="Recuerde usar teclas mayúsculas, minúsculas, números y caracteres especiales..." 
                    placeholder="Contraseña" required>
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputPassword1">Confirmar Contraseña: </label>
                    <input type="password" id="password2" name="password2" class="form-control" 
                    title="Recuerde usar teclas mayúsculas, minúsculas, números y caracteres especiales..." 
                    placeholder="Ingrese nuevamente su Contraseña" required>
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">Primer Nombre:</label>
                    <input type="text" id="nombre1" name="nombre1" class="form-control" 
                    placeholder="Primer Nombre" required>
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">Segundo Nombre:</label>
                    <input type="text" id="nombre2" name="nombre2" class="form-control"  placeholder="Nombre de Usuario">
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">Primer Apellido:</label>
                    <input type="text" id="apellido1" name="apellido1" class="form-control" 
                    placeholder="Primer Apellido" required>
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">Segundo Apellido:</label>
                    <input type="text" id="apellido2" name="apellido2" class="form-control" 
                    placeholder="Segundo Apellido">
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" 
                    placeholder="Ingrese una cuenta de correo electrónico válida, Ejemplo: ejemplo@ejemplo.com" required>
                  </div>
                  <div class="form-group" align="center">
                    <label for="exampleInputEmail1">¿Desea recibir notificaciones de publicaciones del Herbario?:</label>
                    <input type="radio" id="notificacion" name="notificacion" value="a" required> Si
                    <input type="radio" id="notificacion" name="notificacion" value="b" required> No<br><br>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer" align="center">
                  <button type="submit" class="btn btn-primary">Registrar</button>
                  <button type="reset" class="btn btn-danger">Cancelar</button>
                </div>
              </form>
          </div>
        </div>
      </div>
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
<!-- jQuery -->
  <script src="../CMS/plugins/jquery/jquery.min.js"></script>
<!-- jAlert js -->
  <script src="js/jAlert/dist/jAlert.min.js"></script>
  <script src="js/jAlert/dist/jAlert-functions.min.js"> </script>
  
<script>
    $(document).ready(function ()
    {
     
      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";

      if(nuevo == "1")
      {
        successAlert('Exito', 'Te has registrado satisfactoriamente!!!');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'Revisa tus datos e intenta nuevamente!!!');
      }
    });
    </script>

</body>

</html>