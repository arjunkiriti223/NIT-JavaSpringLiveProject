<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<a href="pdf">PDF EXPORT</a>

	<h3 align="center">Welcome to Shipment Type data</h3>
	<a href="excel">EXCEL Export</a>
	<c:choose>

		<c:when test="${!empty list }">
			<table  align="center" border="1">
				<tr>
					<th>shipmentId</th>
					<th>shipmentMode</th>
					<th>shipmentCode</th>
					<th>enbShip</th>
					<th>shipmentGrade</th>
					<th>shipmentDesc</th>
					<th>Operations</th>
				</tr>
				<c:forEach items="${list}" var="ob">
					<tr>
						<td>${ob.shipId}</td>
						<td>${ob.shipMode}</td>
						<td>${ob.shipCode}</td>
						<td>${ob.enbShip}</td>
						<td>${ob.shipGrade}</td>
						<td>${ob.shipDesc}</td>
						<td><a href="delete?sid=${ob.shipId}">DELETE</a></td>
						<td><a href="edit?sid=${ob.shipId}">EDIT</a></td>
						<td><a href="view?sid=${ob.shipId}">VIEW</a></td>
					</tr>


				</c:forEach>
			</table>

		</c:when>
		<c:otherwise>
			<H3>DATA NOT FOUND</H3>
		</c:otherwise>
	</c:choose>
	                                 <h3 align="center">${message}</h3>
</body>
</html>