<!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="fas fa-door-open"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">Salir del Sistema</span>
          <div class="dropdown-divider"></div>
          <!-- <a class="dropdown-item dropdown-footer" href="index.jsp"> <i class="fa fa-power-off"></i>
			<span>Cerrar Sesión</span>
		  </a> -->
	     <a class="dropdown-item dropdown-footer" href="${pageContext.request.contextPath}/CMS/index.jsp"> <i class="fa fa-power-off"></i>
		  <span>Cerrar Sesión</span>
		  </a>
        </div>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->