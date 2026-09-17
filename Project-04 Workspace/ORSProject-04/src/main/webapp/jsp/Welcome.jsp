<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">

<title>Welcome Page</title>

<!-- Bootstrap Icons -->
<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>


<body>

    <%@ include file="Header.jsp"%>


    <!-- WELCOME BACKGROUND -->

    <div class="position-relative overflow-hidden bg-light"
         style="min-height: 80vh; padding-top: 70px; padding-bottom: 70px;">


        <!-- BACKGROUND ACADEMIC ICONS -->

        <i class="bi bi-book position-absolute text-primary"
           style="
           font-size: 130px;
           opacity: 0.06;
           top: 40px;
           left: 8%;">
        </i>


        <i class="bi bi-mortarboard-fill position-absolute text-primary"
           style="
           font-size: 160px;
           opacity: 0.06;
           top: 70px;
           right: 8%;">
        </i>


        <i class="bi bi-laptop position-absolute text-primary"
           style="
           font-size: 140px;
           opacity: 0.05;
           bottom: 40px;
           left: 10%;">
        </i>


        <i class="bi bi-journal-bookmark-fill position-absolute text-primary"
           style="
           font-size: 130px;
           opacity: 0.05;
           bottom: 50px;
           right: 10%;">
        </i>


        <!-- DECORATIVE CIRCLES -->

        <div class="position-absolute bg-primary rounded-circle"
             style="
             width: 200px;
             height: 200px;
             opacity: 0.04;
             top: 30px;
             left: 35%;">
        </div>


        <div class="position-absolute bg-info rounded-circle"
             style="
             width: 230px;
             height: 230px;
             opacity: 0.04;
             bottom: 20px;
             right: 35%;">
        </div>


        <!-- WELCOME CONTENT -->

        <div class="container position-relative">

            <div class="row justify-content-center">

                <div class="col-md-8">


                    <!-- WELCOME CARD -->

                    <div class="card shadow-lg border-0 text-center">


                        <!-- CARD HEADER -->

                        <div class="card-header bg-white py-4">

                            <i class="bi bi-mortarboard-fill text-primary"
                               style="font-size: 55px;">
                            </i>

                            <h1 class="text-primary mt-2 mb-0">
                                Welcome to ORS
                            </h1>

                        </div>


                        <!-- CARD BODY -->

                        <div class="card-body p-5">


                            <h2 class="fw-bold mb-3">

                                Hello Guest !
                                <%=isLogin ? "(" + userBean.getFirstName() + ")" : ""%>

                            </h2>


                            <p class="text-secondary">

                                Manage students, courses, subjects,
                                colleges, examinations and results
                                easily with ORS.

                            </p>


                            <!-- ICON FEATURES -->

                            <div class="row mt-4">


                                <div class="col-md-4 mb-3">

                                    <div class="p-3">

                                        <i class="bi bi-people-fill text-primary"
                                           style="font-size: 35px;">
                                        </i>

                                        <h6 class="fw-bold mt-2">
                                            Students
                                        </h6>

                                    </div>

                                </div>


                                <div class="col-md-4 mb-3">

                                    <div class="p-3">

                                        <i class="bi bi-book-half text-success"
                                           style="font-size: 35px;">
                                        </i>

                                        <h6 class="fw-bold mt-2">
                                            Courses
                                        </h6>

                                    </div>

                                </div>


                                <div class="col-md-4 mb-3">

                                    <div class="p-3">

                                        <i class="bi bi-bar-chart-fill text-warning"
                                           style="font-size: 35px;">
                                        </i>

                                        <h6 class="fw-bold mt-2">
                                            Results
                                        </h6>

                                    </div>

                                </div>


                            </div>


                            <!-- LOGIN MESSAGE -->

                            <% if (isLogin) { %>

                                <div class="alert alert-success mt-3" role="alert">

                                    <i class="bi bi-check-circle-fill"></i>

                                    You are successfully logged in.

                                </div>

                            <% } else { %>

                                <div class="alert alert-primary mt-3" role="alert">

                                    <i class="bi bi-info-circle-fill"></i>

                                    Please login to access ORS features.

                                </div>

                            <% } %>


                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>


    <%@ include file="Footer.jsp"%>

</body>

</html>