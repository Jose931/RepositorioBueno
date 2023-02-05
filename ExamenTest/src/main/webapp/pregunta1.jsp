<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Clases.* , Scriptlets.*" import ="java.util.ArrayList"%>
<!DOCTYPE html>


<%
HttpSession miSesion = request.getSession(true);

 ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=""></form>
	<h2>
	<%
	String salida = "";
	if(preguntas != null){
		for(int i = 0; i < preguntas.size(); i++){
			salida += preguntas.get(i).getEnunciado() + ": Respuestas=> [";
			for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++){
				salida += preguntas.get(i).getRespuestas().get(j).getTexto() + ", ";
				
			}
			salida += " ]";
		}
		
		out.print(salida);
	}
		
	%>
	</h2>
</body>
</html>