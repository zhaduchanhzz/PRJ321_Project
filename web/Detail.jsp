<%-- 
    Document   : Detail
    Created on : Mar 9, 2021, 2:58:20 AM
    Author     : Chien
--%>
<%@page import="DAO.CustomerDAO"%>
<%@page import="Entity.Review"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <!--Important link from https://bootsnipp.com/snippets/XqvZr-->
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">
        <div class="pd-wrap">
            <link href="Css/details.css" rel="stylesheet" >
            <script src="Css/details..js"></script>
            <script>
                function myFunction(name) {
                    var x = document.getElementById(name);
                    x.checked = true;
                }
            </script>

            <c:forEach items="${details}" var="o">

                <div class="container">
                    <div class="heading-section">
                        <h2>${o.pname}</h2>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div id="slider" class="owl-carousel product-slider">
                                <div class="item">
                                    <img src="${o.img}" />
                                </div>

                            </div>
                            <div id="thumb" class="owl-carousel product-thumb">
                                <div class="item">
                                    <img src="${o.img}" />
                                </div>

                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="product-dtl">
                                <div class="product-info">
                                    <div class="product-name">${o.pname}</div>
                                    Averagevote : ${o.avgvote}
                                    <div class="product-price-discount"><span>PRICE : ${o.price}$</span><br><span class="product-price-discount">${o.quantity} Product left</span></div>
                                </div>
                                <h5>Description:</h5>
                                <p>${o.decs}</p>

                                <div class="product-count">
                                    <label for="size">Quantity</label>
                                    <form action="CartControl?action=add&pid=${o.pid}" method="post" class="display-flex">
                                        <div class="qtyminus">-</div>
                                        <input type="text" name="qty" value="1" class="qty">
                                        <div class="qtyplus">+</div>
                                        <input type="submit" value="Add to Cart" class="round-black-btn">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="product-info-tabs">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" id="description-tab" data-toggle="tab" href="#description" role="tab" aria-controls="description" aria-selected="true">Description</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="review-tab" data-toggle="tab" href="#review" role="tab" aria-controls="review" aria-selected="false">Reviews (0)</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="description" role="tabpanel" aria-labelledby="description-tab">
                                ${o.decs}
                            </div>
                            <div class="tab-pane fade" id="review" role="tabpanel" aria-labelledby="review-tab">
                                <c:if test="${listrv == null}">
                                    <div class="review-heading">REVIEWS</div>
                                    <p class="mb-20">There are no reviews yet.</p>
                                </c:if>
                                <ul>

                                    <c:forEach items="${listrv}" var="a">
                                        <% Review item = (Review) pageContext.getAttribute("a");
                                            DAO.CustomerDAO dao = new CustomerDAO();
                                            String seller = dao.getCustomerName(item.getCid());

                                        %>
                                        <li>User : &nbsp;&nbsp;&nbsp; <%=seller%>&nbsp;&nbsp;&nbsp; |
                                            &nbsp;&nbsp;&nbsp;Rating : ${a.grade} Star &nbsp;&nbsp;&nbsp;|
                                            &nbsp;&nbsp;&nbsp;Comment  : ${a.comment}&nbsp;&nbsp;&nbsp;|</li> 
                                        </tr>

                                    </c:forEach>
                                </ul>

                                <form class="review-form" action="Detail?action=addrv&pid=${o.pid}" method="post">
                                    <div class="form-group">
                                        <label>Your rating</label>
                                        <div class="reviews-counter">
                                            <div class="rate">
                                                <input type="radio" id="star5" name="rate" value="5"  />
                                                <label for="star5" title="text">5 stars</label>
                                                <input type="radio" id="star4" name="rate" value="4" />
                                                <label for="star4" title="text">4 stars</label>
                                                <input type="radio" id="star3" name="rate" value="3" />
                                                <label for="star3" title="text">3 stars</label>
                                                <input type="radio" id="star2" name="rate" value="2" />
                                                <label for="star2" title="text">2 stars</label>
                                                <input type="radio" id="star1" name="rate" value="1" />
                                                <label for="star1" title="text">1 star</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>Your message</label>
                                        <textarea class="form-control" name ="comment"rows="10"></textarea>
                                    </div>

                                    <input type="submit" value="Submit Review" class="round-black-btn">
                                </form>
                            </div>
                        </div>
                    </div>

                    <div style="text-align:center;font-size:14px;padding-bottom:20px;">Get free icon packs for your next project at <a href="http://iiicons.in/" target="_blank" style="color:#ff5e63;font-weight:bold;">www.iiicons.in</a></div>
                </div>
            </c:forEach>


        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="	sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
