<%@page import="BEAN.ExamenBean1"%>
<%@page import="BEAN.ProfesorBean"%>
<%@page import="java.util.ArrayList"%>
<%! ArrayList<ExamenBean1> lista; %>
  <%lista=(ArrayList<ExamenBean1>)request.getAttribute("cargar");%>
    <%! ProfesorBean obj=new ProfesorBean();%>
    <%obj=(ProfesorBean)request.getAttribute("codprof");%>
    <html>
    <head>    <script>
      paginacion();
    </script></head>
    <body>
      
      
      
      <div class="row">
        <div class="col-md-12 animated fadeInRightBig">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Relacion de Examenes</h3>
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
              <form class="form-horizontal form-border" id="form">
               
                
                
                <div class="form-group">
                  <div class="col-sm-6">
                   <input type="number" class="form-control" name="txtcant" id="cant" placeholder="Cantidad de preguntas">
                   <input type="hidden" class="form-control" name="txtnom" id="codprofesor" placeholder="Nombre" value="<%=obj.getCodigoprofesor()%>">
                 </div>
                 <div class="col-sm-6">
                  <input class="btn btn-primary" type="button" value="Nuevo" onclick="generarpreguntas('<%=request.getContextPath()%>')" >              
                </div>
              </div>


            </form>
            <div class="table-responsive">
              
              <table class="table table-bordered table-striped" id="tabla">
                <thead>
                  <tr>
                    
                    <th>NUMERO </th>
                    <th>NOMBRE</th>
                  </tr>
                </thead>
                <tbody>
                  <%  for(ExamenBean1 obj:lista){     %>
                  <tr >
                    <td><%=obj.getCodexamen()%></td>
                    <td><%=obj.getNombreexamen()%></td>
                    
                    
                    <%    }   %> 
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
  
  