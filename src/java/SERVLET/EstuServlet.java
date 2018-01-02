
package SERVLET;

import BEAN.AdministradorBean;
import BEAN.AlumnoBean;
import BEAN.ExamenBean1;
import BEAN.ExamenReseultoBean1;
import BEAN.ProfesorBean;
import BEAN.camionbean;
import BEAN.horariobean;
import BEAN.notaxexamenbean;
import BEAN.preguntasbean;
import DAO.AlumnoDAO;
import DAO.ExamenDAO;
import DAO.ExamenResueltoDAO;
import DAO.ProfesorDAO;
import DAO.adminDao;
import DAO.prototipodao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.security.auth.login.AppConfigurationEntry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class EstuServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
     String opcad=request.getParameter("op");
     int op=Integer.parseInt(opcad);
     response.setContentType("application/json");
     StringBuilder json = null;
        //examen
     camionbean objvcamionbean = null;
     prototipodao objprototipodao = null;
     horariobean objhorariobean = null;
     ProfesorBean obj2=null;
     ExamenDAO objdao=null;
     ArrayList Lista=null;
     ArrayList Lista2=null;
     AlumnoBean objestubean=null;
     AlumnoBean obj=null;
     AlumnoDAO objestudao=null;
     ProfesorBean objprofbean=null;
     ProfesorDAO objprofdao=null;
        //examenresulto
     ExamenResueltoDAO objresdao=null;
     String pagina="";
     switch(op){
        case 1:{
            try {
                objestubean = new AlumnoBean();
                objestudao = new AlumnoDAO();
                AdministradorBean objadmin=new AdministradorBean();
                adminDao objadmindao=new adminDao();
                objprofbean=new ProfesorBean();
                objprofdao=new ProfesorDAO();
                obj=new AlumnoBean();
                obj2=new ProfesorBean();
                String usuario = request.getParameter("txtnombre");
                String clave = request.getParameter("txtcontra");
                int  tipocad = Integer.parseInt(request.getParameter("txtseleccion"));
                objestubean.setIdalumno(usuario);
                objestubean.setContraalumno(clave);
                objadmin.setIdadmin(usuario);
                objadmin.setContradmin(clave);
                
                objprofbean.setIdprofesor(usuario);
                objprofbean.setContraprofesor(clave);
                if(tipocad==1){
                 int i=objprofdao.ValidarAcceso(objprofbean);
                 if(i==1){
                     obj2=objprofdao.DatosUsuario(objprofbean);
                     request.setAttribute("admin",obj2);
                     pagina="/Seguridad/Profesor/menuProfesor.jsp";
                 }else{
                  request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                  pagina="/index.jsp";
              }
              
          }else {if(tipocad==2)
            {
                int i=objestudao.ValidarAcceso(objestubean);
                if(i==1){
                  obj=objestudao.DatosUsuario(objestubean);
                  request.setAttribute("estudiante",obj);
                  pagina="/Seguridad/Estudiante/menuEstudiante.jsp";
              }else{
                  request.setAttribute("mensaje","Datos Incorrectos , vuelva Ingresar correctamente");
                  pagina="/index.jsp";
              }
          }else{
            if(tipocad==3){
                int i=objadmindao.ValidarAcceso(objadmin);
                if(i==1){
                  objadmin=objadmindao.DatosUsuario(objadmin);
                  request.setAttribute("admin",objadmin);
                  pagina="/Seguridad/Administrador/menuAdmin.jsp";
              }else{
                  request.setAttribute("mensaje","Datos Incorrectos del administrador , vuelva Ingresar correctamente");
                  pagina="/index.jsp";
              }
          }
      }
  }
} catch (Exception e) {
    request.setAttribute("mensaje","Loguearse por favor");
    pagina="/index.jsp";
}

break;
}
case 2:{
  
    break;
}
case 3:{
    break;
}
case 4:{
    objresdao=new ExamenResueltoDAO();
    
    objprofbean=new ProfesorBean();
    int cod=Integer.parseInt(request.getParameter("cod"));
    
    objprofbean.setCodigoprofesor(cod);
    request.setAttribute("codprof", objprofbean); 
    Lista=objresdao.ListarExamenResueltosProfesor1(objprofbean);
    request.setAttribute("cargar", Lista);
    pagina="/Mantenimiento/Profesor/RevisionExamenes/MostrarExamenRevisar.jsp";
    break;
}
case 5:{
    ExamenBean1 objexa=new ExamenBean1();
    objdao=new ExamenDAO();
    objestudao=new AlumnoDAO();
    obj=new AlumnoBean();
    
    int codalum=Integer.parseInt(request.getParameter("cod"));
    obj.setCodalumno(codalum);
    
    Lista=objdao.ListarExamenEstudiante2(obj);
    int codexamenresuelto;
    if(objdao.GenerarCodigoExamenResuelto()==0){
        codexamenresuelto=objdao.GenerarCodigoExamenResuelto()+1;
    }else{
        codexamenresuelto=objdao.GenerarCodigoExamenResuelto();
    }
    objexa.setCodexamenprof(codexamenresuelto);
    
    objexa.setCodalumno(codalum);
                //objdao.GrabarExamenResueltoss(objexa);
               // JOptionPane.showMessageDialog(null, "asdasd");
    request.setAttribute("cargar", Lista);
    request.setAttribute("codalum", obj);
    pagina="/Mantenimiento/Alumno/ExamenEstudiante/MostrarExamenAntes.jsp";
    break;
}
case 6:{
   String a = null;
   String   numeroCad[] =request.getParameterValues("codexamen");
   int  numero[]=new  int[numeroCad.length];
   for(int i=0;i<numero.length;i++)
   {
    numero[i]=Integer.parseInt(numeroCad[i]);
    
}

objestudao=new AlumnoDAO();
obj=new AlumnoBean();
int codalum=Integer.parseInt(request.getParameter("cod"));
obj.setCodalumno(codalum);
obj.setCodexamen(numero[0]);

objdao = new ExamenDAO();
ExamenBean1 objbean1= new ExamenBean1();
objbean1.setCodexamen(numero[0]);

objbean1.setCodalumno(codalum);
                 //JOptionPane.showMessageDialog(null, ""+objbean1.getCodalumno());
Lista=objdao.capturarExamen1(objbean1);
ArrayList Lista1=objdao.ListarExamenEstudiante3(obj);
request.setAttribute("DATOS",  Lista);
request.setAttribute("datos_retroceder",  Lista1);

request.setAttribute("codalum",  obj);
request.setAttribute("codexamen",  objbean1);
pagina = "/Mantenimiento/Alumno/ExamenEstudiante/ResolverExamen.jsp";
break;
}
case 7:{
   pagina="/index.jsp";
   break;
}
case 8:{
   objdao=new ExamenDAO();
   
   obj=new AlumnoBean();
   
   int cod=Integer.parseInt(request.getParameter("cod"));
   obj.setCodalumno(cod);
   request.setAttribute("codestu", obj); 
   Lista=objdao.ListarExamenALUMO1(obj);
   request.setAttribute("cargar", Lista);
   pagina="/Mantenimiento/Alumno/Estudiantes/ExamenResueltoEstudiante.jsp";
   break;
}
case 9:{
  objdao=new ExamenDAO();
  objresdao=new ExamenResueltoDAO();
  obj=new AlumnoBean();
  ExamenReseultoBean1 objresbean1=new ExamenReseultoBean1();
  int cant=Integer.parseInt(request.getParameter("txtcant"));
  int codalumno=Integer.parseInt(request.getParameter("txtcodalum")); 
  objresbean1.setCodalumno(codalumno);

  int cont=1;
  int ii=0;
  for(int i=0;i<cant;i++){
     int codpreg=Integer.parseInt(request.getParameter("pre"+cont));
     objresbean1.setCodpreg(codpreg);
     String res=request.getParameter("res"+cont);
     objresbean1.setRespuesta(res);
     ii=objresdao.GrabarExamenResuelto1(objresbean1);
     cont++;
 }
 
 if(ii == 1){
    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
}else{
    request.setAttribute("mensaje","Registro No Insertado");    
}           
obj.setCodalumno(codalumno);
Lista=objdao.ListarExamenEstudiante2(obj);
request.setAttribute("cargar", Lista);
request.setAttribute("codalum", obj);
pagina="/Mantenimiento/Alumno/ExamenEstudiante/MostrarExamenAntes.jsp";

break;
}

case 10:{
   int codipreg=Integer.parseInt(request.getParameter("codpreg"));
   int codalum=Integer.parseInt(request.getParameter("codalum"));
   int codexamen=Integer.parseInt(request.getParameter("codexamen"));
   
   objdao=new ExamenDAO();
   preguntasbean ob=new preguntasbean();
   ob.setCodpregunta(codipreg);
   Lista=objdao.capturarposiblesrespuestas(ob);
   
   ExamenReseultoBean1 ob256=new ExamenReseultoBean1();
   ob256.setCodalumno(codalum);
   ob256.setCodpreg(codipreg);
   ob256.setCodexamen(codexamen);
   request.setAttribute("cargar", Lista);
   request.setAttribute("obj", ob256);
   
   pagina="/Mantenimiento/Alumno/ExamenEstudiante/Responder.jsp";
   break;
}
case 11:{
   obj=new AlumnoBean();
   ExamenBean1 objbean1=new ExamenBean1();
   objdao=new ExamenDAO();
   objresdao=new ExamenResueltoDAO();
   int codipreg=Integer.parseInt(request.getParameter("codpreg"));
   int codalum=Integer.parseInt(request.getParameter("codalum"));
   int codexamen=Integer.parseInt(request.getParameter("codexamen"));
   String respuesta=request.getParameter("respuesta");
   
   ExamenReseultoBean1 ob111=new ExamenReseultoBean1();
   ob111.setCodalumno(codalum);
   ob111.setRespuesta(respuesta);
   ob111.setCodpreg(codipreg);
   int ii=objresdao.GrabarExamenResuelto1(ob111);
   if(ii == 1){
    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
}else{
    request.setAttribute("mensaje","Registro No Insertado");    
}           
obj.setCodalumno(codalum);
obj.setCodexamen(codexamen);
objbean1.setCodalumno(codalum);
objbean1.setCodexamen(codexamen);
Lista=objdao.capturarExamen1(objbean1);
ArrayList Lista1=objdao.ListarExamenEstudiante3(obj);
request.setAttribute("datos_retroceder",  Lista1);
request.setAttribute("DATOS",  Lista);
request.setAttribute("codalum",  obj);
request.setAttribute("codexamen",  objbean1);
pagina = "/Mantenimiento/Alumno/ExamenEstudiante/ResolverExamen.jsp";

break;
}
case 12:{
    objdao=new ExamenDAO();
    obj=new AlumnoBean();
    int codalum=Integer.parseInt(request.getParameter("cod"));
    obj.setCodalumno(codalum);
    Lista=objdao.ListarExamenEstudiante2(obj);
    request.setAttribute("cargar", Lista);
    request.setAttribute("codalum", obj);
    pagina="/Mantenimiento/Alumno/ExamenEstudiante/MostrarExamenAntes.jsp";
    break;
}
case 13:{
    ExamenBean1 objexa=new ExamenBean1();
    objdao=new ExamenDAO();
    objestudao=new AlumnoDAO();
    obj=new AlumnoBean();
    
    int codalum=Integer.parseInt(request.getParameter("cod"));
    obj.setCodalumno(codalum);
    int codexamen=Integer.parseInt(request.getParameter("codexamen"));
                        //  JOptionPane.showMessageDialog(null, ""+codexamen);

    Lista=objdao.ListarExamenEstudiante2(obj);
    int codexamenresuelto;
    if(objdao.GenerarCodigoExamenResuelto()==0){
        codexamenresuelto=objdao.GenerarCodigoExamenResuelto()+1;
    }else{
        codexamenresuelto=objdao.GenerarCodigoExamenResuelto();
    }
    objexa.setCodexamenprof(codexamenresuelto);
    objexa.setCodexamen(codexamen);
    objexa.setCodalumno(codalum);
    objdao.GrabarExamenResueltoss(objexa);
                //JOptionPane.showMessageDialog(null, "asdasd");
    request.setAttribute("cargar", Lista);
    request.setAttribute("codalum", obj);
    pagina="/Mantenimiento/Alumno/ExamenEstudiante/MostrarExamenAntes.jsp";
    break;
}
case 14:{
    objresdao=new ExamenResueltoDAO();
    
    objprofbean=new ProfesorBean();
    int cod=Integer.parseInt(request.getParameter("codprof"));
    int codalum=Integer.parseInt(request.getParameter("codalum"));
    
    objprofbean.setCodigoprofesor(cod);
    objprofbean.setCodalumno(codalum);
    request.setAttribute("codprof", objprofbean); 
    Lista=objresdao.ListarExamenResueltosProfesor3(objprofbean);
    request.setAttribute("cargar", Lista);
    pagina = "/Mantenimiento/Profesor/RevisionExamenes/TerminarRevision.jsp";
    
    
    break;
}
case 15:{
    objresdao=new ExamenResueltoDAO();
    
    objprofbean=new ProfesorBean();
    int cod=Integer.parseInt(request.getParameter("cod"));
    int codalum=Integer.parseInt(request.getParameter("codalum"));
    
    objprofbean.setCodigoprofesor(cod);
    objprofbean.setCodalumno(codalum);
    request.setAttribute("codprof", objprofbean); 
    Lista=objresdao.ListarExamenResueltosProfesor3(objprofbean);
    request.setAttribute("cargar", Lista);
    pagina = "/Mantenimiento/Profesor/RevisionExamenes/TerminarRevision.jsp";
    
    break;
}
case 16: {
    objprofbean = new ProfesorBean();
    objprofdao = new ProfesorDAO();

    String usuario = request.getParameter("txtnombre");
    String clave = request.getParameter("txtcontra");
    objprofbean.setIdprofesor(usuario);
    objprofbean.setContraprofesor(clave);
    PrintWriter out = response.getWriter();
    int i = objprofdao.ValidarAcceso(objprofbean);
    json = new StringBuilder();
    json.append("{\"profesor\":\"" + i + "\"}");
    out.print(json.toString());
    break;
}
case 17: {
    objprofbean = new ProfesorBean();
    objprofdao = new ProfesorDAO();

    String usuario = request.getParameter("txtnombre");
    String clave = request.getParameter("txtcontra");
    objprofbean.setIdprofesor(usuario);
    objprofbean.setContraprofesor(clave);
    PrintWriter out = response.getWriter();
    objprofbean = objprofdao.DatosUsuario(objprofbean);
    json = new StringBuilder();
    json.append("{\"codprofesor\":\"" + objprofbean.getCodigoprofesor() + "\",\"nombreprofesor\":\"" + objprofbean.getNombprofesor() + "\",\"idprofesor\":\"" + objprofbean.getIdprofesor() + "\",\"contraprofesor\":\""
        + "" + objprofbean.getContraprofesor() + "\"},");

    out.print(json.toString());
    break;
}
case 18: {

    objvcamionbean = new camionbean();
    objprototipodao = new prototipodao();

    Lista = objprototipodao.ListarCamiones();
    PrintWriter out = response.getWriter();
    json = new StringBuilder();

    json.append("{\"camion\":[");

    for (int i = 0; i < Lista.size(); i++) {
        camionbean obj1 = (camionbean) Lista.get(i);
        if (i == Lista.size()) {
            json.append("{\"codcamion\":\"" + obj1.getIdcamiones() + "\",\"marca\":\"" + obj1.getMarca() + "\",\"modelo\":\"" + obj1.getModelo() + "\",\"matricula\":\"" + obj1.getMatricula() + "\"}");
        } else {
            json.append("{\"codcamion\":\"" + obj1.getIdcamiones() + "\",\"marca\":\"" + obj1.getMarca() + "\",\"modelo\":\"" + obj1.getModelo() + "\",\"matricula\":\"" + obj1.getMatricula() + "\"},");
        }
    }

    json.append("]}");
    out.print(json.toString());
    break;
}
case 19: {
    objhorariobean = new horariobean();
    objprototipodao = new prototipodao();

    Lista = objprototipodao.ListarHorario();
    PrintWriter out = response.getWriter();
    json = new StringBuilder();

    json.append("{\"horario\":[");

    for (int i = 0; i < Lista.size(); i++) {
        horariobean obj1 = (horariobean) Lista.get(i);
        if (i == Lista.size()) {
            json.append("{\"codhorario\":\"" + obj1.getCodhorario() + "\",\"fecha\":\"" + obj1.getFecha() + "\",\"lugar\":\"" + obj1.getLugar() + "\"}");
        } else {
            json.append("{\"codhorario\":\"" + obj1.getCodhorario() + "\",\"fecha\":\"" + obj1.getFecha() + "\",\"lugar\":\"" + obj1.getLugar() + "\"},");
        }
    }

    json.append("]}");
    out.print(json.toString());
    break;
}

            //jsonalumno
case 20: {
    ExamenBean1 objexa = new ExamenBean1();
    objdao = new ExamenDAO();
    obj = new AlumnoBean();

    int codalum = Integer.parseInt(request.getParameter("cod"));
    obj.setCodalumno(codalum);

    Lista = objdao.ListarExamenEstudiante2(obj);
    PrintWriter out = response.getWriter();
    json = new StringBuilder();

    json.append("{\"examenesprofesores\":[");

    for (int i = 0; i < Lista.size(); i++) {
        ExamenBean1 obj1 = (ExamenBean1) Lista.get(i);
        if (i == Lista.size()) {
            json.append("{\"codexamen\":\"" + obj1.getCodexamen() + "\",\"nombreexamen\":\"" + obj1.getNombreexamen() + "\",\"codprofesor\":\"" + obj1.getCodprofesor() + "\"}");
        } else {
            json.append("{\"codexamen\":\"" + obj1.getCodexamen() + "\",\"nombreexamen\":\"" + obj1.getNombreexamen() + "\",\"codprofesor\":\"" + obj1.getCodprofesor() + "\"},");
        }
    }

    json.append("]}");
    out.print(json.toString());
    break;
}
case 21: {
    objdao = new ExamenDAO();

    obj = new AlumnoBean();

    int cod = Integer.parseInt(request.getParameter("cod"));
    obj.setCodalumno(cod);
    Lista = objdao.ListarExamenALUMO1(obj);
    PrintWriter out = response.getWriter();
    json = new StringBuilder();

    json.append("{\"promedio\":[");

    for (int i = 0; i < Lista.size(); i++) {
        notaxexamenbean obj1 = (notaxexamenbean) Lista.get(i);
        if (i == Lista.size()) {
            json.append("{\"codexamen\":\"" + obj1.getCodexamen() + "\",\"puntajeexamen\":\"" + obj1.getPuntaje() + "\",\"codalumno\":\"" + obj1.getCodalumno() + "\"}");
        } else {
            json.append("{\"codexamen\":\"" + obj1.getCodexamen() + "\",\"puntajeexamen\":\"" + obj1.getPuntaje() + "\",\"codalumno\":\"" + obj1.getCodalumno() + "\"},");
        }
    }

    json.append("]}");
    out.print(json.toString());
    break;
}
case 22: {
    objestubean = new AlumnoBean();
    objestudao = new AlumnoDAO();
    String usuario = request.getParameter("txtnombre");
    String clave = request.getParameter("txtcontra");
    objestubean.setIdalumno(usuario);
    objestubean.setContraalumno(clave);
    PrintWriter out = response.getWriter();
    int i = objestudao.ValidarAcceso(objestubean);
    json = new StringBuilder();
    json.append("{\"alumno\":\"" + i + "\"}");
    out.print(json.toString());
    break;
}
case 23: {
    objestubean = new AlumnoBean();
    objestudao = new AlumnoDAO();
    String usuario = request.getParameter("txtnombre");
    String clave = request.getParameter("txtcontra");
    objestubean.setIdalumno(usuario);
    objestubean.setContraalumno(clave);
    PrintWriter out = response.getWriter();

    objestubean = objestudao.DatosUsuario(objestubean);
    json = new StringBuilder();
    json.append("{\"codalumno\":\"" + objestubean.getCodalumno() + "\",\"nombrealumno\":\"" + objestubean.getNomalumno() + "\",\"idalumno\":\"" + objestubean.getIdalumno() + "\",\"contraalumno\":\""
        + "" + objestubean.getContraalumno() + "\"},");

    out.print(json.toString());
    break;
}


case 24: {
    AdministradorBean objadmin=new AdministradorBean();
    adminDao objadmindao=new adminDao();
    
    String usuario = request.getParameter("txtnombre");
    String clave = request.getParameter("txtcontra");
    objadmin.setIdadmin(usuario);
    objadmin.setContradmin(clave);
    
    
    
    PrintWriter out = response.getWriter();
    int i = objadmindao.ValidarAcceso(objadmin);
    json = new StringBuilder();
    json.append("{\"administrador\":\"" + i + "\"}");
    out.print(json.toString());
    break;
}
case 25: {
    AdministradorBean objadmin=new AdministradorBean();
    adminDao objadmindao=new adminDao();
    
    String usuario = request.getParameter("txtnombre");
    String clave = request.getParameter("txtcontra");
    objadmin.setIdadmin(usuario);
    objadmin.setContradmin(clave);
    PrintWriter out = response.getWriter();

    objadmin=objadmindao.DatosUsuario(objadmin);
    json = new StringBuilder();
    json.append("{\"codadmin\":\"" + objadmin.getCodadmin()+ "\",\"nombreadmin\":\"" + objadmin.getNomadmin()+ "\",\"idadmin\":\"" + objadmin.getIdadmin()+ "\",\"contraadmin\":\""
        + "" + objadmin.getContradmin()+ "\"},");

    out.print(json.toString());
    break;
}
case 26:{
    ProfesorDAO objDAO=new ProfesorDAO();
    
    Lista=objDAO.ListarProfesor();
    
    PrintWriter out = response.getWriter();
    json = new StringBuilder();

    json.append("{\"profesores\":[");

    for (int i = 0; i < Lista.size(); i++) {
        ProfesorBean obj1 = (ProfesorBean) Lista.get(i);
        if (i == Lista.size()) {
            json.append("{\"codprofesor\":\"" + obj1.getCodigoprofesor()+ "\",\"nombreprofesor\":\"" + obj1.getNombprofesor()+ "\",\"idprofesor\":\"" + obj1.getIdprofesor()+ "\",\"contraprofesor\":\"" + obj1.getContraprofesor()+ "\"}");
        } else {
            json.append("{\"codprofesor\":\"" + obj1.getCodigoprofesor()+ "\",\"nombreprofesor\":\"" + obj1.getNombprofesor()+ "\",\"idprofesor\":\"" + obj1.getIdprofesor()+ "\",\"contraprofesor\":\"" + obj1.getContraprofesor()+ "\"},");
        }
    }

    json.append("]}");
    out.print(json.toString());
    
    break;
}
case 27:{
    
   AlumnoDAO objDAO=new AlumnoDAO();
   
   Lista=objDAO.ListarAlumno();
   
   PrintWriter out = response.getWriter();
   json = new StringBuilder();

   json.append("{\"alumnos\":[");

   for (int i = 0; i < Lista.size(); i++) {
    AlumnoBean obj1 = (AlumnoBean) Lista.get(i);
    if (i == Lista.size()) {
        json.append("{\"codalumno\":\"" + obj1.getCodalumno()+ "\",\"nombrealumno\":\"" + obj1.getNomalumno()+ "\",\"idalumno\":\"" + obj1.getIdalumno()+ "\",\"contraalumno\":\"" + obj1.getContraalumno()+ "\"}");
    } else {
        json.append("{\"codalumno\":\"" + obj1.getCodalumno()+ "\",\"nombrealumno\":\"" + obj1.getNomalumno()+ "\",\"idalumno\":\"" + obj1.getIdalumno()+ "\",\"contraalumno\":\"" + obj1.getContraalumno()+ "\"},");
    }
}

json.append("]}");
out.print(json.toString());
break;


}

case 28:{
    objdao=new ExamenDAO();
    
    obj=new AlumnoBean();
    
    int cod=Integer.parseInt(request.getParameter("cod"));
    obj.setCodalumno(cod);
    request.setAttribute("codestu", obj); 
    Lista=objdao.ListarExamenALUMO1(obj);
    Lista2=objdao.ListarExamenEstudiante2(obj);
    request.setAttribute("cargar1", Lista);
    request.setAttribute("cargar2", Lista2);
    pagina="/Seguridad/Estudiante/carrusel.jsp";
    break;
}
case 29:{
   ProfesorDAO objDAO=new ProfesorDAO();
   int Codigoadmin=Integer.parseInt(request.getParameter("cod"));
   AdministradorBean objadminbvean=new AdministradorBean();
   objadminbvean.setCodadmin(Codigoadmin);
   ArrayList ListaProfesor=objDAO.ListarProfesor();
   AlumnoDAO objaldao=new AlumnoDAO();
   ArrayList  ListaAlumno=objaldao.ListarAlumno();
   request.setAttribute("cargaralumno", ListaAlumno);
   request.setAttribute("cargarprofesor", ListaProfesor);
   pagina="/Seguridad/Administrador/carrusel3.jsp";

   break;
}

}
getServletContext().getRequestDispatcher(pagina).forward(request, response);
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
