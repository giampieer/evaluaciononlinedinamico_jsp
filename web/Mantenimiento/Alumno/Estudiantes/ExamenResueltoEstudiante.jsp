<%@page import="BEAN.notaxexamenbean"%>
<%@page import="BEAN.ProfesorBean"%>
<%@page import="BEAN.AlumnoBean"%>
<%@page import="java.util.ArrayList"%>
<%! ArrayList<notaxexamenbean> lista; %>
  <%lista=(ArrayList<notaxexamenbean>)request.getAttribute("cargar");%>
    
    <html>
    <head>       
      <script>paginacion();</script>
    </head>
    <body>
      
     
      
      <div class="row">
        <div class="col-md-12 animated fadeInRightBig">
          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Notas</h3>
              
            </div>
            <div class="panel-body">
              <div class="table-responsive">
                
                <table class="table table-bordered table-striped" id="tabla">
                  <thead>
                    <tr>
                      <th>Numero Examen</th>
                      <th>Puntaje Examen</th>
                      <th></th>
                    </tr>
                  </thead>
                  
                  <tbody>
                    <% double sumanotas=0;
                    int i=0;
                    for(notaxexamenbean obj:lista){     %>
                    <tr >
                     <td><%=obj.getCodexamen()%></td>
                     <td></td>
                     <td><%=obj.getPuntaje()%></td>
                     <%i++;%>
                     <%    sumanotas=sumanotas+obj.getPuntaje() ;}
                     %> 
                   </tr>
                   <%double promedio=0;
                   promedio=sumanotas/i ;%>
                   <td></td>
                   <td>PROMEDIO ACTUAL</td>
                   <%
                   if(sumanotas==0){
                   promedio=0;%>
                   <td><%=promedio %></td>
                   <%}else{%>
                   <td><%=promedio %></td>
                   <% }%>
                 </tbody>
               </table>
             </div>
           </div>
         </div>
       </div>
     </div>
   </body>
   </html>
