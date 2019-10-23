<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<body>
	<%@ include file="../../../loginCheck.jsp" %>
	<%@ include file="../../../loginInfo.jsp" %>
	<h1>상품 리스트</h1>
	<table border="1">
		<tr><th>num</th><th>name</th><th>price</th></tr>
		<c:forEach items="${pros }" var="pro">
		<tr>
			<td><a href="proview?num=${pro.num}">${pro.num }</a></td>
			<td>${pro.name }</td>
			<td>${pro.price }</td>
		</tr>
		</c:forEach>
	</table>
	<br />
	<button onclick="history.back()">이전 페이지</button>
	<button onclick="location.href='/controller'">메인 페이지</button>
	<br /><br />
	<button onclick="location.href='proregpage'">상품 등록</button>
</body>
</html>