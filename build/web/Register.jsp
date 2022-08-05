<%-- 
    Document   : Register
    Created on : Mar 4, 2021, 11:28:22 PM
    Author     : Chien
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Register</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script> 

    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <div class="container-fluid mt-3 form-control" >
            <form action="RegisterController" method="Post">
                <div class="text-danger">${mess1}</div>
                <div class="form-group col-sm-3">
                    <label for="myName">Full Name</label>
                    <input type="text" class="form-control "
                           id="myName" placeholder="Name" name="name" required>
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
                    <label for="myRe-Password">Re-Password</label>
                    <input type="password" class="form-control"
                           id="myRe-Password" placeholder="Re-Password" name="re-password" required>
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
                    <input type="password" class="form-control"
                           id="myRe-Password" placeholder="Level 2 Password " name="pass2" required>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Secret Question</label>

                    <select class="form-control" name ="questindex">
                        <%
                            DBContext dao = new DBContext();
                            ResultSet rs = dao.GetData("Select * from Quest");
                            while (rs.next()) {
                        %>


                        <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>

                        <%}
                        %>
                    </select>
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Answer</label>
                    <input type="text" class="form-control"
                           id="myRe-Password" placeholder="Answer " name="answer" required>

                </div>
                <div class="form-group col-sm-3" >
                    <label for="myRe-Password">Email</label>
                    <input type="text" class="form-control"
                           id="myRe-Password" placeholder="Email" name="email" required>
                </div>
                <div class="g-recaptcha" data-sitekey="6LfzKBwdAAAAADPH1sh8A41d1QR0dyVTNtskva9h"
                     data-theme ="dark" data-size ="normal"
                     ></div>
                <div class="text-danger">${mess3}</div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form>
            <div>
                <a href="Login.jsp" class="back"><img src="img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png" alt="" height="12px"/>
                    Back to Login</a>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
