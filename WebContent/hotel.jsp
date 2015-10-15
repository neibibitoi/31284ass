<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:import url="hotel.xsl" var="xslt" />
<x:transform xml="${hotelXml}" xslt="${xslt}" />

<c:import url="reviews.xsl" var="xslt2" />
<x:transform xml="${reviewsXml}" xslt="${xslt2}" />

<c:if test="${not empty loginAuthor }">
	<h2>Post Review</h2>
	<form action="OnPostReview" method="post">

		<p style="color: red">${param.errorMsg }</p>

		<input type="hidden" name="hotelId" value="${param.id}">
		<div>
			<label>Headline</label> <input type="text" name="headline">
		</div>
		<div>
			<label>Description</label> <input type="text" name="description">
		</div>
		<div>
			<label>Rating</label> <input type="radio" name="rating" value="1">
			<label>1</label> <input type="radio" name="rating" value="2">
			<label>2</label> <input type="radio" name="rating" value="3">
			<label>3</label> <input type="radio" name="rating" value="4">
			<label>4</label> <input type="radio" name="rating" value="5">
			<label>5</label>
		</div>
		<input type="hidden" name="username" value="${loginAuthor.name}">
		<input type="hidden" name="password" value="${loginAuthor.password}">

		<button type="submit">Post</button>
	</form>
</c:if>