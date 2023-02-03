

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.Point;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Servlet implementation class UsandoVectores
 */
public class CreaSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession(false) != null) {
			request.getSession().invalidate();
		}

		HttpSession miSesion = request.getSession(true);

		Enumeration enumeracionAtributos;

		String nombreAtr, valorAtr;

		enumeracionAtributos = miSesion.getAttributeNames();

		while (enumeracionAtributos.hasMoreElements()) {
			nombreAtr = enumeracionAtributos.nextElement().toString();
			valorAtr = miSesion.getAttribute(nombreAtr).toString();
			System.out.println(nombreAtr + " = " + valorAtr);
		}
		
		int entero = 12;
		double real = 3.1416;
		String cadena = "Hola sesión";
		Date fecha = new Date();
		Map <String,String> semaforo = new LinkedHashMap<String,String>();
		semaforo.put("R", "Rojo");
		semaforo.put("A", "Amarillo");
		semaforo.put("V", "Verde");
		
		Point unPunto = new Point(2,3);
		
		miSesion.setAttribute("entero", entero);
		miSesion.setAttribute("real", real);
		miSesion.setAttribute("texto", cadena);
		miSesion.setAttribute("fecha", fecha);
		miSesion.setAttribute("semaforo", semaforo);
		miSesion.setAttribute("punto", unPunto);
		
		enumeracionAtributos = miSesion.getAttributeNames();
		
		while (enumeracionAtributos.hasMoreElements()) {
			nombreAtr = enumeracionAtributos.nextElement().toString();
			valorAtr = miSesion.getAttribute(nombreAtr).toString();
			System.out.println(nombreAtr + " = " + valorAtr);
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RecuperaSesion");
		dispatcher.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
