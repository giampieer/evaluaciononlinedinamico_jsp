<%@page import="BEAN.ExamenReseultoBean1"%>
<%@page import="BEAN.ProfesorBean"%>
<%@page import="java.util.ArrayList"%>
<%! ArrayList<ExamenReseultoBean1> lista; %>
  <%lista=(ArrayList<ExamenReseultoBean1>)request.getAttribute("cargar");%>

    <%! ProfesorBean objporf=new ProfesorBean(); %>
    <%objporf=(ProfesorBean)request.getAttribute("codprof");%>
    <html>
    <head>    <script>
      paginacion();
    </script></head>
    <body>
      
      
      
      <div class="row">
        <div class="col-md-12 animated fadeInRightBig">
          <div class="panel panel-default">
            <div class="panel-heading">
              <% String nombre="";  
              for(ExamenReseultoBean1 obj:lista){    
              nombre=obj.getNombrealumno();
              
            }%>
            <h3 class="panel-title">Lista  de Examenes del alumno : <%=nombre%> </h3>
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
            
            
            <table id="tabla" class="table table-striped table-bordered" cellspacing="0" width="100%">
              <thead>
                <tr>
                  <th>NOMBRE ALUMNO</th>
                  <th>NOMBRE EXAMEN</th>
                  <th> </th>
                </thead>
                <tbody>
                 <%  for(ExamenReseultoBean1 obj:lista){     %>
                 <tr >
                  <td><%=obj.getNombrealumno()%></td>
                  <td><%=obj.getNombreexamen()%></td>
                  
                  
                  <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/revisarexamen.png" name="elegir"  onclick="cargar('<%=request.getContextPath()%>','Examen',6,'cod='+<%= obj.getCodexamen()%>+'&codprof='+<%= objporf.getCodigoprofesor()%>+'&codalum='+<%= obj.getCodalumno()%>+'&codexameresuelto='+<%= obj.getCodexamenresuelto()%>)"></td>
                  <%    }   %> 
                </tr>
                
              </tbody>
            </table>
            <div class="form-group">
              <div class="col-sm-offset-8 col-sm-10">
                <input type="button"  onclick="cargar('<%=request.getContextPath()%>','Estu',4 ,'cod='+<%=objporf.getCodigoprofesor()%>)" value="salir" class="btn btn-primary">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
  </html>
  