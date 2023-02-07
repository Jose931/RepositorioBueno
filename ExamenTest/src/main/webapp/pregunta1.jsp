<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="Clases.Pregunta,Clases.CreaMapas,Clases.Examen , Scriptlets.*"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<%
HttpSession miSesion = request.getSession(true);

ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");

int[] seleccionados = (int[]) miSesion.getAttribute("elecciones1");
if (seleccionados == null) {
	seleccionados = new int[0];
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>1ª PREGUNTA</h2>
	<p>
		<%
		out.print(preguntas.get(0).getEnunciado());
		%>
	</p>
	<form action="Navegacion" method = "post">
		<%=Scriptlets.generaArrayCajasChequeo("elecciones", CreaMapas.hazMapa(preguntas, 0), seleccionados)%>
		<input type="hidden" name="pagina" value = "1">
		<input type="submit" value="Siguiente" name="navegar">
	</form>
</body>
</html>