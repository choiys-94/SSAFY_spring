<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="login" method="POST">
	<table border="1">
		<tr>
			<th colspan="2" align="center">로그인</th>
		</tr>
		<tr>
			<th>id</th>
			<td><input type="text" name="id" id="id" required="required" placeholder="id" /></td>
		</tr>
		<tr>
			<th>pw</th>
			<td><input type="password" name="pw" id="pw" required="required" placeholder="pw" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" onclick="location.href='memregpage'">회원 가입</button>
				<input type="submit" value="로그인">
			</td>
		</tr>
	</table>
</form>