/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank;

import DbConnection.dbconnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nithin S R
 */
public class UpdatedonorBE extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdatedonorBE</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet UpdatedonorBE at " + request.getContextPath() + "</h1>");
             long phone = Long.parseLong(request.getParameter("phone"));
            String donorName = request.getParameter("name");
            long donorid= Long.parseLong(request.getParameter("donor-id"));
            String dob = request.getParameter("date-of-birth");
            String donormail = request.getParameter("email");
            String dgroup = request.getParameter("blood group");
            String dcity= request.getParameter("city");
            String dgender = request.getParameter("gender");
            Connection con=dbconnection.getConnectTobloodbank();
              String sql = "UPDATE donor SET dname=?, demail=?, dob=?, dph=?, dbgrup=?, dcity=?, dgender=? WHERE did=?";


        
       PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, donorName);
         ps.setString(2, donormail);
          ps.setString(3, dob);
       
        ps.setLong(4, phone);
         ps.setString(5, dgroup);
          ps.setString(6, dcity);
           ps.setString(7, dgender);
           ps.setLong(8,donorid);
       
        int i = ps.executeUpdate();
        if (i > 0) {
          out.println("<script> alert(\"donor updated\") </script>");
          request.getRequestDispatcher("updatedonor.html").include(request, response);

        } else {
            out.println("<script> alert(\"enter correct donor id\")</script>");
            request.getRequestDispatcher("updatedonor.html").include(request, response);

        }
            out.println("</body>");
            out.println("</html>");
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatedonorBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatedonorBE.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatedonorBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatedonorBE.class.getName()).log(Level.SEVERE, null, ex);
        }
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
