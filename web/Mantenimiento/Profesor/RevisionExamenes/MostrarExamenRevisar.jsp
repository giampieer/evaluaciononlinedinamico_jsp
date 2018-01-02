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
              <h3 class="panel-title">Revision de Examenes por Alumnos </h3>
              
            </div>
            <div class="panel-body">

              <div class="table-responsive">
                <table class="table table-bordered table-striped" id="tabla">
                  <thead>
                    <tr>
                      
                      <th>CODIGO ALUMNO</th>
                      <th>NOMBRE ALUMNO</th>
                      <th> </th>
                    </tr>
                  </thead>
                  <tbody>
                    <%  for(ExamenReseultoBean1 obj:lista){     %>
                    <tr >
                      <td><%=obj.getCodalumno()%></td>
                      <td><%=obj.getNombrealumno()%></td>
                      
                      
                      <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/revisarexamen.png" name="elegir"  onclick="cargar('<%=request.getContextPath()%>','Estu',14,'cod='+<%= obj.getCodexamen()%>+'&codprof='+<%= objporf.getCodigoprofesor()%>+'&codalum='+<%= obj.getCodalumno()%>)"></td>
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