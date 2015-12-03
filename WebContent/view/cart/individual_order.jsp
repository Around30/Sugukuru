<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>すぐくる</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/bower_components/normalize-css/normalize.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assets/css/main.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  </head>
	<body>
	<jsp:include page="/view/layout/user/header.jsp" >
      <jsp:param name="corporationFlg" value="corporationFlg" />
    </jsp:include>
		<form action="<%= request.getContextPath() %>/IndividualWebOrder" method="post">
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
					<td><input type="text" name="postalCode"/></td>
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
			<p><input type="submit" value="注文確認画面へ"/></p>
		</form>
		<jsp:include page="/view/layout/user/footer.jsp" />
	</body>
</html>