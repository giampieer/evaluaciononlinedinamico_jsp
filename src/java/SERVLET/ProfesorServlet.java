
package SERVLET;

import BEAN.AdministradorBean;
import BEAN.ProfesorBean;
import DAO.ExamenDAO;
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
 * @author Autonoma
 */
public class ProfesorServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String pagina="";
        ProfesorBean obj=null;
        ProfesorDAO objDAO = null;
        ArrayList ListaProfesor = null;
        AdministradorBean objadminbvean=null;
        switch(op)
        {
            case 1:{
                objDAO=new ProfesorDAO();
                int Codigoadmin=Integer.parseInt(request.getParameter("cod"));
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                ListaProfesor=objDAO.ListarProfesor();
                request.setAttribute("carga", ListaProfesor);
                request.setAttribute("codadmin", objadminbvean);

                pagina = "/Mantenimiento/Administrador/MatenimientoProfesor/MostrarProfesor.jsp";
                break;
            }
            
            case 2:{
                int Codigoadmin=Integer.parseInt(request.getParameter("codadmin"));
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                pagina = "/Mantenimiento/Administrador/MatenimientoProfesor/NuevoProfesor.jsp";
                break;
            }
            
            case 3:{
                obj=new ProfesorBean();
                objDAO=new ProfesorDAO();
                int Codigoadmin=Integer.parseInt(request.getParameter("txtcodadmin"));
                int Codigo=Integer.parseInt(request.getParameter("txtcod"));
                String Nombre=request.getParameter("txtnombre");
                String Usuario=request.getParameter("txtusuario");
                String Clave=request.getParameter("txtclave");
                obj.setCodigoprofesor(Codigo);
                obj.setNombprofesor(Nombre);
                obj.setIdprofesor(Usuario);
                obj.setContraprofesor(Clave);
                obj.setCodadmin(Codigoadmin);
                int i=objDAO.GrabarProfesor(obj);
                if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                }               
                
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                pagina = "/Mantenimiento/Administrador/MatenimientoProfesor/NuevoProfesor.jsp";                
                break;
            }
            
            case 4:
            {
                objDAO=new ProfesorDAO();
                obj=new ProfesorBean();
                String codcad=request.getParameter("cod");
                int Codigoadmin=Integer.parseInt(request.getParameter("codadmin"));
                int cod=Integer.parseInt(codcad);
                obj.setCodigoprofesor(cod);
                obj=objDAO.CapturarProfesor(obj);
                request.setAttribute("Actualizar",obj);
                
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                
                pagina="/Mantenimiento/Administrador/MatenimientoProfesor/ModificarProfesor.jsp";
                
                break;
                
            }
            
            case 6:{
                obj=new ProfesorBean();
                objDAO=new ProfesorDAO();
                int codigoadmin=Integer.parseInt(request.getParameter("codadmin"));
                int codigo=Integer.parseInt(request.getParameter("cod"));
                obj.setCodigoprofesor(codigo);
                int i=objDAO.eliminarUsuario(obj);
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(codigoadmin);
                ListaProfesor=objDAO.ListarProfesor();
                request.setAttribute("codadmin", objadminbvean);
                if(i == 1){
                    request.setAttribute("mensaje","Registro Eliminado Satisfactoriamente");
                }else{
                    request.setAttribute("mensaje","Registro No Eliminado");
                }
                ListaProfesor=objDAO.ListarProfesor();
                request.setAttribute("carga", ListaProfesor);
                pagina = "/Mantenimiento/Administrador/MatenimientoProfesor/MostrarProfesor.jsp";
                break;
            }
            case 7:{
                obj=new ProfesorBean();
                objDAO=new ProfesorDAO();
                int Codigoadmin=Integer.parseInt(request.getParameter("txtcodadmin"));
                int Codigo=Integer.parseInt(request.getParameter("txtcod"));
                String Nombre=request.getParameter("txtnombre");
                String Usuario=request.getParameter("txtusuario");
                String Clave=request.getParameter("txtclave");
                obj.setCodigoprofesor(Codigo);
                obj.setNombprofesor(Nombre);
                obj.setIdprofesor(Usuario);
                obj.setContraprofesor(Clave);
                obj.setCodadmin(Codigoadmin);
                int i=objDAO.ModificarUsuario(obj);
                if(i == 1){
                    request.setAttribute("mensaje","Registro Modificado Satisfactoriamente");
                }else{
                    request.setAttribute("mensaje","Registro No Modificado");    
                }               
                
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                ListaProfesor=objDAO.ListarProfesor();
                request.setAttribute("carga", ListaProfesor);
                pagina = "/Mantenimiento/Administrador/MatenimientoProfesor/MostrarProfesor.jsp";
                break;
            }
            case 8:{
               ExamenDAO objdao=new ExamenDAO();
               ProfesorDAO objprofdao=new ProfesorDAO();
               ProfesorBean objprofbean=new ProfesorBean();
               int cod=Integer.parseInt(request.getParameter("cod"));
               objprofbean.setCodigoprofesor(cod);
               
               ArrayList Lista=objdao.ListarExamenProfesor11(objprofbean);
               ArrayList Lista2=objprofdao.ListarExamenProfesor(objprofbean);
               request.setAttribute("cargar", Lista);
               request.setAttribute("cargar2", Lista2);
               pagina="/Seguridad/Profesor/carrusel2.jsp";
               
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
