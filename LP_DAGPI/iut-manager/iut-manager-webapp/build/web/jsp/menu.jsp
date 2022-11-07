<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="leftColumn">
<div id="navcolumn">
<h5><a href="${contextPath}">IUT Manager Index</a></h5>
<br>
<h5>Départements</h5>
<ul>
	<li class="none"><a
		href="${contextPath}/departement.do?action=displayDepartementList">Liste des
	départements</a></li>
	<li class="none"><a
		href="${contextPath}/jsp/departementEdit.jsp">Ajouter un
	département</a></li>
</ul>
<h5>Etudiants</h5>
<ul>
	<li class="none"><a
		href="${contextPath}/etudiant.do?action=displayEtudiantList">Liste des
	étudiants</a></li>
	<li class="none"><a
		href="${contextPath}/jsp/etudiantEdit.jsp">Ajouter un
	étudiant</a></li>
</ul>
</div>
</div>