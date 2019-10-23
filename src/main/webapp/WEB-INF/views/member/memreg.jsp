<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록</title>
</head>
<body>
	<c:if test="${userid }">
		<%@ include file="../../../loginInfo.jsp" %>
	</c:if>
	<h1>회원 등록</h1>
	<form action="memreg" method="POST">
		<table border="1">
			<tr>
				<th>id</th>
				<td><input type="text" id="id" name="id" required="required"/></td>
			</tr>
			<tr>
				<th>pw</th>
				<td><input type="password" id="pw" name="pw" required="required"/></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" id="name" name="name" /></td>
			</tr>
			<tr>
				<th>tel</th>
				<td><input type="text" id="tel" name="tel" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="취소" /><input type="submit" value="확인" /></td>
			</tr>
		</table>
	</form>
	<br />
	<button onclick="history.back()">이전 페이지</button>
	<button onclick="location.href='/controller'">메인 페이지</button>
</body>
</html>