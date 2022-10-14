<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/jsp/header.jsp" />
<h2>Gestion des départements</h2>
<h3>Liste des départements</h3>
<table class="bodyTable" width="80%">
	<tbody>
		<tr class="a">
			<th width="30%">Nom</th>
			<th width="50%">Description</th>
			<th width="20%">Adresse</th>
		</tr>
		<c:forEach items="${departementList}" var="current" varStatus="status">
			<c:url value="departement.do" var="displayDepartementURL">
				<c:param name="action" value="displayDepartement" />
				<c:param name="id" value="${current.id}" />
			</c:url>
			<tr <c:if test="${(status.index % 2) == 0}">class="a"</c:if>
				<c:if test="${(status.index % 2) != 0}">class="b"</c:if>>
				<td><a href="${displayDepartementURL}"><c:out
					value="${current.nom}" /></a></td>
				<td><c:out value="${current.description}" /></td>
				<td><c:out value="${current.adresse}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:import url="/jsp/footer.jsp" />