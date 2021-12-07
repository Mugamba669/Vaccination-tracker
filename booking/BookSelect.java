/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author DELL
 */
public class BookSelect extends SimpleTagSupport {

    private String table;
    private String where;
    private String displayFormat;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            try{
            Class.forName("com.mysql.jdbc.Driver");
             try{
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
          Statement state = conn.createStatement();
 
         ResultSet set =  state.executeQuery("select * from "+ table +"");
 out.println("<div class='card card-profile col-lg-9'");
out.println("<div class=\"card-header  z-index-2\">\n" +
"              <div class=\"bg-gradient-primary shadow-primary border-radius-md pt-4 pb-3\">\n" +
"                <h6 class=\"text-white text-center text-capitalize ps-3\">Health Centers Available</h6>\n" +
"              </div>\n" +
"            </div>"
 + "<div class='card-body'>"
 + "<div class='table-responsive'>");

       out.println("<table class='table align-items-center mb-0'>");
     out.print("<tr>");
     out.println("<th>HealthCenter</th>"
               + "<th>Total Vaccine</th>"
               + "<th>Total Patients</th>"
                + "<th>Available Vaccine");
     out.println("</tr>");
            while(set.next()){
            out.println("<tr>"
             + "<td>"+set.getString("name")+"</td>"
             + "<td>"+set.getString("totalVaccine")+"</td>"
             + "<td>"+set.getString("totalPatients")+"</td>"
              + "<td>"+set.getString("availableVaccines")+"</td>"
             + "</tr>");
            }
out.println("</table>"
 + "</div>"
 + "</div>"
 + "</div>");
        
         }catch(SQLException ex){
               out.println("Error: "+ex.getMessage());
           }
    
        }catch(ClassNotFoundException ex){
            out.println("Error:"+ex.getMessage());
        }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in BookSelect tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }
    
}
