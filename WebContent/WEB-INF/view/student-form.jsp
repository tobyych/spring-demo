<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

    <title>Hello World - Input Form</title>

</head>

<body>

    <form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName" />

    <br />

    Last name: <form:input path="lastName" />

    <input type="submit" value="Submit" />

    </form:form>

</body>

</html>