<%-- 
    Document   : MostrarProfesor
    Created on : 04-jul-2017, 8:49:36
    Author     : Autonoma
    --%>

    <%@page import="BEAN.AdministradorBean"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="BEAN.ProfesorBean"%>
    <%!ArrayList<ProfesorBean> ListaProfesor;%>
      <%ListaProfesor=(ArrayList <ProfesorBean>)request.getAttribute("carga");%>
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
                  <h3 class="panel-title">Relacion de los Docentes</h3>
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
                 <input class="btn btn-primary" type="button" value="Nuevo" onclick="Menu('<%=request.getContextPath()%>','Profesor',2,'codadmin=<%=objadminbean.getCodadmin() %>')" >                                       <div class="table-responsive">
                  
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
                      <% for(ProfesorBean obj:ListaProfesor){%>
                      
                      <tr>
                        <td><%=obj.getCodigoprofesor()%></td>
                        <td><%=obj.getNombprofesor()%></td>
                        <td><%=obj.getIdprofesor()%></td>
                        <td><%=obj.getContraprofesor()%></td>
          <%--  <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/modificar.png" name="elegir" value="<%=obj.getCodigoprofesor()%>" onclick="cargar('<%=request.getContextPath()%>','Profesor',4,'cod='+<%= obj.getCodigoprofesor()%>+'&codadmin='+<%= objadminbean.getCodadmin()%>')"></td>
              <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/write.png" name="elegir" value="<%=obj.getCodigoprofesor()%>" onclick="cargar('<%=request.getContextPath()%>','Usuario',6,'cod='+<%= obj.getCodigoprofesor()%>'+&codadmin='+<%= objadminbean.getCodadmin()%>')"></td>
              --%>
              <td align="center">
                <input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/modificar.png" name="elegir"  onclick="cargar('<%=request.getContextPath()%>','Profesor',4,'cod=<%=obj.getCodigoprofesor()%>&codadmin=<%=objadminbean.getCodadmin()%>')"></td>

                <td align="center">
                  <input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/delete.png" name="elegir"  onclick="eliminar('<%=request.getContextPath()%>','Profesor',6,'cod=<%=obj.getCodigoprofesor()%>&codadmin=<%=objadminbean.getCodadmin()%>')"></td>

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
