<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="<%= request.getContextPath() %>/LoginForConfirm" method="post">
			<input type="hidden" name="order_id" value="<%=request.getParameter("order_id")%>" />
			<input type="hidden" name="corporation_account_id" value="<%=request.getParameter("corporation_account_id") %>" />
			<input type="text" name="password" />
			<input type="submit" value="送信" />
		</form>
	</body>
</html>