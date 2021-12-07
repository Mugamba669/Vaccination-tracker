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
public class BookingStatus extends SimpleTagSupport {

    private String table;

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
       
        ResultSet s = state.executeQuery("select * from "+ table +"");
        out.println(" <table class=\"table align-items-center mb-0\">\n" +
"                  <thead>\n" +
"                    <tr>\n" +
"                      <th class=\"text-uppercase text-secondary font-weight-bolder opacity-7\">Name</th>\n" +
"                      <th class=\"text-uppercase text-secondary text-1x font-weight-bolder opacity-7 ps-2\">Email</th>\n" +
"                      <th class=\"text-center text-uppercase text-secondary text-1x font-weight-bolder opacity-7\">HealthCenter</th>\n" +
"                      <th class=\"text-center text-uppercase text-secondary text-1x font-weight-bolder opacity-7\">VaccineName</th>\n"+
  " <th class=\"text-uppercase text-secondary text-1x font-weight-bolder opacity-7\">Time</th>\n"+
 " <th class=\"text-uppercase text-secondary text-1x font-weight-bolder opacity-7\">Date</th>\n"+
" </tr>\n" +" </thead><tbody>");
       while(s.next()){
        out.print("<tr>");
       out.println("<td class''>"+s.getString("name")+"</td>");  
        out.println("<td class''>"+s.getString("email")+"</td>");
       out.println("<td class''>"+s.getString("healthCenter")+"</td>");
       out.println("<td class''>"+s.getString("vaccineName")+"</td>");      
        out.println("<td class''>"+s.getString("time")+"</td>");
       out.println("<td class''>"+s.getString("date")+"</td>");
      out.println("</tr>");
           }
out.println("</tbody>");
//        out.print("<script type='text/javascript'>alert('Your booking session is recorded sucessfully')</script>");
//        out.print("<script type='text/javascript'>window.location = './pages/booking.jsp'</script>");
//
//        }
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
            throw new JspException("Error in BookingStatus tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }
    
}
