<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<html>
<body>

	<h1>Translated Review Detail</h1>

	<p>Translate to language: ${toLan}</p>


	<table border="1">
		<tbody>
			<tr bgcolor="#9acd32">
				<th>Id</th>
				<td>${review.id}</td>
			</tr>
			<tr>
				<th>Author Id</th>
				<td>${review.authorId}</td>
			</tr>
			<tr bgcolor="#9acd32">
				<th>Headline</th>
				<td>${translationResults[0]}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td>${translationResults[1]}</td>
			</tr>
			<tr bgcolor="#9acd32">
				<th>Ratig</th>
				<td>${review.rating}</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${review.date}</td>
			</tr>
		</tbody>
	</table>

</body>
</html>