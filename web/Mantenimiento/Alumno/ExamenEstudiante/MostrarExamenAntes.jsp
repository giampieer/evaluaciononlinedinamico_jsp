<%@page import="BEAN.ExamenBean1"%>
<%@page import="BEAN.AlumnoBean"%>
<%@page import="java.util.ArrayList"%>
<%! ArrayList<ExamenBean1> lista; %>
  <%lista=(ArrayList<ExamenBean1>)request.getAttribute("cargar");%>

    <%!AlumnoBean obj1=new AlumnoBean();%>
    <%obj1=(AlumnoBean)request.getAttribute("codalum");%>

    <html>
    <head>       
      <script>
        paginacion();
      </script>
    </head>
    <body>
      <div class="row">
        <div class="col-md-12 animated fadeInRightBig">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Examenes a Resolver</h3>
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
                
                <table class="table table-bordered table-striped" id="tabla">                            <thead>
                  <tr>
                    <th>Numero</th>
                    <th>Nombre Examen</th>
                    <th> </th>
                  </tr>
                </thead>
                <tbody>
                  <%  for(ExamenBean1 obj:lista){     %>
                  <tr >
                    <td><%=obj.getCodexamen()%></td>
                    <td><%=obj.getNombreexamen()%></td>
                    <td align="center"><input class="animated infinite pulse" type="image" width="30px" src="<%=request.getContextPath()%>/imagenes/resolverexam.png" name="elegir"  onclick="cargarexamen('<%=request.getContextPath()%>','Estu',6,'codexamen='+<%= obj.getCodexamen()%>+'&cod='+<%=obj1.getCodalumno()%>)"></td>
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
