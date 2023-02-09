<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="Clases.Pregunta,Clases.CreaMapas,Clases.Examen , Scriptlets.*"
	import="java.util.ArrayList"%>
<%
HttpSession miSesion = request.getSession(true);
ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");
int contador = 0;
int size = 0;

for(int i = 0; i < preguntas.get(2).getRespuestas().size(); i++){
	if(preguntas.get(2).getRespuestas().get(i).isMarcada() == true){
		size++;
	}
}
int[] seleccionados = new int[size];

for(int i = 0; i < preguntas.get(2).getRespuestas().size(); i++){
	if(preguntas.get(2).getRespuestas().get(i).isMarcada() == true){
		seleccionados[contador] = i; 
		contador++;
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Examen: Pregunta 3</title>
</head>
<body>
	<h2>3ª PREGUNTA</h2>
	<p>
		<%
		out.print(preguntas.get(2).getEnunciado());
		%>
	</p>
	<form action="Navegacion" method="post">
		<%=Scriptlets.arrayCheckBox("elecciones3", CreaMapas.hazMapa(preguntas, 2), seleccionados)%>
		<input type="hidden" name="pagina" value="3"> 
		<input type="submit" value="Anterior" name="navegar">
		<input type="submit" value="Finalizar" name="navegar">
	</form>
	
	<p>
	<%
		String salida = (String)miSesion.getAttribute("salida3");
		if(salida == null || salida.equals("")){
			salida = "";
			out.print(salida);
		}else{
			out.print(salida);
		}
	%>
	</p>	
</body>
</html>