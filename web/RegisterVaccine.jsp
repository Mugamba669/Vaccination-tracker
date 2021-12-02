<%-- 
    Document   : RegisterVaccine
    Created on : Dec 2, 2021, 3:32:46 AM
    Author     : mugamba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="vaccination" uri="/WEB-INF/tlds/Vaccine"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="VaccineServlet" method="post">
            <input type="text" placeholder="Vaccine name" name="name"/>     
            <input type="text" placeholder="Enter received vaccines" name="ttvaccine"/>
            <input type="submit" value="Register Vaccine"/>
        </form>
           <%
              String name =  request.getParameter("name");
              String ttvaccine =  request.getParameter("ttvaccine");
        %>
        
        
        
        <vaccination:insert table="vaccine" values="${name},${ttvaccine}"/>
    </body>
</html>
