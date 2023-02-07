
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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

		switch (pagina) {
		case "1":

			
			direccion = "/pregunta2.jsp";
			break;
		case "2":
			
			if (navego.equals("Siguiente")) {
				direccion = "/pregunta3.jsp";
			} else {
				direccion = "/pregunta1.jsp";
			}
			break;

		case "3":
			
			if (navego.equals("Siguiente")) {
				direccion = "/final.jsp";
				
			} else {
				direccion = "/pregunta2.jsp";
			}
			break;
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(direccion);
		dispatcher.forward(request, response);
		;

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

	/**
	 * Devuelve true si la sesion no esta vacia
	 * 
	 * @param {@code HttpSession, String}
	 * @return {@code boolean}
	 */
	public Boolean existeSesion(HttpSession miSesion, String pregunta) {
		if (miSesion.getAttribute(pregunta) == null) {
			return false;
		}
		return true;
	}

	/**
	 * Devuelve un array de enteros dependiendo de si hay valores seleccionados,si hay valores y ademas existe una sesion con una seleccion previa ,si no los hay pero hay una sesion creada con ellos o si no hay valores ni hay una sesion
	 * @param {@code String[], HttpSessiong}
	 * @return {@code int[]}
	 */
	public int[] convirtiendoArray(String[] eleccionesI, HttpSession miSesion, String eleccionesX) {
		int[] elecciones;
		
		if (existeEleccion(eleccionesI)) {
			elecciones = cambioElecciones(eleccionesI);
			
		} else if (existeSesion(miSesion, eleccionesX) ) {
			elecciones = (int[]) miSesion.getAttribute(eleccionesX);
		} else {
			elecciones = new int[0];
		}

		return elecciones;
	}

	/**
	 * 
	 *Devuelve la suma de los arrays de elecciones de la sesion y la nueva seleccion para tener un array con la seleccion mas nueva 
	 * @param {@code HttpSession, int[], String}
	 * @return {@code int[]}
	 */
	
	public int[] sumaArrays(HttpSession miSesion, int[] eleccionesNuevas, String eleccionesX) {
		int[] elecciones = (int[]) miSesion.getAttribute(eleccionesX);
		int[] eleccionesFinales = new int [elecciones.length + eleccionesNuevas.length];
		
		System.arraycopy(elecciones, 0, eleccionesFinales, 0, elecciones.length);
		System.arraycopy(eleccionesNuevas, 0, eleccionesFinales, elecciones.length, eleccionesNuevas.length);
		
		return eleccionesFinales;
	}
}
