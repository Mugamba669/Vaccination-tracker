<%-- 
    Document   : register
    Created on : Dec 1, 2021, 8:58:03 PM
    Author     : mugamba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="vaccination" uri="/WEB-INF/tlds/Admins"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <form action="AdminServlet" method="post">
            <input type="text"name="name"placeholder="Fill your name"/>
            <input type="email" name="email" placeholder="provide your email"/>
            <input type="text" name="role" placeholder="Enter role"/> 
            <input type="password" name="passcode" placeholder="Enter password"/>

              <input type="submit" value="register"/>
        </form>
        
          <%
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String role = request.getParameter("role"); 
            String name = request.getParameter("name");

        %>
        
        
        
        <vaccination:insert table="admin" values="${name},${email},${pass},${role}"/>
    </body>
</html>
