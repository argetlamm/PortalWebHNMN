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
                listatTblp = dtpus.QuienesSomos();
                String publicado = "publicado";
                String item1="", item2="", item3="";
                for (Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 1){
                			item1 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 2){
                			item2 = tpublc.getPublic_content();
                		}else if(tpublc.getMenu_order() == 3){
                			item3 = tpublc.getPublic_content();
                		}
                	}
                }
                	//System.out.println("LETRAAAAS:  ="+tblp.getPublic_titulo());
                %>
                <h2><b><%=item1 %></b></h2>
                <p><%=item2 %></p>
                <p><%=item3 %></p>
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
          <%
                	/*DT_publicaciones dtpus = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listatTblp = new ArrayList<Tbl_publicaciones>();*/
                listatTblp = dtpus.QuienesSomos();
                //String publicado = "publicado";
                String item4="", item5="", item6="", item7="";
                for (Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 4){
                			item4 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 5){
                			item5 = tpublc.getPublic_content();
                		}else if(tpublc.getMenu_order() == 6){
                			item6 = tpublc.getPublic_content();
                		}else if(tpublc.getMenu_order() == 7){
                			item7 = tpublc.getPublic_content();
                		}
                	}
                }
                	//System.out.println("LETRAAAAS:  ="+tblp.getPublic_titulo());
                %>
                <h2><b><%=item4 %></b></h2>
                <p><%=item5 %></p>
                <p><%=item6 %></p>
                <p><%=item7 %></p>
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
				<%
                	/*DT_publicaciones dtpus = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listatTblp = new ArrayList<Tbl_publicaciones>();*/
                listatTblp = dtpus.QuienesSomos();
                //String publicado = "publicado";
                String item8="", item9="";
                for (Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 8){
                			item8 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 9){
                			item9 = tpublc.getPublic_content();
                		}
                	}
                }
                	//System.out.println("LETRAAAAS:  ="+tblp.getPublic_titulo());
                %>
                <h2><b><%=item8 %></b></h2>
                <p><%=item9 %></p>
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
				<%
                	/*DT_publicaciones dtpus = new DT_publicaciones();
                ArrayList<Tbl_publicaciones> listatTblp = new ArrayList<Tbl_publicaciones>();*/
                listatTblp = dtpus.QuienesSomos();
                //String publicado = "publicado";
                String item10="", item11="", item12="";
                for (Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 10){
                			item10 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 11){
                			item11 = tpublc.getPublic_content();
                		}
                		else if(tpublc.getMenu_order() == 12){
                			item12 = tpublc.getPublic_content();
                		}
                	}
                }
                	//System.out.println("LETRAAAAS:  ="+tblp.getPublic_titulo());
                %>
                <h2><b><%=item10 %></b></h2>
                <p><%=item11 %></p>
                <p><%=item12 %></p>
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

</body>

</html>
