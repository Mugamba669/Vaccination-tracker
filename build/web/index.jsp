<%-- 
    Document   : Patients
    Created on : Nov 29, 2021, 11:12:48 PM
    Author     : mugamba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to the vaccination track System</title>
        <link rel="stylesheet" type="text/css" href="./bootstrap.min.css"/>
        <style>
           body{
                margin: 0;
                padding: 0;
            }

            .welcome{
                display: flex;
                flex-direction:row;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 100%;
            }
            .welcome .ptr1{
                margin: 10px;
                padding: 10px;
                display: flex;
                width: 400px;
                background: #888;
                flex-direction:column;
                justify-content: center;
                align-items: center;
                
            }
            .welcome .ptr1 p{
                font:400 15px Ubuntu,Arial;
            }

            .welcome .ptr2{
                margin: 10px;
                padding: 10px;
                display: flex;
                flex-direction:column;
                justify-content: center;
                align-items: center;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
               
            <div class="col-md-9">
                <p>Welcome To Vaccination track System</p>
            </div>
            
            <div class="col-md-9">
                
                <button onclick="window.location='./register.jsp'">Register</button>  
                <button onclick="window.location='./Login.jsp'">Login</button>

<!--                <form action="/WEB-INF/Booking.jsp" method="post">
                    <input type="text" placeholder="Enter your name" name="name" autofocus/>    
                   <input type="text" placeholder="Add your email" name="email" autofocus/>
                   <input type="text" placeholder="Set your password" name="pass" autofocus/>
                   <input type="submit" value="Sign Up"/>
                </form>-->
              </div>
            </div>
        </div>
        <vaccination:Booking date="30/11/2021" time="9:55am"/>
        <!--b>The Vaccine type is jsp:getProperty name="zyx" property="type"/></b>-->
    </body>
</html>
