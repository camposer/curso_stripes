package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/basico/HolaMundo
@WebServlet("/HolaMundo")
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] numeros = new String[] { "uno", "dos", "tres" };
		
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head><title>Hola mundo</title></head>");
		pw.println("<body>");

		pw.println("Hola mundo <br>");
		pw.println("<table border='1'>");
		
		for (String n : numeros)
			pw.println("<tr><td>" + n + "</td></tr>");
		
		pw.println("</table>");
		
		pw.println("</body>");
		pw.println("</html>");
	}

}
