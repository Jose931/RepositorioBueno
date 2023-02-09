<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<p>Bienvenido a tu examen de tipo test</p>
	</div>
	<div>
		<p>Este examen constara de 3 preguntas de tipo test con cuatro
			respuestas en cada pregunta. Las preguntas pueden tener mas de una
			respuesta posible hasta el punto de que puedan ser todas las
			respuestas validas. La puntuacion s4e calculara a partir de la
			cantidad de respuestas validas en la totalidad del examen. Por
			ejemplo, si un examen tiene 9 respuestas validas, la nota del examen
			se calculara sobre 9. Al finalizar el examen se mostrara la nota
			equivalente sobre 10.</p>
	</div>
	<div>
		<p>¡MUCHA SUERTE!</p>
	</div>
	<div>
		<form action="Logica" method="post">
			<input type="submit" value="¿Emepzamos?" name=empezar>
		</form>
	</div>

</body>
</html>