<%-- 
    Document   : forget
    Created on : Mar 17, 2022, 1:38:02 AM
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

        <div class="text-danger">${mess}</div>

        <form action="forget" method="post">
            <input type="email" name="email" value="" Placeholder="Email"><br>
            <input type="username" name="username" value="" Placeholder="username"><br>
            <input type="submit" value="submit">



        </form>
    </body>
</html>
