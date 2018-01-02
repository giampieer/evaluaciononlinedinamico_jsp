<%@page import="BEAN.ProfesorBean"%>
<%@page import="DAO.ExamenDAO"%>
<%ExamenDAO obj=new ExamenDAO();%>
<%! ProfesorBean obj1=new ProfesorBean();%>
<%! ProfesorBean obj2=new ProfesorBean();%>
<%obj1=(ProfesorBean)request.getAttribute("obj");%>
<html>
<head></head>
<body>
  
  
  
  <div class="row">
    <div class="col-md-8 animated fadeInRightBig">
      <div class="panel panel-default">
        <div class="panel-heading">
          <h3 class="panel-title">REGISTRAR  EXAMEN</h3>
          <% if(request.getAttribute("mensaje")!=null){
          String mensaje = (String)request.getAttribute("mensaje");
          %>
          <div class="alert alert-success animated bounceInRight">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            <strong><%=mensaje%></strong>

          </div> 
          <%  }   %>
        </div>
        
        <% int i=obj.GenerarCodigoExamenss();
        if(i==0){i=1;}
        else{i=obj.GenerarCodigoExamenss();}%>
        
        <% int b=obj.GenerarCodigopregunta();
        if(b==0){b=1;}
        else{b=obj.GenerarCodigopregunta();}%>
        
        <% int c=obj.GenerarCodigoexamenrespuestas();
        if(c==0){c=1;}
        else{c=obj.GenerarCodigoexamenrespuestas();}%>
        
        <% int d=obj.GenerarCodigopreguntanotaprof();
        if(d==0){d=1;}
        else{d=obj.GenerarCodigopreguntanotaprof();}%>
        
        
        <div class="panel-body">
          <form class="form-horizontal form-border" id="form">
           <input type="hidden" class="form-control" placeholder="Codigo" id="txtcod" name="txtcod" value="<%=b%>" readonly="readonly" >
           <input type="hidden" class="form-control" placeholder="Codigo" id="txtrespuesta" name="txtcod" value="<%=c%>" readonly="readonly" >
           <input type="hidden" class="form-control" placeholder="Codigo" id="txtnota" name="txtcod" value="<%=d%>" readonly="readonly" >
           <input type="hidden" class="form-control" name="txtnom" id="txtcant" value="<%=obj1.getCantpre()%>">
           <input type="hidden" class="form-control" name="txtnom" id="codprofe" value="<%=obj1.getCodigoprofesor()%>"  placeholder="Nombre">

           
           <div class="form-group">
            
            <div class="col-sm-6">
              <label class="col-sm-12 ">Codigo examen</label>
              <input type="text" class="form-control" placeholder="Codigo" id="txtnumexamen" name="txtcod" value="<%=i%>" readonly="readonly" >
            </div>
            
            <div class="col-sm-6">
              <label class="col-sm-12 ">Nombre del Examen</label>
              <input type="text" class="form-control" name="txtnombre" id="txtnom" placeholder="Nombre">
            </div>
          </div>
          
          
          
          
          <% int cantidad=obj1.getCantpre();
          double puntaje=0;
          int cont=1;
          for(int a=1;a<=cantidad;a++){
          puntaje++;
        }
        double total=20/puntaje;
        
        for(int a=1;a<=cantidad;a++){ %>
        <div class="form-group">
          
          <div class="col-sm-6">
            <label class="col-sm-12">PREGUNTA <%=cont%></label>
            <input type="text" class="form-control" name="txtpre<%=cont%>" id="pre<%=cont%>" placeholder="Nombre">
            <br>
          </div>
          <div class="col-sm-12">
           
           <div class="col-sm-4">
             
            <div class="col-sm-6">
              <label class="col-sm-12">Resp. 1</label>
              <input type="text" class="form-control" name="txtnombre" id="res1<%=cont%>" placeholder="Nombre">
            </div>
            
            <div class="col-sm-6">
             <center>
              <label class="col-sm-12">Punt.</label>
              
              <input type="radio" class="icheck"name="txtnota<%=cont%>" id="nota1<%=cont%>" value="<%=total%>"/>
            </center>
          </div>
          <br>
        </div>
        
        <div class="col-sm-4">
         
          <div class="col-sm-6">
            <label class="col-sm-12">Resp. 2</label>
            <input type="text" class="form-control" name="txtnombre" id="res2<%=cont%>" placeholder="Nombre">
          </div>
          
          <div class="col-sm-6">
            <center>
              <label class="col-sm-12">Punt.</label>
              <input type="radio" class="icheck"name="txtnota<%=cont%>" id="nota2<%=cont%>"value="<%=total%>"/></center></div><br></div>
              
              
              
              <div class="col-sm-4">
               
                <div class="col-sm-6">
                  <label class="col-sm-12">Resp. 3</label>
                  <input type="text" class="form-control" name="txtnombre" id="res3<%=cont%>" placeholder="Nombre"><br>
                </div>
                
                <div class="col-sm-6">
                  <center>
                    <label class="col-sm-12">Punt.</label>
                    <input type="radio" class="icheck"name="txtnota<%=cont%>" id="nota3<%=cont%>"value="<%=total%>" /></center></div><br></div>
                  </div>
                </div>

                
                <%  
                cont++;
                
              }
              

              %>
              
              <div class="form-group">
                <div class="col-sm-offset-8 col-sm-10">
                  <input type="button"onclick="grabarExamenProfesor2('<%=request.getContextPath()%>')" value="grabar" class="btn btn-primary">
                </div>
                <div class="col-sm-offset-8 col-sm-10">
                  <input type="button"  onclick="cargar('<%=request.getContextPath()%>','Examen',4 ,'cod='+<%=obj1.getCodigoprofesor()%>)" value="salir" class="btn btn-primary">
                </div>
              </div>
              
            </form>
            
            
            
          </div>
        </div>
      </div>
    </div>
  </body>
  </html>
  
  