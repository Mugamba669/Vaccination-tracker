<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="../assets/img/favicon.png">
  <title>
    Material Dashboard 2 by Creative Tim
  </title>
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  <!-- Nucleo Icons -->
  <link href="../assets/css/nucleo-icons.css" rel="stylesheet" />
  <link href="../assets/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- Material Icons -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
  <!-- CSS Files -->
  <link id="pagestyle" href="../assets/css/material-dashboard.css?v=3.0.0" rel="stylesheet" />
</head>

<body class="g-sidenav-show  bg-gray-200">
  <aside class="sidenav navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-3   bg-gradient-dark" id="sidenav-main">
    <div class="sidenav-header">
      <i class="fas fa-times p-3 cursor-pointer text-white opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
      <a class="navbar-brand m-0" href="#">
        <span class="ms-1 font-weight-bold text-white">Vaccination Tracker</span>
      </a>
    </div>
    <hr class="horizontal light mt-0 mb-2">
    <div class="collapse navbar-collapse  w-auto  max-height-vh-100" id="sidenav-collapse-main">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link text-white" href="../pages/dashboard.jsp">
            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
              <i class="material-icons opacity-10">dashboard</i>
            </div>
            <span class="nav-link-text ms-1">Dashboard</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white " href="../pages/patients.jsp">
            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
              <i class="material-icons opacity-10">table_view</i>
            </div>
            <span class="nav-link-text ms-1">RegisterPatients</span>
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link active text-white bg-gradient-primary" href="../pages/healthcenter.jsp">
            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
              <i class="material-icons opacity-10">receipt_long</i>
            </div>
            <span class="nav-link-text ms-1">Register Health Centers</span>
          </a>
        </li>
   
        <li class="nav-item">
          <a class="nav-link text-white " href="../pages/vaccine.jsp">
            <div class="text-white text-center me-2 d-flex align-items-center justify-content-center">
              <i class="material-icons opacity-10">receipt_long</i>
            </div>
            <span class="nav-link-text ms-1">Register Vaccines</span>
          </a>
        </li>
       
      </ul>
    </div>
  </aside>
  <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg ">
    <!-- Navbar -->
    <nav class="navbar navbar-main navbar-expand-lg px-0 mx-4 shadow-none border-radius-xl" id="navbarBlur" navbar-scroll="true">
      <div class="container-fluid py-1 px-3">
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Pages</a></li>
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">HealthCenters</li>
          </ol>
          <h6 class="font-weight-bolder mb-0">Health Centers</h6>
        </nav>
      </div>
    </nav>
    <!-- End Navbar -->
       <form action="/Vaccination/PatientServlet" method="post" class="text-start row">
      <div class="col-xl-4 col-lg-5 col-md-7">
              <div class="card card-plain">
                  
                <div class="card-body">
                 
                    <div class="input-group input-group-outline mb-3">
                      <input type="text" placeholder="Enter patient's name" class="form-control" name="name"/>
                    </div>
                      
                    <div class="input-group input-group-outline mb-3">
                      <input type="text" placeholder="Enter patient's nin" class="form-control"name="nin"/>
                    </div>
                      
                      
                     <div class="input-group input-group-outline mb-3">
                      <!--<label class="form-label">Date of Vaccination</label>-->
                      <input type="date" placeholder="Enter patient's date of vaccination" class="form-control"name="date"/>
                    </div>
                  
                          
                     <div class="input-group input-group-outline mb-3">
                      <!--<label class="form-label">Health Center</label>-->
                      <input type="text"placeholder="Enter health center" class="form-control"name="healthcenter"/>
                    </div>       
                    <div class="text-center">
                      <input type="submit" class="btn btn-lg bg-gradient-primary btn-lg w-100 mt-4 mb-0"value="Register Health Center"/>
                    </div>
                </div>
              </div>
      </div>
  </form>
  </main>
</body>

</html>