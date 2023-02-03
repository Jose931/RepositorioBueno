
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Servlet implementation class UserAnonimo
 */
public class UserAnonimo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAnonimo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		Cookie[] misCookies = request.getCookies();
		String mensaje = "";
		out.print("<html>");
		out.print("<head><title>Comprobando usuario</title></head>");
		out.print("<body>");
		
		if(misCookies != null) {
			
			for (int i = 0; i < misCookies.length; i++) {
				if(misCookies[i].getName().equals("uid")) {
					mensaje = "Hola " + misCookies[i].getName() + " " + misCookies[i].getValue();
					out.print("<p>" + mensaje + "</p>");
				}
			}
			
			if(mensaje.equals("")) {
				mensaje = "No te conocia pero te recordare";
				Random num = new Random();
				String contenido = String.valueOf(num.nextInt(500));
				Cookie nuevaCookie = new Cookie("uid", contenido);
				response.addCookie(nuevaCookie);
				out.print("<p>" + mensaje + "</p>");
			}
		}else {
			mensaje = "No te conocia pero te recordare";
			Random num = new Random();
			String contenido = String.valueOf(num.nextInt(500));
			Cookie nuevaCookie = new Cookie("uid", contenido);
			response.addCookie(nuevaCookie);
			out.print("<p>" + mensaje + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
