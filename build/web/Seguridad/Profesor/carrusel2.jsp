<%@page import="BEAN.ExamenBean1"%>
<%@page import="BEAN.notaxexamenbean"%>
<%@page import="BEAN.AlumnoBean"%>
<%@page import="java.util.ArrayList"%>
<%!  ArrayList<ExamenBean1>lista2=new ArrayList<ExamenBean1>(); %>

    <% lista2=(ArrayList<ExamenBean1>)request.getAttribute("cargar"); %>
        <%! ArrayList<notaxexamenbean> lista; %>
            <%lista=(ArrayList<notaxexamenbean>)request.getAttribute("cargar2");%>
                <html>
                <head>
                    <script>
                        animacion_numeros();
                    </script>
                </head>
                <body>
                    <%
                    int i=0;
                    for(ExamenBean1 obj:lista2){
                    i++;
                }
                
                int a=0;
                for(notaxexamenbean obj1:lista){
                a++;
            }
            %>

            <div class="row">
                <div class="col-md-3 col-sm-6 animated fadeInDown">
                    <div class="dashboard-tile detail tile-red">
                        <div class="content">
                            <h1 class="text-left timer" data-from="0" data-to="<%=i%>" data-speed="4000"> </h1>
                            <p>Examenes Creados</p>
                        </div>
                        <div class="icon"><i class="fa fa-users"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 animated fadeInUp">
                    <div class="dashboard-tile detail tile-turquoise">
                        <div class="content">
                            <h1 class="text-left timer" data-from="0" data-to="<%=a %>" data-speed="4000"> </h1>
                            <p>Examenes Revisados</p>
                        </div>
                        <div class="icon"><i class="fa fa-comments"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 animated fadeInDown">
                    <div class="dashboard-tile detail tile-blue">
                        <div class="content">
                            <h1 class="text-left timer" data-from="0" data-to="<%=i %>" data-speed="4000"> </h1>
                            <p>Examenes a Revisar</p>
                        </div>
                        <div class="icon"><i class="fa fa fa-envelope"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 animated fadeInUp">
                    <div class="dashboard-tile detail tile-purple">
                        <div class="content">
                            <h1 class="text-left timer" data-to="<%=i %>" data-speed="4000"> </h1>
                            <p>Cantidad Alumno</p>
                        </div>
                        <div class="icon"><i class="fa fa-bar-chart-o"></i>
                        </div>
                    </div>
                </div>
            </div>
            
        </body>
        </html>
