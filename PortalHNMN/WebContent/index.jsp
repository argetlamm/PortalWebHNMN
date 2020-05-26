<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Inicio - Herbario Nacional de Nicaragua</title>
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
  <!-- jAlert css  -->
  <link rel="stylesheet" href="CMS/plugins/jAlert/dist/jAlert.css" />

	<%
/* RECUPERAMOS EL VALOR DE LA VARIABLE MSJ */
String mensaje = "";
mensaje = request.getParameter("msj");
mensaje = mensaje==null?"":mensaje;

%>

</head>

<body>
  <div id="wrapper">
    <!-- MENU -->
  	<jsp:include page="WEB-INF/layouts/menu.jsp"></jsp:include>
    <!-- MENU -->
    <section id="featured">
      <!-- start slider -->
      <!-- Slider -->
      <div id="nivo-slider">
        <div class="nivo-slider">
        	<%
        	DT_publicaciones dtpus = new DT_publicaciones();
        	ArrayList<Tbl_publicaciones> listaBanner = new ArrayList<Tbl_publicaciones>();
            listaBanner = dtpus.imagenesBanner();
            String publicado = "publicado";
            String url = "";
            int contador = 1;
            
            for (Tbl_publicaciones tpublc : listaBanner){
            	if(tpublc.getPublic_estado().trim().equals(publicado)){
            		url = tpublc.getPublic_titulo();
        	%>
          	<img src=<%=url %> alt="" title="#caption-<%=contador %>"/>
           <% 
           		contador++;
            	} 
            }
         	%>
        </div>
      </div>
      <!-- end slider -->
    </section>
    <section class="callaction">
      <div class="container">
        <div class="row">
          <div class="span12">
            <div class="big-cta">
              <div class="cta-text">
                <h3><span class="highlight"><strong>BIENVENIDOS AL PORTAL WEB DEL HERBARIO NACIONAL DE NICARAGUA!</strong></span></h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
        <div class="row">
          <div class="span12">
            <div class="row">
            <%
            DT_publicaciones dtpuss = new DT_publicaciones();
            ArrayList<Tbl_publicaciones> listaInicio = new ArrayList<Tbl_publicaciones>();
            listaInicio = dtpuss.itemsInicio();
            String titulo = "";
            String contenido = "";
            String enlace = "";
            String icon = "";
            
            for(Tbl_publicaciones tbpub : listaInicio)
            {
            	if(tbpub.getPublic_estado().trim().equals(publicado))
            	{
            		titulo = tbpub.getPublic_titulo();
            		contenido = tbpub.getPublic_content();
            		enlace = tbpub.getPublic_enlace();
            		icon = tbpub.getPublic_tipo_img();
            %>
              <div class="span3">
                <div class="box aligncenter">
                  <div class="aligncenter icon">
                    <a href=<%=enlace %>><i class="<%=icon.trim() %> icon-circled icon-64 active"></i></a>
                  </div>
                  <div class="text">
                    <h6><%=titulo %></h6>
					<p><%=contenido %></p>
                    <a href=<%=enlace %>>Infórmate...</a>
                  </div>
                </div>
              </div>
            <%
            	}
            }
            %>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section id="bottom">
      <div class="container">
        <div class="row">
          <div class="span12">
            <div class="aligncenter">
              <div id="twitter-wrapper">
                <div id="twitter">
                </div>
              </div>
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
  
  <!-- jAlert js -->
  <script src="CMS/plugins/jAlert/dist/jAlert.min.js"></script>
  <script src="CMS/plugins/jAlert/dist/jAlert-functions.min.js"> </script>
  <script src="CMS/plugins/select2/js/select2.full.min.js"></script>
  
    <script>
    $(document).ready(function ()
    {
     
      /////////// VARIABLES DE CONTROL MSJ ///////////
      var nuevo = 0;
      nuevo = "<%=mensaje%>";
      
      if(nuevo == "1")
      {
        successAlert('Estimado Usuario', 'Ha sido redirigido al sitio web original debido a que los perfiles de usuario aún no están disponibles. ¡espere a futuras actualizaciones del sitio!"');
      }
      if(nuevo == "2")
      {
        errorAlert('Error', 'El usuario ingresado no existe, verifique sus credenciales');
      }
    });
    </script>

<script async type="text/javascript" src="https://userlike-cdn-widgets.s3-eu-west-1.amazonaws.com/0af277ee13dc0508efad8915517bf694eb1dbc21bb4152cf920a8ae1b3d35228.js"></script></body>
</html>
