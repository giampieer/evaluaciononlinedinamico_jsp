<%@page import="BEAN.ExamenBean1"%>
<%@page import="BEAN.notaxexamenbean"%>
<%@page import="BEAN.AlumnoBean"%>
<%@page import="java.util.ArrayList"%>
<%!  ArrayList<ExamenBean1>lista2=new ArrayList<ExamenBean1>(); %>
    <%! ArrayList<notaxexamenbean>lista=new ArrayList<notaxexamenbean>(); %>
        <% lista=(ArrayList<notaxexamenbean>)request.getAttribute("cargar1");%>
            <% lista2=(ArrayList<ExamenBean1>)request.getAttribute("cargar2"); %>
                <html>
                <head>
                    <script>
                        animacion_numeros();
                    </script>
                </head>
                <body>
                    <%
            //hallar promedio,puntaje total,examenes hechos
                    int cant_resueltos=0;
                    String estado="";
                    double promedio=0;
                    double promedio_general=0;
                    for(notaxexamenbean  obj:lista){
                    promedio_general+=obj.getPuntaje();
                    cant_resueltos++;
                }
                promedio=promedio_general/cant_resueltos;
                if(cant_resueltos==0){
                promedio=0;} 
                if(promedio<11){
                estado="DESAPROBADO";
            }else{
            if(promedio>=11 && promedio<=20){
            estado="APROBADO";
        }
    }
        //hallar examens faltantes
    
    int cant_resuelto2=0;
    for (ExamenBean1 obj:lista2) {
    cant_resuelto2++;
}

%>
<div class="row">
    <div class="col-md-3 col-sm-6 animated fadeInDown">
        <div class="dashboard-tile detail tile-red">
            <div class="content">
                <h1 class="text-left timer" data-from="0" data-to="<%=cant_resueltos%>" data-speed="4000"> </h1>
                <p>Examenes Revisados</p>
            </div>
            <div class="icon"><i class="fa fa-users"></i>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-6 animated fadeInUp">
        <div class="dashboard-tile detail tile-turquoise">
            <div class="content">
                <h1 class="text-left timer" data-from="0" data-to="<%=cant_resuelto2 %>" data-speed="4000"> </h1>
                <p>Examenes Faltantes</p>
            </div>
            <div class="icon"><i class="fa fa-comments"></i>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-6 animated fadeInDown">
        <div class="dashboard-tile detail tile-blue">
            <div class="content">
                <h1 class="text-left timer" data-from="0" data-to="<%=promedio_general %>" data-speed="4000"> </h1>
                <p>Puntos Obtenidos</p>
            </div>
            <div class="icon"><i class="fa fa fa-envelope"></i>
            </div>
        </div>
    </div>
    <div class="col-md-3 col-sm-6 animated fadeInUp">
        <div class="dashboard-tile detail tile-purple">
            <div class="content">
                <h1 class="text-left timer" data-to="<%=promedio %>" data-speed="4000"> </h1>
                <p>Promedio Actual (<%=estado %>)</p>
            </div>
            <div class="icon"><i class="fa fa-bar-chart-o"></i>
            </div>
        </div>
    </div>
</div>

</body>
</html>
