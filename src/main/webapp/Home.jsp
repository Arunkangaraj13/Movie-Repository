<%@page import="dto.movie.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<h2>Home Page to display All movies</h2>

	<a href="AddMovie.jsp">Add Movie</a>

	<table border="2px solid black">
		<tr>
			<th>Movie Id</th>
			<th>Movie Name</th>
			<th>Movie Price</th>
			<th>Movie Rating</th>
			<th>Movie Genere</th>
			<th>Movie Language</th>
			<th>Movie Image</th>
		</tr>

		<%List <Movie> movie=(List) request.getAttribute("movies"); %>
		<%for(Movie m :movie){ %>
		<tr>
			<td><%=m.getMovieId() %></td>
			<td><%=m.getMovieName() %></td>
			<td><%=m.getMoviePrice() %></td>
			<td><%=m.getMovieRating() %></td>
			<td><%=m.getMovieGenere() %></td>
			<td><%=m.getMovieLanguage() %></td>
			<td><%=m.getMovie?? %></td>
		</tr>

	</table>
</body>
</html>