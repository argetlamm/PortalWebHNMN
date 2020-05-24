<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*, java.util.Map.Entry, java.io.File;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Noticia - Herbario Nacional de Nicaragua</title>
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
              <h2>Noticia individual</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="noticias.jsp?category=all&page=1">Noticias</a><i class="icon-angle-right"></i></li>
              <li class="active">Noticia</li>
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
              <%
            	DT_publicaciones dtpus = new DT_publicaciones();
            	ArrayList<Tbl_publicaciones> listaCategorias = new ArrayList<Tbl_publicaciones>();
            	listaCategorias = dtpus.listarCategoriasCompletas();
            	String categoria = "";
            	int cantidad = 0;
            	ArrayList<Tbl_publicaciones> categoriasSinRepetidos = new ArrayList<Tbl_publicaciones>();
            	Map<String, Tbl_publicaciones> mapPublicacion = new HashMap<String, Tbl_publicaciones>(listaCategorias.size());
            	
            	for(Tbl_publicaciones tpub : listaCategorias)
            	{
            		mapPublicacion.put(tpub.getPublic_tipo(), tpub);
            	}
            	
            	for(Entry<String, Tbl_publicaciones> tpub : mapPublicacion.entrySet())
            	{
            		categoriasSinRepetidos.add(tpub.getValue());
            	}
            %>
            	
              <div class="widget">
                <h5 class="widgetheading">Categorías</h5>
                <ul class="cat">
                <%
	                for(Tbl_publicaciones tpub : categoriasSinRepetidos)
	            	{
		            	categoria = tpub.getPublic_tipo();
		            	cantidad = dtpus.cantidadCategoriaCompletas(categoria);
	            %>
                  <li><i class="icon-angle-right"></i><a href="${pageContext.request.contextPath}/SL_noticias?category=<%=categoria%>&page=1"><%=categoria %></a><span> (<%=cantidad %>)</span></li>
                <%
	            	}
	            %>
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
          <%
          	String idNoticia = "";
          	idNoticia = request.getParameter("IdNot");
	      	int id = Integer.parseInt(idNoticia);
	      	
	      	DT_publicaciones dpus = new DT_publicaciones();
	  		ArrayList<Tbl_publicaciones> noticia = new ArrayList<Tbl_publicaciones>();
	  		String publicado = "publicado";
	  		String titulo = "";
	  		String contenido = "";
	  		String fecha = "";
	  		String autor = "";
	  		String categoriaArt = "";
	  		String url = "";
	  		
	  		noticia = dpus.detallesArt(id);
	  		for (Tbl_publicaciones tpublc : noticia){
	          	if(tpublc.getPublic_estado().trim().equals(publicado)){
	          		titulo = tpublc.getPublic_titulo();
	          		contenido = tpublc.getPublic_content();
	          		fecha = tpublc.getPublic_fecha();
	          		autor = tpublc.getGuid();
	          		categoriaArt = tpublc.getPublic_tipo();
	          		url = tpublc.getPublic_imagen_art();
	          	}
	  		}
          %>
            <article>
              <div class="row">
                <div class="span8">
                  <div class="post-image">
                    <div class="post-heading">
                      <h3><a href="#"><%=titulo %></a></h3>
                    </div>
                    <% 
                   	File f = new File(url);
                   	if(f.exists() && !f.isDirectory()){
                   		%>
                       	<img src=<%=url %> alt="" />
                       	<%
                   	}else{
                   		%>
                       	<img src="img/events/imagenEjemplo.jpg"/>
                       	<%
                   	}
                    %>
                  </div>
                  <p> <%=contenido %> </p>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"><%=fecha %></a></li>
                      <li><i class="icon-user"></i><a href="#"><%=autor %></a></li>
                      <li><i class="icon-folder-open"></i><a href="#"><%=categoriaArt %></a></li>
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