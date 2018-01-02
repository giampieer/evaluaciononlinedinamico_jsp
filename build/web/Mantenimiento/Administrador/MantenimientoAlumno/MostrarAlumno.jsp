<%@page import="BEAN.AdministradorBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.AlumnoBean"%>
<%!ArrayList<AlumnoBean> ListaAlumno;%>
  <%ListaAlumno=(ArrayList <AlumnoBean>)request.getAttribute("carga");%>
    <%!AdministradorBean objadminbean=new AdministradorBean(); %>
    <%objadminbean=(AdministradorBean)request.getAttribute("codadmin"); %>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>    <script>
      paginacion();
    </script></head>
    <body>

      
      <div class="row">
        <div class="col-md-12 animated fadeInRightBig">
          <div class="panel panel-default">
            
            <div class="panel-heading">
              <h3 class="panel-title">Relacion de los Alumnos</h3>
              <% if(request.getAttribute("mensaje")!=null){
              String mensaje = (String)request.getAttribute("mensaje");
              %>
              <div class="alert alert-success animated bounceInRight">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <strong><%=mensaje%></strong>

              </div> 
              <%  }   %>
            </div>
            <div class="panel-body">
              <input class="btn btn-primary" type="button" value="Nuevo" onclick="Menu('<%=request.getContextPath()%>','Alumno',2,'codadmin=<%=objadminbean.getCodadmin() %>')" >              
              <div class="table-responsive">
                
                <table class="table table-bordered table-striped" id="tabla">
                  <thead>
                    <tr>
                      <th>CODIGO</th>
                      <th>NOMBRE</th>
                      <th>USUARIO</th>
                      <th>CLAVE</th>
                      <th>Modificar</th>
                      <th>Eliminar</th>
                    </tr>
                  </thead>
                  <tbody>
                    <% for(AlumnoBean obj:ListaAlumno){%>
                    
                    <tr>
                      <td><%=obj.getCodalumno()%></td>
                      <td><%=obj.getNomalumno()%></td>
                      <td><%=obj.getIdalumno()%></td>
                      <td><%=obj.getContraalumno()%></td>
          <%--  <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/modificar.png" name="elegir" value="<%=obj.getCodigoprofesor()%>" onclick="cargar('<%=request.getContextPath()%>','Profesor',4,'cod='+<%= obj.getCodigoprofesor()%>+'&codadmin='+<%= objadminbean.getCodadmin()%>')"></td>
              <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getCodigoprofesor()%>" onclick="cargar('<%=request.getContextPath()%>','Usuario',6,'cod='+<%= obj.getCodigoprofesor()%>'+&codadmin='+<%= objadminbean.getCodadmin()%>')"></td>
              --%>
              
              <td align="center">
                <input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/modificar.png" name="elegir"  onclick="cargar('<%=request.getContextPath()%>','Alumno',4,'cod=<%=obj.getCodalumno()%>&codadmin=<%=objadminbean.getCodadmin()%>')"></td>

                <td align="center">
                  <input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir"  onclick="eliminar('<%=request.getContextPath()%>','Alumno',6,'cod=<%=obj.getCodalumno()%>&codadmin=<%=objadminbean.getCodadmin()%>')"></td>

                  
                  <% } %>
                </tr>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
