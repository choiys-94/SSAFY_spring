<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<script type="text/javascript">
	function deletepro(){
		var num = myForm.num;
		location.href="prodelete?num=" + num.value;
	}
	
	function updatepro(){
		myForm.action="proupdate";
		myForm.submit();
	}
</script>
</head>
<body>
	<%@ include file="../../../loginCheck.jsp" %>
	<%@ include file="../../../loginInfo.jsp" %>
	<h1>상품 정보</h1>
	<form action="#" method="POST" id="myForm">
		<table border="1">
			<tr>
				<th>num</th>
				<td><input type="text" id="num" name="num" value="${pro.num }" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" id="name" name="name" value="${pro.name }" required="required"/></td>
			</tr>
			<tr>
				<th>price</th>
				<td><input type="text" id="price" name="price" value="${pro.price }"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="delete" value="삭제" onclick="deletepro()"/>
					<input type="button" id="update" value="수정" onclick="updatepro()"/>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<button onclick="history.back()">이전 페이지</button>
	<button onclick="location.href='/controller'">메인 페이지</button>
</body>
</html>