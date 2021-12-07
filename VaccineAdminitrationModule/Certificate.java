/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.health.administration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Certificate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                    String name = request.getParameter("name");  
                    String nin = request.getParameter("nin");
                    String healthcenter = request.getParameter("healthcenter");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Certificate</title>");
            out.println("  <link id=\"pagestyle\" href=\"./assets/css/material-dashboard.css?v=3.0.0\" rel=\"stylesheet\" />\n" +
"        <style>\n" +
"            body{\n" +
"                display:flex;\n" +
"                flex-direction: column;\n" +
"                justify-content:center;\n" +
"                align-items: center;\n" +
"            }\n"
 + "button{opacity:1;} button:hover{opacity:0;}" +
"         </style>");            
            out.println("</head>");
            out.println("<body>");

                displayCertificate(name,out);

            out.println("<button onclick='window.print();'>Print Now</button>");
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

   private void displayCertificate(String patient,PrintWriter out){
      try{
    Class.forName("com.mysql.jdbc.Driver");
       try{
       Connection con  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
     Statement state = con.createStatement();
   ResultSet set = state.executeQuery("select * from patients where name='"+patient+"';");
   out.println(" <div class=\"card w-60 card-profile\">\n" +
"            <div class=\"card-body\">\n" +
"        <div class=\"table-responsive\">\n");

 while(set.next()){
       out.println(

"        <table class='table align-items-center mb-0'>\n" +
"            <thead>\n" +
"                <tr>\n" +
"                    <th colspan=\"\">\n" +
"            <center>\n" +
"                <p class=\"text-2xl\"> Vaccination Certificate</p>\n" +
"                <br><!-- added logo -->\n" +
"                <img src=\"./assets/img/download.jpeg\" alt=\"courtofarms.jpeg\"/>\n" +
"            </center>\n" +
"                 </th>\n" +
"               </tr>\n" +
"            </thead>\n" +
"            <tbody>\n" +
"                 <tr>\n" +
"                    <td>Name</td>\n" +
"                    <td>"+set.getString("name")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                  <tr>\n" +
"                    <td>NIN</td>\n" +
"                    <td>"+set.getString("nin")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                  <tr>\n" +
"                    <td>Date</td>\n" +
"                    <td>"+set.getString("dateOfVaccination")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                  <tr>\n" +
"                    <td>Health center</td>\n" +
"                    <td>"+set.getString("healthCenter")+"</td>\n" +
"                 </tr>\n" +
"                  <tr>\n" +
"                    <td>Vaccine</td>\n" +
"                    <td>"+set.getString("vaccine")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                   <tr>\n" +
"                    <td>Batch</td>\n" +
"                    <td>"+set.getString("batch")+"</td>\n" +
"                 </tr>\n" +
"                 \n" +
"                   <tr>\n" +
"                    <td>Vaccination Status</td>\n" +
"                    <td>"+set.getString("status")+"</td>\n" +
"                 </tr>\n" +
"            </tbody>\n");   
   }
out.println("</table>\n" +
"     </div>   \n" +
"            \n" +
"       </div>\n" +
"  </div>");
}catch(SQLException ex){
   out.println("SQL Error:"+ex.getMessage());
}
   }catch(ClassNotFoundException ex){
    out.println("Error:"+ex.getMessage());
}
}

}
