
package SERVLET;

import BEAN.AdministradorBean;
import BEAN.AlumnoBean;
import DAO.AlumnoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Autonoma
 */
public class AlumnoServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String opcad=request.getParameter("op");
        int op=Integer.parseInt(opcad);
        String pagina="";
        AlumnoBean obj=null;
        AlumnoDAO objDAO = null;
        ArrayList ListaAlumno = null;
        AdministradorBean objadminbvean=null;
        switch(op)
        {
            case 1:{
                objDAO=new AlumnoDAO();
                int Codigoadmin=Integer.parseInt(request.getParameter("cod"));
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                ListaAlumno=objDAO.ListarAlumno();
                request.setAttribute("carga", ListaAlumno);
                request.setAttribute("codadmin", objadminbvean);

                pagina = "/Mantenimiento/Administrador/MantenimientoAlumno/MostrarAlumno.jsp";
                break;
            }
            
            case 2:{
                int Codigoadmin=Integer.parseInt(request.getParameter("codadmin"));
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                pagina = "/Mantenimiento/Administrador/MantenimientoAlumno/NuevoAlumno.jsp";
                break;
            }
            
            case 3:{
                obj=new AlumnoBean();
                objDAO=new AlumnoDAO();
                int Codigoadmin=Integer.parseInt(request.getParameter("txtcodadmin"));
                int Codigo=Integer.parseInt(request.getParameter("txtcod"));
                String Nombre=request.getParameter("txtnombre");
                String Usuario=request.getParameter("txtusuario");
                String Clave=request.getParameter("txtclave");
                obj.setCodalumno(Codigo);
                obj.setNomalumno(Nombre);
                obj.setIdalumno(Usuario);
                obj.setContraalumno(Clave);
                obj.setCodadmin(Codigoadmin);
                int i=objDAO.GrabarAlumno(obj);
                if(i == 1){
                    request.setAttribute("mensaje","Registro Insertado Satisfactoriamente");
                }else{
                    request.setAttribute("mensaje","Registro No Insertado");    
                }               
                
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                pagina = "/Mantenimiento/Administrador/MantenimientoAlumno/NuevoAlumno.jsp";                
                break;
            }
            
            case 4:
            {
                objDAO=new AlumnoDAO();
                obj=new AlumnoBean();
                String codcad=request.getParameter("cod");
                int Codigoadmin=Integer.parseInt(request.getParameter("codadmin"));
                int cod=Integer.parseInt(codcad);
                obj.setCodalumno(cod);
                obj=objDAO.CapturarAlumno(obj);
                request.setAttribute("Actualizar",obj);
                
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(Codigoadmin);
                request.setAttribute("codadmin", objadminbvean);
                
                pagina="/Mantenimiento/Administrador/MantenimientoAlumno/ModificarAlumno.jsp";
                
                break;
                
            }
            
            case 6:{
                obj=new AlumnoBean();
                objDAO=new AlumnoDAO();
                int codigoadmin=Integer.parseInt(request.getParameter("codadmin"));
                int codigo=Integer.parseInt(request.getParameter("cod"));
                obj.setCodalumno(codigo);
                int i=objDAO.eliminarUsuario(obj);
                objadminbvean=new AdministradorBean();
                objadminbvean.setCodadmin(codigoadmin);
                ListaAlumno=objDAO.ListarAlumno();
                request.setAttribute("codadmin", objadminbvean);
                if(i == 1){
                    request.setAttribute("mensaje","Registro Eliminado Satisfactoriamente");
                }else{
                    request.setAttribute("mensaje","Registro No Eliminado");
                }
                ListaAlumno=objDAO.ListarAlumno();
                request.setAttribute("carga", ListaAlumno);
                pagina = "/Mantenimiento/Administrador/MantenimientoAlumno/MostrarAlumno.jsp";
                break;
            }
            case 7:{
                obj=new AlumnoBean();
                objDAO=new AlumnoDAO();
                int Codigoadmin=Integer.parseInt(request.getParameter("txtcodadmin"));
                int Codigo=Integer.parseInt(request.getParameter("txtcod"));
                String Nombre=request.getParameter("txtnombre");
                String Usuario=request.getParameter("txtusuario");
                String Clave=request.getParameter("txtclave");
                obj.setCodalumno(Codigo);
                obj.setNomalumno(Nombre);
                obj.setIdalumno(Usuario);
                obj.setContraalumno(Clave);
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
                ListaAlumno=objDAO.ListarAlumno();
                request.setAttribute("carga", ListaAlumno);
                pagina = "/Mantenimiento/Administrador/MantenimientoAlumno/MostrarAlumno.jsp";
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
