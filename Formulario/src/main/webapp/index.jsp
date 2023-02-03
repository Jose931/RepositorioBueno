<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="paqueteScriptlets.Scriptlets, paqueteClases.Datos"%>
<%
String nombre = (String) request.getAttribute("nombre");
if(request.getAttribute("nombre") == null){
	nombre = "";
}
String contraseña = (String) request.getAttribute("contraseña");
if(request.getAttribute("contraseña") == null){
	contraseña = "";
}
String sexo = (String) request.getAttribute("sexo");
if(sexo == null){
	sexo = "";
}
String pais = (String) request.getAttribute("pais");
if(request.getAttribute("pais") == null){
	 pais = "";
}
String fecha = (String) request.getAttribute("fecha");
String acepta = (String) request.getAttribute("acepto");
if(acepta == null){
	acepta = "";
}
String comentario = (String) request.getAttribute("comentario");
if(request.getAttribute("contraseña") == null){
	comentario = "";
}
String [] colores = (String []) request.getAttribute("colores");
if(colores == null){
	colores = new String[0];
}
String errores = (String) request.getAttribute("errores");
String[] estaciones = (String[]) request.getAttribute("estaciones");
if(estaciones == null){
	estaciones = new String [0];
}
Boolean registro = (Boolean) request.getAttribute("registroOk");
if(registro == null){
	registro = false;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Formulario" method="post">
		<input type="text" name="nombre" placeholder="Nombre" value="<%= nombre %>"> <br>
		<input type="password" name="pass" placeholder="Contraseña" value="<%= contraseña %>"> <br>
		<%= Scriptlets.generaBotonesRadio("sexo", Datos.sexo, sexo)%>
		<br> 
		<label for="fecha">Fecha</label> <input type="date" name="fecha"> <br>
		<%= Scriptlets.generaSelectSimple("paises", Datos.arrayPaises , pais)%><br>
		<%= Scriptlets.generaSelectMultiple("colores", Datos.arrayColores, colores, colores.length + 2) %>
		 <br> 
		<%=Scriptlets.generaArrayCajasChequeo("estaciones", Datos.arrayEstacion, estaciones) %> <br>
		<br> <input type="checkbox" value="acepto" name='acepto'>
		<label for="acepto">¿Aceptas las condiciones de la página?</label> <br>
		<textarea name="comentarios" cols="30" rows="5"
			placeholder="Escribe aqui tu comentario" value="<%= comentario %>"></textarea>
		<br> <input type="submit" value="Enviar">
	</form>

	<h3>
		<%
		if (errores != "") {
			out.print(errores);
		}else{
			out.print("");
		}
		%>
	</h3>
	<h3>
		<%
		if(registro){
			out.print("Datos registrados correctamente.");
		}else{
			out.print("Problema al registrar los datos.");
		}
		;
		%>
	</h3>
</body>

</html>