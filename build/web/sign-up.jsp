<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
 <%@taglib prefix="vaccination" uri="/WEB-INF/tlds/Admins"%>

 <!DOCTYPE html>
<head>
  <link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./assets/img/favicon.png">
  <title>
   Create Account
  </title>
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  <!-- Nucleo Icons -->
  <link href="./assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="./assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- Material Icons -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
  <!-- CSS Files -->
  <link id="pagestyle" href="./assets/css/material-dashboard.css?v=3.0.0" rel="stylesheet" />
</head>

<body>
  <main class="main-content  mt-0">
    <section>
      <div class="page-header min-vh-100">
        <div class="container">
          <div class="row">
            <div class="col-6 d-lg-flex d-none h-100 my-auto pe-0 position-absolute top-0 start-0 text-center justify-content-center flex-column">
              <div class="position-relative bg-gradient-primary h-100 m-3 px-7 border-radius-lg d-flex flex-column justify-content-center" style="background-image: url('./assets/img/illustrations/illustration-signup.jpg'); background-size: cover;">
              </div>
            </div>
            <div class="col-xl-4 col-lg-5 col-md-7 d-flex flex-column ms-auto me-auto ms-lg-auto me-lg-5">
              <div class="card card-plain">
                <div class="card-header">
                  <h4 class="font-weight-bolder">Sign Up</h4>
                  <p class="mb-0">Enter your name, email, password and role to register</p>
                </div>
                <div class="card-body">
                    
                  <form action="AdminServlet" method="post">
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">Name</label>
                      <input type="text" class="form-control" name="name"/>
                    </div>
                      
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">Email</label>
                      <input type="email" class="form-control"name="email"/>
                    </div>
                      
                      <div class="input-group input-group-outline mb-3">
                      <label class="form-label">Role</label>
                      <input type="text" class="form-control" name="role"/>
                    </div>
                      
                    <div class="input-group input-group-outline mb-3">
                      <label class="form-label">Password</label>
                      <input type="password" class="form-control" name="passcode"/>
                    </div>
                    <div class="text-center">
                      <input type="submit" class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0"value="Sign Up"/>
                    </div>
                      
                  </form>
                   
                    <%
                        String name = request.getParameter("name"); 
                        String email = request.getParameter("email");
                        String role = request.getParameter("role");
                        String pass  = request.getParameter("password");
                     %>
   
                  <vaccination:insert table="admin" values="${name},${email},${pass},${role}" />
                </div>
                <div class="card-footer text-center pt-0 px-lg-2 px-1">
                  <p class="mb-2 text-sm mx-auto">
                    Already have an account?
                    <a href="./index.jsp" class="text-primary text-gradient font-weight-bold">Sign in</a>
                  </p>
                </div>
                  
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
                   
</body>

</html>

  