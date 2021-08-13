<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="<c:url value="/web/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />" ></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <style>
            body {
                background-image: url('	https://tipsmake.com/data/images/beautiful-technology-background-picture-1-TDsP3Qvos.jpg');
                padding: 50px;
            }
/*            form
            {align-content:center;
             text-align: center;

            }*/
            h1{
                color: white
            }
            a{
                color: red;         
            }
            .relative{
                height:350px;
                width: 350px;
                position: relative;
                left: 30%;
                top: 50%; 

            }
            * {
                margin: 0;
                padding: 0;
            }
            .form-tt {
                width: 400px;
                border-radius: 10px;
                overflow: hidden;
                padding: 55px 55px 37px;
                background: #9152f8;
                background: -webkit-linear-gradient(top,#7579ff,#b224ef);
                background: -o-linear-gradient(top,#7579ff,#b224ef);
                background: -moz-linear-gradient(top,#7579ff,#b224ef);
                background: linear-gradient(top,#7579ff,#b224ef);
                text-align: center;
            }
            .form-tt h1 {
                font-size: 30px;
                color: #fff;
                line-height: 1.2;
                text-align: center;
                text-transform: uppercase;
                display: block;
                margin-bottom: 30px;
            }

            .form-tt input[type=text], .form-tt input[type=password] {
                font-family: Poppins-Regular;
                font-size: 16px;
                color: #fff;
                line-height: 1.2;
                display: block;
                width: calc(100% - 10px);
                height: 45px;
                background: 0 0;
                padding: 10px 0;
                border-bottom: 2px solid rgba(255,255,255,.24)!important;
                border: 0;
                outline: 0;
            }
            .form-tt input[type=text]::focus, .form-tt input[type=password]::focus {
                color: red;
            }
            .form-tt input[type=password] {
                margin-bottom: 20px;
            }
            .form-tt input::placeholder {
                color: #fff;
            }
            .checkbox {
                display: block;
            }
            .form-tt input[type=submit] {
                font-size: 16px;
                color: #555;
                line-height: 1.2;
                padding: 0 20px;
                min-width: 120px;
                height: 50px;
                border-radius: 25px;
                background: #fff;
                position: relative;
                z-index: 1;
                border: 0;
                outline: 0;
                display: block;
                margin: 30px auto;
            }
            #checkbox {
                display: inline-block;
                margin-right: 10px;
            }
            .checkbox-text {
                color: #fff;
            }
            .psw-text {
                color: #fff;
            }
        </style>
    </head>
    <body>
        <div class="form-tt" style="position: relative;
                left: 30%;
                top: 50%;">
        <h1>Login </h1>
        <form:form method="POST" action="${request.contextPath}/spring-login/loginCheck" commandName="user">
            <table>
                <tr><td style="color: whitesmoke">User Name:</td></tr>
                <tr><td><form:input path="username" /></td></tr>
                <tr><td style="color: whitesmoke">Password:</td></tr>
                <tr><td><form:password path="password" /></td></tr>
                <tr><td><input type="submit" value="LOGIN" /></td></tr>

            </table>
            <a href="${request.contextPath}/spring-login/add">Register</a>
        </form:form>
            </div>
    </body>
</html>