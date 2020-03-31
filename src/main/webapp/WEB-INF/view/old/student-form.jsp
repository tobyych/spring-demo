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

    <br />

    Where are you from?

    <form:select path="country">
        <form:options items="${theCountryOptions}" />
    </form:select>

    <br />

    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLangOptions}" />

    <br />

    Operating Systems:

    Linux <form:checkbox path="operatingSystems" value="Linux" />
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
    Windows <form:checkbox path="operatingSystems" value="Windows" />

    <br />

    <input type="submit" value="Submit" />

    </form:form>

</body>

</html>