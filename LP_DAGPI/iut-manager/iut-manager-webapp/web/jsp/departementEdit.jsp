<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/jsp/header.jsp" />

<h2>Gestion des départements</h2>
<h3>Edition d'un département</h3>
<p>TODO : à implémenter</p>

<form action="${contextPath}/departement.do" method="post">
    <input type="hidden" name="action" value="editDepartement">    
    <input type="hidden" name="id_dept" value="${departement.id}">

    <p>Nom du Département : <input type="text" name="nameDept" value="<c:out value="${departement.nom}" />"></p>
    <p>Adresse du Département : <input type="text" name="adrDept" value="<c:out value="${departement.adresse}"/>"></p>
    <p>Description du Département : <input type="text" name="descDept" value="<c:out value="${departement.description}"/>"></p>
    <input type="submit" name="submit">
</form>
<c:import url="/jsp/footer.jsp" />