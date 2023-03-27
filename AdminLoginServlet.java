package com.example.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AdminLoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

			   String username = request.getParameter("username");
			   String password = request.getParameter("password");

			   // TODO: Validate the username and password against the administrator credentials stored in the database

			   // If the validation is successful
			   HttpSession session = request.getSession();
			   session.setAttribute("authenticated", true);
			   response.sendRedirect("admin-dashboard.jsp");

			   // If the validation fails
			   request.setAttribute("error", "Invalid username or password");
			   request.getRequestDispatcher("admin-login.jsp").forward(request, response);
			}
	}

