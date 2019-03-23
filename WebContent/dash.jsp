<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="com.srg.data.*, com.srg.model.*, com.controller.*, ComUtil.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dash</title>
</head>
<body>
<html>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/b-1.5.2/r-2.2.2/datatables.min.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>


<body>

	<div id="content-wrapper">

		<div class="container-fluid">

			<!-- Breadcrumbs-->
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
				<li class="breadcrumb-item active">Overview</li>
			</ol>

		</div>
		
			<div class="container">
				<table id="myTable" class="table table-bordered" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th scope="col">Book-No</th>
							<th scope="col">Book Title</th>
							<th scope="col">Book Author</th>
							<th scope="col">Book Publish</th>
							<th scope="col">Classification</th>
							<th scope="col">SubclassificationName</th>
							<th scope="col">Action</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach var="book" items="${booksList}">
							<tr>
								<td scope="row"><c:out value="${book.bookId}" /></td>
								<td scope="row"><c:out value="${book.bookTitle}" /></td>
								<td scope="row"><c:out value="${book.bookauthor}" /></td>
								<td scope="row"><c:out value="${book.bookpublish}" /></td>
								<td scope="row"><c:out value="${book.classification}" /></td>
								<td scope="row"><c:out value="${book.subclassification}"/></td>
								<td scope="row"><a href="Editbook.jsp?id=${book.getBookId()}">Edit</a></td>
								<td scope="row"><a href="deletebook?deletebookId=${book.getBookId()}">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
					</div>
					</div>
				</table>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
				<script type="text/javascript"
					src="https://cdn.datatables.net/v/bs4/jq-3.3.1/dt-1.10.18/b-1.5.2/r-2.2.2/datatables.min.js"></script>

				<script type="text/javascript">
					$(document).ready(function() {
						$('#myTable').DataTable();
					});
				</script>

			</div>
</div>
	
</body>
</body>
</html>