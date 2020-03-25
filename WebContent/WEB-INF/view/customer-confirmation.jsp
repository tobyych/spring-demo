<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

    <title>Customer Confirmation</title>

<head>

</head>

<body>

Customer ${customer.firstName} ${customer.lastName} is confirmed.

<br />

Free passes: ${customer.freePasses}

<br />

Postal code: ${customer.postalCode}

<br />

Course code: ${customer.courseCode}

<br />

<a href="/">Return to Home Page</a>

</body>

</html>
