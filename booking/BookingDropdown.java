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
public class BookingDropdown extends SimpleTagSupport {

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
 
         ResultSet set =  state.executeQuery("select * from "+ table +"");
            while(set.next()){
            out.println("<option class='from-control' value='"+set.getString("name")+"'>"+set.getString("name")+"</option>");
            }
        
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
            throw new JspException("Error in BookingDropdown tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }
    
}
