<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
    
<footer>
      <div class="container">
        <div class="row">
          <div class="span3">
            <div class="widget">
            <%
            
            DT_publicaciones dtpus = new DT_publicaciones(); 
            ArrayList<Tbl_publicaciones> listatTfoot = new ArrayList<Tbl_publicaciones>();
            listatTfoot = dtpus.titulosFtr();
            String publicado = "publicado";
            String titulo1="",titulo2="",titulo3="", titulo4="";
            
            for(Tbl_publicaciones tpublc : listatTfoot){
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
            
            listatTfoot = dtpus.itemsFtr();
            String item1="", item2="", item3="", item4="", item5="", item6="", item7="", item8="",item9="",
            		item10="",item11="",item12="",item13="",item14="",item15="", item16="";
            String enlace2="", enlace3="", enlace4="", enlace5="", enlace6="", enlace7="", enlace8="", enlace9="";
            for(Tbl_publicaciones tpublc : listatTfoot){
            	if(tpublc.getPublic_estado().trim().equals(publicado)){
            		if(tpublc.getMenu_order() == 1){
            			item1 = tpublc.getPublic_content();
            		}else if(tpublc.getMenu_order() == 2){
            			item2 = tpublc.getPublic_titulo();
            			enlace2 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 3){
            			item3 = tpublc.getPublic_titulo();
            			enlace3 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 4){
            			item4 = tpublc.getPublic_titulo();
            			enlace4 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 5){
            			item5 = tpublc.getPublic_titulo();
            			enlace5 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 6){
            			item6 = tpublc.getPublic_titulo();
            			enlace6 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 7){
            			item7 = tpublc.getPublic_titulo();
            			enlace7 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 8){
            			item8 = tpublc.getPublic_titulo();
            			enlace8 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 9){
            			item9 = tpublc.getPublic_titulo();
            			enlace9 = tpublc.getPublic_enlace();
            		}else if(tpublc.getMenu_order() == 10){
            			item10 = tpublc.getPublic_titulo();
            		}else if(tpublc.getMenu_order() == 11){
            			item11 = tpublc.getPublic_titulo();
            		}else if(tpublc.getMenu_order() == 12){
            			item12 = tpublc.getPublic_titulo();
            		}else if(tpublc.getMenu_order() == 13){
            			item13 = tpublc.getPublic_titulo();
            		}	
            	}
            }
            %>
            
              <h5 class="widgetheading"><%=titulo1 %></h5>
              <ul class="link-list">
               <%=item1 %>
              </ul>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading"><%=titulo2 %></h5>
              <ul class="link-list">
                <li><a href=<%=enlace2%>><%=item2 %></a></li>
                <li><a href=<%=enlace3%>><%=item3 %></a></li>
                <li><a href=<%=enlace4%>><%=item4 %></a></li>
                <li><a href=<%=enlace5%>><%=item5 %></a></li>
              </ul>
            </div>
          </div>
          <div class="span3">
            <div class="widget">
              <h5 class="widgetheading"><%=titulo3 %></h5>
              <ul class="link-list">
                <li><a href=<%=enlace6%>><%=item6 %></a></li>
                <li><a href=<%=enlace7%>><%=item7 %></a></li>
                <li><a href=<%=enlace8%>><%=item8 %></a></li>
                <li><a href=<%=enlace9%>><%=item9 %></a></li>
              </ul>
            </div>
          </div>
                    <div class="span3">
            <div class="widget">
              <h5 class="widgetheading"><%=titulo4 %></h5>
              <address>
			  <strong><%=item10 %></strong>
			  <br> <%=item11 %>
			 </address>
              <p>
                <i class="icon-phone"></i><%=item12 %><br>
                <i class="icon-envelope-alt"></i><%=item13 %>
              </p>
            </div>
          </div>
        </div>
      </div>
</footer>