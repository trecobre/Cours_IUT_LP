<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IUT Manager</title>
<style type="text/css" media="all">
@import url("${contextPath}/css/base.css");
@import url("${contextPath}/css/theme.css");
</style>
</head>
<body class="composite">
<div id="breadcrumbs">
<div class="xleft">IUT Manager</div>
<div class="xright"><a href="${contextPath}">IUT Manager Index</a> | <a
	href="https://www.iut.u-bordeaux.fr/info/" class="externalLink">IUT
Informatique Bordeaux</a> | <a href="https://www.oracle.com/java/technologies/"
	class="externalLink">Java</a> | <a
	href="https://jakarta.ee/"
	class="externalLink">JEE</a></div>
<div class="clear">
<hr />
</div>
</div>
<c:import url="/jsp/menu.jsp" />
<div id="bodyColumn">
<div id="contentBox">
<div class="section">