<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("t_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>abc</title>
</head>
<body>

<h1>ABC</h1>
이름: ${t_name}
name: <%=name%>
<br>
지역: ${t_area}


</body>
</html>