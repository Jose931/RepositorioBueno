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
	}
}
 
if(seleccionados == null){
	seleccionados = new int [0];
}else{
	for(int i = 0; i < seleccionados.length; i++){
		 System.out.println(seleccionados[i]);
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
		<%=Scriptlets.generaArrayCajasChequeo("elecciones3", CreaMapas.hazMapa(preguntas, 2), seleccionados)%>
		<input type="hidden" name="pagina" value="3"> 
		<input type="submit" value="Anterior" name="navegar">
		<input type="submit" value="Siguiente" name="navegar">
	</form>
</body>
</html>