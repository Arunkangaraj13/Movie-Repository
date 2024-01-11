package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.movie.Admin;
import dao.movie.*;


@WebServlet("/adminsignup")

public class SaveAdmin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("adminId"));
		String name = req.getParameter("adminName");
		long phone = Long.parseLong(req.getParameter("adminPhone"));
		String email = req.getParameter("adminEmail");
		String pwd = req.getParameter("adminPwd");

		Admin ad = new Admin();
		ad.setAdminId(id);
		ad.setAdminName(name);
		ad.setAdminPhone(phone);
		ad.setAdminEmail(email);
		ad.setAdminPwd(pwd);

		DAO dao1 = new DAO();
		
		
		try {
			int res =dao1.saveAdmin(ad);
		
			if(res==1) {
				req.setAttribute("signupmessage", "SignUp Successfully");
				RequestDispatcher rd= req.getRequestDispatcher("AdLogin.jsp");
				rd.include(req, resp);
			}
			else {
				req.setAttribute("signupmessage", "SignUp Failed Retry:((");
				RequestDispatcher rd= req.getRequestDispatcher("AdSignup.jsp");
				rd.include(req, resp);
			}
		
		
		}
		
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}
}
