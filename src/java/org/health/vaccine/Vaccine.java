/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.vaccine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author mugamba
 */
public class Vaccine extends SimpleTagSupport {

    private String table;
    private String values;// gdgdgd,dhhd,ddhdd,dhdhdh
     private  String[] arr;
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
          arr = values.split(",");
          try{

            Class.forName("com.mysql.jdbc.Driver");
             try{
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaccination","root","");
//Statement stst = conn.createStatement();
 Statement state = conn.createStatement();
      /**id	name	totalVaccine****/
if(arr.length > 1){
     state.execute("insert into "+ table +"(name,totalVaccine)values('"+arr[0]+"','"+arr[1]+"');");
       
            out.print("<script type='text/javascript'>alert('"+arr[0]+" has been registered')</script>");
             out.print("<script type='text/javascript'>window.location = 'Home.jsp'</script>");
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
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Vaccine tag", ex);
        }
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setValues(String values) {
        this.values = values;
    }
    
}
