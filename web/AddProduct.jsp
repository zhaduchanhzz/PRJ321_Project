<%-- 
    Document   : AddProduct
    Created on : Mar 15, 2022, 12:59:32 PM
    Author     : zhadu
--%>
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

        <c:if test="${update == null}" var="a">
            <form action="ManageProduct?action=add" method="POST">
                <table border="0">      
                    <tr>
                        <td>Product ID:</td>
                        <td><input type="text" name="pid" value="" /></td>
                    </tr>
                    <tr>
                        <td>Product Name:</td>
                        <td><input type="text" name="pname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td><input type="text" name="quantity" value="" /></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><input type="text" name="price" value="" /></td>
                    </tr>
                    <tr>
                        <td>Image Link </td>
                        <td><input type="text" name="image" value="" /></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><input type="text" name="des" value="" /></td>
                    </tr>
                    <tr>
                        <td>Status: </td>
                        <td><input type="radio" name="status" value="1" checked />Enable
                            <input type="radio" name="status" value="0" />Disable
                        </td>
                    </tr>
                    <tr>
                        <td>Category: </td>
                        <td>
                            <select name="cate" size="1">
                                <c:forEach items="${listcate}" var="o">
                                    <option value="${o.cid}">${o.cname}</option>
                                </c:forEach>


                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Insert" name="submit"/>
                            <input type="reset" value="reset" />
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
        <c:forEach items="${update}" var="a">
            <form action="ManageProduct?action=update" method="POST">
                <table border="0">      
                    <tr>
                        <td>Product ID:</td>
                        <td><input type="text" name="pid" value="${a.pid}" readonly/></td>
                    </tr>
                    <tr>
                        <td>Product Name:</td>
                        <td><input type="text" name="pname" value="${a.pname}" /></td>
                    </tr>
                    <tr>
                        <td>Quantity:</td>
                        <td><input type="number" name="quantity" value="${a.quantity}" /></td>
                    </tr>
                    <tr>
                        <td>Price:</td>
                        <td><input type="text" name="price" value="${a.price}" /></td>
                    </tr>
                    <tr>
                        <td>Image Link </td>
                        <td><input type="text" name="image" value="${a.img}" /></td>
                    </tr>
                    <tr>
                        <td>Description: </td>
                        <td><input type="text" name="des" value="${a.decs}" /></td>
                    </tr>
                    <tr>
                        <td>Status: </td>
                        <td><input type="radio" name="status" value="1" checked />Enable
                            <input type="radio" name="status" value="0" />Disable
                        </td>
                    </tr>
                    <tr>
                        <td>Category: </td>
                        <td>
                            <select name="cate" size="1">
                                <c:forEach items="${listcate}" var="o">
                                    <option value="${o.cid}">${o.cname}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Update" name="submit"/>
                            <input type="reset" value="reset" />
                        </td>
                    </tr>
                </table>
            </form>
        </c:forEach>>
    </body>
</html>
