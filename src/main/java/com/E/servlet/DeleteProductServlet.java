package com.E.servlet;

import java.io.IOException;

import com.E.DAO.DeleteProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
   protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	   HttpSession session = req.getSession(false);
	   if(session==null) {
		   req.getRequestDispatcher("AdminLogin.html").forward(req, res);
	   }else {
		   String pCode =req.getParameter("pcode");
		   int  rowCount=new DeleteProductDAO().deleteProduct(pCode);
		   if(rowCount>0) {
			   req.setAttribute("msg", "Your Product deleted");
			   req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
		   }
	   }
	
}
}
