<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Welcome to the Document Upload page</h2>
	<form align="center" action="upload" method="post"
		enctype="multipart/form-data">
		<pre>
	ID: <input type="text" name="fileId" />
	
	Doc:<input type="file" name="fileob" />
	
	<input type="submit" value="upload" />
	</pre>

	</form>
	<h3 align="center">${message}</h3>
</body>
</html>