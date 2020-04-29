import javax.servlet.http.HttpServlet;

public class IndexServlet extends HttpServlet{

	
	private String message;

	   public void init() throws ServletException {
	      // Do required initialization
	      message = "Server is Working  ....";
	   }

	   public void doGet(HttpServletRequest req, HttpServletResponse res)
	      throws ServletException, IOException {
	      
	      // Set response content type
	      response.setContentType("text/html");

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      out.println("<h1>" + message + "</h1>");
	   }

	   public void destroy() {
	      // do nothing.
	   }
	
	
}
