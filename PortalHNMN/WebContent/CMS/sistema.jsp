<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<%
	//Recuperamos el valor del username especificado al crear la sesión en el servlet del login (SL_login_usuarios)
	String loginUser = "";
	int rolId = 0;

	loginUser = (String) session.getAttribute("login");
	loginUser = loginUser==null?"":loginUser;

	//Si el login recuperado es vacío, redirecciono al login.
	if(loginUser.equals(""))
	{
		response.sendRedirect("index.jsp");
	}
	else
	{
		//Si el login contiene datos se realizará esto
		ArrayList<V_tbl_Rol_Opcion> listOpciones = new ArrayList <V_tbl_Rol_Opcion>();
		DT_rol dtr = new DT_rol();
		//Se asigna a un nuevo objeto de tipo httpSession el valor de la sesión activa para poder setear un dato nuevo
    	HttpSession hts2 = request.getSession(true);
		//Se solicita el id del rol que la sesión provee y se parsea a entero (la sesión sólo provee datos en String)
    	int idRol = Integer.parseInt( hts2.getAttribute("idRol").toString());
		//Se llena el ArrayList de listOpciones con las opciones que tiene disponible el rol que posee el id enviado
   		listOpciones = dtr.listRolOpc(idRol);
		//Posteriormente se setea en la sesión nueva las opciones que el usuario tiene disponible según lo obtenido
    	hts2.setAttribute("listOpciones", listOpciones);
	}
%>
<%
	//Se policita a la sesión activa el atributo de ayuda (1 si el usuario desea que aparezcan las ayudas, 2 si no lo desea)
	String ayudaS = "";
	int ayuda = 0;

	ayudaS = (String) session.getAttribute("ayuda");
	ayudaS = ayudaS==null?"":ayudaS;
	ayuda = Integer.parseInt(ayudaS);
%>


 <title>CMS | Herbario Nacional de Nicaragua</title>

 <!-- Font Awesome Icons -->
 <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
 <!-- IonIcons -->
 <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
 <!-- Theme style -->
 <link rel="stylesheet" href="dist/css/adminlte.min.css">
 <!-- Google Font: Source Sans Pro -->
 <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
 <!-- jAlert css  -->
 <link rel="stylesheet" href="../plugins/jAlert/dist/jAlert.css" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
  
  <!-- Navbar -->
  	<jsp:include page="layouts/topbar.jsp"></jsp:include>
  <!-- /.navbar -->

  <!-- SIDEBAR -->
  	<jsp:include page="layouts/menu.jsp"></jsp:include>
  <!-- SIDEBAR -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid" align="center">
      <form role="form" action="${pageContext.request.contextPath}/SL_ayudas" method="post">
      	<%
      	//Si la ayuda es uno, creará, dentro del formulario que reacciona al botón de Cambiar, un dúo de radio buttons
      	//Y aparecerá marcado, por defecto, el botón "Si", o sea, la opción 1
        if(ayuda==1)
        {
        %>
          	<label> ¿Ayuda disponible? </label>
         	<br>
            <input type="radio" id="yes" name="option" value="a" checked>
         	<label for="yes">Si</label><br>
         	<input type="radio" id="no" name="option" value="b">
         	<label for="no">No</label><br>
         	<input type="submit" value="Cambiar">
         	<h3> Luego de presionar el botón, por favor cierre e inicie sesión nuevamente, sino, el cambio no se verá reflejado</h3>
        <%
        }
        else
        {
        	//Si la ayuda es dos, creará, dentro del formulario que reacciona al botón de Cambiar, un dúo de radio buttons
          	//Y aparecerá marcado, por defecto, el botón "No", o sea, la opción 2
        %>
	        <label> ¿Ayuda disponible? </label>
	        <br>
	        <input type="radio" id="yes" name="option" value="a">
	        <label for="yes">Si</label><br>
	        <input type="radio" id="no" name="option" value="b" checked>
	        <label for="no">No</label><br>
	        <input type="submit" value="Cambiar">
	        <h3> Luego de presionar el botón, por favor cierre e inicie sesión nuevamente, sino, el cambio no se verá reflejado</h3>
        <%
        }
      	%>
      </form>
      <img alt="" src="dist/img/const.jpg">
      </div>
      <div class="card-header" style="text-aling:right;">
      	<a target="_blank" href="https://analytics.google.com/analytics/web/?authuser=1#/report-home/a153329080w216581644p206913185" 
      	class="btn btn-primary"><i class="fas fa-chart-line"></i> Google Analytics</a>
      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Footer -->
  	<jsp:include page="layouts/footer.jsp"></jsp:include>
  <!-- ./Footer -->
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="dist/js/adminlte.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="plugins/chart.js/Chart.min.js"></script>
<script src="dist/js/demo.js"></script>
<script src="dist/js/pages/dashboard3.js"></script>
<!-- jAlert js -->
<script src="../plugins/jAlert/dist/jAlert.min.js"></script>
<script src="../plugins/jAlert/dist/jAlert-functions.min.js"> </script>
<script src="../plugins/select2/js/select2.full.min.js"></script>

</body>
</html>