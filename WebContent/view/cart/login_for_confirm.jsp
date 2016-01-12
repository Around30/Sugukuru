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
		<p>
			<h1>確認用ログイン</h1>
			<form action="<%= request.getContextPath() %>/LoginForConfirm" method="post">
				<input type="hidden" name="order_id" value="<%=request.getParameter("order_id")%>" />
				<input type="hidden" name="corporation_account_id" value="<%=request.getParameter("corporation_account_id") %>" />
				password:<input type="text" name="password" />
				<input type="submit" value="送信" />
			</form>
		</p>
		<jsp:include page="/view/layout/user/footer.jsp" />
	</body>
</html>