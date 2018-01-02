/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import BEAN.ExamenBean1;
import BEAN.ExamenReseultoBean1;

import BEAN.NotaBean1;
import BEAN.ProfesorBean;
import BEAN.RespuestasProf;
import BEAN.notaprof;
import BEAN.notaxexamenbean;
import DAO.ExamenDAO;
import DAO.ExamenResueltoDAO;
import DAO.NotaDAO;
import DAO.ProfesorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Home
 */
public class ExamenServlet extends HttpServlet {

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
      
      response.setContentType("text/html;charset=UTF-8");
      String opcad=request.getParameter("op");
      int op=Integer.parseInt(opcad);
      response.setContentType("application/json");
      StringBuilder json=null;
      NotaBean1 obj=null;
      ExamenDAO objdao=null;
      RespuestasProf objres1=null;
      RespuestasProf objres2=null;
      ArrayList Lista=null;
      String pagina="";
      RespuestasProf objres=null;
      ExamenResueltoDAO objresdao=null;
      ProfesorBean objprofbean=null;
      ExamenBean1 obj12=null;
      NotaDAO objnotadao=null;
      ProfesorDAO objprofdao=null;

      switch(op){
            case 1: //Listar
            {
              objdao=new ExamenDAO();
              objprofbean=new ProfesorBean();
              int cod=Integer.parseInt(request.getParameter("cod"));
              objprofbean.setCodigoprofesor(cod);
              request.setAttribute("codprof", objprofbean); 
              Lista=objdao.ListarExamenProfesor11(objprofbean);
              
              request.setAttribute("cargar", Lista);
              pagina="/Mantenimiento/Profesor/Examen/MostrarExamen.jsp";
              
              break;
            }
            case 2: //
            {
             objprofbean=new ProfesorBean();
             int cod=Integer.parseInt(request.getParameter("codprofesor"));
             int cant=Integer.parseInt(request.getParameter("cant"));
             objprofbean.setCodigoprofesor(cod);
             objprofbean.setCantpre(cant);
             request.setAttribute("obj", objprofbean); 
               // request.setAttribute("cant", objprofbean.getCantpre());
             
             pagina="/Mantenimiento/Profesor/Examen/GrabarExamen.jsp";
             break;
           }
              case 3: // Nuevo
              {
               
                
                break;
              }
              case 4:{
                objdao=new ExamenDAO();
                objprofbean=new ProfesorBean();
                int cod=Integer.parseInt(request.getParameter("cod"));
                objprofbean.setCodigoprofesor(cod);
                request.setAttribute("codprof", objprofbean); 
                Lista=objdao.ListarExamenProfesor11(objprofbean);
                
                request.setAttribute("cargar", Lista);
                
                
                pagina="/Mantenimiento/Profesor/Examen/MostrarExamen.jsp";
                break;
              }
              case 5:{
               
                
                break;
              }
            case 6: // capturar examen
            {
              
              
              obj12=new ExamenBean1();
              String a = null;
              String   numeroCad[] =request.getParameterValues("cod");
              int  numero[]=new  int[numeroCad.length];
              for(int i=0;i<numero.length;i++)
              {
                numero[i]=Integer.parseInt(numeroCad[i]);
                
              }
              int codalumno=Integer.parseInt(request.getParameter("codalum"));
              int codexmres=Integer.parseInt(request.getParameter("codexameresuelto"));
               //   JOptionPane.showMessageDialog(null, ""+codalumno);
              objprofbean=new ProfesorBean();
              int cod=Integer.parseInt(request.getParameter("codprof"));
              objprofbean.setCodigoprofesor(cod);
              objprofbean.setCodexamresuelto(codexmres);
              objprofbean.setCodexamen(numero[0]);
              request.setAttribute("codprof", objprofbean); 
              
              objresdao = new ExamenResueltoDAO();
              obj12.setCodexamen(numero[0]);
              obj12.setCodalumno(codalumno);
              Lista=objresdao.capturarExamenResuelto2(obj12);
              
              request.setAttribute("lista1",  Lista);
              
              pagina = "/Mantenimiento/Profesor/RevisionExamenes/RevisandoExamen.jsp";
              break;
            }
            case 7:{
              
              break;
            }
            
            case 8:{
              String nombcurso,prof,cant,codpregunta,numexamen,nota;
              int cod,cantidad;
              cod=Integer.parseInt(request.getParameter("txtcod"));
              nombcurso=request.getParameter("txtnom");
              numexamen=request.getParameter("txtnumexamen");
              cantidad=Integer.parseInt( request.getParameter("txtcant"));
              prof=request.getParameter("codprofe");
              nota=request.getParameter("txtnota");
              ExamenBean1 objbean22=new ExamenBean1();
              objdao=new ExamenDAO();
              
              int codexam=0;
              if(objdao.GenerarCodigoExamenss()==0){
               codexam=objdao.GenerarCodigoExamenss()+1;
             }else{
               codexam=objdao.GenerarCodigoExamenss();
             }
             
             objprofbean=new ProfesorBean();
             objprofbean.setCodigoprofesor(Integer.parseInt(prof));
             objprofbean.setCantpre(cantidad);
             objres=new RespuestasProf();
             objbean22.setCodexamen(Integer.parseInt(numexamen));
             objbean22.setCodprofesor(Integer.parseInt(prof));
             objbean22.setNombreexamen(nombcurso);
             objbean22.setCodexamenprof(codexam);
             int numpregunta=cod;
             objdao.GrabarExamenprof(objbean22);
             int cont=1;
             int ii=0;
             for(int i=1;i<=cantidad;i++){
              objbean22.setNumerpregunta(numpregunta);
              String pre=request.getParameter("pre"+cont);
              
              objbean22.setPregunta(pre);
              ii= objdao.GrabarExamen1(objbean22);
              numpregunta++;
              cont++;
            }
            int numpregunta1=cod;
            int conta=1;
            notaprof obj128=new notaprof();
            objres1=new RespuestasProf();
            objres2=new RespuestasProf();
            int codrespuesta=Integer.parseInt(request.getParameter("txtrespuesta"));
            int codnota=Integer.parseInt(nota);
            for(int i=1;i<=cantidad;i++){
              obj128.setCodnota(codnota);
              objres.setCodrepuestaprof(codrespuesta);
              objres.setCodnumpregunta(numpregunta1);
              
              String res1=request.getParameter("res1("+conta+")");
              String pun1=request.getParameter("punt1("+conta+")");
              obj128.setPuntaje(Double.parseDouble(pun1));
              obj128.setCodpregunta(codrespuesta);
              objres.setRespuesta(res1);
                      //JOptionPane.showMessageDialog(null, ""+obj128.getCodnota()+"\n"+obj128.getCodpregunta()+"\n"+obj128.getPuntaje());
                      //JOptionPane.showMessageDialog(null, ""+objres.getRespuesta()+"\n"+objres.getCodnumpregunta()); 
              objdao.GrabarRespuestaProf(objres);
              objdao.GrabarNotaProf(obj128);
              
              
              codrespuesta++;
              codnota++;
              numpregunta1++;
              conta++;
                 //JOptionPane.showMessageDialog(null, ""+obj128.getCodnota()+"\n"+obj128.getCodpregunta()+"\n"+obj128.getPuntaje());
              
            }
            int numpregunta2=cod;
            int conta2=1;
            for(int i=1;i<=cantidad;i++){
              objres.setCodrepuestaprof(codrespuesta);
              objres.setCodnumpregunta(numpregunta2);
              obj128.setCodnota(codnota);
              String res1=request.getParameter("res2("+conta2+")");
              String pun1=request.getParameter("punt2("+conta2+")");
              obj128.setPuntaje(Double.parseDouble(pun1));
              obj128.setCodpregunta(codrespuesta);
              objres.setRespuesta(res1);
              objdao.GrabarRespuestaProf(objres);
              objdao.GrabarNotaProf(obj128);
              
              
              codrespuesta++;
              codnota++;
              numpregunta2++;
              
              conta2++;
                 // JOptionPane.showMessageDialog(null, ""+obj128.getCodnota()+"\n"+obj128.getCodpregunta()+"\n"+obj128.getPuntaje());
            }
            int conta3=1;
            int numpregunta3=cod;
            for(int i=1;i<=cantidad;i++){
              objres.setCodrepuestaprof(codrespuesta);
              objres.setCodnumpregunta(numpregunta3);
              obj128.setCodnota(codnota);     
              String res1=request.getParameter("res3("+conta3+")");
              String pun1=request.getParameter("punt3("+conta3+")");
              obj128.setPuntaje(Double.parseDouble(pun1));
              obj128.setCodpregunta(codrespuesta);
              objres.setRespuesta(res1);
              objdao.GrabarRespuestaProf(objres);
              objdao.GrabarNotaProf(obj128);
              
              
              codrespuesta++;
              codnota++;
              numpregunta3++;
              conta3++;
                  //JOptionPane.showMessageDialog(null, ""+obj128.getCodnota()+"\n"+obj128.getCodpregunta()+"\n"+obj128.getPuntaje());
            }
            
            
            if(ii == 1){
              request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
            }else{
              request.setAttribute("mensaje","Registro No Insertado");    
            }           
            request.setAttribute("obj", objprofbean);
            
            pagina="/Mantenimiento/Profesor/Examen/GrabarExamen.jsp";
            break;
          }
          case 9:{
            obj=new NotaBean1();
            double notaxexamen=0;
            objnotadao=new NotaDAO();
            int ii=0;
            int codalum=0;
            int codnota=Integer.parseInt(request.getParameter("codnota"));
            int codexamprincipal=Integer.parseInt(request.getParameter("codexamprin"));
            int codexamres=Integer.parseInt(request.getParameter("codexamres"));
            int cant=Integer.parseInt(request.getParameter("txtcant"));
            int codprof=Integer.parseInt(request.getParameter("txtcodprofesor"));
            int cont=1;
            int a=0;
            for(int i=0;i<cant;i++){
             obj.setCodnota(codnota);
             int codpreg=Integer.parseInt(request.getParameter("pre"+cont));
             obj.setCodpre(codpreg);
             int codalumno=Integer.parseInt(request.getParameter("alumno"+cont));
             codalum=codalumno;
             obj.setCodalumno(codalumno);
             double nota=Double.parseDouble(request.getParameter("nota"+cont));
             notaxexamen=notaxexamen+nota;
             obj.setPuntaje(nota);
             ii=objnotadao.GrabarNota1(obj);
             codnota++;
             cont++;
           }
           
           notaxexamenbean ob333=new notaxexamenbean();
           int codnotaxexamen=0;
           if(objnotadao.GenerarCodigoexamen()==0){
             codnotaxexamen=objnotadao.GenerarCodigoexamen()+1;
           }else{
            codnotaxexamen=objnotadao.GenerarCodigoexamen();
          }
          ob333.setCodexamen(codnotaxexamen);
          
          
                 //ob333.setCodalumno(codalum);
          ob333.setPuntaje(notaxexamen); 
              //ob333.setCodprof(codprof);
          ob333.setCodexamenprincipal(codexamprincipal);
          ob333.setCodexamenres(codexamres);
          a= objnotadao.GrabarNotaExamen(ob333);
          if(ii == 1 && a==1){
            request.setAttribute("mensaje","Registro Insertado Satisfactoriamente ");
          }else{
            request.setAttribute("mensaje","Registro No Insertado");    
          }       
          
          
          objprofbean=new ProfesorBean();
          
          objprofbean.setCodigoprofesor(codprof);
          request.setAttribute("codprof", objprofbean); 
          
          objresdao=new ExamenResueltoDAO();
          Lista=objresdao.ListarExamenResueltosProfesor1(objprofbean);
          request.setAttribute("cargar", Lista);
          
          
          pagina="/Mantenimiento/Profesor/RevisionExamenes/MostrarExamenRevisar.jsp";
          break;
        }
            //json
        case 10:{
         objdao=new ExamenDAO();
         objprofbean=new ProfesorBean();
         int cod=Integer.parseInt(request.getParameter("cod"));
         objprofbean.setCodigoprofesor(cod);
         request.setAttribute("codprof", objprofbean); 
         Lista=objdao.ListarExamenProfesor11(objprofbean);
         PrintWriter out = response.getWriter();
         json=new StringBuilder();
         
         json.append("{\"examen\":[");
         for(int i=0;i<Lista.size();i++)
         {
           ExamenBean1  obj1=(ExamenBean1) Lista.get(i);
           if(i==Lista.size())
           {  
             json.append("{\"codexamen\":\""+obj1.getCodexamen()+"\",\"nombexamen\":\""+obj1.getNombreexamen()+"\",\"profesor_idporfesor\":\""+obj1.getCodprofesor()+"\"}");   
           }
           else{
             json.append("{\"codexamen\":\""+obj1.getCodexamen()+"\",\"nombexamen\":\""+obj1.getNombreexamen()+"\",\"profesor_idporfesor\":\""+obj1.getCodprofesor()+"\"},");   
           }
         }
         
         json.append("]}");
         out.print(json.toString());
         break;
       }
       case 11:{
        
        objresdao=new ExamenResueltoDAO();
        
        objprofbean=new ProfesorBean();
        int cod=Integer.parseInt(request.getParameter("cod"));
        
        objprofbean.setCodigoprofesor(cod);
        request.setAttribute("codprof", objprofbean); 
        Lista=objresdao.ListarExamenResueltosProfesor1(objprofbean);
        PrintWriter out = response.getWriter();
        json=new StringBuilder();

        json.append("{\"examenrevisar\":[");
        for(int i=0;i<Lista.size();i++)
        {
          ExamenReseultoBean1  obj1=(ExamenReseultoBean1) Lista.get(i);
          if(i==Lista.size())
          {  
           json.append("{\"codexamen\":\""+obj1.getCodexamen()+"\",\"nombexamen\":\""+obj1.getNombreexamen()+"\",\"nombalumno\":\""+obj1.getNombrealumno()+"\",\"codalumno\":\""+obj1.getCodalumno()+"\"}");   
         }
         else{
           json.append("{\"codexamen\":\""+obj1.getCodexamen()+"\",\"nombexamen\":\""+obj1.getNombreexamen()+"\",\"nombalumno\":\""+obj1.getNombrealumno()+"\",\"codalumno\":\""+obj1.getCodalumno()+"\"},");   
         }
       }
       
       json.append("]}");
       out.print(json.toString());
       break;
     }
     case 12:{
      objprofbean=new ProfesorBean();
      objprofdao=new ProfesorDAO();
      int cod=Integer.parseInt(request.getParameter("cod"));
      objprofbean.setCodigoprofesor(cod);
      Lista=objprofdao.ListarExamenProfesor(objprofbean);
      PrintWriter out = response.getWriter();
      json=new StringBuilder();
      
      json.append("{\"notasalumno\":[");
      

      for(int i=0;i<Lista.size();i++)
      {
        notaxexamenbean  obj1=(notaxexamenbean)Lista.get(i);
        if(i==Lista.size())
        {  
         json.append("{\"codexamen\":\""+obj1.getCodexamen()+"\",\"puntaje\":\""+obj1.getPuntaje()+"\",\"profesor_idporfesor\":\""+obj1.getCodprof()+"\",\"codalumno\":\""+obj1.getCodalumno()+"\",\"nombalumno\":\""+obj1.getNombrealumno()+"\"}");   
       }
       else{
         json.append("{\"codexamen\":\""+obj1.getCodexamen()+"\",\"puntaje\":\""+obj1.getPuntaje()+"\",\"profesor_idporfesor\":\""+obj1.getCodprof()+"\",\"codalumno\":\""+obj1.getCodalumno()+"\",\"nombalumno\":\""+obj1.getNombrealumno()+"\"},");   
       }
     }
     
     json.append("]}");
     out.print(json.toString());
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
