
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class RecuperaCookie
 */
public class RecuperaCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecuperaCookie() {
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

		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Crea y Recupera</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Recupera Cookie</h1>");
			out.println("<h2>Cookies recibidas:</h2>");

			Cookie[] misCookies = request.getCookies();

			for (int i = 0; i < misCookies.length; i++) {
				
				String [] contenidoCookie = misCookies[i].getValue().split("|");
				out.print("Nombre: <b>" + misCookies[i].getName() + "</b>" + " <br />");
				for (int j = 0; j < contenidoCookie.length; j++) {
					if(j == 0) {
						out.print("Contenido: " + contenidoCookie[i]);
					}else {
						out.print(", " +contenidoCookie[i] + ", ");
					}
				}
				
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			out.println("Se produce una excepci�n <br />");
			e.printStackTrace(out);
		} finally {
			out.close();
		}
	}

}
