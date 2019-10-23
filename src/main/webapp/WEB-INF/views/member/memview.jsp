<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>

<script type="text/javascript">
	function deletemem(){
		var id = myForm.id;
		location.href="memdelete?id=" + id.value;
	}
	
	function updatemem(){
		myForm.action="memupdate";
		myForm.submit();
	}
</script>

</head>
<body>
	<%@ include file="../../../loginCheck.jsp" %>
	<%@ include file="../../../loginInfo.jsp" %>
	<h1>회원 정보</h1>
	<form action="#" method="POST" id="myForm">
		<table border="1">
			<tr>
				<th>id</th>
				<td><input type="text" id="id" name="id" value="${mem.id }" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>pw</th>
				<td><input type="password" id="pw" name="pw" value="${mem.pw }" required="required"/></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" id="name" name="name" value="${mem.name }"/></td>
			</tr>
			<tr>
				<th>tel</th>
				<td><input type="text" id="tel" name="tel" value="${mem.tel }" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="delete" value="삭제" onclick="deletemem()"/>
					<input type="button" id="update" value="수정" onclick="updatemem()"/>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<button onclick="history.back()">이전 페이지</button>
	<button onclick="location.href='/controller'">메인 페이지</button>
</body>
</html>