<html>
<head>
  <%@page import="BEAN.ExamenBean1"%>
  <%@page import="java.util.ArrayList"%>
  <%@page import="BEAN.ProfesorBean"%>
  <%@page import="DAO.NotaDAO"%>
  <%@page import="DAO.ExamenResueltoDAO"%>
  <%NotaDAO obj=new NotaDAO();%>
  <%! ArrayList<ExamenBean1>lista; %>
    <%lista=(ArrayList<ExamenBean1>)request.getAttribute("lista1");%>

      <%!ProfesorBean objprofbean=new ProfesorBean();%>
      <%objprofbean=(ProfesorBean)request.getAttribute("codprof");%>
    </head>
    <body>
      
      <div class="row">
        <div class="col-md-6 animated fadeInRightBig">
          <div class="panel panel-solid-info">
            <div class="panel-heading">
              <h3 class="panel-title">REVISION DEL  EXAMEN</h3>
              
            </div>
            <% int i=obj.GenerarCodigo();
            if(i==0){i=1;}
            else{i=obj.GenerarCodigo();}%>
            <input type="hidden" class="form-control" placeholder="Codigo" id="txtcodnota" name="txtcodnota" value="<%=i%>" readonly="readonly" >
            <input type="hidden" class="form-control" name="cant" id="codexamprin" value="<%=objprofbean.getCodexamen()%>" >

            <input type="hidden" class="form-control" name="cant" id="codexamres" value="<%=objprofbean.getCodexamresuelto()%>" >
            
            
            <input type="hidden" class="form-control" name="txtcodigoprofesor" id="txtcodigoprofesor" value="<%=objprofbean.getCodigoprofesor()%>" >
            <%
            double cont=0;
            int conta=0;
            int codalum=0;
            double puntaje=0;
            int nombre=0;
            for(ExamenBean1 obj12:lista){
            cont++;
            conta++;
          }
          double prom=0;
          int nom=1;
          for(ExamenBean1 obj12:lista){%>
          <div class="panel-body">
           <form class="form-horizontal form-border" name="form">
            <input type="hidden" class="form-control" name="txtcodres" id="pregunta<%=nom%>" value="<%=obj12.getNumerpregunta()%>" >
            <input type="hidden" class="form-control" name="txtcodres" id="codalumno<%=nom%>" value="<%=obj12.getCodalumno()%>" >
            
            
            <input type="hidden" class="form-control" name="cant" id="nota<%=nom%>" value="<%=obj12.getRespuesta()%>" >
            
            <%
            nombre=obj12.getCodalumno();
            prom=prom+Double.parseDouble(obj12.getRespuesta());
            
            codalum=obj12.getCodalumno();
            nom++;
          }
          
          %> 
          
          EXAMEN DEL ALUMNO :<%=nombre%><br>
          PROMEDIO DEL EXAMEN :<%=prom%><br>
          <input type="hidden" class="form-control" name="cant" id="cant" value="<%=conta%>" >

          
          <input type="button"onclick="NotaExamenes('<%=request.getContextPath()%>')" value="Revisar" class="btn btn-primary">
          <input type="button"  onclick="cargar('<%=request.getContextPath()%>','Estu',15 ,'cod='+<%=objprofbean.getCodigoprofesor()%>+'&codalum='+<%=codalum%>)" value="salir" class="btn btn-primary">
        </form>
      </div>
      
    </div>
  </div>
  
</div>
</body>
</html> 
