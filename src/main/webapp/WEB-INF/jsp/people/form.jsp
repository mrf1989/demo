<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<title>Hello World!</title>
	<meta charset="utf-8">
</head>
<body>
	<h1>Hello World!</h1>
	<h3>Person Form</h3>
	
	<form:form modelAttribute="person" action="/people/save" method="post">
		First name<form:input path="firstName"/>
		Last name<form:input path="lastName"/>
		<input type="submit" value="Save">
	</form:form>
		
	<ul>
	<c:forEach items="${people}" var="person">
		<li><c:out value="${person.firstName}"/></li>
	</c:forEach>
	</ul>
	<a href="/">Back Home</a>
</body>
</html>