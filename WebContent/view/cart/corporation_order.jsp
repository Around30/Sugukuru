<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="<%= request.getContextPath() %>/CorporationWebOrder" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="text" name="phonetic"/></td>
				</tr>
			</table>
			<p><input type="submit" value="注文確認画面へ"/></p>
		</form>
	</body>
</html>