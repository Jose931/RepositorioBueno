
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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
import Clases.*;;

/**
 * Servlet implementation class logica
 */
public class Logica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logica() {
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

		String empiezaExamen = request.getParameter("empezar");

		if (empiezaExamen == null) {

		} else {

			ArrayList<Integer> numPreguntas = generarNumerosParaPreguntas();
			Connection conn = null;
			try {
				conn = conectaBaseDatos();
				Statement stmt = conn.createStatement();
				HttpSession miSesion = request.getSession(true);

				ArrayList<Pregunta> examen = obteniendoPreguntas(numPreguntas, stmt);

				miSesion.setAttribute("preguntas", examen);

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
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pregunta1.jsp");
			dispatcher.forward(request, response); 
		}
	}

	/**
	 * Este metodo genera un numeros aleatorios del 1 al 20 sin repetirse
	 */
	private ArrayList<Integer> generarNumerosParaPreguntas() {

		ArrayList<Integer> numParaPreguntas = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int numero = (int) (Math.random() * 20 + 1);
			if (!numParaPreguntas.contains(numero)) {
				numParaPreguntas.add(numero);
			} else {
				i--;
			}
		}
		return numParaPreguntas;

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
	 * Crea un ArrayList de tipo Pregunta a partir de la consulta a la base de datos de
	 * las preguntas del examen
	 * 
	 * @param {code ArrayLis<Integer>, Statement Object}
	 * @return {@code ArrayList<Pregunta>}
	 */
	private ArrayList<Pregunta> obteniendoPreguntas(ArrayList<Integer> numPreguntas, Statement stmt) throws Exception {
		ArrayList<Pregunta> preguntas = new ArrayList<>();

		for (int i = 0; i < numPreguntas.size(); i++) {
			ResultSet rset = stmt.executeQuery("SELECT * from preguntas where id_pregunta = " + numPreguntas.get(i));
			rset.next();
			preguntas.add(new Pregunta(
							rset.getInt("id_pregunta"),
							rset.getString("pregunta"), 
							obtengoRespuesta(stmt, numPreguntas.get(i))));

		}

		return preguntas;
	}

	/**
	 * Crea un Objeto con las respuestas de la pregunta que tiene como id el primer
	 * parametro
	 * 
	 * @param {@code Statement Object, int id_pregunta}
	 * @return {@code ArrayList<Respuesta>}
	 */
	private ArrayList<Respuesta> obtengoRespuesta(Statement stmt, int num) throws Exception {
		ArrayList<Respuesta> respuestas = new ArrayList<>();

		ResultSet resp = stmt
				.executeQuery("SELECT id_pregunta, respuesta, valida from respuestas where id_pregunta = " + num);
		while (resp.next()) {
			respuestas.add(
					new Respuesta(
							resp.getInt("id_pregunta"), 
							resp.getString("respuesta"),
							resp.getBoolean("valida"), 
							false));
		}

		return respuestas;
	}
}
