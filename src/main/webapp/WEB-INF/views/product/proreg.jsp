<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<%@ include file="../../../loginCheck.jsp" %>
	<%@ include file="../../../loginInfo.jsp" %>
	<h1>상품 등록</h1>
	<form action="proreg" method="POST">
		<table border="1">
			<tr>
				<th>num</th>
				<td><input type="text" id="num" name="num" required="required"/></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" id="name" name="name" required="required"/></td>
			</tr>
			<tr>
				<th>price</th>
				<td><input type="number" id="price" name="price" required="required"/></td>
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