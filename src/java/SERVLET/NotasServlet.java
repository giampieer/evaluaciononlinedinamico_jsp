
package SERVLET;

import BEAN.ProfesorBean;
import DAO.ProfesorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Home
 */
public class NotasServlet extends HttpServlet {

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
     ProfesorBean objprofbean=null;
     ProfesorDAO objprofdao=null;
     ArrayList Lista=null;
     String pagina="";
     
     switch(op){
        case 1:{
            objprofbean=new ProfesorBean();
            objprofdao=new ProfesorDAO();
            int cod=Integer.parseInt(request.getParameter("cod"));
            objprofbean.setCodigoprofesor(cod);
            Lista=objprofdao.ListarExamenProfesor(objprofbean);
            
            request.setAttribute("cargar", Lista);
            pagina="/Mantenimiento/Alumno/NotasAlumnos/MostrarNotas.jsp";
            
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
