//REUTILIZABLES CON JQUERY

function Ajax(tipoparametro,ruta,servlet,op,parametros,div){
  $.ajax(
    {   type:"POST",
    dataType:"html",
    url:ruta+"/"+servlet+"Servlet",
    data:"op="+op+"&"+parametros,
    success:function(datos)
    {
      $(div).html(datos);
    }
  }); 
}

  //loadin en ajax 
  $(document).ajaxStart(function(){
    const pre = Prelodr()
    pre.show('Cargando...')
    $(document).ajaxStop(function(){
      pre.hide()   
    });
  });

  function cargar(ruta, tabla, op, parametros)
  {
    Ajax("GET",ruta,tabla,op,parametros,"#contenido1")
  }
//cambiar numeros
function animacion_numeros(){
 $(document).ready(function() {
  app.timer();
  
});
}

function cargarinactividad (){
 var device = navigator.userAgent
 if (device.match(/Iphone/i)|| 
  device.match(/Ipod/i)|| 
  device.match(/Android/i)|| 
  device.match(/J2ME/i)||
  device.match(/BlackBerry/i)||
  device.match(/iPhone|iPad|iPod/i)|| 
  device.match(/Opera Mini/i)||
  device.match(/IEMobile/i)|| 
  device.match(/Mobile/i)||
  device.match(/Windows Phone/i)||
  device.match(/windows mobile/i)||
  device.match(/windows ce/i)||
  device.match(/webOS/i)|| 
  device.match(/palm/i)|| 
  device.match(/bada/i)||
  device.match(/series60/i)|| 
  device.match(/nokia/i)|| 
  device.match(/symbian/i)||
  device.match(/HTC/i)){}
  else
  {
    var temp = setTimeout(redireccion, 30000);

    document.addEventListener("click", function() {
      clearTimeout(temp);
      temp = setTimeout(redireccion, 30000);
    })
  }}
  function redireccion() {
    swal({
      title: "Deseas salir del Menu por Inactividad?",
      text: "Tendras que iniciar sesion nuevamente ",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "SALIR",
      cancelButtonText: "CANCELAR",
      closeOnConfirm: true,
      closeOnCancel: false
    },
    function(isConfirm){
      if (isConfirm) {
       window.location = "index.jsp";
       
     } else {
      swal("Cancelado", "No se grabo ningun dato", "error");
    }
  });
    
  }
 //LOGIN
 //funcion para no  retroceder despues de cerrar sesion
 function bloqueo(){
  window.location.hash="no-back-button";
                window.location.hash="Again-No-back-button" //chrome
                window.onhashchange=function(){window.location.hash="no-back-button";}
                
                //NOTIFICACION
                Push.create("INICIE SESION POR FAVOR", {
                  body: "I.E.P. NUESTRA SEÑORA DE LA MERCED ",
                  icon:"./imagenes/logo.png",
                  timeout: 4000,
                  onClick: function () {
                    window.focus();
                    this.close();
                  }
                });
              } 
    //cerrar sesion del menu 
    function cerrarsesion(ruta){
      swal({
        title: "Desea cerrar sesion?",
        text: "Elija por favor ",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "Cerrar Sesion",
        cancelButtonText: "Cancelar",
        closeOnConfirm: false,
        closeOnCancel: false
      },
      function(isConfirm){
        if (isConfirm) {
   //$(location).attr('href',""+ruta+ "/inicio/menu3ajax.jsp"); 
   $(location).attr('href',""+ruta+ "/index.jsp"); 
 } else {
  swal("CERRAR SESION CANCELADO", "I.E.P. NUESTRA SEÑORA DE LA MERCED", "error");
}
});
    }
    function paginacion(){
     $(document).ready(function()
      {$('#tabla').DataTable(
        {   "language":
        {   "sProcessing": "Procesando...",
        "sLengthMenu": "Mostrar _MENU_ registros",
        "sZeroRecords": "No se encontraron resultados",
        "sEmptyTable": "Ningun dato disponible en esta tabla",
        "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
        "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
        "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
        "sInfoPostFix": "",
        "sSearch": "Buscar:",
        "sUrl": "",
        "sInfoThousands": ",",
        "sLoadingRecords": "Cargando...",
        "oPaginate": 
        {   "sFirst": "Primero",
        "sLast": "Utimo",
        "sNext": "Siguiente",
        "sPrevious": "Anterior"
      },
      "oAria":
      {   "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
      "sSortDescending": ": Activar para ordenar la columna de manera descendente"
    }
  }
});
    });
     
   }
   function grabar1(ruta, tabla, op, parametros)
   {
     swal({
      title: "Desea grabar el registro?",
      text: "Los datos seran registrados en la base de datos",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "GRABAR",
      cancelButtonText: "CANCELAR",
      closeOnConfirm: true,
      closeOnCancel: false
    },
    function(isConfirm){
      if (isConfirm) {
        Ajax("GET",ruta,tabla,op,parametros,"#contenido1");
        
      } else {
        swal("Cancelado", "No se grabo ningun dato", "error");
      }
    });
   }

   function grabar2(ruta, tabla, op, parametros)
   {
    
    Ajax("GET",ruta,tabla,op,parametros,"#contenido1");
    
  }
  function eliminar(ruta, tabla, op, parametros)
  {
    
    swal({
      title: "Desea eliminar el registro?",
      text: "Los datos seran eliminados permanentemente",
      type: "warning",
      showCancelButton: true,
      confirmButtonColor: "#DD6B55",
      confirmButtonText: "ELIMINAR",
      cancelButtonText: "CANCELAR",
      closeOnConfirm: true,
      closeOnCancel: false
    },
    function(isConfirm){
      if (isConfirm) {
        Ajax("GET",ruta,tabla,op,parametros,"#contenido1");  
        
      } else {
        swal("Cancelado", "No se elimino ningun dato", "error");
      }
    });
  }



  function modificar(ruta, tabla, op, parametros)
  {
   swal({
    title: "Desea modificar el registro?",
    text: "Los datos seran modificados en la base de datos",
    type: "warning",
  showCancelButton: true,//se muestre el boton cancelar
  confirmButtonColor: "#DD6B55",
  confirmButtonText: "MODIFICAR",
  cancelButtonText: "CANCELAR",
  closeOnConfirm: true,//al confirmar el boton modificar se cierre la alerta
  closeOnCancel: false//al  cancelar me envia a la funcion
},
function(isConfirm){
  if (isConfirm) {
    Ajax("GET",ruta,tabla,op,parametros,"#contenido1");  
    
  } else {
    swal("Cancelado", "No se modifico ningun dato", "error");
  }
});
 }




//salir de un formulario
function salir(ruta,servlet,op,parametros)
{
  Ajax("GET",ruta,servlet,op,parametros,"#contenido1");
}



function cargar(ruta, tabla, op, parametros)
{
  Ajax("GET",ruta,tabla,op,parametros,"#contenido1");
}

function cargar_terminarexamen(ruta, tabla, op, parametros)
{
  Ajax("GET",ruta,tabla,op,parametros,"#contenido1");
  alertify.warning("EXAMEN ENVIADO AL PROFESOR !!!")

  habilitar=0;
}

function cargarexamen(ruta, tabla, op, parametros)
{
  swal({
    title: "DESEA RESOLVER EL EXAMEN?",
    text: "Los datos seran eliminados permanentemente",
    type: "warning",
    showCancelButton: true,
    confirmButtonColor: "#DD6B55",
    confirmButtonText: "RESOLVER",
    cancelButtonText: "CANCELAR",
    closeOnConfirm: true,
    closeOnCancel: false
  },
  function(isConfirm){
    if (isConfirm) {
      alertify.warning("AL RESOLVER EXAMEN SELECCIONADO NO PODRAS RETROCEDER HASTA TERMINAR LA EVALUACION")
      Ajax("GET",ruta,tabla,op,parametros,"#contenido1");  
      cargarinactividad1(parametros);
    } else {
      swal("Cancelado", "No se elimino ningun dato", "error");
    }
  });
}
//acabar examen automatico
var par;
var habilitar;
var valor1;
function capturar_examen_resuelto(valor){
  valor1=valor;
}
function cargarinactividad1(parametros){

  par=parametros;
  setTimeout("alerta_acabar()",15000);
  setTimeout("acabarexamen()", 30000);
  
  habilitar=1;
  
  
}
function acabarexamen(){
  if(habilitar==1&& valor1==1){
    alertify.warning("TERMINO EL EXAMEN !!!")
    cargar("/Evaluacion",'Estu',13 ,par);
    par="";
  }else{
   alertify.warning("El examen no fue registrado por no responder ninguna preguntas")
   cargar("/Evaluacion",'Estu',12,par);
   par="";
 }

}
function alerta_acabar(){
 var duration = 15;
 var msg = alertify.message('El examen acabara en '+ duration +' segundos.', 15, function(){ clearInterval(interval);});
 var interval = setInterval(function(){
  if(habilitar==1){

    msg.setContent('El examen acabara en '+(--duration)+' segundos.');
  }else{
    msg.setContent('El examen fue Registrado.');

  }
},1000);
 
}
function Menu(ruta,servlet,op,parametros)
{
  Ajax("GET",ruta,servlet,op,parametros,"#contenido1");
}



function cargar_promedio(ruta,servlet,op,parametros)
{
  Ajax("GET",ruta,servlet,op,parametros,"#contenido1");
}
 //bienvenido al ingresar al menu
 function bienvenido(ruta){
   window.location.hash="no-back-button";
               window.location.hash="Again-No-back-button" //chrome
               window.onhashchange=function(){window.location.hash="no-back-button";}
               swal({
                title: "Bienvenido :<small>"+ruta+" </small>",

                html: true
              });
               
               Push.create("Bienvenido:"+ruta+"", {
                body: "I.E.P. NUESTRA SEÑORA DE LA MERCED",
                icon:"./imagenes/logo.png",
                timeout: 4000,
                onClick: function () {
                  window.focus();
                  this.close();
                }
              });
               
             }
 //cargar en orden para onload
 function  ingresarmenu(ruta){
     bienvenido(ruta);//bienvenido al ingresar menu
     
   }
   
//login
function enter1(ruta)
{
  var rutatotal, usuario,clave,seleccion;
  rutatotal=ruta+"/EstuServlet?op=1";
  usuario=document.form.txtnombre.value;
  clave=document.form.txtcontra.value;
  seleccion=document.getElementById('txtseleccion').value;
  if(seleccion=='0')
  {
    alertify.warning("SELECCIONAR CATEGORIA PARA INGRESAR");
    document.form.txtseleccion.focus();
    return ;
  }else if(usuario=='')
  {
    alertify.warning("Ingrese el usuario por favor!!");
    document.form.txtnombre.focus();
    return;
  }else if(clave=='')
  {
    alertify.warning("Ingrese la clave por favor!!");
    document.form.txtcontra.focus();
    return;
  }else{
    document.form.action=rutatotal;
    document.form.method="POST";
    document.form.submit();;
  }
}
function generarpreguntas(ruta){
  var cant,codprof;
  cant=document.getElementById('cant').value;
  codprof=document.getElementById('codprofesor').value;
  
  var parametros = '';
  parametros = "cant=" + cant + "&";
  parametros += "codprofesor=" + codprof ;
  
  if(cant=='')
  {
    alertify.warning("Elija la cantidad de preguntas");
    document.form.txtcant.focus();
    return;
  }else if(codprof=='')
  {
    alertify.warning("Ingrese el codigo del profesor");
    document.form.txtnom.focus();
    return;
  }else{
   grabar2(ruta,'Examen', 2, parametros);
 }
}





function grabarExamenProfesor2(ruta) {
  var cod,nombcurso,pre,prof,cant,numexamen,codrespuesta,nota;
  cod=document.getElementById('txtcod').value;
  numexamen=document.getElementById('txtnumexamen').value;
  nombcurso=document.getElementById('txtnom').value;
  cant=document.getElementById('txtcant').value;
  prof=document.getElementById('codprofe').value;
  codrespuesta=document.getElementById('txtrespuesta').value;
  nota=document.getElementById('txtnota').value;
  var cont=1;
  var parametros = '';
  parametros = "txtcod=" + cod + "&";
  parametros += "txtnom=" + nombcurso + "&";
  parametros += "codprofe=" + prof +"&";
  parametros += "txtcant=" + cant +"&";
  parametros += "txtnumexamen=" + numexamen +"&";
  parametros += "txtrespuesta=" + codrespuesta +"&";
  parametros += "txtnota=" + nota +"&";
  for (var i=0;i<cant;i++){
   parametros += "pre"+cont+"="+document.getElementById('pre'.concat(cont)).value+ "&";
   
   parametros += "res1("+cont+")="+document.getElementById('res1'.concat(cont)).value+ "&";
   if(document.getElementById('nota1'.concat(cont)).checked==true){
    parametros += "punt1("+cont+")="+document.getElementById('nota1'.concat(cont)).value+ "&";
    parametros += "res2("+cont+")="+document.getElementById('res2'.concat(cont)).value+ "&";
    parametros += "punt2("+cont+")="+0+ "&";
    parametros += "res3("+cont+")="+document.getElementById('res3'.concat(cont)).value+ "&";
    parametros += "punt3("+cont+")="+0+ "&";
  }else{
    if(document.getElementById('nota2'.concat(cont)).checked==true){
      parametros += "punt1("+cont+")="+0+ "&";
      parametros += "res2("+cont+")="+document.getElementById('res2'.concat(cont)).value+ "&";
      parametros += "punt2("+cont+")="+document.getElementById('nota2'.concat(cont)).value+ "&";
      parametros += "res3("+cont+")="+document.getElementById('res3'.concat(cont)).value+ "&";
      parametros += "punt3("+cont+")="+0+ "&"; 
    }else{
      if(document.getElementById('nota3'.concat(cont)).checked==true){
       parametros += "punt1("+cont+")="+0+ "&";
       parametros += "res2("+cont+")="+document.getElementById('res2'.concat(cont)).value+ "&";
       parametros += "punt2("+cont+")="+0+ "&";
       parametros += "res3("+cont+")="+document.getElementById('res3'.concat(cont)).value+ "&";
       parametros += "punt3("+cont+")="+document.getElementById('nota3'.concat(cont)).value+ "&";
     }
   }

 }  cont++;}
 
 if(cod=='')
 {
  alertify.warning("Elija el codigo");
  return;
}else if(nombcurso=='')
{
  alertify.warning("Ingrese el nombre del examen");
  return;
}else if(numexamen==''){
  alertify.warning("Ingrese numeor examen");
  return; 
}else if(prof==''){
  alertify.warning("Ingrese codigo profesor");
  return;    
}else if(document.getElementsByName("txtnotas").checked==false){
  alert("SELECCIONAR PUNTAJE A LA RESPUESTA CORRECTA");
  return;      
}else
{
  var contador=1;
  for(var i=0;i<cant;i++){
    if(document.getElementById('pre'.concat(contador)).value==''){
     alert("Ingrese la pregunta ".concat(contador));
     return;
   }else if(document.getElementById('res1'.concat(contador)).value=='')
   {
    alertify.warning("Ingrese la respuesta 1 de la pregunta ".concat(contador));
    return;
  }else if(document.getElementById('res2'.concat(contador)).value==''){
    alert("Ingrese la respuesta 2 de la pregunta ".concat(contador));
    return;  
    
  }else if(document.getElementById('res3'.concat(contador)).value==''){
    alertify.warning("Ingrese la respuesta 3 de la pregunta ".concat(contador));
    return; 
  }  else if(document.getElementById('nota1'.concat(contador)).checked==false && document.getElementById('nota2'.concat(contador)).checked==false  && document.getElementById('nota3'.concat(contador)).checked==false  ){
    alertify.warning("INSERTAR PUNTAJE A LA RESPUESTA CORRECTA");
    return; 
  }  
  
  contador ++;
}
grabar1(ruta,'Examen', 8, parametros);
}



}



function TerminarExamen1(ruta){
  var codpregunta,respuesta,codalum,cant;
  codalum=document.getElementById('codalum').value;
  cant=document.getElementById('txtcant').value;
  
  var parametros = '';
  parametros = "txtcodalum=" +codalum + "&";
  parametros += "txtcant=" +cant + "&";
  var contador=1;
  
  for (var i=0;i<cant;i++){
   parametros += "pre"+contador+"="+document.getElementById('preg'.concat(contador)).value+"&";
   parametros += "res"+contador+"="+document.getElementById('respuesta'.concat(contador)).value+"&";
   contador++;
 }
 
 
 var contador=1;
 for(var i=0;i<cant;i++){
  if(document.getElementById('preg'.concat(contador)).value==''){
   alertify.warning("Ingrese la pregunta ".concat(contador));
   
       // document.form.txtpres.focus();
       return;
     }else{
      if(document.getElementById('respuesta'.concat(contador)).value==''){
        alertify.warning("Ingrese la respuesta ".concat(contador));
        return;
      }
    }
    contador ++;
  }
  if(codalum=='')
  {
    alertify.warning("Elija el codigo alumno");
    document.form.txtcant.focus();
    return;
  }else if(cant=='')
  {
    alertify.warning("Ingrese el nombre del examen");
    document.form.codalum.focus();
    return;
  }else
  {
    modificar(ruta,'Estu', 9, parametros);
  }
  
  
}
function TerminarExamenes128(ruta){
  var codalumno,codexamen,codpreg,respuesta;
  codalumno=document.getElementById('codalum').value;
  codexamen=document.getElementById('codexamen').value;
  codpreg=document.getElementById('codpreg').value;
  respuesta=document.getElementById('respuesta').value;
  
  var parametros = '';
  parametros = "codalum=" + codalumno + "&";
  parametros += "codexamen=" + codexamen + "&";
  parametros += "codpreg=" + codpreg+ "&";
  parametros += "respuesta=" + respuesta + "&";
  
  if(codalumno=='0')
  {
    alertify.warning("Elija el codigo del libro");
    document.form.respuesta.focus();
    return;
  }else if(codexamen=='0')
  {
    alertify.warning("Ingrese");
    document.form.respuesta.focus();
    return;
  }else if(codpreg=='0')
  {
    alertify.warning("Ingrese");
    document.form.respuesta.focus();
    return;
  }else if(respuesta=='cero'){
    alertify.warning("Ingrese");
    document.form.respuesta.focus();
    return; 
  }else{
   grabar1(ruta,'Estu', 11, parametros);   
   
 }
}


function NotaExamenes(ruta){
  var codnota,cant,nota1,codigopro,codexamres,codexamprin;
  codnota=document.getElementById('txtcodnota').value;
  cant=document.getElementById('cant').value;
  codigopro=document.getElementById('txtcodigoprofesor').value;
  codexamres=document.getElementById('codexamres').value;
  codexamprin=document.getElementById('codexamprin').value;
  var parametros = '';
  parametros = "codnota=" +codnota + "&";
  parametros += "txtcant=" +cant + "&";
  parametros += "txtcodprofesor=" +codigopro + "&";
  parametros += "codexamres=" +codexamres + "&";
  parametros += "codexamprin=" +codexamprin + "&";
  var contador=1;
  
  for (var i=0;i<cant;i++){
   parametros += "pre"+contador+"="+document.getElementById('pregunta'.concat(contador)).value+"&";
   parametros += "alumno"+contador+"="+document.getElementById('codalumno'.concat(contador)).value+"&";
   parametros += "nota"+contador+"="+document.getElementById('nota'.concat(contador)).value+"&";
   contador++;
 }
 
 
 
 var contador=1;
 for(var i=0;i<cant;i++){
  if(document.getElementById('pregunta'.concat(contador)).value==''){
   alertify.warning("Ingrese la pregunta ".concat(contador));
   
       // document.form.txtpres.focus();
       return;
     }else{
      if(document.getElementById('codalumno'.concat(contador)).value==''){
        alertify.warning("Ingrese el codigo alumno ".concat(contador));
        return;
      }else{
        if(document.getElementById('nota'.concat(contador)).value=='cero'){
          alertify.warning("Ingrese la nota ".concat(contador));
          return;
        }
      }
    }
    contador ++;
  }
  if(codnota=='')
  {
    alertify.warning("Elija el codigo de la nota");
    document.form.txtcodnota.focus();
    return;
  }else if(cant=='')
  {
    alertify.warning("Ingrese el cantidad de notas");
    document.form.cant.focus();
    return;
  }else if(codigopro=='')
  {
    alertify.warning("Ingrese el codigo del profesor");
    document.form.txtcodigoprofesor.focus();
    return;
  }else
  {
    grabar1(ruta,'Examen', 9, parametros);
  }
  
  
}

function GrabarProfesor(ruta)
{
  var codigo=document.getElementById('txtcod').value;
  var nombre=document.getElementById('txtnombre').value;
  var usuario=document.getElementById('txtusuario').value;
  var clave=document.getElementById('txtclave').value;
  var codadmin=document.getElementById('txtcodadmin').value;

  var parametros="";
  parametros="txtcod="+codigo+"&";
  parametros+="txtnombre="+nombre+"&";
  parametros+="txtusuario="+usuario+"&";
  parametros+="txtclave="+clave+"&";
  parametros+="txtcodadmin="+codadmin;

  
  if (nombre=="")
  {
    alertify.warning("Ingrese el Nombre del profesor");
    document.getElementById('txtnombre').focus();
    return;
  }else if(usuario == "")
  {
    alertify.warning("Ingrese el usuario del profesor");
    document.getElementById('txtusuario').focus();
    return;  
  }else if(clave == "")
  {
    alertify.warning("Ingrese el clave del profesor");
    document.getElementById('txtclave').focus();
    return;
  }else{
    grabar1(ruta,'Profesor',3,parametros);
  }
  
  
  
}

function ModificarProfesor1(ruta)
{
  var codigo=document.getElementById('txtcod').value;
  var nombre=document.getElementById('txtnombre').value;
  var usuario=document.getElementById('txtusuario').value;
  var clave=document.getElementById('txtclave').value;
  var codadmin=document.getElementById('txtcodadmin').value;

  var parametros="";
  parametros="txtcod="+codigo+"&";
  parametros+="txtnombre="+nombre+"&";
  parametros+="txtusuario="+usuario+"&";
  parametros+="txtclave="+clave+"&";
  parametros+="txtcodadmin="+codadmin;

  
  if (nombre=="")
  {
    alertify.warning("Ingrese el Nombre del profesor");
    document.getElementById('txtnombre').focus();
    return;
  }else if(usuario == "")
  {
    alertify.warning("Ingrese el usuario del profesor");
    document.getElementById('txtusuario').focus();
    return;  
  }else if(clave == "")
  {
    alertify.warning("Ingrese la clave del profesor");
    document.getElementById('txtclave').focus();
    return;
  }else{
    modificar(ruta,'Profesor',7,parametros);
  }
  
  
  
}

function GrabarAlumno(ruta)
{
  var codigo=document.getElementById('txtcod').value;
  var nombre=document.getElementById('txtnombre').value;
  var usuario=document.getElementById('txtusuario').value;
  var clave=document.getElementById('txtclave').value;
  var codadmin=document.getElementById('txtcodadmin').value;
  
  var parametros="";
  parametros="txtcod="+codigo+"&";
  parametros+="txtnombre="+nombre+"&";
  parametros+="txtusuario="+usuario+"&";
  parametros+="txtclave="+clave+"&";
  parametros+="txtcodadmin="+codadmin;
  
  if (nombre=="")
  {
    alertify.warning("Ingrese el Nombre del alumno");
    document.getElementById('txtnombre').focus();
    return;
  }else if(usuario == "")
  {
    alertify.warning("Ingrese el usuario del alumno");
    document.getElementById('txtusuario').focus();
    return;  
  }else if(clave == "")
  {
    alertify.warning("Ingrese el clave del alumno");
    document.getElementById('txtclave').focus();
    return;
  }else{
    grabar1(ruta,'Alumno',3,parametros);
  }
  
  
}

function ModificarAlumno(ruta)
{
  var codigo=document.getElementById('txtcod').value;
  var nombre=document.getElementById('txtnombre').value;
  var usuario=document.getElementById('txtusuario').value;
  var clave=document.getElementById('txtclave').value;
  var codadmin=document.getElementById('txtcodadmin').value;

  var parametros="";
  parametros="txtcod="+codigo+"&";
  parametros+="txtnombre="+nombre+"&";
  parametros+="txtusuario="+usuario+"&";
  parametros+="txtclave="+clave+"&";
  parametros+="txtcodadmin="+codadmin;

  
  if (nombre=="")
  {
    alertify.warning("Ingrese el Nombre del alumno");
    document.getElementById('txtnombre').focus();
    return;
  }else if(usuario == "")
  {
    alertify.warning("Ingrese el usuario del alumno");
    document.getElementById('txtusuario').focus();
    return;  
  }else if(clave == "")
  {
    alertify.warning("Ingrese la clave del alumno");
    document.getElementById('txtclave').focus();
    return;
  }else{
    modificar(ruta,'Alumno',7,parametros);
  }
}

