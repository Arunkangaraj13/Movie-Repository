package dao.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Blob;

import dto.movie.Admin;
import dto.movie.Movie;

public class DAO {

	private Connection getConn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");

	}

	public int saveAdmin(Admin admin) throws SQLException, ClassNotFoundException {
		Connection con = getConn();
		PreparedStatement pst = con.prepareStatement("insert into admin values(?,?,?,?,?)");

		pst.setInt(1, admin.getAdminId());
		pst.setString(2, admin.getAdminName());
		pst.setLong(3, admin.getAdminPhone());
		pst.setString(4, admin.getAdminEmail());
		pst.setString(5, admin.getAdminPwd());

		return pst.executeUpdate();

	}
	public Admin findByEmail(String adminemail) throws ClassNotFoundException, SQLException {
		Connection con= getConn();
		PreparedStatement pst=con.prepareStatement("select * from admin where adminEmail=?");
		pst.setString(1, adminemail);
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Admin admin= new Admin();
			
			admin.setAdminId(rs.getInt(1));
			admin.setAdminName(rs.getString(2));
			admin.setAdminPhone(rs.getLong(3));
			admin.setAdminEmail(rs.getString(4));
			admin.setAdminPwd(rs.getString(5));
			
			return admin;
		}
		return null;
		
		
		
		
		
	}
	
	public  int saveMovie(Movie movie) throws SQLException, ClassNotFoundException {
		Connection con=getConn();
		
		PreparedStatement pst= con.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
		
		pst.setInt(1, movie.getMovieId());
		pst.setString(2, movie.getMovieName());
		pst.setDouble(3,movie.getMoviePrice());
		pst.setDouble(4,movie.getMovieRating());
		pst.setString(5,movie.getMovieGenere());
		pst.setString(6, movie.getMovieLanguage());
		
		return pst.executeUpdate() ;
				
	}
	public  List<Movie> getAllMovies() throws ClassNotFoundException, SQLException {
		
		Connection con=getConn();
		PreparedStatement pst= con.prepareStatement("select * from movie");
		ResultSet rs= pst.executeQuery();
		
		List<Movie> movies= new ArrayList<Movie>();
		
		
		while(rs.next()) {
			Movie m= new Movie();
			m.setMovieId(rs.getInt(1));
			m.setMovieName(rs.getString(2));
			m.setMoviePrice(rs.getDouble(3));
			m.setMovieRating(rs.getDouble(4));
			m.setMovieGenere(rs.getString(5));
			m.setMovieLanguage(rs.getString(6));
			Blob b= (Blob) rs.getBlob(7);
			byte[] img = b.getBytes(1,(int) b.length());
			movies.add(m);
			
		}
		return movies;
		
	}
}
