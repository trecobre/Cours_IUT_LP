<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/jsp/header.jsp" />
<h2>Erreur applicative</h2>
<p>Une erreur est survenue dans l'application.</p>
<div class="section">
<h3>Error detail</h3>
<p>Informations détaillées sur l'erreur :</p>
<table class="bodyTable" width="80%">
	<tbody>
		<tr class="a">
			<th width="10%">Name</th>
			<th width="10%">Description</th>
			<th width="20%">Type</th>
			<th width="60%">Message</th>
		</tr>
		<tr class="a">
			<td>Error</td>
			<td>The error.</td>
			<td><c:out value="${pageContext.errorData.throwable.class.name}" /></td>
			<td><c:out value="${pageContext.errorData.throwable.message}" /></td>
		</tr>
		<c:choose>
			<c:when test="${!empty pageContext.errorData.throwable.cause}">
				<tr class="b">
					<td>Cause</td>
					<td>The error cause.</td>
					<td><c:out
						value="${pageContext.errorData.throwable.cause.class.name}" /></td>
					<td><c:out
						value="${pageContext.errorData.throwable.cause.message}" /></td>
				</tr>
			</c:when>
		</c:choose>
	</tbody>
</table>
</div>
<c:import url="/jsp/footer.jsp" />