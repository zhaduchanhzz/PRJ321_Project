<%-- 
    Document   : ManageProduct
    Created on : Mar 9, 2021, 2:31:45 AM
    Author     : Chien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Manage Account</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="container-fluid">

            <div class="m-2">
                <a href="HomePage" class="back"><img src="img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png" alt="" height="12px"/>
                    Back to Home</a>
            </div>
            <div class="text-danger">${mess1}</div>

            <div class="text-danger">${mess2}</div>

            <div class="text-danger">${mess3}</div>
            <a href="./ManageProduct?action=add">Add new Product</a>

            <div class="table-responsive-sm mt-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>PID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Image</th>
                            <th>Description</th>
                            <th>Status</th>
                            <th>Cate ID</th>
                            <th>Add by C ID</th>
                            <th>AvgVote</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${managep}" var="o">
                            <tr>
                                <td>${o.pid}</td>
                                <td>${o.pname}</td>
                                <td>${o.quantity}</td>
                                <td>${o.price}</td>
                                <td><img src="${o.img}" alt="" </td>
                                <td>${o.decs}</td>
                                <td>${o.status}</td>
                                <td>${o.cateid}</td>
                                <td>${o.addbycid}</td>
                                <td>${o.avgvote}</td>
                                <td style="font-size: 20px"><a href="./ManageProduct?action=delete&pid=${o.pid}" class="ml-3">Delete</a><a href="./ManageProduct?action=update&pid=${o.pid}" class="ml-3">Update</a></td>
                            </tr>
                        </c:forEach>   

                    </tbody>
                </table>

            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
