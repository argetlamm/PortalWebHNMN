 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
 <!-- start header -->
    <header>
      <div class="container ">
        <div class="row nomargin">
          <div class="span12">
            <div class="headnav">
              <ul>
                <li><a href="registro.jsp"><i class="icon-user"></i> Regístrate</a></li>
                <li><a href="././CMS/index.jsp">Iniciar Sesión</a></li>
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
                ArrayList<Tbl_publicaciones> listatTblp = new ArrayList<Tbl_publicaciones>();
                listatTblp = dtpus.itemMenu();
                String publicado = "publicado";
                String item1="", item2="", item3="", item4="", item5="", item6="", item7="", item8="";
                for (Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 1){
                			item1 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 2){
                			item2 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 3){
                			item3 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 4){
                			item4 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 5){
                			item5 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 6){
                			item6 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 7){
                			item7 = tpublc.getPublic_titulo();
                		}else if(tpublc.getMenu_order() == 8){
                			item8 = tpublc.getPublic_titulo();
                		}
                	}
                }
                	//System.out.println("LETRAAAAS:  ="+tblp.getPublic_titulo());
                %>
                  <ul class="nav topnav">
                    <li class="dropdown active">
                      <a href="index.jsp"><%=item1 %></a>
                    </li>
                    <li class="dropdown">
                      <a href="noticias.jsp"><%=item2 %>
                      <i class="icon-angle-down">
                      </i>
                      </a>
                      <ul class="dropdown-menu">
                        <li><a href="articulos.jsp"><%=item3 %></a></li>
                        <li><a href="eventos.jsp"><%=item4 %></a></li>
                        <li><a href="cursos.jsp"><%=item5 %></a></li>
                      </ul>
                    </li>
                    <li class="dropdown">
                      <a href="colecciones.jsp"><%=item6 %></a>
                    </li>
                    <li class="dropdown">
                      <a href="acercade.jsp"><%=item7 %> </a>
                    </li>
                    <li>
                      <a href="contacto.jsp"><%=item8 %> </a>
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