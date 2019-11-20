<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="../sistema.jsp" class="brand-link">
      <img src="../dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">CMS - PWHN</span>
    </a>
    <%
	String loginUser = "";
	int rolId = 0;

	loginUser = (String) session.getAttribute("login");
	loginUser = loginUser==null?"":loginUser;
	%>
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="../dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Bienvenido: <%=loginUser %></a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-header">Menú</li>
          
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-shield-alt"></i>
              <p>
                Seguridad
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="./././tblusuarios.jsp" class="nav-link">
                  <i class="fas fa-users nav-icon"></i>
                  <p>Control de Usuarios</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./././tblRol.jsp" class="nav-link">
                  <i class="nav-icon fas fa-dice"></i>
                  <p>Control de Roles</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./././tblOpcion.jsp" class="nav-link">
                  <i class="fas fa-filter nav-icon"></i>
                  <p>Control de Opciones</p>
                </a>
              </li>
              <li class="nav-item">
              <a href="./././listRolOpcion.jsp" class="nav-link">
                <i class="fas fa-toolbox nav-icon"></i>
                <p>Opciones de Rol</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="./././listUserRol.jsp" class="nav-link">
                <i class="fas fa-toolbox nav-icon"></i>
                <p>Roles de Usuario</p>
              </a>
            </li>
            </ul>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>