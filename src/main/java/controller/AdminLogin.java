package controller;

import java.io.IOException;
import java.sql.SQLException;

import dao.movie.*;
import dto.movie.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String adEmail =req.getParameter("adminemail");
		String adPwd =req.getParameter("adminpwd");
		
		DAO dao3=new DAO();
		
		try {
			Admin admin= dao3.findByEmail(adEmail);
			
			if(admin!=null) {
				if(admin.getAdminPwd().equals(adPwd)) {
					req.setAttribute("loginmessage", "Login Success:))");
					RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
					rd.include(req, resp);
				}
				else {
					req.setAttribute("loginmessage", "Invalid Password:))");
					RequestDispatcher rd=req.getRequestDispatcher("AdLogin.jsp");
					rd.include(req, resp);
				}
				
				
			}
			else {
				req.setAttribute("loginmessage", "Invalid Email:((");
				RequestDispatcher rd=req.getRequestDispatcher("AdLogin.jsp");
				rd.include(req, resp);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
