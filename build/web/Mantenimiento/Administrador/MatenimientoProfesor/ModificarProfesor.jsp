<%@page import="BEAN.AdministradorBean"%>
<%@page import="BEAN.ProfesorBean"%>
<%!ProfesorBean objbean=new ProfesorBean();%>
<%objbean=(ProfesorBean)request.getAttribute("Actualizar");%>
<%!AdministradorBean objadminbean=new AdministradorBean(); %>
<%objadminbean=(AdministradorBean)request.getAttribute("codadmin"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    
    
    
   <div class="row" >
    <div class="col-md-8 animated fadeInRightBig">
        <div class="panel panel-default" >
            <div class="panel-heading">
                <h3 class="panel-title">MODIFICAR PROFESOR :</h3>
                
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
          <div class="panel-body" >

            <form class="form-horizontal form-border" id="form">
             
             <div class="form-group">
               
                 <label class="col-sm-2 control-label">Codigo </label>
                 <div class="col-sm-10">
                  
                    <input type="text" class="form-control" placeholder="Codigo" id="txtcod" name="txtcod" value="<%=objbean.getCodigoprofesor()%>" readonly="readonly" >
                </div>    </div>                           <div class="form-group">

                    <label class="col-sm-2 control-label">Nombre </label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="txtnombre" id="txtnombre" value="<%=objbean.getNombprofesor()%>" placeholder="Nombre">
                    </div>   </div>                            <div class="form-group">

                        <label class="col-sm-2 control-label">Usuario </label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="txtusuario" id="txtusuario" placeholder="Usuario" value="<%=objbean.getIdprofesor()%>">
                        </div>            </div>                   <div class="form-group">

                            <label class="col-sm-2 control-label">Clave </label>

                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="txtclave" id="txtclave" placeholder="Clave"value="<%=objbean.getContraprofesor()%>">
                            </div>    
                            <input type="hidden" class="form-control" name="txtcodadmin" id="txtcodadmin" value="<%=objadminbean.getCodadmin() %>"placeholder="Clave">

                            
                            
                            
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-8 col-sm-10">
                                <input type="button"onclick="ModificarProfesor1('<%=request.getContextPath()%>')" value="Modificar" class="btn btn-primary">
                            </div>
                            <div class="col-sm-offset-8 col-sm-10">
                                <input type="button"   onclick="salir('<%=request.getContextPath()%>','Profesor',1,'cod=<%=objadminbean.getCodadmin()%>')" value="Salir" class="btn btn-primary">
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
