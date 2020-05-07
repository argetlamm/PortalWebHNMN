<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="entidades.*, datos.*, java.util.*;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<%
	String loginUser = "";
	int rolId = 0;

	loginUser = (String) session.getAttribute("login");
	loginUser = loginUser==null?"":loginUser;
	
// 	rolId = (int) session.getAttribute("idRol");
// 	rolId = loginUser==null?0:rolId;
	
	if(loginUser.equals(""))
	{
		response.sendRedirect("index.jsp");
	}
	else
	{
		ArrayList<V_tbl_Rol_Opcion> listOpciones = new ArrayList <V_tbl_Rol_Opcion>();
		DT_rol dtr = new DT_rol();
    	HttpSession hts2 = request.getSession(true);
   		System.out.println("hts.getAttribute(\"idRol\") en sistema = " + hts2.getAttribute("idRol"));
    	int idRol = Integer.parseInt( hts2.getAttribute("idRol").toString());
    	System.out.println("idRol = " + idRol);
   		listOpciones = dtr.listRolOpc(idRol);
    	hts2.setAttribute("listOpciones", listOpciones);
		
		
// 		HttpSession hts4 = request.getSession(true);
// 		hts4.setAttribute("idusuario", idUsuario);
		
	}
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

</body>
</html>