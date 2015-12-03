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
		<form action="<%= request.getContextPath() %>/CorporationWebOrder" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password"/></td>
				</tr>
			</table>
			<p><input type="submit" value="注文確認画面へ"/></p>
		</form>
		<jsp:include page="/view/layout/user/footer.jsp" />
	</body>
</html>