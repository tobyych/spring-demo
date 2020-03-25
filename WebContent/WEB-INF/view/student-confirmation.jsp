<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <title>Hello World</title>

<head>

</head>

<body>

Hello World of Spring!

<br />

Welcome ${student.firstName} ${student.lastName}!

<br />

Country: ${student.country}

<br />

Favorite Language: ${student.favoriteLanguage}

<br />

Favorite Operation System(s):

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>


<br />

<a href="/">Return to Home Page</a>

</body>

</html>
