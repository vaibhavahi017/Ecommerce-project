package com.E.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		HttpSession session = req.getSession();
		if(session==null) {
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		}else {
			req.setAttribute("msg", "Logout Successfully");
			req.getRequestDispatcher("Logout.jsp").forward(req, res);
		}
		
	}

}
