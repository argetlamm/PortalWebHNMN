 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
 <!-- start header -->
    <header>
      <div class="container ">
        <div class="row nomargin">
          <div class="span12">
            <div class="headnav">
              <ul>
                <li><a href="#mySignup" data-toggle="modal"><i class="icon-user"></i> Regístrate</a></li>
                <li><a href="././CMS/index.jsp" data-toggle="modal">Iniciar Sesión</a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="span4">
            <div class="logo">
              <a href="index.jsp"><img src="img/logohn.png" alt="" class="logo" /></a>
              <h1>Herbario Nacional de Nicaragua</h1>
            </div>
          </div>
          <div class="span8">
            <div class="navbar navbar-static-top">
              <div class="navigation">
                <nav>
                <%
                	DT_publicaciones dtpus = new DT_publicaciones();
                	Tbl_publicaciones tblp = new Tbl_publicaciones();
                	tblp = dtpus.itemMenu();
                	System.out.println("LETRAAAAS:  ="+tblp.getPublic_titulo());
                %>
                  <ul class="nav topnav">
                    <li class="dropdown active">
                      <a href="index.jsp"><%=tblp.getPublic_titulo()%></a>
                    </li>
                    <li class="dropdown">
                      <a href="noticias.jsp">Noticias <i class="icon-angle-down"></i></a>
                      <ul class="dropdown-menu">
                        <li><a href="articulos.jsp">Artículos</a></li>
                        <li><a href="eventos.jsp">Eventos</a></li>
                        <li><a href="cursos.jsp">Cursos</a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="colecciones.jsp">Colecciones</a>
                    </li>
                    <li class="dropdown">
                      <a href="acercade.jsp">Acerca De </a>
                    </li>
                    <li>
                      <a href="contacto.jsp">Contacto </a>
                    </li>
                  </ul>
                </nav>
              </div>
              <!-- end navigation -->
            </div>
          </div>
        </div>
      </div>
    </header>
    <!-- end header -->