<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/jsp/header.jsp" />
<h2>Gestion des étudiants</h2>
<h3>Liste des étudiants</h3>
<table class="bodyTable" width="80%">
	<tbody>
		<tr class="a">
			<th width="20%">Nom</th>
			<th width="20%">Prénom</th>
			<th width="40%">Adresse</th>
			<th width="20%">Département</th>
		</tr>
		<c:forEach items="${etudiantList}" var="current" varStatus="status">
			<tr <c:if test="${(status.index % 2) == 0}">class="a"</c:if>
				<c:if test="${(status.index % 2) != 0}">class="b"</c:if>>
				<td><c:out value="${current.nom}" /></td>
				<td><c:out value="${current.prenom}" /></td>
				<td><c:out value="${current.adresse}" /></td>
				<td><c:choose>
					<c:when test="${current.departement == null}">Pas de département</c:when>
					<c:otherwise>
						<c:url value="departement.do" var="displayDepartementURL">
							<c:param name="action" value="displayDepartement" />
							<c:param name="id" value="${current.departement.id}" />
						</c:url>
						<a href="${displayDepartementURL}"><c:out
							value="${current.departement.nom}" /></a>
					</c:otherwise>
				</c:choose></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:import url="/jsp/footer.jsp" />