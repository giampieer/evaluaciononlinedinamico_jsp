
<%@page import="BEAN.ExamenReseultoBean1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.preguntasbean"%>
<%!ArrayList<preguntasbean> lista ; %>
    <%lista=(ArrayList<preguntasbean>)request.getAttribute("cargar");%>
        <%!ExamenReseultoBean1 obj=new ExamenReseultoBean1(); %>
        <%obj=(ExamenReseultoBean1)request.getAttribute("obj");%>
        <html>
        <head></head>
        <body>
            <div class="row">
                <div class="col-md-8 animated fadeInRightBig">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">RESOLVER PREGUNTA</h3>
                            
                        </div>
                        <%
                        
                        String pregunta="";
                        for (preguntasbean obj2:lista){
                        pregunta= obj2.getPregunta();
                        
                    }%>
                    <div class="panel-body">

                        <form class="form-horizontal form-border" id="form">
                          
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label"><%=pregunta%></label>
                                <div class="col-sm-6">
                                    <select  name="respuesta" id="respuesta" class="form-control" >
                                        <option value="cero">----- Responder  -----</option>
                                        <% 
                                        for (preguntasbean obj2:lista){%>
                                        <option value="<%=obj2.getPuntaje()%>"><%=obj2.getRespuesta()%></option>
                                        
                                        <%
                                        
                                        
                                    }%>
                                </select>                                        </div>
                            </div>
                            <input type="hidden" class="form-control" name="txtnom" id="codalum" value="<%=obj.getCodalumno()%>">
                            <input type="hidden" class="form-control" name="txtnom" id="codpreg" value="<%=obj.getCodpreg()%>">
                            <input type="hidden" class="form-control" name="txtnom" id="codexamen" value="<%=obj.getCodexamen()%>">
                            
                            <div class="form-group">
                                <div class="col-sm-offset-8 col-sm-10">
                                    <input type="button"onclick="TerminarExamenes128('<%=request.getContextPath()%>')" value="Grabar" class="btn btn-primary">

                                </div>
                                
                            </div>           
                            
                        </form>


                    </div>
                </div>
            </div>
        </div>

        
    </body>
    </html>