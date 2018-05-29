package hangman.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hangman.dao.UserDAO;
import hangman.dao.UserDAOImpl;
import hangman.model.User;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO ud = new UserDAOImpl();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		User user = new User();
		user = ud.getUser(username, password);

		if (submitType.equals("PLAY") && user != null && user.getUsername() != null) {
			
			request.setAttribute("message", user.getUsername());
			request.getRequestDispatcher("game.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "Data not found, click on Register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
