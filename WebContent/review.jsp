<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>


<html>
<body>

	<h1>Review Detail</h1>

	<c:import url="review.xsl" var="xslt" />
	<x:transform xml="${reviewXml}" xslt="${xslt}" />


	<h2>Translate to other language</h2>
	<form action="ReviewTranslate">
		<input type="hidden" name="id" value="${id}">
		<select name="toLan">
			<c:forEach var="lan" items="${lans}">
				<option value="${lan}">${lan}</option>
			</c:forEach>
		</select>
		<button type="submit">Translate Now!</button>
	</form>

</body>
</html>
