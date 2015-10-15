<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:import url="hotel.xsl" var="xslt" />
<x:transform xml="${hotelXml}" xslt="${xslt}" />

<c:import url="reviews.xsl" var="xslt2" />
<x:transform xml="${reviewsXml}" xslt="${xslt2}" />
