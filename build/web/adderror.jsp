<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create account</title>
</head>
<body>
<h3>The username: <core:out value="${username}" /> is already existed !!! Click below to login again</h3>
<table>
    <tr>
        <td><a href="${request.contextPath}/spring-login/add">Retry</a></td>
    </tr>
</table>
</body>
</html>