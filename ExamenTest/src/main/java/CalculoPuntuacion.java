
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import Clases.Examen;
import Clases.Pregunta;
import Clases.Respuesta;

/**
 * Servlet implementation class CalculoPuntiacion
 */
public class CalculoPuntuacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculoPuntuacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession miSesion = request.getSession(true);

		ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");
		
		
		Connection conn = null;
		try {
			conn = conectaBaseDatos();
			Statement stmt = conn.createStatement();
			double nota = calculoNota(preguntas, miSesion);
			String clave = generaClave(stmt);
			
			Examen examen = new Examen(clave, sacoPregunta(preguntas, 0), sacoRespuesta(preguntas, 0), sacoPregunta(preguntas, 1),
					sacoRespuesta(preguntas, 1), sacoPregunta(preguntas, 2), sacoRespuesta(preguntas, 2), nota);

			
			String insert = "INSERT INTO examenes values ('" + 
					examen.getId_examen() + "', '" + 
					examen.getPregunta1() + "', '"+ 
					examen.getRespuesta1() + "', '" + 
					examen.getPregunta2() + "' , '" + 
					examen.getRespuesta2() + "' , '" +
					examen.getPregunta3()+ "', '" +
					examen.getRespuesta3()+ "', '" +
					examen.getPuntuacion()+ "')";
			
			int rset = stmt.executeUpdate(insert);

			miSesion.setAttribute("examenFinal", examen);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/final.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Conecta con la base de datos
	 * 
	 * @return {@code Connection Objet}
	 */
	private Connection conectaBaseDatos() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "");
		return conn;
	}

	/**
	 * Mira cual es el maximo de preguntas que se pueden acertar
	 * 
	 * @param {@code ArrayList<Pregunta>}
	 * @return {@code int}
	 */
	public int comprobarPuntuacionMaximna(ArrayList<Pregunta> preguntas) {

		int maximo = 0;

		for (int i = 0; i < preguntas.size(); i++) {
			for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++) {
				if (preguntas.get(i).getRespuestas().get(j).isValida()) {
					maximo++;
				}
			}
		}

		return maximo;
	}

	/**
	 * Devuelve el numero total de respuestas acertadas
	 * 
	 * @param {@code ArrayList<Pregunta>}
	 * @return {@code int}
	 */
	public int preguntasAcertadas(ArrayList<Pregunta> preguntas) {
		int acertadas = 0;

		for (int i = 0; i < preguntas.size(); i++) {
			for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++) {
				if (preguntas.get(i).getRespuestas().get(j).isValida()
						&& preguntas.get(i).getRespuestas().get(j).isMarcada()) {
					acertadas++;
				}
			}
		}

		return acertadas;
	}

	/**
	 * Devuelve el numero total de respuestas falladas
	 * 
	 * @param {@code ArrayList<Pregunta>}
	 * @return {@code int}
	 */
	public int preguntasFalladas(ArrayList<Pregunta> preguntas) {
		int falladas = 0;

		for (int i = 0; i < preguntas.size(); i++) {
			for (int j = 0; j < preguntas.get(i).getRespuestas().size(); j++) {
				if (!preguntas.get(i).getRespuestas().get(j).isValida()
						&& preguntas.get(i).getRespuestas().get(j).isMarcada()) {
					falladas++;
				}
			}
		}

		return falladas;
	}

	/**
	 * Calcula la nota a partir de las respuestas falladas y acertadas
	 * 
	 * @param {@code ArrayList<>}
	 * @return {@code double}
	 */
	public double calculoNota(ArrayList<Pregunta> preguntas, HttpSession miSesion) {
		int notaMaxima = comprobarPuntuacionMaximna(preguntas);
		int acertadas = preguntasAcertadas(preguntas);
		int falladas = preguntasFalladas(preguntas);
		double nota = ((acertadas * 1) - (falladas * 0.25));
		double notaFinal = Math.round(pasarNota10(nota, notaMaxima) * 10.0) / 10.0;
		miSesion.setAttribute("maxima", notaMaxima);
		miSesion.setAttribute("acertadas", acertadas);
		miSesion.setAttribute("falladas", falladas);
		miSesion.setAttribute("notaPrimera", nota);
		
		return notaFinal;
	}

	/**
	 * Pasa la nota sobre 10
	 * 
	 * @param {@code double, int}
	 * @return {@code double}
	 */
	public double pasarNota10(double nota, int notaMaxima) {

		double notaFinal = (nota * 10) / notaMaxima;

		return notaFinal;
	}
	/**
	 * Saca el texto de cada una de las preguntas
	 * 
	 * @param {@code ArrayList<Pregunta>, int}
	 * @return {@code String}
	 */
	public String sacoPregunta(ArrayList<Pregunta> preguntas, int numPregunta) {
		String pregunta = preguntas.get(numPregunta).getEnunciado();
		return pregunta;
	}
	/**
	 * Saca las respuestas marcadas
	 * 
	 * @param {@code ArrayList<Pregunta>, int}
	 * @return {@code String}
	 */
	public String sacoRespuesta(ArrayList<Pregunta> preguntas, int numPregunta) {
		String respuesta = "";
		int contador = 0;
		for (int i = 0; i < preguntas.get(numPregunta).getRespuestas().size(); i++) {
			if (preguntas.get(numPregunta).getRespuestas().get(i).isMarcada()) {
				if (contador == 0) {
					respuesta += preguntas.get(numPregunta).getRespuestas().get(i).getTexto();
					contador++;
				} else {
					respuesta += "&" + preguntas.get(numPregunta).getRespuestas().get(i).getTexto();
				}
			}
		}

		return respuesta;
	}
	/**
	 * Sacamos el examen a partir de nuestra clave
	 * 
	 * @param {@code Statement, int}
	 * @return {@code ArrayList<Respuesta>}
	 */
	private Examen  obtengoExamen(Statement stmt, String Clave) throws Exception {
		Examen examen = new Examen();

		ResultSet resp = stmt
				.executeQuery("SELECT id_pregunta, respuesta, valida from respuestas where id_pregunta = ");
		while (resp.next()) {
			
		}

		return examen;
	}
	/**
	 * Nos genera una clave de String que no se  repita con ninguna de la base de datos
	 * 
	 * @param {@code Statement}
	 * @return {@code String}
	 * @throws SQLException 
	 */
	private String generaClave(Statement stmt) throws SQLException {
		String cadena = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String clave= "";
		
		do {
			for (int x = 0; x < 8; x++) {
		        int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, cadena.length() - 1);
		        char caracterAleatorio = cadena.charAt(indiceAleatorio);
		        clave += caracterAleatorio;
		    }
		}while(!existeClave(stmt, clave));
		
		
		return clave;
	}
	/**
	 *Comprueba si la clave existe en la base de datos
	 * 
	 * @param {@code Statement, String}
	 * @return {@code boolean}
	 * @throws SQLException 
	 */
	private boolean existeClave(Statement stmt, String clave) throws SQLException {
		
		ResultSet rset = stmt.executeQuery("SELECT id_examen from examenes");
		
		while(rset.next()) {
			if(clave.equals(rset.getString("id_examen"))) {
				return false;
			}
		}
		return true;
	}

}
