<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Tienda Libros</h1>
	<h3>Elige autor(s):</h3>
	<form method="get">
		<input type="checkbox" name="autor" value="Alvaro Garcia">Alvaro Garcia
		<input type="checkbox" name="autor" value="Aleksa Vukotic">Aleksa Vukotic
		<input type="checkbox" name="autor" value="Giulio Zambon">Giulio Zambon
		<input type="submit" value="consulta">
	</form>
	<%
		String[] autores = request.getParameterValues("autor");
		if (autores != null) {
	%>
	<%@ page import = "java.sql.*" %>
	<%
		//Paso 1: Cargar el driver JDBC.
		Class.forName("com.mysql.jdbc.Driver");
		//Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		String userName="root";
		String password="";
		String url="jdbc:mysql://localhost/tiendalibros";
		Connection conn = DriverManager.getConnection(url, userName, password);
		//Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		Statement stmt = conn.createStatement();
		String sqlStr = "SELECT * FROM libros WHERE ";
		for (int i = 0; i < autores.length; i++ ) {
		sqlStr = sqlStr + "autor = '" + autores[i] + "' ";
		if (i != autores.length - 1) {
		sqlStr += "OR ";
		}
		}
		sqlStr += "AND cantidad > 0 ORDER BY precio DESC";
		//para depuraci´on
		System.out.println("La consulta sql es " + sqlStr);
		//Paso 4: Ejecutar las sentencias SQL a trav´es de los objetos Statement
		ResultSet rset = stmt.executeQuery(sqlStr);
	%>

	<%
		//Paso 5: Procesar el conjunto de registros resultante utilizando ResultSet
		while (rset.next()) {
	%>
		<tr>
		<td><%= rset.getString("autor") %></td>
		<td><%= rset.getString("nombre") %></td>
		<td><%= rset.getInt("precio") %></td>
		<td><%= rset.getInt("cantidad") %></td>
		</tr>
	<%
		}
	%>
	</table>
	<%
		//Cierre de recursos
		rset.close();
		stmt.close();
		conn.close();
		}
	%>
</body>
</html>
