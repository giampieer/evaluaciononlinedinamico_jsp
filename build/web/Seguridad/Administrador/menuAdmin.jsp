
<%@page import="BEAN.AdministradorBean"%>
<%@page import="BEAN.AlumnoBean"%>
<%!
AdministradorBean objadBean = new AdministradorBean();
%>
<%   
objadBean=(AdministradorBean)request.getAttribute("admin");
%>
<html lang="en" >
<head>
  <meta http-equiv=?Content-Language? content=?es?/>
  <meta name="author" content="Giampieer Mariscal">
  <meta name="owner" content="Giampieer Mariscal">
  <meta name="description" content="Login para ingrsear al menu principal del admin ,Login para ingrsear al menu principal del personal">
  <meta name="keywords" content="ejemplo de software, software libre, login">
  <meta name="robots" content="index,follow">
  <meta name="classification" content="proyecto gestion,isagen,ejemplo,practica gestion">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="theme-color" content="#00BFA5" />
  <link rel="shortcut icon" href="<%=request.getContextPath()%>/imagenes/logo.ico" type="image/x-icon">
<script  src="http://www.gstatic.com/firebasejs/live/3.1/firebase.js"></script> 

  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dataTables.bootstrap.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/prelodr.min.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/alertify.min.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/default.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
  <link rel="Stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/sweetalert.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">


  <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.dataTables.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/dataTables.bootstrap.min.js"></script>
  <script  src="<%=request.getContextPath()%>/js/bootstrap.min.js" ></script>
  <script src="<%=request.getContextPath()%>/js/application.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.navgoco.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/switchery.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/prelodr.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/alertify.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/ajax1.js"></script>
  <script src="<%=request.getContextPath()%>/js/jquery.countTo.js"></script>   
  <script src="<%=request.getContextPath()%>/js/sweetalert.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/push.min.js"></script>

  <script>
    paginacion();
    animacion_numeros();
    
</script>
</head>
<body class="off-canvas" onload="ingresarmenu('<%= objadBean.getIdadmin()%>'),cargar_promedio('<%=request.getContextPath()%>','Estu',29,'cod=<%=objadBean.getCodadmin()%>'),cargarinactividad()">
    <div id="container"style="position: relative">
        <header id="header">
            <!--logo start-->
            <div class="brand">
                <a href="javascript:cargar_promedio('<%=request.getContextPath()%>','Estu',29,'cod=<%=objadBean.getCodadmin() %>')" class="logo"><span>ADMIN</span></a>
            </div>
            <!--logo end-->
            <div class="toggle-navigation toggle-left">
                <button type="button" class="btn btn-default" id="toggle-left" data-toggle="tooltip" data-placement="right" title="Menu">
                    <i class="fa fa-bars"></i>
                </button>
            </div>
            <div class="user-nav">
                <ul>
                    <li class="dropdown messages">
                        <span class="badge badge-danager animated bounceIn" id="new-messages">5</span>
                        <button type="button" class="btn btn-default dropdown-toggle options" id="toggle-mail" data-toggle="dropdown">
                            <i class="fa fa-envelope"></i>
                        </button>
                        <ul class="dropdown-menu alert animated fadeInDown">
                            <li>
                                <h1>You have <strong>5</strong> new messages</h1>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="profile-photo">
                                        <img src="<%=request.getContextPath() %>/imagenes/avatar.gif" alt="" class="img-circle">
                                    </div>
                                    <div class="message-info">
                                        <span class="sender">James Bagian</span>
                                        <span class="time">30 mins</span>
                                        <div class="message-content">Lorem ipsum dolor sit amet, elit rutrum felis sed erat augue fusce...</div>
                                    </div>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="profile-photo">
                                        <img src="<%=request.getContextPath() %>/imagenes/avatar1.gif" alt="" class="img-circle">
                                    </div>
                                    <div class="message-info">
                                        <span class="sender">Jeffrey Ashby</span>
                                        <span class="time">2 hour</span>
                                        <div class="message-content">hendrerit pellentesque, iure tincidunt, faucibus vitae dolor aliquam...</div>
                                    </div>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="profile-photo">
                                        <img src="<%=request.getContextPath() %>/imagenes/avatar2.gif" alt="" class="img-circle">
                                    </div>
                                    <div class="message-info">
                                        <span class="sender">John Douey</span>
                                        <span class="time">3 hours</span>
                                        <div class="message-content">Penatibus suspendisse sit pellentesque eu accumsan condimentum nec...</div>
                                    </div>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="profile-photo">
                                        <img src="<%=request.getContextPath() %>/imagenes/avatar3.gif" alt="" class="img-circle">
                                    </div>
                                    <div class="message-info">
                                        <span class="sender">Ellen Baker</span>
                                        <span class="time">7 hours</span>
                                        <div class="message-content">Sem dapibus in, orci bibendum faucibus tellus, justo arcu...</div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="profile-photo">
                                        <img src="<%=request.getContextPath() %>/imagenes/avatar4.gif" alt="" class="img-circle">
                                    </div>
                                    <div class="message-info">
                                        <span class="sender">Ivan Bella</span>
                                        <span class="time">6 hours</span>
                                        <div class="message-content">Curabitur metus faucibus sapien elit, ante molestie sapien...</div>
                                    </div>
                                </a>
                            </li>
                            <li><a href="#">Check all messages <i class="fa fa-angle-right"></i></a>
                            </li>
                        </ul>

                    </li>
                    <li class="profile-photo">
                        <img src="<%=request.getContextPath() %>/imagenes/avatar.png" alt="" class="img-circle">
                    </li>
                    <li class="dropdown settings">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                           <%=objadBean.getIdadmin()%> <i class="fa fa-angle-down"></i>
                       </a>
                       <ul class="dropdown-menu animated fadeInDown">
                        <li>
                            <a href="#"><i class="fa fa-user"></i> Modificar Datos</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-calendar"></i> Modificar Contraseña</a>
                        </li>
                        
                        <li>
                            <a href="javascript:cerrarsesion('<%=request.getContextPath()%>')"><i class="fa fa-power-off"></i> Cerrar Sesion</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <div class="toggle-navigation toggle-right">
                        <a href="javascript:void(0)" class="btn btn-default" id="toggle-right">
                            <i class="fa fa-comment"></i>
                        </a>
                    </div>
                </li>
            </ul>
        </div>
    </header>
    <!--sidebar left start-->
    <nav class="sidebar sidebar-left">
        <h5 class="sidebar-header">Menu:</h5>
        <ul class="nav nav-pills nav-stacked">
            <li class="active">
                <a href="#" title="Dashboard">
                    <i class="fa fa-user"></i><%=objadBean.getIdadmin()%>
                </a>
            </li>
<!--
INHABILITAR CHAT FIREBASE 
<div class="container">
      <input id="txtEmail" type="email" placeholder="Email">
      <input id="txtPassword" type="password" placeholder="Contraseña">
      <button id = "btnLogin" class="btn btn-action">Login</button>
      <button id = "btnSignUp" class="btn btn-secondary">Registrarse</button>
      <button id = "btnLogout" class="btn btn-action hide">Logout</button>
    </div>-->
            <li class="nav-dropdown">
                <a href="#" title="Tables">
                    <i class="fa fa-table"></i> Relacion
                </a>
                <ul class="nav-sub">
                    <li><a href="javascript:Menu('<%=request.getContextPath()%>','Profesor',1,'cod=<%=objadBean.getCodadmin()%>')">Profesores</a>
                    </li>
                    <li><a href="javascript:Menu('<%=request.getContextPath()%>','Alumno',1,'cod=<%=objadBean.getCodadmin()%>')">Estudiantes</a>
                    </li>
                </ul>
            </li>
            
            
            
            
        </ul>
    </nav>
    <!--sidebar left end-->
    <!--main content start-->
    <section class="main-content-wrapper">
        <section id="main-content">
           <div id="contenido1">
              
           </div>
           <!--tiles end-->


           <!--ToDo end-->
       </section>
   </section>
</div>
<!--main content end-->
<!--sidebar right start-->
<div class="sidebarRight">
    <div id="rightside-navigation">
        <div id="right-panel-tabs" role="tabpanel">
            <ul class="nav nav-tabs nav-justified" role="tablist">
                <li class="active"><a data-target="#chat" data-toggle="tab" role="tab" data-toggle="tab" title="Chat"><i class="icon-users fa-lg"></i></a>
                </li>
                <li><a data-target="#settings" role="tab" data-toggle="tab" title="Settings"><i class="icon-settings fa-lg"></i></a>
                </li>

            </ul>
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="chat">
                    <div class="heading">
                        <ul>
                            <li>
                                <input type="text" class="search" placeholder="Search">
                                <button type="submit" class="btn btn-sm btn-search"><i class="fa fa-search"></i>
                                </button>
                            </li>
                        </ul>
                    </div>

                    <h3 class="sidebar-title">online</h3>
                    <div class="list-contacts">
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>James Bagian</h4>
                                <p>Los Angeles, CA</p>
                            </div>
                            <div class="item-status item-status-online"></div>
                        </a>
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar1.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>Jeffrey Ashby</h4>
                                <p>New York, NY</p>
                            </div>
                            <div class="item-status item-status-online"></div>
                        </a>
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar2.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>John Douey</h4>
                                <p>Dallas, TX</p>
                            </div>
                            <div class="item-status item-status-online"></div>
                        </a>
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar3.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>Ellen Baker</h4>
                                <p>London</p>
                            </div>
                            <div class="item-status item-status-away"></div>
                        </a>
                    </div>

                    <h3 class="sidebar-title">offline</h3>
                    <div class="list-contacts">
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar4.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>Ivan Bella</h4>
                                <p>Tokyo, Japan</p>
                            </div>
                            <div class="item-status"></div>
                        </a>
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar5.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>Gerald Carr</h4>
                                <p>Seattle, WA</p>
                            </div>
                            <div class="item-status"></div>
                        </a>
                        <a href="javascript:void(0)" class="list-item">
                            <div class="list-item-image">
                                <img src="<%=request.getContextPath() %>/imagenes/avatar6.gif" class="img-circle">
                            </div>
                            <div class="list-item-content">
                                <h4>Viktor Gorbatko</h4>
                                <p>Palo Alto, CA</p>
                            </div>
                            <div class="item-status"></div>
                        </a>
                    </div>
                </div>
                <div role="tabpanel" class="tab-pane" id="settings">
                    <ul class="setting-list">
                        <li>
                            <h3 class="sidebar-title">Account Settings</h3>
                        </li>
                        <li>
                            <h5>Share your status</h5>
                            <input type="checkbox" class="js-switch" checked />
                        </li>
                        <li>
                            Vivamus sagittis lacus vel augue laoreet rutrums.
                        </li>
                        <li>
                            <h5>Notifications</h5>
                            <input type="checkbox" class="js-switch" />
                        </li>
                        <li>
                            Vivamus sagittis lacus vel augue laoreet rutrums.
                        </li>
                        <li>
                            <h5>Vacation responder</h5>
                            <input type="checkbox" class="js-switch" checked />
                        </li>
                        <li>
                            Vivamus sagittis lacus vel augue laoreet rutrums.
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="<%=request.getContextPath()%>/js/chat1.js"></script>
</body>


</html>
