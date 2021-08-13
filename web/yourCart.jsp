<%-- 
    Document   : yourCart
    Created on : Jul 14, 2021, 1:42:13 PM
    Author     : trans
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>CHO DO CU NOI NIEU CHAO THUNG</title>
        <style>
            body {
                background-image: url('https://tipsmake.com/data/images/beautiful-technology-background-picture-1-TDsP3Qvos.jpg');

            }
            form
            {align-content:center 

            }
            input[type=text] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                box-sizing: border-box;
            }
            h1{
                color: white
            }
            .topnav {
                background-color: #333;
                overflow: hidden;
            }

            /* Style the links inside the navigation bar */
            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }

            /* Change the color of links on hover */
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }

            /* Add a color to the active/current link */
            .topnav a.active {
                background-color: #04AA6D;
                color: white;
            }
            table{background-color: white; 
                  table-layout: auto;
                  width: 75%;
                  text-align: center;
                  <%--position:absolute; left:80px; top:20px;--%>
            }
        </style>
    </head>
    <body>
        <div class="topnav">
            <a  href="${request.contextPath}/spring-login/home">Home</a>
            <a href="${request.contextPath}/spring-login/product.do2">Your Product</a>
            <a class="active" href="${request.contextPath}/spring-login/yourCart">Your Cart</a>
            <a href="${request.contextPath}/spring-login/editUser/${sessionScope.username}">Edit information</a>
            <p></p>
        </div>
        <h1>Your Cart</h1>
        <table border="1">
            <th>ID</th>
            <th>Product Name</th>
            <th>unit</th>
            <th>Price</th>
                <c:forEach items="${listProduct}" var="product">
                <tr>
                    <td>${product.getProductID()}</td>
                    <td>${product.getProductName()}</td>
                    <td>${product.getUnit()}</td>
                    <td>${product.getPrice()}</td>
                     <td><a href="${request.contextPath}/spring-login/deleteYourCart/${product.getProductID()}">Delete Cart</a></td>
                </tr>
            </c:forEach>
        </table>
        <a href="${request.contextPath}/spring-login/buyProduct" style="color: red">Buy your Order</a>
    </body>
</html>