

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import Datos.Datos;

/**
 * Servlet implementation class Recuperacion
 */
public class Recuperacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recuperacion() {
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
		
		
		
		String nombre = request.getParameter("nombre");
		String contraseña = request.getParameter("contraseña");
		
		Iterator<String> iterador = Datos.usuarios.keySet().iterator();
		Boolean userEncontrado = false;
		String user = "";
		while(iterador.hasNext()) {
			if(Datos.usuarios.containsKey(contraseña) && Datos.usuarios.containsKey(nombre)) {
				userEncontrado = true;
				user += Datos.usuarios.keySet().toString();
			}
		}
		
		if(userEncontrado) {
			Cookie []misCookies = request.getCookies();
			if(existeCookie(user, misCookies)) {
				
			}
		}
		
		
	}
	
	private Boolean coincideNombre(String nombre, String nombreCookie) {
		if(nombre.equals(nombreCookie)) {
			return true;
		}
		
		return false;
	}
	
	private Boolean existeCookie(String user, Cookie [] misCookies) {
		if(misCookies != null) {
			for (int i = 0; i < misCookies.length; i++) {
				if(coincideNombre(user, misCookies[i].getName())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

}
