<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<title>Hello World!</title>
	<meta charset="utf-8">
</head>
<body>
	<h1>Hello World!</h1>
	<ul>
	<c:forEach items="${people}" var="person">
		<li><c:out value="${person.firstName}"/></li>
	</c:forEach>
	</ul>
	<a href="/people/form">Add person</a><br/>
	<a href="/">Back Home</a>
</body>
</html>