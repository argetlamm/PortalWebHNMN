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
          <li class="nav-header">Men�</li>
          
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
                <a href="../seguridad/tblusuarios.jsp" class="nav-link">
                  <i class="fas fa-users nav-icon"></i>
                  <p>Control de Usuarios</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../seguridad/tblRol.jsp" class="nav-link">
                  <i class="nav-icon fas fa-dice"></i>
                  <p>Control de Roles</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../seguridad/tblOpcion.jsp" class="nav-link">
                  <i class="fas fa-filter nav-icon"></i>
                  <p>Control de Opciones</p>
                </a>
              </li>
              <li class="nav-item">
              <a href="../seguridad/listRolOpcion.jsp" class="nav-link">
                <i class="fas fa-toolbox nav-icon"></i>
                <p>Opciones de Rol</p>
              </a>
            </li>
            <li class="nav-item">
              <a href="../seguridad/listUserRol.jsp" class="nav-link">
                <i class="far fa-id-card nav-icon"></i>
                <p>Roles de Usuario</p>
              </a>
            </li>
            </ul>
          </li>
          <li class="nav-item">
                <a href="../menu/editMenu.jsp" class="nav-link">
                  <i class="fas fa-stream nav-icon"></i>
                  <p>Edici�n de Menu</p>
                </a>
         </li>
         </li>
          <li class="nav-item">
                <a href="../footer/editFooter.jsp" class="nav-link">
                  <i class="fas fa-stream nav-icon"></i>
                  <p>Edici�n de Footer</p>
                </a>
         </li>
         <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-file-alt"></i>
              <p>
                P�gina de Inicio
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../menu/editBanner.jsp" class="nav-link">
                  <i class="fas fa-images nav-icon"></i>
                  <p>Banners de Inicio</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../menu/editInicio.jsp" class="nav-link">
                  <i class="far fa-newspaper nav-icon"></i>
                  <p>Navegaci�n del Menu</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fab fa-black-tie"></i>
              <p>
                �Qui�nes Somos?
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../quienesSomos/editQuienesSomos.jsp" class="nav-link">
                  <i class="fab fa-black-tie nav-icon"></i>
                  <p>�Qui�nes Somos?</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../quienesSomos/editHistoria.jsp" class="nav-link">
                  <i class="fas fa-book nav-icon"></i>
                  <p>Historia</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../quienesSomos/editMision.jsp" class="nav-link">
                  <i class="fas fa-clipboard-list nav-icon"></i>
                  <p>Misi�n</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="../quienesSomos/editVision.jsp" class="nav-link">
                  <i class="fas fa-chart-line nav-icon"></i>
                  <p>Visi�n</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-check-square nav-icon"></i>
              <p>
                Suscripci�n
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../suscripcion/notificacion.jsp" class="nav-link">
                  <i class="fas fa-envelope-open-text nav-icon"></i>
                  <p>Notificaciones</p>
                </a>
                </li>
            </ul>
          </li>
            <!--           ///////////////////////Sexta Secci�n//////////////////////////////////// -->                             
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-hand-holding-usd nav-icon"></i>
              <p>
                Donaci�n
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../donacion/editDonacion.jsp" class="nav-link">
                  <i class="fas fa-money-bill-wave nav-icon"></i>
                  <p>Modificar Donaciones</p>
                </a>
               </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
             <i class="fas fa-list-alt nav-icon"></i>
              <p>
               	Servicios
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../servicios/editServicios.jsp" class="nav-link">
                  <i class="fas fa-clipboard nav-icon"></i>
                  <p>Editar servicios</p>
                </a>
               </li>
            </ul>
           </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
             <i class="fas fa-paste nav-icon"></i>
              <p>
               	Publicaciones
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../publicaciones/newArticulos.jsp" class="nav-link">
                  <i class="fas fa-vote-yea nav-icon"></i>
                  <p>Agregar art�culos s�lo texto</p>
                </a>
               </li>
               <li class="nav-item">
                <a href="../publicaciones/newArticulosImagen.jsp" class="nav-link">
                  <i class="fas fa-images nav-icon"></i>
                  <p>Agregar art�culos con imagen</p>
                </a>
               </li>
               <li class="nav-item">
                <a href="../publicaciones/editArticulos.jsp" class="nav-link">
                  <i class="fas fa-pen nav-icon"></i>
                  <p>Editar art�culos</p>
                </a>
               </li>
            </ul>
           </li>
           <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="far fa-calendar-alt nav-icon"></i>
              <p>
               	Eventos
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../eventos/newEvento.jsp" class="nav-link">
                  <i class="fas fa-calendar-plus nav-icon"></i>
                  <p>Agregar eventos s�lo texto</p>
                </a>
               </li>
               <li class="nav-item">
                <a href="../eventos/newEventoImagen.jsp" class="nav-link">
                  <i class="fas fa-calendar-day nav-icon"></i>
                  <p>Agregar eventos con imagen</p>
                </a>
               </li>
               <li class="nav-item">
                <a href="../eventos/editEventos.jsp" class="nav-link">
                  <i class="far fa-calendar-check nav-icon"></i>
                  <p>Editar eventos</p>
                </a>
               </li>
            </ul>
           </li>
           <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-shopping-cart nav-icon"></i>
              <p>
                Productos
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="editProductos.jsp" class="nav-link">
                  <i class="fas fa-cart-plus nav-icon"></i>
                  <p>Modificar Productos</p>
                </a>
               </li>
               
            </ul>
            </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fab fa-pagelines nav-icon"></i>
              <p>
                Colecciones
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../colecciones/editColecciones.jsp" class="nav-link">
                  <i class="fas fa-highlighter nav-icon"></i>
                  <p>Modificar Colecciones</p>
                </a>
               </li>
               
            </ul>
            </li>
            <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-hands-helping nav-icon"></i>
              <p>
                Colaboraciones
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../colaboraciones/editColaboraciones.jsp" class="nav-link">
                  <i class="fas fa-handshake nav-icon"></i>
                  <p>Modificar Colaboraciones</p>
                </a>
               </li>
               
            </ul>
            </li>
             <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="fas fa-hands-helping nav-icon"></i>
              <p>
                Visitas
                <i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="../visitas/editVisitas.jsp" class="nav-link">
                  <i class="fas fa-pen nav-icon"></i>
                  <p>Modificar Visitas</p>
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