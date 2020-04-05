 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Quiénes somos - Herbario Nacional de Nicaragua</title>
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
  <!-- boxed bg -->
  <link id="bodybg" href="bodybg/bg1.css" rel="stylesheet" type="text/css" />
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
              <h2>¿Quiénes Somos?</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li class="active">¿Quiénes Somos?</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
    <section id="content">
      <div class="container">
         <div class="row">
          <div class="span6">
          	<%
          		DT_publicaciones dtpus = new DT_publicaciones();
            	ArrayList<Tbl_publicaciones> listatTblp = new ArrayList<Tbl_publicaciones>();
            	listatTblp = dtpus.titulosQuienesSomos();
            	String publicado = "publicado";
            	String titulo1="",titulo2="",titulo3="", titulo4="";
  
            	for(Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 1){
                			titulo1=tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 2){
                			titulo2 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 3){
                			titulo3 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 4){
                			titulo4 = tpublc.getPublic_titulo();
                		}
                	}
                }
          	%>
          	<h2><b><%=titulo1 %></b></h2>
            <%
                	DT_publicaciones dtpusdos = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listaIQSomos = new ArrayList<Tbl_publicaciones>();
                listaIQSomos = dtpusdos.itemsQuienesSomos();
                String parrafo="";
                for (Tbl_publicaciones tpublc : listaIQSomos){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                			parrafo=tpublc.getPublic_content();
		
                %>
                <p><%=parrafo %></p>
                <%
               	 	}
                }
                %>
          </div>
          <div class="span6">
            <!-- start flexslider -->
            <div class="flexslider">
              <ul class="slides">
                <li>
                  <img src="img/works/full/image-01-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-02-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-03-full.jpg" alt="" />
                </li>
              </ul>
            </div>
            <!-- end flexslider -->
          </div>
        </div>
         <!-- divider -->
        <div class="row">
          <div class="span12">
            <div class="solidline">
            </div>
          </div>
        </div>
        <!-- end divider -->
        <div class="row">
          <div class="span6">
          	<h2><b><%=titulo2 %></b></h2>
          <%
                	DT_publicaciones dtpusTres = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listaIHistoria = new ArrayList<Tbl_publicaciones>();
                listaIHistoria = dtpusdos.itemsHistoria();
                String parrafoH="";
               
                for (Tbl_publicaciones tpublc : listaIHistoria){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		parrafoH=tpublc.getPublic_content();
                %>
                <p><%=parrafoH %></p>
                <%
                	}
                }
                %>
          </div>
          <div class="span6">
            <!-- start flexslider -->
            <div class="flexslider">
              <ul class="slides">
                <li>
                  <img src="img/works/full/image-01-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-02-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-03-full.jpg" alt="" />
                </li>
              </ul>
            </div>
            <!-- end flexslider -->
          </div>
        </div>
        <!-- divider -->
        <div class="row">
          <div class="span12">
            <div class="solidline">
            </div>
          </div>
        </div>
        <!-- end divider -->
        <div class="row">
          <div class="span6">
				<h2><b><%=titulo3 %></b></h2>
          <%
                	DT_publicaciones dtpusCuatro = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listaIVision = new ArrayList<Tbl_publicaciones>();
                listaIVision = dtpusdos.itemsVision();
                String parrafoV="";
               
                for (Tbl_publicaciones tpublc : listaIVision){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		parrafoV=tpublc.getPublic_content();
                %>
                <p><%=parrafoV %></p>
                <%
                	}
                }
                %>
          </div>
          <div class="span6">
            <!-- start flexslider -->
            <div class="flexslider">
              <ul class="slides">
                <li>
                  <img src="img/works/full/image-01-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-02-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-03-full.jpg" alt="" />
                </li>
              </ul>
            </div>
            <!-- end flexslider -->
          </div>
        </div>
        <div class="row">
          <div class="span6">
				<h2><b><%=titulo4 %></b></h2>
          <%
                	DT_publicaciones dtpusCinco = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listaIMision = new ArrayList<Tbl_publicaciones>();
                listaIMision = dtpusdos.itemsMision();
                String parrafoM="";
               
                for (Tbl_publicaciones tpublc : listaIMision){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		parrafoM=tpublc.getPublic_content();
                %>
                <p><%=parrafoM %></p>
                <%
                	}
                }
                %>
          </div>
          <div class="span6">
            <!-- start flexslider -->
            <div class="flexslider">
              <ul class="slides">
                <li>
                  <img src="img/works/full/image-01-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-02-full.jpg" alt="" />
                </li>
                <li>
                  <img src="img/works/full/image-03-full.jpg" alt="" />
                </li>
              </ul>
            </div>
            <!-- end flexslider -->
          </div>
        </div>
        <!-- divider -->
        <div class="row">
          <div class="span12">
            <div class="solidline">
            </div>
          </div>
        </div>
        <!-- end divider -->
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
  
<script async type="text/javascript" src="https://userlike-cdn-widgets.s3-eu-west-1.amazonaws.com/54537da60973928bf0460f49379de0b7757d7a01cff914af08b8b9cf87bc6502.js"></script>
</body>

</html>
