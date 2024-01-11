package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.movie.DAO;
import dto.movie.Movie;

@WebServlet("/savemovie")
@MultipartConfig(maxFileSize = 5*1024*1024)

public class SaveMovie extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int movieId= Integer.parseInt(req.getParameter("movieId"));
		String movieName= req.getParameter("movieName");
		double moviePrice=Double.parseDouble(req.getParameter("moviePrice"));
		double movieRating=Double.parseDouble(req.getParameter("movieRating"));
		String movieGenere= req.getParameter("movieGenere");
		Part imagePart=req.getPart("movieImage");
		
		
		Movie movie=new Movie();
		
		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		movie.setMoviePrice(moviePrice);
		movie.setMovieRating(movieRating);
		movie.setMovieGenere(movieGenere);
		movie.setMovieImage(imagePart.getInputStream().readAllBytes());
		
		DAO dao2=new DAO();
		
		try {
			dao2.saveMovie(movie);
			req.setAttribute("movie",dao2.getAllMovies());
			
			RequestDispatcher rd= req.getRequestDispatcher("Home.jsp");
			rd.include(req, resp);
			
			
		}
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
