<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true" import="java.util.*" import = "Clases.Producto"%>

<%
HttpSession miSesion = request.getSession();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<%
		out.print("IdSesion: " + miSesion.getId());
		%>
	</h3>

	<h3>
		<%
		Date momento = new Date(miSesion.getCreationTime());
		out.print("MomentoCreacion: " + momento);

		long duracion = miSesion.getLastAccessedTime() - miSesion.getCreationTime();
		Date duracionTime = new Date(duracion);

		Date acceso = new Date(miSesion.getLastAccessedTime());
		out.print("Ultimo acceso: " + acceso);

		out.print("Duracion acceso es: " + duracionTime.getMinutes() + "min");
		%>
	</h3>

	<h3>
		<%
			miSesion.setAttribute("Trabajo", "Paginas JSP");
			Integer edad = 26;
			miSesion.setAttribute("edad", edad);
			
			out.print("trabajo en " + miSesion.getAttribute("Trabajo") +" y mi edad es de " +  miSesion.getAttribute("edad"));
			
			Producto miProducto = (Producto) miSesion.getAttribute("producto");
			
			out.print(miProducto.toString());	
			
			
			Vector<String> v = new Vector<>();
			
			v.addElement(new String("Lunes"));
			v.addElement(new String("Martes"));
			v.addElement(new String("Miercoles"));
			v.addElement(new String("Jueves"));
			v.addElement(new String("Viernes"));
			v.addElement(new String("Sabado"));
			v.addElement(new String("Domingo"));
			
			
			
			miSesion.setAttribute("diasSemana",v);
			
			Vector<String> vector1 = (Vector<String>)miSesion.getAttribute("diasSemana");
			
			out.print(vector1.isEmpty());
			
		
		%>
	</h3>
	
	<h3>
		<%
		
		if(vector1 != null){
			for(int i = 0; i < vector1.size(); i++){
				out.print(vector1.elementAt(i) + " ");
			}
		}
		 
		
		%>
	</h3>
</body>
</html>