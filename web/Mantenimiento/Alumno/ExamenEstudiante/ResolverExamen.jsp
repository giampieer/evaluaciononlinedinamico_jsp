<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.ExamenBean1"%>
<%@page import="BEAN.AlumnoBean"%>

<%@page import="DAO.ExamenResueltoDAO"%>

<%ExamenResueltoDAO obj=new ExamenResueltoDAO();%>
<%!ArrayList<ExamenBean1> lista ; %>
    <%lista=(ArrayList<ExamenBean1>)request.getAttribute("DATOS");%>
<%!ArrayList<ExamenBean1> lista2 ; %>
    <%lista2=(ArrayList<ExamenBean1>)request.getAttribute("datos_retroceder");%>
        <%!AlumnoBean obj1=new AlumnoBean();%>
        <%obj1=(AlumnoBean)request.getAttribute("codalum");%>
        <%!ExamenBean1 obj2=new ExamenBean1();%>
        <%obj2=(ExamenBean1)request.getAttribute("codexamen");%>
        <html>
        <head></head>
        <body>
           
           <div class="row">
            <div class="col-md-8 animated fadeInRightBig">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">RESOLVER EXAMEN :</h3>
                        
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

                    <form class="form-horizontal form-border" id="form">
                     
                       <%int cont=0;
                       int nom=1;
                       int valor =0;
                        int dato=0;
                       if(lista.size()==0){%>
                       <label>EXAMEN RESUELTO !!!!! </label>
                       <%}else{
                       
                       
                       for (ExamenBean1 obj2:lista){
                       %>
                       
                       <div class="form-group">
                        <label class="col-sm-3 control-label"><%=obj2.getPregunta()%></label>
                        <div class="col-sm-6">
                            <input type="hidden" class="form-control"  id="preg<%=nom%>" value="<%=obj2.getNumerpregunta()%>" >
                        </div>
                        <div class="col-sm-6">
                            <input type="button"onclick="grabar2('<%=request.getContextPath()%>','Estu',10,'codpreg='+<%=obj2.getNumerpregunta()%>+'&codalum='+<%=obj1.getCodalumno()%>+'&codexamen='+<%=obj2.getCodexamen()%>)" value="Resp." class="btn btn-primary">
                        </div>
                    </div>
                    
                    
                    <%
                    cont++;
                    nom++;
                    
                }}
int aa=0;
                    for(ExamenBean1 ob3:lista2){
aa++;
}
if(aa>=1){
dato=0;
}else{
dato=1;
}
                    %>
                
                    <script>
                        capturar_examen_resuelto(<%=dato%>);
                    </script>
                <input type="hidden" class="form-control" name="txtcant" id="txtcant" value="<%=cont%>" >
                <input type="hidden" class="form-control" name="codalum" id="codalum" value="<%=obj1.getCodalumno()%>" >
                <%if(lista.size()==0){%> 
                <div class="form-group">
                    <div class="col-sm-offset-8 col-sm-10">
                        <input type="button"  onclick="cargar_terminarexamen('<%=request.getContextPath()%>','Estu',13 ,'cod='+<%=obj1.getCodalumno()%>+'&codexamen='+<%=obj2.getCodexamen()%>)" value="Terminar " class="btn btn-primary">
                    </div>
                </div>
                <%                       }else{%>
                
                <%}%>
            </form>


        </div>
    </div>
</div>
</div>




</body>
</html>

