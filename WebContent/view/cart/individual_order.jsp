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
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<th>フリガナ</th>
					<td><input type="text" name="phonetic"/></td>
				</tr>
				<tr>
					<th>郵便番号</th>
					<td><input type="text" name="poatalCode"/></td>
				</tr>
				<tr>
					<th>住所</th>
					<td><input type="text" name="address"/></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><input type="text" name="phoneNumber"/></td>
				</tr>
				<tr>
					<th>メールアドレス</th>
					<td><input type="text" name="mailAddress"/></td>
				</tr>
			</table>
			<p><input type="submit" value="注文"/></p>
		</form>
	</body>
</html>