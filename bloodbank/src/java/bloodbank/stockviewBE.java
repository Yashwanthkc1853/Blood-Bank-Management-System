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
import java.sql.ResultSet;
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
public class stockviewBE extends HttpServlet {

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
        String BG = request.getParameter("blood group");


        Connection con = dbconnection.getConnectTobloodbank();
        String sql = "SELECT * FROM stock WHERE Bgrup=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, BG);
      
        ResultSet rs = ps.executeQuery();

        // HTML content generation
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Flight Search Results</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; background-color: #f5f5f5; }");
        out.println("h1 { text-align: center; margin-top: 20px; color: #333; }");
        out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        out.println("th, td { padding: 8px; border: 1px solid #ddd; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
       
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Donor Search Results</h1>");
        out.println("<table>");
        out.println("<tr><th>Blood Group </th><th>Units Available</th></tr>");

        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getString(1) + "</td>");
            out.println("<td>" + rs.getLong(2) + "</td>");
           
            

            out.println("</tr>");
            out.println("<a href=\"admindashboard.html\">Back to Dashboard</a>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
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
            Logger.getLogger(stockviewBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stockviewBE.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(stockviewBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(stockviewBE.class.getName()).log(Level.SEVERE, null, ex);
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
