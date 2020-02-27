<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uom type register page</title>
</head>
<body>
<form action="save" method="post">
<pre>
Uom Type:<select name="uomType">
			<option>--select--</option>
			<option>packing</option>
			<option>No packing</option>
			<option>--NA--</option>
		</select>
		
Uom Model:<input type="text" name="uomModel">

Description:<textarea name="uomDesc"></textarea>

<input type="submit" value="craete Uom">


</pre>
</form>
   ${savemessage}

</body>
</html>