
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import Clases.Pregunta;

/**
 * Servlet implementation class Navegacion
 */
public class Navegacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Navegacion() {
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

		String pagina = request.getParameter("pagina");
		String navego = request.getParameter("navegar");
		HttpSession miSesion = request.getSession(true);
		String direccion = "";
		ArrayList<Pregunta> preguntas = (ArrayList<Pregunta>) miSesion.getAttribute("preguntas");
		
		
		
		
		
		switch (pagina) {
		case "1":
			String[] elecciones1 = request.getParameterValues("elecciones1");
			if(elecciones1 == null) {
				elecciones1 = new String [0];
			}
			int [] eleccionesP1 = cambioElecciones(elecciones1);
			preguntas = metiendoSeleccionadas(preguntas, eleccionesP1, 0);
			miSesion.setAttribute("eleccionesP1", eleccionesP1);
			miSesion.setAttribute("preguntas", preguntas);
			direccion = "/pregunta2.jsp";
			break;
		case "2":
			String[] elecciones2 = request.getParameterValues("elecciones2");
			if(elecciones2 == null) {
				elecciones2 = new String [0];
			}
			int [] eleccionesP2 = cambioElecciones(elecciones2);
			preguntas = metiendoSeleccionadas(preguntas, eleccionesP2, 1);
			miSesion.setAttribute("eleccionesP2", eleccionesP2);
			miSesion.setAttribute("preguntas", preguntas);
			if (navego.equals("Siguiente")) {
				direccion = "/pregunta3.jsp";
			} else {
				direccion = "/pregunta1.jsp";
			}
			break;

		case "3":
			String[] elecciones3 = request.getParameterValues("elecciones3");
			if(elecciones3 == null) {
				elecciones3 = new String [0];
			}
			int [] eleccionesP3 = cambioElecciones(elecciones3);
			preguntas = metiendoSeleccionadas(preguntas, eleccionesP3, 2);
			miSesion.setAttribute("eleccionesP3", eleccionesP3);
			miSesion.setAttribute("preguntas", preguntas);
			if (navego.equals("Siguiente")) {
				direccion = "/final.jsp";
				
			} else {
				direccion = "/pregunta2.jsp";
			}
			break;
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(direccion);
		dispatcher.forward(request, response);
		

	}

	/**
	 * Devuelve un array de enteros a partir de un array de Strings
	 * 
	 * @param {{@code String [] }
	 * @return {@code int[]}
	 */
	public int[] cambioElecciones(String[] elecciones) {
		int[] seleccionesPreguntas = new int[elecciones.length];

		for (int i = 0; i < elecciones.length; i++) {
			seleccionesPreguntas[i] = Integer.parseInt(elecciones[i]);
		}
		return seleccionesPreguntas;
	}

	/**
	 * Devuelve true si el array no esta vacio
	 * 
	 * @param {@code String []}
	 * @return {@code boolean}
	 */
	public boolean existeEleccion(String[] elecciones) {
		return elecciones != null ? true : false;
	}

	
	public ArrayList<Pregunta> metiendoSeleccionadas(ArrayList<Pregunta> preguntas, int[] elecciones, int pregunta){
		
//	preguntas = reseteando(preguntas, pregunta);
		for(int i = 0; i < preguntas.get(pregunta).getRespuestas().size(); i++) {
			
			for (int j = 0; j < elecciones.length; j++) {
				if(i == elecciones[j] ) {
					preguntas.get(pregunta).getRespuestas().get(i).setMarcada(true);
				}
			}
		}
		return preguntas;
	}
	
	
	
	public ArrayList<Pregunta> reseteando(ArrayList<Pregunta> preguntas, int pregunta){

		for(int i = 0; i < preguntas.get(pregunta).getRespuestas().size(); i++) {
			preguntas.get(pregunta).getRespuestas().get(i).setMarcada(false);
		}
		
		return preguntas;
	}
	
}
