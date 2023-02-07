<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="Clases.Pregunta,Clases.CreaMapas,Clases.Examen , Scriptlets.*"
	import="java.util.ArrayList"%>
	<%
HttpSession miSesion = request.getSession(true);

ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");
ArrayList<String> enunciados = new ArrayList<>();

int[] seleccionados = (int[]) miSesion.getAttribute("elecciones3");
if (seleccionados == null) {
	seleccionados = new int[0];
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>3ª PREGUNTA</h2>
	<p>
		<%
		out.print(preguntas.get(2).getEnunciado());
		%>
	</p>
	<form action="Navegacion" method="post">
	<%=Scriptlets.generaArrayCajasChequeo("elecciones", CreaMapas.hazMapa(preguntas, 2), seleccionados)%>
		<input type="hidden" name="pagina" value="3">
		<input type="submit" value="Anterior" name="navegar">
		<input type="submit" value="Siguiente" name="navegar">
	</form>
</body>
</html>