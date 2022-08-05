<%-- 
    Document   : CheckOut
    Created on : Mar 15, 2022, 3:05:41 PM
    Author     : zhadu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>

        <form action="CartControl?action=checkoutconfim" method="post">
            <div class="text-danger">${mess}</div>
            <div class="form-group col-sm-3">
                <label for="myUserName">Name</label >
                <input type="text" class="form-control "
                       id="myUserName" placeholder="Full name" name="cname"  value ="${sessionScope.acc.cname}"   required>
            </div>

            <div class="form-group col-sm-3" >
                <label for="myRe-Password">Phone</label>
                <input type="text" class="form-control"
                       id="myRe-Password" placeholder="Phone number" name="cphone"value ="${sessionScope.acc.cphone}" required>
            </div>
            <div class="form-group col-sm-3" >
                <label for="myRe-Password">AddRess</label>
                <input type="text" class="form-control"
                       id="myRe-Password" placeholder="Address" name="caddress" value ="${sessionScope.acc.cAddress}" required>
            </div>
            <div class="form-group col-sm-3" >
                <label for="myRe-Password">ToTal</label>
                <input type="text" class="form-control"
                       id="myRe-Password" placeholder="Address" name="total" value ="${sessionScope.total}" readonly>
            </div>
            <input type ="submit" value="submit" name="submit">
        </form>
    </body>
</html>
