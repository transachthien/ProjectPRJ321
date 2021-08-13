<%-- 
    Document   : addProduct
    Created on : Jul 2, 2021, 9:29:29 PM
    Author     : trans
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD Product</title>
    <script type="text/javascript">
    function validateFileType(){
        var fileName = document.getElementById("fileName").value;
        var idxDot = fileName.lastIndexOf(".") + 1;
        var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
        if (extFile=="jpg" || extFile=="jpeg" || extFile=="png"){
            //TO DO
        }else{
            alert("Only jpg/jpeg and png files are allowed!");
        }   
    }
    </script>
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
        <h3>Registration Product</h3>
        <form:form method="POST" action="${request.contextPath}/spring-login/${actions}" commandName="product"> <%--enctype="multipart/form-data" --%>
            <table>
                <tr><td>Product Name:</td><td><form:input path="ProductName" value="${product.getProductName()}" /></td></tr>
                <tr><td>Unit:</td><td><form:input path="Unit" value="${product.getUnit()}" /></td></tr>
                <tr><td>Price:</td><td><form:input path="Price" value="${product.getPrice()}" /></td></tr>
                <%--<tr><td>Image:</td><td><input name="image" type="file" id="fileName" accept=".jpg,.jpeg,.png" onchange="validateFileType()" /></td></tr>--%>
                <tr><td>Detail:</td><td><form:input path="Detail" value="${product.getDetail()}" /></td></tr>
                <tr><td>Product create by:</td><td><form:input path="ProductCreateBy" value="${sessionScope.username}" disabled="true"  /></td></tr>
                <tr><td><input type="submit" value="Submit" /></td></tr>
            </table>
        </form:form>
        </div>
    </body>
</html>
