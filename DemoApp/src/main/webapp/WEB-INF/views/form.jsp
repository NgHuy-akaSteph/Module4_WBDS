<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
<%--@elvariable id="customer" type="com.dev.demoapp.entities.Customer"--%>
    <form:form modelAttribute="customer" aciton="/create-customer" method="post" >
        Name: <form:input path="name" /><br><br>
        Gender: <form:radiobuttons path="gender" items="${genders}"/><br><br>
        Is admin: <form:checkbox path="admin" /><br><br>
        Hobby: <form:checkboxes path="hobbies" items="${hobbyArr}"/><br><br>
        Type: <form:select path="type" items="${types}"/><br><br>
        Country: <form:select path="country" items="${countries}"/><br><br>
        <button type="submit">Create customer</button>
    </form:form>
</body>
</html>
