
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

			String[] eleccionesP1 = request.getParameterValues("elecciones");
			int[] elecciones1 = convirtiendoArray(eleccionesP1, miSesion);
			miSesion.setAttribute("elecciones1", elecciones1);
			direccion = "/pregunta2.jsp";
			break;
		case "2":
			String[] eleccionesP2 = request.getParameterValues("elecciones");
			int[] elecciones2 = convirtiendoArray(eleccionesP2, miSesion);
			miSesion.setAttribute("elecciones2", elecciones2);
			if (navego.equals("Siguiente")) {
				direccion = "/pregunta3.jsp";
			} else {
				direccion = "/pregunta1.jsp";
			}
			break;

		case "3":
			String[] eleccionesP3 = request.getParameterValues("elecciones");
			int[] elecciones3 = convirtiendoArray(eleccionesP3, miSesion);
			miSesion.setAttribute("elecciones3", elecciones3);
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
	 * Devuelve un array de enteros a paertir de un array de Strings
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
	 * @param {@code String []}
	 * @return {@code boolean}
	 */
	public boolean existeEleccion(String[] elecciones) {
		return elecciones != null ? true : false;
	}
	/**
	 * Devuelve true si la sesion no esta vacia
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
	 * Devuelve un array de enteros dependiendo de si hay valores seleccionados, si no los hay pero hay una sesion creada con ellos o si no hay valores ni hay una sesion
	 * @param {@code String[], HttpSessiong}
	 * @return {@code int[]}
	 */
	public int[] convirtiendoArray(String[] eleccionesI, HttpSession miSesion) {
		int[] elecciones;
		if (existeEleccion(eleccionesI)) {
			elecciones = cambioElecciones(eleccionesI);
		} else if (existeSesion(miSesion, "elecciones1")) {
			elecciones = (int[]) miSesion.getAttribute("elecciones1");
		} else {
			elecciones = new int[0];
		}

		return elecciones;
	}
}
