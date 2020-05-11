<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*, java.util.Map.Entry;"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Art�culos - Herbario Nacional de Nicaragua</title>
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

</head>

<body>
  <div id="wrapper">
  	<!-- MENU -->
  	<jsp:include page="WEB-INF/layouts/menu4.jsp"></jsp:include>
    <!-- MENU -->
    
    <section id="inner-headline">
      <div class="container">
        <div class="row">
          <div class="span4">
            <div class="inner-heading">
              <h2>�ltimos art�culos</h2>
            </div>
          </div>
          <div class="span8">
            <ul class="breadcrumb">
              <li><a href="index.jsp"><i class="icon-home"></i></a><i class="icon-angle-right"></i></li>
              <li><a href="noticias.jsp">Noticias</a><i class="icon-angle-right"></i></li>
              <li class="active">Publicaciones</li>
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
            	listaCategorias = dtpus.listarCategorias();
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
                <h5 class="widgetheading">Categor�as</h5>
                <ul class="cat">
                <%
	                for(Tbl_publicaciones tpub : categoriasSinRepetidos)
	            	{
		            	categoria = tpub.getPublic_tipo();
		            	cantidad = dtpus.cantidadCategoria(categoria);
	            %>
                  <li><i class="icon-angle-right"></i><a href="${pageContext.request.contextPath}/SL_articulos?category=<%=categoria%>&page=1"><%=categoria %></a><span> (<%=cantidad %>)</span></li>
                <%
	            	}
	            %>
                </ul>
              </div>
            </aside>
          </div>
          <div class="span8">
          <%
          		//Solicitamos el valor de category, y de page, ambos provienen del URL.
       			String categoriaActual = request.getParameter("category");
          		String paginaCadena = request.getParameter("page");
          		int paginaActual = Integer.parseInt(paginaCadena);
          		//Declaramos nuestras variables a usar
				int cantidadArt = 0;
				int cantidadPaginas = 0;
				int articulosARestar = 0;
				
          		//Creamos nuestro objeto de Datos y un ArrayList de los art�culos a mostrar en pantalla.
	          	DT_publicaciones dpus = new DT_publicaciones();
	      		ArrayList<Tbl_publicaciones> listaArticulos = new ArrayList<Tbl_publicaciones>();
	      		
	      		//Si la categor�a actual es "all", que es el valor por defecto, entrar� al if.
	      		if(categoriaActual.equals("all"))
	      		{
					//Primero, le damos valor a la cantidad de art�culos, que la usaremos para saber cu�ntas p�ginas hay.
					cantidadArt = dpus.cantidadArticulos();
					
					//Si existen m�s de 5 art�culos, entrar� al if para calcular cu�ntas p�ginas hay y comprobar en cu�l se est�
					if(cantidadArt>5)
					{
						//Si sobra residuo, significa que la divisi�n NO se hace entre un m�ltilplo de 5
						if((cantidadArt%5)!=0)
						{
							//Por ende, haremos la divisi�n normal, que s�lo nos devolver� la parte entera y le sumaremos 1
							//que ser�a la p�gina extra por esos art�culos que no se podr�n mostrar en las p�ginas "cerradas"
							//o sea, con 5 art�culos completos. Ej:
							//Si tenemos 14 art�culos, el resultado ser� 2, y sobrar� 4, entonces nuestras p�ginas ser�n 3
							//ya que posicionaremos los primeros 5 art�culos en la primera p�gina, los siguientes 5
							//en la segunda p�gina, y los �ltimos cuatro en la tercera p�gina, o sea, la que sumamos al final.
							cantidadPaginas = (cantidadArt/5)+1;
							//Y ac� comprobamos en qu� p�gina estamos.
							if(paginaActual>1)
			          		{
								//Si estamos en cualquiera que no es la primera, se calcular� cu�ntos art�culos se obviar�n
								//o sea, cu�ntos art�culos est�n en las p�ginas anteriores y no tenemos que mostrar
								//Ej: Si la p�gina es la 5, significa que tendr� que comenzar por el art�culo 21
								//Y ser�a 5-1 = 4.
								//4 * 5 = 20 (Ver el m�todo que se usar� para entender por qu� mandar� 20 en vez de 21.)
								articulosARestar = (paginaActual-1)*5;
				      			//Y listaremos los 5 art�culos que nos interesan seg�n el par�metro
				      			listaArticulos = dpus.listarArticulosPorPagina(articulosARestar);
			          		}
							else
							{
								//Se hace el else porque, a pesar de que hayan m�s de 5 art�culos, a�n se puede redireccionar
								//a la primera p�gina
								articulosARestar = 0;
								listaArticulos = dpus.listarArticulosPorPagina(articulosARestar);
							}
						}
						else
						{
							//Si es un m�ltiplo de 5, significa que todas las p�ginas tendr�n cinco art�culos
							cantidadPaginas = cantidadArt/5;
							if(paginaActual>1)
			          		{
								articulosARestar = (paginaActual-1)*5;
								listaArticulos = dpus.listarArticulosPorPagina(articulosARestar);
			          		}
							else
							{
								articulosARestar = 0;
								listaArticulos = dpus.listarArticulosPorPagina(articulosARestar);
							}
						}
					}
					else
					{
						//Sino hay m�s de cinco art�culos, s�lo puede haber una p�gina
						cantidadPaginas = 1;
						articulosARestar = 0;
						listaArticulos = dpus.listarArticulosPorPagina(articulosARestar);
					}
	      		}
	      		else
	      		{
	      			//Si la categor�a es cualquier otra, o sea, es un filtro, estaremos ac� en el else.
	      			//Donde comenzaremos a listar, de nuevo, la lista de las categorias existentes sin repetici�n
	      			for(Tbl_publicaciones tpub : categoriasSinRepetidos)
	          		{
	      				//Por cada objeto, asignaremos a una variable llamada categor�a, la categor�a del objeto
	          			categoria = tpub.getPublic_tipo();
	          			//Si la categor�a "de turno" del for, es igual a la categor�a actual, entraremos al if.
	          			if(categoria.trim().equals(categoriaActual.trim()))
	          			{
	          				//Veremos cu�ntos art�culos hay seg�n la categor�a
	          				cantidadArt = dtpus.cantidadCategoria(categoria);
	          				//Si hay m�s de 5 art�culos, entrar� al if
	          				if(cantidadArt>5)
	        				{
	          					//Y hacemos las mismas comprobaciones del primer caso.
	        					if((cantidadArt%5)!=0)
	        					{
	        						cantidadPaginas = (cantidadArt/5)+1;
	        						if(paginaActual>1)
	    			          		{
	    								articulosARestar = (paginaActual-1)*5;
	    								//Como en este caso tambi�n nos interesa filtrar por categor�a
	    								//Usaremos otro m�todo que filtra por categor�a y por art�culos a obviar
	    								listaArticulos = dpus.listarArticulosPorPaginaCategoria(categoriaActual.trim(), articulosARestar);
	    			          		}
	    							else
	    							{
	    								articulosARestar = 0;
	    								listaArticulos = dpus.listarArticulosPorPaginaCategoria(categoriaActual.trim(), articulosARestar);
	    							}	
	        					}
	        					else
	        					{
	        						cantidadPaginas = cantidadArt/5;
	        						if(paginaActual>1)
	        						{
	        							articulosARestar = (cantidadPaginas-1)*5;
	        							listaArticulos = dpus.listarArticulosPorPaginaCategoria(categoriaActual, articulosARestar);
	        						}
	        						else
	    							{
	    								articulosARestar = 0;
	    								listaArticulos = dpus.listarArticulosPorPaginaCategoria(categoriaActual, articulosARestar);
	    							}
	        					}
	        				}
	          				else
	    					{
	    						cantidadPaginas = 1;
	    						articulosARestar = 0;
	    						listaArticulos = dpus.listarArticulosPorPaginaCategoria(categoriaActual, articulosARestar);
	    					}
	          			}
	          		}
	      		}

	      		String titulo = "";
	      		String previa = "";
	      		String fecha = "";
	      		String redactor = "";
	      		String categoriaArt = "";
	      		String url = "";
	      		int id = 0;
	      		int contador = 0;
	      		
	      		for(Tbl_publicaciones tpub : listaArticulos)
	      		{
	      			titulo = tpub.getPublic_titulo();
	      			previa = tpub.getPublic_previa();
	      			fecha = tpub.getPublic_fecha();
	      			redactor = tpub.getGuid();
	      			id = tpub.getMenu_order();
	      			categoriaArt = tpub.getPublic_tipo();
	      			url = tpub.getPublic_imagen_art();
	      			if(url.trim().equals("sin-imagen"))
	      			{
	      	%>
            <article>
              <div class="row">
                <div class="span8">
                  <div class="post-quote">
                    <div class="post-heading">
                      <h3><a href="#"><%=titulo %></a></h3>
                    </div>
                    <blockquote>
                      <i class="icon-quote-left"></i> <%=previa%>...
                    </blockquote>
                  </div>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"><%=fecha %></a></li>
                      <li><i class="icon-user"></i><a href="#"><%=redactor %></a></li>
                      <li><i class="icon-folder-open"></i><a href="#"><%=categoriaArt %></a></li>
                    </ul>
                    <a href="${pageContext.request.contextPath}/SL_articuloIndividual?IdArt=<%=id%>" class="pull-right">Continua leyendo... <i class="icon-angle-right"></i></a>
                  </div>
                </div>
              </div>
            </article>
            <%
		      		}
	      			else
	      			{
	      	%>
	      	<article>
              <div class="row">
                <div class="span8">
                  <div class="post-image">
                    <div class="post-heading">
                      <h3><a href="#"><%=titulo %></a></h3>
                    </div>
                    <img src=<%=url %> alt="" />
                  </div>
                  <p>
                    <%=previa%>...
                  </p>
                  <div class="bottom-article">
                    <ul class="meta-post">
                      <li><i class="icon-calendar"></i><a href="#"><%=fecha %></a></li>
                      <li><i class="icon-user"></i><a href="#"><%=redactor %></a></li>
                      <li><i class="icon-folder-open"></i><a href="#"><%=categoriaArt %></a></li>
                    </ul>
                    <a href="${pageContext.request.contextPath}/SL_articuloIndividual?IdArt=<%=id%>" class="pull-right">Continua leyendo... <i class="icon-angle-right"></i></a>
                  </div>
                </div>
              </div>
            </article>
	      	<%
	      			}
            	}
            %>
            <div id="pagination">
              <span class="all">P�gina <%=paginaActual %> de <%=cantidadPaginas %></span>
              <%
              //Si la p�gina en la que estamos NO es la 1.
              if(paginaActual>1)
              {
                  for(int i=1; i<=cantidadPaginas; i++)
                  {
                	  //Comprobamos cuando la p�gina en la que estamos sea igual a la I del for
                	  if(i==paginaActual)
                	  {
                		  //Y le crearemos un span espec�fico para el resaltado
                		  %>
                		  <span class="current"><%=i %></span>
                		  <%
                	  }
                	  else
                	  {
                		  //En los otros casos, crearemos un enlace para el cambio de p�gina y que se mantenga la categor�a
                	  %>
                	  <a href="${pageContext.request.contextPath}/SL_articulos?category=<%=categoriaActual%>&page=<%=i%>" class="inactive"><%=i %></a>
                	  <%
                	  }
                  }
              }
              else
              {
            	  //Si la p�gina es la uno, creamos ya por defecto el span con el 1 resaltado y sin enlace
            	  %>
            	  <span class="current">1</span>
            	  <%
            	  //Y el for empezar� por la p�gina 2
            	  for(int i=2; i<=cantidadPaginas; i++)
                  {
                	  %>
                	  <a href="${pageContext.request.contextPath}/SL_articulos?category=<%=categoriaActual%>&page=<%=i%>" class="inactive"><%=i %></a>
                	  <%
                  }
              }
              %>
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

<script async type="text/javascript" src="https://userlike-cdn-widgets.s3-eu-west-1.amazonaws.com/0af277ee13dc0508efad8915517bf694eb1dbc21bb4152cf920a8ae1b3d35228.js"></script>

</body>

</html>

