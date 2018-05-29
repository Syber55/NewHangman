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


@WebServlet("/registrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationController() {
      
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO ud = new UserDAOImpl();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		User user = new User();
		user = ud.getUser(username, password);

		if (submitType.equals("REGISTER")) {
			user = new User();
			user.setUsername(username);
			user.setPassword(password);
			ud.insertUser(user);
			
			request.setAttribute("message", "Registration done");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "Data not found, click on Register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
		
		
	}

