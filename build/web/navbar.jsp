<%-- 
    Document   : navbar
    Created on : Mar 17, 2022, 12:45:57 PM
    Author     : zhadu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>

        <link href="Css/Homepage.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-dark" >
            <div class="container">
                <img src="img/shop-icon.png" alt="" height="50vh"/>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item  mx-3 col-lg-0">
                            <a class="nav-link text-white" href="HomePage">Home</a>
                        </li>
                        <li class="nav-item  mx-3 col-lg-0">
                            <a class="nav-link text-white" href="#footer">Contact Us</a>
                        </li>

                        <c:if test="${sessionScope.acc.role >= 2}">
                            <li class="nav-item mx-3 col-lg-0">
                                <a class="nav-link text-white" href="ManageAccount?action=listall">ManageAccount</a>
                            <li class="nav-item mx-3 col-lg-0">
                                <a class="nav-link text-white" href="ManageProduct?listall">ManageProduct</a>
                            </li>
                            </li> 
                        </c:if>
                        <c:if test="${sessionScope.acc.role == 1}">
                            <li class="nav-item mx-3 col-lg-0">
                                <a class="nav-link text-white" href="ManageProduct?action=listbyid&id=${sessionScope.acc.id}">ManageProduct</a>
                            </li> 
                        </c:if>
                        <c:if test="${sessionScope.acc == null}">
                            <li class="nav-item mx-3 col-lg-0">
                                <a class="nav-link text-white" href="Login.jsp">Login</a>
                            </li> 
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <li class="nav-item  mx-3 col-lg-0">
                                <a class="nav-link text-white" href="#">Hello ${sessionScope.acc.cname}</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.acc != null}">
                            <li class="nav-item mx-3 col-lg-0">
                                <a class="nav-link text-white" href="Logout">Logout</a>
                            </li> 
                        </c:if>

                    </ul>

                    <form method="post" action="Search" class="form-inline my-2 my-lg-0">
                        <input name="input" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        <select name="selects" class="btn-outline-success bg-dark ml-2" style="min-height: 37px; border-radius: 5px;">
                            <option value="pname">Name</option>
                            <option value="price">Price</option>
                        </select>
                    </form>
                    <form method="post" action="CartControl">
                        <button class="btn btn-outline-success my-2 my-sm-0 ml-2 bg-light" type="submit" ><img src="img/unnamed.png" alt="" height="15px"/>
                            Cart 0</button>
                    </form>
                </div>
            </div>
        </nav>
    </body>
</html>
