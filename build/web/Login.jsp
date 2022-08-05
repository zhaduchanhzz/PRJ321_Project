<%-- 
    Document   : login
    Created on : Feb 21, 2021, 12:11:20 AM
    Author     : Chien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <link href="Css/login.css" rel="stylesheet" type="text/css"/>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script> 
    </head>
    <body>

        <div class="container-fluid mt-3 form-control" style="form{display: block;}">

            <form action="LoginController" method="Post" class="d-inline">
                <div class="form-group col-sm-3">
                    <label for="myUserName">UserName</label>
                    <input type="text" class="form-control "
                           id="myUserName" placeholder="UserName" name="user">
                </div>
                <div class="form-group col-sm-3" >
                    <label for="myPassword">Password</label>
                    <input type="password" class="form-control"
                           id="myPassword" placeholder="Password" name="password">
                </div>
                <div class="text-danger">${mess}</div>
                <div class="g-recaptcha" data-sitekey="6LfzKBwdAAAAADPH1sh8A41d1QR0dyVTNtskva9h"
                     data-theme ="dark" data-size ="normal"
                     ></div>
                <button type="submit" class="btn btn-primary">Sign in</button>
            </form>

            <form action="Register.jsp" method="Post" class="d-inline">
                <button type="submit" class="btn btn-primary">Register</button>
            </form>
            <div>
                <a href="forget.jsp" class="back">/>
                    Forgot password?</a>
            </div>
            <div>
                <a href="HomePage" class="back"><img src="img/png-clipart-clockwise-arrow-rotation-circle-computer-icons-arrow-text-circular-thumbnail.png" alt="" height="12px"/>
                    Back to Home</a>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>