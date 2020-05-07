  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-light navbar-white">
    <div class="container">
      <a href="sistema2.jsp" class="navbar-brand">
        <img src="dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">Herbario Nacional</span>
      </a>

      <!-- Left navbar links -->
      <ul class="navbar-nav">
        <li class="nav-item">
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="sistema2.jsp" class="nav-link">Inicio</a>
        </li>
        <li class="nav-item dropdown">
          <a id="dropdownSubMenu1" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle">Noticias</a>
          <ul aria-labelledby="dropdownSubMenu1" class="dropdown-menu border-0 shadow">
          <li><a href="#" class="dropdown-item">Artículos </a></li>
          <li class="dropdown-divider"></li>
            <li><a href="#" class="dropdown-item">Eventos </a></li>
          </ul>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="#" class="nav-link">Colecciones</a>
        </li>
        <li class="nav-item dropdown">
          <a id="dropdownSubMenu2" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle">Acerca De</a>
          <ul aria-labelledby="dropdownSubMenu1" class="dropdown-menu border-0 shadow">
          <li><a href="#" class="dropdown-item">Historia </a></li>
          <li class="dropdown-divider"></li>
          <li><a href="#" class="dropdown-item">Misión </a></li>
          <li class="dropdown-divider"></li>
          <li><a href="#" class="dropdown-item">Visión</a></li>
          </ul>
        </li>
        <li class="nav-item d-none d-sm-inline-block">
          <a href="#" class="nav-link">Contacto</a>
        </li>
      </ul>

      <!-- Right navbar links -->
      <ul class="navbar-nav ml-auto">
        
      <!-- Login Button -->
        <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="fas fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a class="dropdown-item dropdown-footer" href="#"> <i class="fas fa-sign-in-alt"></i>
			<span> Regístrate</span>
		  </a>
		  <div class="dropdown-divider"></div>
          <a class="dropdown-item dropdown-footer" href="index.jsp"> <i class="fa fa-power-off"></i>
			<span> Iniciar Sesión</span>
		  </a>
        </div>
     	</li>
     	<!-- Login Button End-->
     	
        <!-- Sitemap Button -->
        <li class="nav-item dropdown">
          <a class="nav-link"  href="herbario/sitemap.jsp">
            <i class="fas fa-sitemap"></i>
          </a>
        </li>
        <!-- Sitemap Button End-->
        
      </ul>
    </div>
  </nav>
  <!-- /.navbar -->