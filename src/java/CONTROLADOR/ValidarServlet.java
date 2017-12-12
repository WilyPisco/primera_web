/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import DATOS.ConexionDAO;
import DATOS.Usuario;
import DATOS.Error;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wily1
 */
@WebServlet(name = "validarServlet", urlPatterns = {"/validar.pis"})
public class ValidarServlet extends HttpServlet {

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
        ConexionDAO dao= new ConexionDAO();
        String mail,pass;
        mail=request.getParameter("txtEmail");
        pass=request.getParameter("txtPass");
        Usuario u= new Usuario(mail, pass);
        Usuario u2= dao.Existe(u);
        
        HttpSession session = request.getSession();
        if(u2.ExisteError()){
            List<Error> errores= u2.getErrores();
            session.setAttribute("errores", errores);
            request.getRequestDispatcher("Error.wil").forward(request, response);
        }
        else{
            session.setAttribute("usuario", u2);
            request.getRequestDispatcher("Menu.wil").forward(request, response);        
        }
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
