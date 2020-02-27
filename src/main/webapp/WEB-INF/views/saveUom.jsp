<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><h3>Welcome to UOM data</h3>
<c:choose>

<c:when test="${!empty list}">
<table border="1">
		<tr>
			<th>uomId</th>
			<th>uomType</th>
			<th>uomModel</th>
			<th>uomDesc</th>
			<th>Oprations</th>
		</tr>
		<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.uomId}</td>
			<td>${ob.uomType}</td>
			<td>${ob.uomModel}</td>
			<td>${ob.uomDesc}</td>
			<td><a href="delete?uId=${ob.uomId}">DELETE</a> </td>
		
		</tr>
		</c:forEach>
		</table>
		<tr></tr>
		
		</c:when>
		<c:otherwise>
		<h3>Data not found</h3>
		</c:otherwise>
		</c:choose>
	${deletemessage}
</body>
</html>