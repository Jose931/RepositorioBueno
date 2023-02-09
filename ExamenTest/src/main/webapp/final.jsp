<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="Clases.Examen, Clases.Pregunta, Scriptlets.*" import="java.util.ArrayList" %>
	
	<%
	HttpSession miSesion = request.getSession(true);
	
	Examen miExamen = (Examen) miSesion.getAttribute("examenFinal");
	
	ArrayList<Pregunta> preguntasYRespuestas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");
	int notaMaxima = (int) miSesion.getAttribute("maxima");
	int acertadas = (int) miSesion.getAttribute("acertadas");
	int falladas = (int) miSesion.getAttribute("falladas");
	double notaPrimera = (double) miSesion.getAttribute("notaPrimera");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<p>Has llegado al final del examen</p>
	</div>
	<div>
		<p>
			<% out.print("Id Examen: " + miExamen.getId_examen()); %>
		</p>
	</div>
	<div>
		<p>
			<%
				if(miExamen.getPuntuacion() < 5){
					out.print("¡SUSPENSO!");
				}else{
					out.print("¡APROBADO!");
				}
			%>
		</p>
		
	</div>
	<div>
		<p>
			Resumen: 
		</p>
	</div>
	<div>
		<%= Scriptlets.muestrExamen(preguntasYRespuestas) %>
	</div>
	<div>
		<p><% out.print("El máximo de aciertos es: " + notaMaxima); %></p>
		<p><% out.print("Has acertado: " + acertadas); %></p>
		<p><% out.print("Has fallado: " + notaMaxima); %></p>
		<p><% out.print("Tu nota sobre " + notaMaxima + " es: " + notaPrimera); %></p>
		<p><% out.print("Tu nota sobre 10 es: " + miExamen.getPuntuacion()); %></p>
	</div>
	
</body>
</html>