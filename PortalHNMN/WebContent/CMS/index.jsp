<%@page import="entidades.Tbl_rol"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
    

<%	
   response.setHeader( "Pragma", "no-cache" );
   response.setHeader( "Cache-Control", "no-store" );
   response.setDateHeader( "Expires", 0 );
   response.setDateHeader( "Expires", -1 );
%>

<%
	HttpSession hts = request.getSession(false);
	hts.removeAttribute("login");
	hts.removeAttribute("idRol");
	hts.invalidate();	
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
 <title>Admin Herbario Nacional | Iniciar Sesion</title>
 <!-- Tell the browser to be responsive to screen width -->
 <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Font Awesome -->
 <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
 <!-- Ionicons -->
 <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
 <!-- icheck bootstrap -->
 <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
 <!-- Theme style -->
 <link rel="stylesheet" href="dist/css/adminlte.min.css">
 <!-- Google Font: Source Sans Pro -->
 <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  <!-- Select2 -->
  <link rel="stylesheet" href="plugins/select2/css/select2.min.css">
  <link rel="stylesheet" href="plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css">
  
  <!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-153329080-1"></script>

<!-- SCRIPT DE GOOGLE ANALITYCS QUE DA SEGUIMIENTO A LA PAGINA -->
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-153329080-1');
</script>
<!-- SCRIPT DE GOOGLE ANALITYCS QUE DA SEGUIMIENTO A LA PAGINA -->

</head>
<body class="hold-transition login-page" style="background-image: url('dist/img/background.jpg');">
<div class="login-box">
  <div class="login-logo">
    <a href="#" style="color: white;"><b>Admin </b>Herbario Nacional</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Inicia Sesión</p>

      <form action="../SL_login_usuarios" method="post">
        <div class="input-group mb-3">
          <input type="text" name="login" class="form-control" placeholder="Usuario">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" name="pwd" class="form-control" placeholder="Contraseña">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
<!--         <div class="input-group mb-3"> -->
<!--            <select class="form-control select2" name="rol" style="width: 100%;" required="required"> -->
<!--              <option value="0">Seleccione un Rol...</option> -->
<%--             	<% --%>
<!-- //             		DT_rol dtr = new DT_rol(); -->
<!-- //             	    ArrayList<Tbl_rol> listRol = new ArrayList<Tbl_rol>(); -->
<!-- //             	    listRol = dtr.listRol(); -->
            	    
<!-- //             	    for(Tbl_rol tr : listRol) -->
<!-- //             	    { -->
<%--             	%> --%>
<%--             		 <option value="<%=tr.getId_rol()%>"><%=tr.getRol_name() %></option> --%>
<%--             	<%	 --%>
<!-- //             		}  -->
<%--             	%> --%>
<!--            </select> -->
<!--         </div> -->
        <div class="row">
          <!-- /.col -->
          <div class="col-6">
            <button type="submit" class="btn btn-primary btn-block btn-flat">Iniciar Sesión</button>
          </div>
          <div class="col-6">
            <button type="reset" class="btn btn-danger btn-block btn-flat">Cancelar</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
      <p class="mb-0">
      <br>
        <a href="../index.jsp" class="text-center">Regresar al sitio web</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
 <!-- Select2 -->
<script src="plugins/select2/js/select2.full.min.js"></script>

<script>
  $(function () 
	{
    //Initialize Select2 Elements
    $('.select2').select2({theme: 'bootstrap4'})
	});
</script>
</body>

</html>