<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY</title>
</head>
<body>
	<c:if test="${userid != null}">
		<%@ include file="loginInfo.jsp" %>
	</c:if>
	<h1>메인 페이지</h1>
	<c:choose>
		<c:when test="${empty userid }">
			<%@ include file="login.jsp" %>
		</c:when>
		<c:otherwise>
			<button onclick="location.href='memlist'">회원 목록</button>
			<button onclick="location.href='prolist'">상품 목록</button>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${param.islogin == 0 }">
		<script>
			alert("아이디 또는 패스워드를 확인해주세요");
		</script>
	</c:if>
</body>
</html>