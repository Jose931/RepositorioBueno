<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Clases.* , Scriptlets.*" import ="java.util.ArrayList"%>
<!DOCTYPE html>


<%
	
HttpSession miSesion = request.getSession(true);

 ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("examen");


	



%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>
	<%
		out.print(preguntas.get(0).getRespuestas().get(1).isValida());
	%>
	</h2>
</body>
</html>