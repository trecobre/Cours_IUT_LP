<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/jsp/header.jsp" />
<h2>IUT Manager Index</h2>
<p>Bienvenu dans l'application IUT Manager. Cette application permet
de gérer les départements de l'IUT ainsi que leurs étudiants.</p>
<div class="section">
<h3>Départements</h3>
<p>Les fonctionnalités pour les départements sont les suivantes :</p>
<ul>
	<li>Consultation des départements. De plus, cet écran apporte les
	fonctionnalités :
	<ul>
		<li>Consultation détaillée d'un département</li>
		<li>Modification d'un département</li>
		<li>Suppression d'un département</li>
	</ul>
	</li>
	<li>Ajout d'un département</li>
</ul>
</div>
<div class="section">
<h3>Etudiants</h3>
<p>Les fonctionnalités pour les étudiants sont les suivantes :</p>
<ul>
	<li>Consultation des étudiants. De plus, cet écran apporte les
	fonctionnalités :
	<ul>
		<li>Modification d'un étudiant</li>
		<li>Suppression d'un étudiant</li>
	</ul>
	</li>
	<li>Ajout d'un étudiant</li>
</ul>
</div>
<c:import url="/jsp/footer.jsp" />