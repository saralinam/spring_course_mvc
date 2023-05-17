<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<body>

<h2>Please Employee, Please enter your details</h2>
<br>
<br>


<form:form action = "showDetails" modelAttribute="employee">

    Name <form:input path="name"/>
    <br><br>

    Surname  <form:input path="surname" />
    <br><br>
    Salary <form:input path="salary"/>
    <br><br>

    Department <form:select path="department">
    <form:options items="${employee.departments}" />
    </form:select>

    <br><br>
    <input type="submit" value="ok">

</form:form>


</body>

</html>