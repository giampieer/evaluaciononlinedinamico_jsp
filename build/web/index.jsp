<!DOCTYPE html>

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
  <!--color barra chrome android-->
  <meta name="theme-color" content="#00BFA5" />
</head>

<body onload="bloqueo()" style="background-color: #212121">
  <section id="login-container">

    <div class="row">
      <div class="col-md-4" id="login-wrapper">
        <div class="panel panel-primary animated flipInY">
          <div class="panel-heading">
            <h3 class="panel-title">     
             Iniciar Sesion
           </h3>      
         </div>
         <div class="mens">
           <% if(request.getAttribute("mensaje")!=null){
           String mensaje = (String)request.getAttribute("mensaje");
           %>
           <div class="alert alert-success animated bounceInRight" >
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong ><%=mensaje%></strong>

          </div> 
          <%  }   %>
        </div>
        
        
        
        <div class="panel-body">
         <p> "I.E.P. NUESTRA SEÑORA DE LA MERCED"</p>
         <form class="form-horizontal" role="form" name="form">
          <div class="form-group">
            <div class="col-md-12">
              <select   name="txtseleccion" id="txtseleccion"  class="form-control" >
                <option value="0">------------SELECCIONAR-----------</option>
                <option value="3">ADMINISTRADOR</option>
                <option value="1">PROFESOR</option>
                <option value="2">ESTUDIANTE</option></select>
                
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="col-md-12">
              <input type="text" class="form-control" id="email" name="txtnombre" placeholder="ID">
              <i class="fa fa-user"></i>
            </div>
          </div>
          <div class="form-group">
           <div class="col-md-12">
             <input type="password" class="form-control" id="password" name="txtcontra"placeholder="PASS">
             <i class="fa fa-lock"></i>
           </div>
         </div>
         <div class="form-group">
           <div class="col-md-12">
             <input  type="button" onclick="enter1('<%=request.getContextPath()%>')" value="INGRESAR"class="btn btn-primary btn-block" >
             <hr />
           </div>
         </div>
       </form>
     </div>
   </form>
 </div>
</div>
</div>

</section>


</body>

</html>