<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">

	
	<fieldset style="width: 200px;margin: 0 auto; padding:50px" >
		<%
		String msg = (String)request.getAttribute("msg");			
		%>
		<%= msg != null ? msg : "" %>
		<legend>Login</legend>
		
		<label>Login:</label>
		<input type="text" name = "login"><br>
		<label>Senha:</label>
		<input type="password" name = "Senha"><br>
		<input type="submit" value = "Logar">
		</fieldset>
		</form>
</body>
</html>