
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CreaCookie
 */
public class CreaCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreaCookie() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String nomCookie = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		String idioma = request.getParameter("idioma");
		String contenido = clave + "|" + idioma;

		out.print("<html>");
		out.print("<head><title>Crea y recupera</title></head>");
		out.print("<body>");
		out.print("<h1>Servlet crea y recupera</h1>");

		try {
			Cookie miCookie = new Cookie(nomCookie, contenido);
			response.addCookie(miCookie);

			out.println("Se crea una cookie de nombre " + nomCookie);
			out.println("<br />");
			out.println("El contenido de la cookie es " + contenido);
			out.println("<br />");
		} catch (Exception e) {
			out.println("Se produce una excepci�n: ");
			out.println(e.getMessage());
			out.println("<br />");
		} finally {
			
			request.setAttribute("clave",contenido);
			request.getRequestDispatcher("RecuperaCookie");
			
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
	}

}
