<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:import url="/jsp/header.jsp" />
<h2>Gestion des départements</h2>
<h3>Département détail</h3>
<table class="bodyTable" width="80%">
	<tbody>
		<tr class="a">
			<th width="30%">Nom</th>
			<th width="50%">Description</th>
			<th width="20%">Adresse</th>
		</tr>
		<tr class="b">
			<td><c:out value="${departement.nom}" /></td>
			<td><c:out value="${departement.description}" /></td>
			<td><c:out value="${departement.adresse}" /></td>
		</tr>
	</tbody>
</table>
<c:choose>
	<c:when test="${fn:length(departement.etudiants) < 1}">
		<p>Aucun étudiant n'est associé à ce département.</p>
	</c:when>
	<c:otherwise>
		<p>Liste des étudiants associés à ce département :</p>
		<table class="bodyTable" width="80%">
			<tbody>
				<tr class="a">
					<th width="30%">Nom</th>
					<th width="50%">Prénom</th>
					<th width="20%">Adresse</th>
				</tr>
				<c:forEach items="${departement.etudiants}" var="current"
					varStatus="status">
					<tr <c:if test="${(status.index % 2) == 0}">class="a"</c:if>
						<c:if test="${(status.index % 2) != 0}">class="b"</c:if>>
						<td><c:out value="${current.nom}" /></td>
						<td><c:out value="${current.prenom}" /></td>
						<td><c:out value="${current.adresse}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<c:import url="/jsp/footer.jsp" />