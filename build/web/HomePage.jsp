<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Shop</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>

        <link href="Css/Homepage.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <!-- menu -->
        <%@include file="navbar.jsp" %>
        <!-- end menu -->
        <!-- slide -->
        <div id="carouselExampleIndicators" class="carousel slide mt-1" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="img/5_1banner web 1425x528-op2.png" alt="First slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="img/sb_1582271534_11.jpg" alt="Second slide">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="img/banner-top-trang-chu-1-slide-19.jpg" alt="Third slide">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon " aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- end slide -->
        <!--end of menu-->

        <div class="container">
            <div class="row">
                <div class="col-sm-12" id="ctn2">
                    <div class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-center">
                        <nav class="nav-item " id="title1"> Categories</nav>
                        <ul class="navbar-nav">
                            <c:forEach items="${listC}" var="o">
                                <li class="nav-item ${tag == o.cid ? "active":""}"><a class="nav-link nav-link-dark" href="Category?cid=${o.cid}">${o.cname}</a></li>
                                </c:forEach>
                        </ul>
                        <c:if test="${sessionScope.acc.role == 1 }">
                            <nav class="card">
                                <a href="AddNewProduct" class="btn btn-dark">
                                    Add new product</a>
                            </nav>
                        </c:if>
                    </div>
                </div>
<!--                                <li class="nav-item  mx-3 ${tag == o.cid ? "active":""}"><a href="Category?cid=${o.cid}">${o.cname}</a></li>-->
                <div class="col-sm-12">
                    <div class="row">
                        <c:forEach items="${listP}" var="o">
                            <div class="col-12 col-md-6 col-lg-3">
                                <div class="card" style="margin-bottom: 20px;">
                                    <img class="card-img-top " src="${o.img}" alt="Card image cap" style="width:250px;height:300px;">
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="Detail?pid=${o.pid}" title="View Product">${o.pname}</a></h4>
                                        <p class="card-text show_txt">Price ${o.price} VND</p>
                                        <div class="card">
                                            <c:if test="${sessionScope.acc.role == 1 }">
                                                <div class="card">
                                                    <a href="DeleteProduct" class="btn btn-dark">
                                                        Delete</a>
                                                </div>
                                            </c:if>
                                            <div class="card">
                                                <a href="Detail?pid=${o.pid}" class="btn btn-dark">
                                                    Detail</a>
                                            </div>
                                            <c:if test="${o.quantity > 0}">
                                                <div class="card" >
                                                    <a href="CartControl?action=add&pid=${o.pid}" class="btn btn-dark">
                                                        <img src="img/unnamed.png" alt="" height="20vh"/></a>
                                                </div>
                                            </c:if>
                                            <c:if test="${o.quantity <= 0}">
                                                <div class="card" >
                                                    <a href="HomePage" class="btn btn-dark" style="color: red">
                                                        Het Hang</a>
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>


            </div>
            <nav aria-label="Search results pages">
                <ul class="pagination">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <c:forEach begin="1" end="${endpage}" var ="i">
                        <li class="page-item">
                            <a class="page-link" href="HomePage?page=${i}">${i}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
        <!-- Footer -->
        <footer id="footer" class="bg-light text-center text-lg-start">
            <!-- Grid container -->
            <div class="container p-4">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                        <h5 class="text-uppercase">KẾT NỐI VỚI CHÚNG TÔI</h5>

                        <p>
                            Địa chỉ: aaaaaaaaaaaaaaaa<br/>
                            Điện thoại: 0123 456 789<br/>
                        </p>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase">Links</h5>

                        <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#!" class="text-dark">1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark">2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark">3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark">4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                        <h5 class="text-uppercase mb-0">Links</h5>

                        <ul class="list-unstyled">
                            <li>
                                <a href="#!" class="text-dark">1</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark">2</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark">3</a>
                            </li>
                            <li>
                                <a href="#!" class="text-dark">4</a>
                            </li>
                        </ul>
                    </div>
                    <!--Grid column-->
                </div>
                <!--Grid row-->
            </div>
            <!-- Grid container -->

            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
                <a class="text-dark" href="#">Finish Ahihi</a>
            </div>
            <!-- Copyright -->
        </footer>
        <!-- Footer -->
        <!-- Load jquery trước khi load bootstrap js -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>

