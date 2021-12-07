/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PatientCertificate extends SimpleTagSupport {

    private String table;
    private String displayFormat;
    private String where;

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
       
          ResultSet set = state.executeQuery("select * from "+ table +" where name= '"+where+"'");
             while(set.next()){
            out.println("<tr>"
              /***nin,name,dateOfVaccination,vaccine,batch,healthCenter,status***/
             + "<td>"+set.getString("name")+"</td>"
             + "<td>"+set.getString("nin")+"</td>"
             + "<td>"+set.getString("dateOfVaccination")+"</td>"
              + "<td>"+set.getString("vaccine")+"</td>"
             + "</tr>");
            }   
         }catch(SQLException ex){
               out.println("Error: "+ex.getMessage());
           }
    
        }catch(ClassNotFoundException ex){
           out.println("Error: "+ex.getMessage());
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
            throw new JspException("Error in PatientCertificate tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setDisplayFormat(String displayFormat) {
        this.displayFormat = displayFormat;
    }

    public void setWhere(String where) {
        this.where = where;
    }
    
}
