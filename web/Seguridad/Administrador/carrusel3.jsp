<%@page import="BEAN.ProfesorBean"%>
<%@page import="BEAN.ExamenBean1"%>
<%@page import="BEAN.notaxexamenbean"%>
<%@page import="BEAN.AlumnoBean"%>
<%@page import="java.util.ArrayList"%>
<%!ArrayList<ProfesorBean> ListaProfesor;%>
    <%ListaProfesor=(ArrayList <ProfesorBean>)request.getAttribute("cargarprofesor");%>
        <%!ArrayList<AlumnoBean> ListaAlumno;%>
            <%ListaAlumno=(ArrayList <AlumnoBean>)request.getAttribute("cargaralumno");%>
                <html>
                <head>
                    <script>
                        animacion_numeros();
                    </script>
                </head>
                <body>
                    <%
                    int i=0;
                    for(ProfesorBean obj:ListaProfesor){
                    i++;
                }
                
                int a=0;
                for(AlumnoBean obj1:ListaAlumno){
                a++;
            }
            %>

            <div class="row">
                <div class="col-md-4 col-sm-6 animated fadeInDown">
                    <div class="dashboard-tile detail tile-red">
                        <div class="content">
                            <h1 class="text-left timer" data-from="0" data-to="<%=a%>" data-speed="4000"> </h1>
                            <p>Cantidad Alumnos</p>
                        </div>
                        <div class="icon"><i class="fa fa-users"></i>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 animated fadeInUp">
                    <div class="dashboard-tile detail tile-turquoise">
                        <div class="content">
                            <h1 class="text-left timer" data-from="0" data-to="<%=i%>" data-speed="4000"> </h1>
                            <p>Cantidad Profesores</p>
                        </div>
                        <div class="icon"><i class="fa fa-comments"></i>
                        </div>
                    </div>
                </div>
                
            </div>
            
        </body>
        </html>
