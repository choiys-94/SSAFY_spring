<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<%@ include file="../../../loginCheck.jsp" %>
	<%@ include file="../../../loginInfo.jsp" %>
	<h1>회원 리스트</h1>
	<table border="1">
		<tr><th>id</th><th>pw</th><th>name</th><th>tel</th></tr>
		<c:forEach items="${mems }" var="mem">
		<tr>
			<td><a href="memview?id=${mem.id}">${mem.id }</a></td>
			<td>${mem.pw }</td>
			<td>${mem.name }</td>
			<td>${mem.tel}</td>
		</tr>
		</c:forEach>
	</table>
	<br />
	<button onclick="history.back()">이전 페이지</button>
	<button onclick="location.href='/controller'">메인 페이지</button>
	<br /><br />
	<button onclick="location.href='memregpage'">회원 등록</button>
	
</body>
</html>