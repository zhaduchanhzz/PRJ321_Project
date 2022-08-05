<%-- 
    Document   : ManageAccount
    Created on : Mar 9, 2021, 2:31:34 AM
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

            <form action="ManageAccount" method="post" class="d-inline" style="margin-left: 500px">
                <div class="m-2">
                    <a href="HomePage" class="back"><img src="img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png" alt="" height="12px"/>
                        Back to Home</a>
                </div>
                <div class="text-danger">${mess1}</div>
                <div class="form-group col-sm-3">
                    <input type="text" class="form-control "
                           id="myName" placeholder="Name" name="name">
                </div>
                <div class="text-danger">${mess2}</div>
                <div class="form-group col-sm-3">
                    <label for="myUserName">UserName</label >
                    <input type="text" class="form-control "
                           id="myUserName" placeholder="UserName" name="user" required>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myPassword">Password</label>
                    <input type="password" class="form-control"
                           id="myPassword" placeholder="Password" name="password" required>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Phone</label>
                    <input type="text" class="form-control"
                           id="myRe-Password" placeholder="Phone number" name="cphone" required>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">AddRess</label>
                    <input type="text" class="form-control"
                           id="myRe-Password" placeholder="Address" name="caddress" required>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Level 2 Password</label>
                    <input type="text" class="form-control"
                           id="myRe-Password" placeholder="Level 2 Password " name="pass2" required>

                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Secret Question</label>
                    <select class="form-control" name ="questindex">
                        <option value="1">Ngày Sinh của người yêu bạn là gì ?</option>
                        <option value="2">Biển số xe của bạn là gì?</option>
                        <option value="3">Tên Trường tiểu học của bạn là gì?</option>
                        <option value="4">Một ngày đặc biệt của bạn?</option>
                        <option value="5">Câu nói mà bạn tâm đắc nhất ?</option>
                    </select>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Answer</label>
                    <input type="text" class="form-control"
                           id="myRe-Password" placeholder="Answer " name="answer" required>

                </div>
                <div class="text-danger">${mess3}</div>
                <button type="submit" class="btn btn-dark ml-3">Add new Account</button>
            </form>

            <div class="table-responsive-sm mt-2">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>User ID</th>
                            <th>Name</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Username</th>
                            <th>Password</th>
                            <th>Status</th>
                            <th>Role</th>
                            <th>Questindex</th>
                            <th>Answer</th>
                            <th>Pass2</th>
                            <th>email</th>
                            <th>Act</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listU}" var="o">
                            <tr>
                                <td>${o.id}</td>
                                <td>${o.cname}</td>
                                <td>${o.cphone}</td>
                                <td>${o.cAddress}</td>
                                <td>${o.username}</td>
                                <td>${o.password}</td>
                                <c:if test="${o.status == 0}">
                                    <td>Blocking</td>
                                </c:if>
                                <c:if test="${o.status == 1}">
                                    <td>Active</td>
                                </c:if>
                                <td>${o.role}</td>
                                <td>${o.questindex}</td>
                                <td>${o.answer}</td>
                                <td>${o.pass2}</td>


                                <td>${o.email}</td>
                                <td style="font-size: 20px">
                                    <c:if test="${o.id != sessionScope.acc.id}">

                                        <c:if test="${o.status == 0}">
                                            <a href="./ManageAccount?action=unblock&us=${o.username}" class="ml-3">Unblock</a>
                                        </c:if>
                                        <c:if test="${o.status == 1}">
                                            <a href="./ManageAccount?action=Block&us=${o.username}" class="ml-3">Block</a>
                                        </c:if>
                                    </c:if>
                                </td>

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

