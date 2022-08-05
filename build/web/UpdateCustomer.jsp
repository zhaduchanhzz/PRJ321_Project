<%-- 
    Document   : UpdateCustomer
    Created on : Mar 15, 2022, 2:43:44 PM
    Author     : zhadu
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="Context.DBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container-fluid mt-3 form-control" >
            <form action="UpdateAccount?action=basic" method="Post">
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
                    <label for="myRe-Password">Secret Question</label>
                    select class="form-control" name ="questindex">
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
                <div class="text-danger">${mess}</div>
                <button type="submit" class="btn btn-primary">Register</button>
            </form>

        </div>
    </div>
</body>
</html>
