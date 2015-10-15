<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:if test="${not empty loginAuthor}">
	<a href="OnLogout">Logout</a>
</c:if>
<c:if test="${empty loginAuthor}">
	<a href="login.jsp">Login</a>
</c:if>

<c:import url="hotels.xsl" var="xslt" />
<x:transform xml="${hotelsXml}" xslt="${xslt}" />