<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Fill to Add Movies</h2>
    <form action="savemovie" method="post" enctype="multipart/form-data">
	<table>
	<tr> 
	<td><label for="movieId"> Movie Id</label></td>
	<td> <input type="text" name="id" id="movieId"></td>
	</tr>
	<tr>
	<td><label for="moviename">Movie Name</label></td>
	<td> <input type="text" name="name" id="movieName"></td>
	</tr>
	<tr>
	<td> <label for="movieprice">Movie Price</label></td>
	<td><input type="text" name="price" id="movieprice"></td>
	</tr>
	<tr>
	<td> <label for="movierating">Movie Rating</label></td>
	<td><input type="text" name="rating" id="movierating"></td>
	</tr>
	<tr>
	<td> <label for="moviegenere">Movie Genere</label></td>
	<td><input type="text" name="genere" id="moviegenere"></td>
	</tr>
	<tr>
	<td> <label for="movielanguage">Movie Language</label></td>
	<td><input type="text" name="language" id="movielanguage"></td>
	</tr>
	</table>
	<input type="submit">
	</form>
</body>
</html>