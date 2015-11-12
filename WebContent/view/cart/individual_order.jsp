<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="IndividuakWebOrder" method="post">
			<table>
				<tr>
					<th>氏名</th>
					<td><input type="text" value="name"/></td>
				</tr>
				<tr>
					<th>フリガナ</th>
					<td><input type="text" value="phonetic"/></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><input type="text" value="poatalCode"/></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><input type="text" value="address"/></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><input type="text" value="phoneNumber"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="text" value="mailAddress"/></td>
				</tr>
			</table>
			<p><input type="submit" value="注文"/></p>
		</form>
	</body>
</html>