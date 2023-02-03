

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
import Clases.*;;





/**
 * Servlet implementation class logica
 */
public class logica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String empiezaExamen = request.getParameter("empezar");
		int contador;
		
		
		
		if(empiezaExamen == null) {
			
		}else {
			contador = 1;
			ArrayList<Integer> numPreguntas = generarNumerosParaPreguntas();
			Connection conn = null;
			try {
				conn = conectaBaseDatos();
				
				Statement stmt = conn.createStatement();
				ArrayList<String> preguntas = obteniendoPreguntas(numPreguntas, stmt);
				ArrayList<Respuesta> respuestas =obteniendoRespuestas(numPreguntas, stmt);
				ArrayList<Preguntas> preguntasExamen = obteniendoExamen(numPreguntas, preguntas, respuestas);	
				
			}catch(ClassNotFoundException | SQLException e){
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}
	
	/**
	 * Este metodo genera un numero del 1 al 20 
	 */
	private ArrayList<Integer> generarNumerosParaPreguntas() {

		
		ArrayList<Integer> numParaPreguntas = new ArrayList();
		
		for(int i = 0; i < 3; i++) {
			int numero = (int)(Math.random()*20+1);
			if(!numParaPreguntas.contains(numero)) {
				numParaPreguntas.add(numero);
			}else {
				i--;
			}
		}
		return numParaPreguntas;
		
	}

	/**
	 *Conecta con la base de datos
	 *@return {@code Connection Objet} 
	 */
	private Connection conectaBaseDatos() throws ClassNotFoundException, SQLException {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/examen", "root", "");
			return conn;
	}
	
	/**
	 * Crea un array de tipo String a partir de la consulta a la base de datos de las preguntas del examen
	 * @param {code ArrayLis<Integer>, Statement Object}
	 * @return {@code ArrayList<String>}
	 */
	private ArrayList<String> obteniendoPreguntas(ArrayList<Integer> numPreguntas, Statement stmt) throws Exception{
		ArrayList<String> preguntas = new ArrayList<>();
		for(int i = 0; i < numPreguntas.size(); i++) {
			ResultSet rset = stmt.executeQuery("SELECT * from preguntas where id_pregunta = " + numPreguntas.get(i));
			
			if(rset.next()) {
				preguntas.add(rset.getString("pregunta"));
			}
			rset.close();
		}
		
		return preguntas;
	}
	
	/**
	 * Crea un ArrayList con las respuestas de la pregunta que tiene como id el primer parametro
	 * @param {@code ArrayLis<Integer>, Statement Object}
	 * @return {@code ArrayList<Respuesta>}
	 */
	private ArrayList<Respuesta> obteniendoRespuestas(ArrayList<Integer> numPreguntas, Statement stmt) throws Exception{
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		
		for(int i = 0; i < numPreguntas.size(); i++) {
			ResultSet respuesta = stmt.executeQuery("SELECT * from respuestas where id_pregunta = " + numPreguntas.get(i)); 
			while(respuesta.next()) {
				respuestas.add(new Respuesta(
						respuesta.getInt("id_respuesta"), 
						respuesta.getString("respuesta"), 
						respuesta.getInt("id_pregunta"), 
						respuesta.getBoolean("valida")));
			}
			respuesta.close();
		}
		
		return respuestas;
	}
	
	/**
	 * Crea el array que contiene el examen entero a partir de el array de preguntas y el de respuestas. Es necesario el numero de preguntas para meterlo como parametro en el objeto Preguntas
	 * @param {ArrayList<Integer>, ArrayList<String>, ArrayList<Respuesta>}
	 * @return {@code ArrayList<Preguntas>}
	 */
	private ArrayList<Preguntas> obteniendoExamen(ArrayList<Integer> numPreguntas,ArrayList<String> preguntas, ArrayList<Respuesta> respuestas){
		
		ArrayList<Preguntas> preguntasExamen = new ArrayList<>();
		
		for(int i = 0; i < numPreguntas.size(); i++) {
			preguntasExamen.add(new Preguntas(
					numPreguntas.get(i), 
					preguntas.get(i), 
					respuestas.get(0), 
					respuestas.get(1), 
					respuestas.get(2), 
					respuestas.get(3)));
		}
		
		return preguntasExamen;
	}
}


