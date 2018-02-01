<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store</title>

</head>


<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">ExampleDemo</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">All Books</a></li>
			<li><a href="newBook">New Book</a></li>
		</ul>
	</div>
	</nav>

	<div class="container">
		<c:choose>
			<c:when test="${mode=='BOOK_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Book Name</th>
							<th>Author</th>
							<th>Purchase Date</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td>${book.id }</td>
								<td>${book.name }</td>
								<td>${book.author }</td>
								<td>${book.purchaseDate }</td>
								<td><a href="updateBook?id=${book.id }"><div class="glyphicon glyphicon-pencil"></div></a></td>
								<td><a href="deleteBook?id=${book.id }"><div class="glyphicon glyphicon-trash"></div></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>


			<c:when test="${mode=='BOOK_EDIT' || mode=='BOOK_NEW'}">
				<form action="save" method="POST">
					<input type="hidden" class="form-control" value="${book.id }" name="id" id="id">
					<div class="form-group">
						<label for="name">Book Name</label> <input type="text" class="form-control" value="${book.name }" name="name" id="name">
					</div>
					<div class="form-group">
						<label for="name">Book Name</label> <input type="text" class="form-control" value="${book.author }" name="author" id="name">
					</div>
					<div class="form-group">
						<label for="name">Book Name</label> <input type="text" class="form-control" value="${book.purchaseDate }" name="purchaseDate" id="name">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>
		</c:choose>
	</div>

</body>
</html>