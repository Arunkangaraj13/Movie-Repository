package dto.movie;

public class Movie {
	private int movieId;
	private String movieName;
	private double moviePrice;
	private double movieRating;
	private String movieGenere;
	private String MovieLanguage;
	private byte[] movieImage;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public double getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(double moviePrice) {
		this.moviePrice = moviePrice;
	}
	public String getMovieGenere() {
		return movieGenere;
	}
	public void setMovieGenere(String movieGenere) {
		this.movieGenere = movieGenere;
	}
	public double getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(double movieRating) {
		this.movieRating = movieRating;
	}
	public String getMovieLanguage() {
		return MovieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		MovieLanguage = movieLanguage;
	}
	public byte[] getMovieImage() {
		return movieImage;
	}
	public void setMovieImage(byte[] movieImage) {
		this.movieImage = movieImage;
	}
	
}
