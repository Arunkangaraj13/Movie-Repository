package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.movie.DAO;
import dto.movie.Movie;

public class Home extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DAO dao =new DAO();
		
		try {
			List <Movie> movie =dao.getAllMovies();
			
			if(movie!=null) {
				req.setAttribute("movies", dao.getAllMovies());
				RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
				rd.include(req, resp);
				
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
