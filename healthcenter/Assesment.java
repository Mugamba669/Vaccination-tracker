/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.healthcenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.util.Date;
/**
 *
 * @author Angella Mulikatete
 */
public class Assesment extends SimpleTagSupport {

    private String table;
   private String referal;
Date d = new Date();
//d.
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
           out.print("<table border='2' class='table align-center'>"
 + "<tr>"
 + "<th>Health Center</th>"
 + "<th>Completed</th>"
 + "<th>Pending</th>"
 + "</tr>"
 + "<tr>");
out.println("<td>"+referal+"</td>");
        ResultSet d = state.executeQuery("select count(status) from patients where status ='complete' and healthCenter='"+referal+"'");
           d.next();
           out.println("<td>"+ d.getInt(1)+"</td>");
           d.close();
          ResultSet b = state.executeQuery("select count(status) from patients where status='incomplete' and healthCenter='"+referal+"'");
          b.next();
          out.println("<td>"+ b.getInt(1)+"</td>");
         b.close();
        out.println("</tr></table>");
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

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Assesment tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

  public void setReferal(String referal) {
        this.referal = referal;
    }
    
}
