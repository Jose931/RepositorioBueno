
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedHashMap;




public class Formulario extends HttpServlet {
	public LinkedHashMap<String,String> arrayValoresYEtiquetas = new LinkedHashMap<String,String>();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Formulario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("nombre");
		String contraseña = request.getParameter("pass");
		String sexo = request.getParameter("sexo");
		String fecha = request.getParameter("fecha");
		String pais = request.getParameter("paises");
		String acepto = request.getParameter("acepto");
		String comentario = request.getParameter("comentarios");
		String[] colores = request.getParameterValues("colores");
		String[] estaciones = request.getParameterValues("estaciones");
		String salidaErrores = Validaciones.comprobarEdad(fecha) 
				+ Validaciones.comprobarNombre(name) 
				+ Validaciones.comprobarClave(contraseña) 
				+ Validaciones.comprobarPais(pais) 
				+ Validaciones.comprobarGenero(sexo) 
				+ Validaciones.comprobarAcepto(acepto) 
				+ Validaciones.comprobarColores(colores) 
				+ Validaciones.comprobarEstaciones(estaciones);
		
		String estacionesJuntas = juntarArray(estaciones);
		String coloresJuntos = juntarArray(colores);
		Boolean datosRegistrados = false;
		
		
		
		request.setAttribute("nombre", name);
		request.setAttribute("contraseña", contraseña);
		request.setAttribute("sexo", sexo);
		request.setAttribute("fecha",fecha);
		request.setAttribute("pais", pais);
		request.setAttribute("acepto", acepto);
		request.setAttribute("comentario", comentario);
		request.setAttribute("colores", colores);
		request.setAttribute("estaciones", estaciones);
		request.setAttribute("errores", salidaErrores);
		
		
		if(salidaErrores.equals("")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String userName = "root";
				String password = "";
				String url = "jdbc:mysql://localhost/registro";
				
				Connection conn = DriverManager.getConnection(url, userName, password);
				
				Statement stmt = conn.createStatement();
				
				String insert = "INSERT INTO usuario VALUES (NULL, '"
						 + name + "', '" 
						 + contraseña + "', '" 
						 + sexo + "', '" 
						 + pais + "', '" 
						 + fecha +  "', '" 
						 + acepto +  "', '" 
						 + comentario +  "', '" 
						 + coloresJuntos +  "', '" 
						 + estacionesJuntas +  "')";
				
				
				System.out.println(insert);
				
				int inserta = stmt.executeUpdate(insert);
				
				if(inserta != 0) {
					datosRegistrados = true;
				}
				
				request.setAttribute("registroOk", datosRegistrados);
//				
//				String insertPrepare = "INSERT INTO 'usuaro' VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//				PreparedStatement stmtPrep = conn.prepareStatement(insert);
//
//				stmtPrep.setString(1, name);
//				stmtPrep.setString(2, contraseña);
//				stmtPrep.setString(3, sexo);
//				stmtPrep.setString(4, pais);
//				stmtPrep.setString(5, fecha);
//				stmtPrep.setString(6, acepto);
//				stmtPrep.setString(7, comentario);
//				stmtPrep.setString(8, coloresJuntos);
//				stmtPrep.setString(9, estacionesJuntas);
				
			} catch ( ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
		
		request.setAttribute("registroOk", datosRegistrados);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	public static String juntarArray(String [] array) {
		String valoresJuntos= "";
		
		for(int i = 0; i < array.length; i++) {
			if(i == 0) {
				valoresJuntos += array[i];
			}else {
				valoresJuntos += "&" + array[i];
			}
		}
		
		return valoresJuntos;
	}
	

}
