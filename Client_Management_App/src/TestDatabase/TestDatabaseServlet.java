package TestDatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDatabaseServlet
 */
@WebServlet("/TestDatabaseServlet")
public class TestDatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String db_User = "clientManager";
		String db_password = "springjdbc";
		String jdbcUrl = "jdbc:mysql://localhost:3306/client_records_manager?useSSL=false&serverTimezone=UTC";
		String jdbcDriverClass = "com.mysql.jdbc.Driver";

		// jdbc connection
		try {
			PrintWriter output = response.getWriter();
			output.println("Url: " + jdbcUrl);
			Class.forName(jdbcDriverClass);

			Connection connection = DriverManager.getConnection(jdbcUrl, db_User, db_password);
			output.println("done");
			connection.close();
			output.println("connection closed");
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
