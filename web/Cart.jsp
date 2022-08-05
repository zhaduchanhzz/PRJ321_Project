<%-- 
    Document   : Cart
    Created on : Mar 15, 2021, 5:03:53 PM
    Author     : Chien
--%>

<%@page import="Entity.DiscountCode"%>
<%@page import="DAO.CustomerDAO"%>
<%@page import="java.util.List"%>
<%@page import="Entity.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Css/Cart.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    </head>
    <body>
        <div class="container-fluid">
            <div>
                <a href="HomePage" class="back " style="font-size: 20px">
                    <img src="img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png" alt="" height="15px"/>
                    Back to Home
                </a>
            </div>
            <div class="row">
                <aside class="col-lg-9">
                    <div class="card">
                        <div class="table-responsive">
                            <table class="table table-borderless table-shopping-cart">
                                <thead class="text-muted">
                                    <tr class="small text-uppercase">
                                        <th scope="col">Product</th>
                                        <th scope="col" width="120">Quantity</th>
                                        <th scope="col" width="120">Price</th>
                                        <th scope="col" width="120">Seller</th>
                                        <th scope="col" width="120">Amount</th>
                                        <th scope="col" class="text-right d-none d-md-block" width="200"></th>
                                    </tr>
                                </thead>
                                <%
                                    double total = 0;
                                %>
                                <tbody>
                                    <c:forEach items="${sessionScope.listP}" var="o">
                                        <% Product item = (Product) pageContext.getAttribute("o");
                                            DAO.CustomerDAO dao = new CustomerDAO();
                                            String seller = dao.getCustomerName(item.getAddbycid());
                                            double amount = (item.getQuantity() * item.getPrice());
                                            total += amount;
                                        %>
                                        <tr>
                                            <td>
                                                <figure class="itemside align-items-center">
                                                    <div class="aside"><img src="${o.img}" class="img-sm"></div>
                                                    <figcaption class="info"> <a href="#" class="title text-dark" data-abc="true">${o.pname}</a>
                                                        <!--<p class="small text-muted">SIZE:M <br> Brand: Cantabil</p>-->
                                                    </figcaption>
                                                </figure>
                                            </td>
                                            <td > <button><a href="./CartControl?action=decrese&idd=${o.pid}">-</a></button>
                                                ${o.quantity}
                                                <button><a href="./CartControl?action=increse&idd=${o.pid}">+</a></button></td>

                                            <td>
                                                <div class="price-wrap"> <var id="price" class="price">${o.price}</var> <small class="text-muted"> $VND</small> </div>
                                            </td>

                                            <td>
                                                <div class="price-wrap"> <var class="price"><%=seller%></var> <small class="text-muted"> </small> </div>
                                            </td>
                                            <td>
                                                <div class="price-wrap"> <var class="price"><%=amount%></var> <small class="text-muted"> </small> </div>
                                            </td>
                                            <td class="text-right d-none d-md-block"> <a data-original-title="Save to Wishlist" title="" href="" class="btn btn-light" data-toggle="tooltip" data-abc="true"> <i class="fa fa-heart"></i></a> <a href="CartControl?action=remove&pid=${o.pid}" class="btn btn-light btn-round" data-abc="true"> Remove</a> </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </aside>
                <style>
                    input.larger {
                        width: 25px;
                        height: 25px;
                    }
                </style>
                <aside class="col-lg-3">
                    <div class="text-danger">${message}</div>

                    <c:if test="${sessionScope.discountcode == null}">
                        <div class="card">
                            <div class="card-body">
                                <form action="CartControl?action=discount"method="post">
                                    <dl class="dlist-align">
                                        <dt>Have discount code?</dt> &nbsp;&nbsp;
                                        <input type="checkbox" class="larger" name="chkdiscount"><br>
                                    </dl>
                                    <input type="text" name="discountcode"><br>
                                    <input type="submit" value="Use Discount code">
                                </form>

                                <dl class="dlist-align">
                                    <dt>Total: <%=total%></dt> 
                                    <dd class="text-right text-dark b ml-3"><strong>VND</strong></dd>
                                </dl>
                                <hr> <a href="CartControl?action=checkout" class="btn btn-out btn-primary btn-square btn-main" data-abc="true"> Check Out </a>
                                <a href="HomePage" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true">Continue Shopping</a>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.discountcode != null}">
                        <div class="card">
                            <div class="card-body">
                                <form action="CartControl?action=discount"method="post">
                                    <dl class="dlist-align">
                                        <dt>Have discount code?</dt> &nbsp;&nbsp;
                                        <input type="checkbox" class="larger" name="chkdiscount" checked=""><br>
                                    </dl>
                                    <input type="text" name="discountcode" value="${discountcode.content}"><br>
                                </form>

                                <dl class="dlist-align">
                                    <%
                                        DiscountCode dis = (DiscountCode) session.getAttribute("discountcode");
                                        if (dis != null) {
                                            total = total - (total * dis.getPercent() / 100);
                                        }
                                    %>
                                    <dt>Total after discount : <%=total%></dt> 
                                    <dd class="text-right text-dark b ml-3"><strong>VND</strong></dd>
                                </dl>
                                 <a href="CartControl?action=checkout" class="btn btn-out btn-primary btn-square btn-main" data-abc="true"> Check Out </a>
                                <a href="HomePage" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true">Continue Shopping</a>
                            </div>
                        </div>
                    </c:if>


                    <%
                        session.setAttribute("total", total);
                    %>
                </aside>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    </body>
</html>
