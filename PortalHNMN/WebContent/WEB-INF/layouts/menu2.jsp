 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
 <!-- start header -->
<%
	String loginUser = "";
	int rolId = 0;

	loginUser = (String) session.getAttribute("login");
	loginUser = loginUser==null?"":loginUser;
%>
    <header>
      <div class="container ">
        <div class="row nomargin">
          <div class="span12">
            <div class="headnav">
            <ul>
            	<li><a href="#">Bienvenido: <%=loginUser %></a></li>
            	<li><a class="dropdown-item dropdown-footer" href="${pageContext.request.contextPath}/index.jsp"> <i class="fa fa-power-off"></i>
		  			<span>Cerrar Sesión</span></li>
		  	</a>
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
                String item1="", item2="", item3="", item4="", item5="", item6="", item7="", item8="",
                		item9="", item10="", item11="", item12="";
                String item1_1="", item22="", item33="", item44="", item55="", item66="", item77="", item88="",
                		item99="", item100="", item111="", item122=""; 
                for (Tbl_publicaciones tpublc : listatTblp){
                	if(tpublc.getPublic_estado().trim().equals(publicado)){
                		if(tpublc.getMenu_order() == 1){
                			item1 = tpublc.getPublic_titulo();
                			item1_1 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 2){
                			item2 = tpublc.getPublic_titulo();
                			item22 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 3){
                			item3 = tpublc.getPublic_titulo();
                			item33 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 4){
                			item4 = tpublc.getPublic_titulo();
                			item44 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 5){
                			item5 = tpublc.getPublic_titulo();
                			item55 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 6){
                			item6 = tpublc.getPublic_titulo();
                			item66 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 7){
                			item7 = tpublc.getPublic_titulo();
                			item77 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 8){
                			item8 = tpublc.getPublic_titulo();
                			item88 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 9){
                			item9 = tpublc.getPublic_titulo();
                			item99 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 10){
                			item10 = tpublc.getPublic_titulo();
                			item100 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 11){
                			item11 = tpublc.getPublic_titulo();
                			item111 = tpublc.getPublic_enlace();
                		}else if(tpublc.getMenu_order() == 12){
                			item12 = tpublc.getPublic_titulo();
                			item122 = tpublc.getPublic_enlace();
                		}
                	}
                }
                %>
                  <ul class="nav topnav">
                    <li class="dropdown active">
                      <a href=<%=item1_1.trim() %>><%=item1 %></a>
                    </li>
                    <li class="dropdown">
                      <a href=<%=item22.trim() %>><%=item2 %></a>
                    </li>
                    <li class="dropdown">
                      <a href=<%=item33.trim() %>><%=item3 %></a>
                    </li>
                    <li class="dropdown">
                      <a href=<%=item44.trim() %>><%=item4 %>
                      <i class="icon-angle-down">
                      </i>
                      </a>
                      <ul class="dropdown-menu">
                        <li><a href=<%=item55.trim() %>><%=item5 %></a></li>
                        <li><a href=<%=item66.trim() %>><%=item6 %></a></li>
                        <li><a href=<%=item77.trim() %>><%=item7 %></a></li>
                      </ul>
                    </li>
                    <li>
                      <a href=<%=item88.trim() %>><%=item8 %> </a>
                    </li>
                    <li class="dropdown">
                      <a href=<%=item99.trim() %>><%=item9%>
                      <i class="icon-angle-down">
                      </i>
                      </a>
                      <ul class="dropdown-menu">
                      	<li><a href=<%=item100.trim() %>><%=item10 %></a></li>
                      	<li><a href=<%=item111.trim() %>><%=item11 %></a></li>
                      	<li><a href=<%=item122.trim() %>><%=item12 %></a></li>
                      </ul>
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