/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.healthcenter;

import java.io.IOException;
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
 * @author Angella Mulikatete
 */
public class HealthCenterStatus extends SimpleTagSupport {

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
         String[] results = new String[100];
         int index = 0;
         while(set.next()){
            out.println(" <div class=\"col-xl-3 col-sm-6 mb-xl-0 mb-4\">\n" +
"          <div class=\"card\">\n" +
"            <div class=\"card-header p-3 pt-2\">\n" +
"              <div class=\"icon icon-lg icon-shape bg-gradient-dark shadow-dark text-center border-radius-xl mt-n4 position-absolute\">\n" +
"                <i class=\"material-icons opacity-10\">weekend</i>\n" +
"              </div>\n" +
"              <div class=\"text-end pt-1\">\n" +
"                <p class=\"text-md mb-0 text-capitalize\">"+set.getString("name")+"</p>\n");
//                  printVaccinated(n,state,out);
              out.println("</div>\n" +
"            </div>\n" +
"            <hr class=\"dark horizontal my-0\">\n" +
"            <div class=\"card-footer p-3\">\n" +
"              <p class=\"mb-0\"><span class=\"text-success text-sm font-weight-bolder\">"+set.getString("totalVaccine")+" </span>vaccine available</p>\n" +
"            </div>\n" +
"          </div>\n" +
"        </div>");
            }

//        set.close();


           

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
            throw new JspException("Error in HealthCenterStatus tag", ex);
        }
    }
 private void printVaccinated(String referal,Statement state,JspWriter out) throws SQLException, IOException{
          ResultSet total =  state.executeQuery("select count(*) from patients where healthCenter='"+referal+"'");
//             while(total.next()){
              int vaccinate = total.getInt(1);
               out.println("<h5 class=\"mb-0\">"+vaccinate+" vaccinated</h5>\n");
//              }
//             total.close();
        
}
    public void setTable(String table) {
        this.table = table;
    }
    
}
