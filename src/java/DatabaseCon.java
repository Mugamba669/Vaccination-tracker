
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author mugamba
 */
public class DatabaseCon {
     private String url = "jdbc:mysql://localhost:3306/vacination";
     private String user = "root";
     private String pass =  "";
    private Statement sqlCode;
    
     DatabaseCon() throws SQLException, ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
        this.sqlCode = DriverManager.getConnection (this.url,this.user, this.pass).createStatement();
   }

   public void insertToVaccine(String[] values) throws SQLException{
      this.sqlCode.execute("insert into vaccine (name,totalVaccines)values('"+values[0]+"','"+values[1]+"'");
  }
/**  
id	nin	name	dateOfVaccination	vaccine	date	batch
     * @throws java.sql.SQLException	***/
 public void insertToPatients(String[] values) throws SQLException{
      this.sqlCode.execute("insert into patients (nin,name,DateOfAdmin,vaccine,batch,healthCenter)values('"+values[0]+"','"+values[1]+"'"+values[2]+"','"+values[3]+"'"+values[4]+"','"+values[5]+"'");
  }
public void insertToAdmin(String[] arr) throws SQLException{
      this.sqlCode.execute("insert into admin(name,email,password,role)values('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"');");
  }
public ResultSet adminLogin() throws SQLException{
     return  this.sqlCode.executeQuery("select email,password,role from admin");
 }
public void insertToHealthCenter(String[] arr) throws SQLException{
      this.sqlCode.execute("insert into healthCenter(name,totalVaccine,totalPatients)values('"+arr[0]+"','"+arr[1]+"','"+arr[2]+"','"+arr[3]+"');");
  }

public void insertToBooking(String[] values) throws SQLException{
      this.sqlCode.execute("insert into booking (name,email,healthCenter,vaccineName,place_of_preference,time)values('"+values[0]+"','"+values[1]+"'"+values[2]+"','"+values[3]+"'"+values[4]+"','"+values[5]+"'");

    }

}
