<%@page import="BEAN.notaxexamenbean"%>
<%@page import="BEAN.ProfesorBean"%>
<%@page import="java.util.ArrayList"%>
<%! ArrayList<notaxexamenbean> lista; %>
  <%lista=(ArrayList<notaxexamenbean>)request.getAttribute("cargar");%>
    <html>
    <head>    <script>
      paginacion();
    </script></head>
    <body>
      
      
      
      <div class="row">
        <div class="col-md-12 animated fadeInRightBig">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Relacion de las Notas de los  Alumnos</h3>
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
              
              <div class="table-responsive">
                
                <table class="table table-bordered table-striped" id="tabla">
                  <thead>
                    <tr>
                     <th>NUMERO EXAMEN</th>
                     <th>NOMBRE ALUMNO</th>
                     <th> PUNTAJE EXAMEN</th>
                   </tr>
                 </thead>
                 <tbody>
                  <%  for(notaxexamenbean obj:lista){     %>
                  <tr >
                    <td><%=obj.getCodexamen()%></td>
                    <td><%=obj.getNombrealumno()%></td>
                    <td><%=obj.getPuntaje()%></td>
                    
                    
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
  
  